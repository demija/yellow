package ba.gabela.yellow.database.model.Market.Redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("MarketOutcomeRedis")
@Getter
@Setter
public class MarketOutcomeRedis implements Serializable {
    private String id;
    private String name;
    private Integer status;
}
