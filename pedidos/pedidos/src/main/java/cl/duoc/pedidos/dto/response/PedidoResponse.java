package cl.duoc.pedidos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {
    private Long idPedido;
    private Long idProducto;
    private Long idSucursal;
    private Integer cantidad;
    private Integer total;
    private LocalDateTime fechaPedido;
}