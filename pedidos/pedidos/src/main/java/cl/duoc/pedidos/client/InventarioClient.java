package cl.duoc.pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventario-service", url = "http://localhost:8088/api/inventario")
public interface InventarioClient {

    @GetMapping("/producto/{idProducto}/sucursal/{idSucursal}")
    InventarioDto obtenerStock(
            @PathVariable("idProducto") Long idProducto, 
            @PathVariable("idSucursal") Long idSucursal
    );

    @PostMapping
    void actualizarStock(@RequestBody InventarioDto request);

    @lombok.Data
    class InventarioDto {
        private Long idProducto;
        private Long idSucursal;
        private Integer cantidad;
    }
}