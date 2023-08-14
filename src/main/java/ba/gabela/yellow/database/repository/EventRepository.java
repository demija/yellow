package ba.gabela.yellow.database.repository;

import ba.gabela.yellow.database.model.Event.Relational.EventDTO;
import ba.gabela.yellow.database.model.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventDTO, String> {
    List<EventDTO> findByStartsAtLessThanEqualAndStatus(LocalDateTime currentTime, StatusEnum status);
}
