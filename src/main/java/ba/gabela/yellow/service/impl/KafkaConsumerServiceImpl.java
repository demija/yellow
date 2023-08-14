package ba.gabela.yellow.service.impl;

import ba.gabela.yellow.config.ModelMapperConfig;
import ba.gabela.yellow.database.model.Event.Redis.EventRedis;
import ba.gabela.yellow.database.model.Event.Relational.EventDTO;
import ba.gabela.yellow.database.model.Market.Redis.MarketRedis;
import ba.gabela.yellow.database.model.Market.Relational.MarketDTO;
import ba.gabela.yellow.database.repository.EventRedisRepository;
import ba.gabela.yellow.database.repository.EventRepository;
import ba.gabela.yellow.database.repository.MarketRedisRepository;
import ba.gabela.yellow.database.repository.MarketRepository;
import ba.gabela.yellow.service.KafkaConsumerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
    private static final Logger logger = LogManager.getLogger(KafkaConsumerServiceImpl.class);

    @Autowired
    private ModelMapperConfig mapperConfig;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRedisRepository eventRedisRepository;

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private MarketRedisRepository marketRedisRepository;

    @Override
    @KafkaListener(topicPartitions = @TopicPartition(topic = "${kafka.topic.event}", partitions = { "0", "1" }), containerFactory = "eventKafkaListenerContainerFactory")
    public void consumeEvents(EventRedis event) {
        Optional<EventRedis> eventRedisOptional = eventRedisRepository.findById(event.getId());
        if (eventRedisOptional.isEmpty()) {
            eventRedisRepository.save(mapperConfig.modelMapper().map(event, EventRedis.class));
            eventRepository.save(mapperConfig.modelMapper().map(event, EventDTO.class));
        } else {
            //TODO implement update
        }

        logger.info("Event message processed successfully");
    }

    @Override
    @KafkaListener(topics = "${kafka.topic.market}", groupId = "${kafka.consumer.group-id}", containerFactory = "marketKafkaListenerContainerFactory")
    public void consumeMarkets(MarketRedis market) {
        Optional<MarketRedis> marketRedisOptional = marketRedisRepository.findById(market.getId());
        if (marketRedisOptional.isEmpty()) {
            marketRedisRepository.save(mapperConfig.modelMapper().map(market, MarketRedis.class));
            marketRepository.save(mapperConfig.modelMapper().map(market, MarketDTO.class));
        } else {
            //TODO implement update
        }

        logger.info("Market message processed successfully");
    }
}
