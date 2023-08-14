package ba.gabela.yellow.service.impl;

import ba.gabela.yellow.database.model.Event.Redis.EventRedis;
import ba.gabela.yellow.database.model.Event.Relational.EventDTO;
import ba.gabela.yellow.database.model.Market.Redis.MarketRedis;
import ba.gabela.yellow.database.model.Market.Relational.MarketDTO;
import ba.gabela.yellow.database.repository.EventRedisRepository;
import ba.gabela.yellow.database.repository.EventRepository;
import ba.gabela.yellow.database.repository.MarketRedisRepository;
import ba.gabela.yellow.database.repository.MarketRepository;
import ba.gabela.yellow.service.InitializationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InitializationServiceImpl implements InitializationService {
    private static final Logger logger = LogManager.getLogger(InitializationServiceImpl.class);
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private MarketRedisRepository marketRedisRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRedisRepository eventRedisRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String EVENTS_RESOURCE_PATH = "classpath:eventsInitialData.json";
    private static final String MARKETS_RESOURCE_PATH = "classpath:marketsInitialData.json";

    @Override
    public void initializeData() {
        initializeMarket();
        initializeEvents();
    }

    private void initializeEvents() {
        try {
            Resource resource = resourceLoader.getResource(EVENTS_RESOURCE_PATH);

            EventDTO[] events = objectMapper.readValue(resource.getFile(), EventDTO[].class);
            for (EventDTO obj : events) {
                eventRepository.save(obj);
            }

            EventRedis[] eventsRedis = objectMapper.readValue(resource.getFile(), EventRedis[].class);
            for (EventRedis obj : eventsRedis) {
                eventRedisRepository.save(obj);
            }
        } catch (IOException e) {
            logger.warn("Error initializing Events: {}", e.getMessage());
        }

        logger.info("Events initialized");
    }

    private void initializeMarket() {
        try {
            Resource resource = resourceLoader.getResource(MARKETS_RESOURCE_PATH);

            MarketDTO[] markets = objectMapper.readValue(resource.getFile(), MarketDTO[].class);
            for (MarketDTO obj : markets) {
                marketRepository.save(obj);
            }

            MarketRedis[] marketsRedis = objectMapper.readValue(resource.getFile(), MarketRedis[].class);
            for (MarketRedis obj : marketsRedis) {
                marketRedisRepository.save(obj);
            }
        } catch (IOException e) {
            logger.warn("Error initializing Markets: {}", e.getMessage());
        }

        logger.info("Markets initialized");
    }
}
