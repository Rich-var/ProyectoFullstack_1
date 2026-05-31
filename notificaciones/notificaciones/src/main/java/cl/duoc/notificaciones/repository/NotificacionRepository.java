package cl.duoc.notificaciones.repository;

import cl.duoc.notificaciones.model.NotificacionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<NotificacionModel, Long> {
}