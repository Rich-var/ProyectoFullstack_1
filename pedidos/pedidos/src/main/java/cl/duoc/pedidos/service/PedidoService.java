package cl.duoc.pedidos.service;

import cl.duoc.pedidos.dto.request.PedidoRequest;
import cl.duoc.pedidos.dto.response.PedidoResponse;
import cl.duoc.pedidos.model.PedidoModel;
import cl.duoc.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoResponse crearPedido(PedidoRequest request) {
        // 1. Creamos la entidad e insertamos los datos calculando el TOTAL
        PedidoModel pedido = PedidoModel.builder()
                .idProducto(request.getIdProducto())
                .idSucursal(request.getIdSucursal())
                .cantidad(request.getCantidad())
                .total(request.getCantidad() * request.getPrecioUnitario()) // Solución al Error 500
                .build();

        // 2. Guardamos en la base de datos
        PedidoModel pedidoGuardado = pedidoRepository.save(pedido);

        // 3. Mapeamos y retornamos la respuesta usando Builder de forma correcta
        return PedidoResponse.builder()
                .idPedido(pedidoGuardado.getIdPedido())
                .idProducto(pedidoGuardado.getIdProducto())
                .idSucursal(pedidoGuardado.getIdSucursal())
                .cantidad(pedidoGuardado.getCantidad())
                .total(pedidoGuardado.getTotal())
                .fechaPedido(pedidoGuardado.getFechaPedido())
                .build();
    }

    public List<PedidoResponse> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll().stream()
                .map(pedido -> PedidoResponse.builder()
                        .idPedido(pedido.getIdPedido())
                        .idProducto(pedido.getIdProducto())
                        .idSucursal(pedido.getIdSucursal())
                        .cantidad(pedido.getCantidad())
                        .total(pedido.getTotal())
                        .fechaPedido(pedido.getFechaPedido())
                        .build())
                .toList();
    }

    public PedidoResponse obtenerPedidoPorId(Long id) {
        PedidoModel pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado"));
        
        return PedidoResponse.builder()
                .idPedido(pedido.getIdPedido())
                .idProducto(pedido.getIdProducto())
                .idSucursal(pedido.getIdSucursal())
                .cantidad(pedido.getCantidad())
                .total(pedido.getTotal())
                .fechaPedido(pedido.getFechaPedido())
                .build();
    }
}