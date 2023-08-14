package ba.gabela.yellow.database.repository;

import ba.gabela.yellow.database.model.Market.Redis.MarketRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRedisRepository extends CrudRepository<MarketRedis, String> {
}
