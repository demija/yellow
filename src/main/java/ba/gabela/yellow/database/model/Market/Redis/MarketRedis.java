package ba.gabela.yellow.database.model.Market.Redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash("MarketRedis")
@Getter
@Setter
public class MarketRedis implements Serializable {
    private String id;
    private String name;
    private Integer status;
    private List<MarketOutcomeRedis> outcomes;
}
