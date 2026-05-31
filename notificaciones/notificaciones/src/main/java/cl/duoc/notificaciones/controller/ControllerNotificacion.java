package cl.duoc.notificaciones.controller;

import cl.duoc.notificaciones.model.NotificacionModel;
import cl.duoc.notificaciones.service.NotificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class ControllerNotificacion {

    private final NotificacionService notificacionService;

    @PostMapping
    public ResponseEntity<NotificacionModel> enviarNotificacion(
            @RequestParam String destinatario,
            @RequestParam String mensaje,
            @RequestParam String tipo
    ) {
        NotificacionModel response = notificacionService.registrarNotificacion(destinatario, mensaje, tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}