package ba.gabela.yellow.database.model.Event.Redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("EventMarketOutcomeRedis")
@Getter
@Setter
public class EventMarketOutcomeRedis implements Serializable {
    private String id;
    private String outcomeId;
    private Integer status;
    private Double odds;
}
