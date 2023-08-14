package ba.gabela.yellow.database.model.Event.Redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@RedisHash("EventRedis")
@Getter
@Setter
public class EventRedis implements Serializable {
    private String id;
    private String name;
    private LocalDateTime startsAt;
    private Integer status;
    private List<EventMarketRedis> markets;
}
