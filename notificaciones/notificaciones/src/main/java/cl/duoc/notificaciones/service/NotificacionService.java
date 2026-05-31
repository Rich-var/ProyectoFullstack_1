package cl.duoc.notificaciones.service;

import cl.duoc.notificaciones.model.NotificacionModel;
import cl.duoc.notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public NotificacionModel registrarNotificacion(String destinatario, String mensaje, String tipo) {
        log.info("Registrando historial de notificacion ({}) enviada a: {}", tipo, destinatario);

        NotificacionModel notificacion = NotificacionModel.builder()
                .destinatario(destinatario)
                .mensaje(mensaje)
                .tipo(tipo.toUpperCase())
                .build();

        return notificacionRepository.save(notificacion);
    }
}