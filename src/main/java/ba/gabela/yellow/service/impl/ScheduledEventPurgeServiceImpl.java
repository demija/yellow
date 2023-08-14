package ba.gabela.yellow.service.impl;

import ba.gabela.yellow.database.model.Event.Relational.EventDTO;
import ba.gabela.yellow.database.model.StatusEnum;
import ba.gabela.yellow.database.repository.EventRedisRepository;
import ba.gabela.yellow.database.repository.EventRepository;
import ba.gabela.yellow.service.ScheduledEventPurgeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduledEventPurgeServiceImpl implements ScheduledEventPurgeService {
    private static final Logger logger = LogManager.getLogger(ScheduledEventPurgeServiceImpl.class);

    @Autowired
    private EventRedisRepository eventRedisRepository;

    @Autowired
    private EventRepository eventRepository;

//    @Scheduled(fixedRate = 60000)
    @Override
    public void expireEvents() {
        List<EventDTO> byStartsAtLessThanEqual = eventRepository.findByStartsAtLessThanEqualAndStatus(LocalDateTime.now(), StatusEnum.ACTIVE);

        for (EventDTO eventDTO : byStartsAtLessThanEqual) {
            eventDTO.setStatus(StatusEnum.INACTIVE);
            eventRepository.save(eventDTO);

            eventRedisRepository.deleteById(eventDTO.getId());
        }

        logger.info("Scheduler initialized");
    }
}
