package ba.gabela.yellow.controller;

import ba.gabela.yellow.generated.api.EventApi;
import ba.gabela.yellow.generated.model.Event;
import ba.gabela.yellow.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController implements EventApi {
    @Autowired
    private EventServiceImpl eventService;

    @Override
    public ResponseEntity<List<Event>> filterEvents(String startDate) {
        return ResponseEntity.ok(eventService.filter(startDate));
    }

    @Override
    public ResponseEntity<List<Event>> getEventsList() {
        return ResponseEntity.ok(eventService.getAll());
    }
}
