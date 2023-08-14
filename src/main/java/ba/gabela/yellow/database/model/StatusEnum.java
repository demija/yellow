package ba.gabela.yellow.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum StatusEnum {
    @JsonProperty("0")
    INACTIVE(0),
    @JsonProperty("1")
    ACTIVE(1);

    private final int value;

    StatusEnum(int value) {
        this.value = value;
    }
}
