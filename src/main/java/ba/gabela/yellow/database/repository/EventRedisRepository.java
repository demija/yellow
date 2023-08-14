package ba.gabela.yellow.database.repository;

import ba.gabela.yellow.database.model.Event.Redis.EventRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRedisRepository extends CrudRepository<EventRedis, String> {
}
