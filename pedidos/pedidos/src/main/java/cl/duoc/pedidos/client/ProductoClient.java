package cl.duoc.pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productos-service", url = "http://localhost:8081/api/productos")
public interface ProductoClient {
    
    @GetMapping("/{idProducto}")
    Object buscarPorId(@PathVariable("idProducto") Long idProducto); 
}