package ba.gabela.yellow.service;

import ba.gabela.yellow.database.model.Event.Redis.EventRedis;
import ba.gabela.yellow.database.model.Market.Redis.MarketRedis;

public interface KafkaConsumerService {
    void consumeEvents(EventRedis message);
    void consumeMarkets(MarketRedis message);
}
