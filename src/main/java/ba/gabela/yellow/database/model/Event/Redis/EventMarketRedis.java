package ba.gabela.yellow.database.model.Event.Redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("EventMarketRedis")
@Getter
@Setter
public class EventMarketRedis implements Serializable {
    private String id;
    private String marketId;
    private Integer status;
    private List<EventMarketOutcomeRedis> outcomes;
}
