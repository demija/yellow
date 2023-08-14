package ba.gabela.yellow.service;

import ba.gabela.yellow.generated.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    List<Event> getAll();

    List<Event> filter(String startDate);
}
