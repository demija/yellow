package ba.gabela.yellow.utils;

import ba.gabela.yellow.database.model.StatusEnum;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class IntegerToEnumConverter extends AbstractConverter<Integer, StatusEnum> {
    @Override
    protected StatusEnum convert(Integer integer) {
        return StatusEnum.values()[integer];
    }
}
