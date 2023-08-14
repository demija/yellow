package ba.gabela.yellow.service.impl;

import ba.gabela.yellow.database.model.Event.Redis.EventMarketOutcomeRedis;
import ba.gabela.yellow.database.model.Event.Redis.EventMarketRedis;
import ba.gabela.yellow.database.model.Event.Redis.EventRedis;
import ba.gabela.yellow.database.repository.EventRedisRepository;
import ba.gabela.yellow.generated.model.Event;
import ba.gabela.yellow.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRedisRepository eventRedisRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Event> getAll() {
        List<EventRedis> list = StreamSupport.stream(eventRedisRepository.findAll().spliterator(), false)
                .toList();

        List<EventRedis> filteredEvents = list.stream()
                .peek(event -> {
                    List<EventMarketRedis> filteredMarkets = event.getMarkets().stream()
                            .filter(market -> market.getStatus() != 0)
                            .peek(market -> {
                                List<EventMarketOutcomeRedis> filteredOutcomes = market.getOutcomes().stream()
                                        .filter(outcome -> outcome.getStatus() != 0)
                                        .collect(Collectors.toList());

                                market.setOutcomes(filteredOutcomes);
                            })
                            .collect(Collectors.toList());

                    event.setMarkets(filteredMarkets);
                })
                .toList();

        return filteredEvents.stream()
                .map(item -> {
                    Event event = modelMapper.map(item, Event.class);
                    event.setStartsAt(item.getStartsAt().format(formatter));
                    return event;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> filter(String startDate) {
        LocalDate localDate = LocalDate.parse(startDate);
        LocalDateTime localDateTime = localDate.atStartOfDay();

        Iterable<EventRedis> all = eventRedisRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .filter(event -> event.getStartsAt().isAfter(localDateTime))
                .map(item -> {
                    Event event = modelMapper.map(item, Event.class);
                    event.setStartsAt(item.getStartsAt().format(formatter));
                    return event;
                })
                .collect(Collectors.toList());
    }
}
