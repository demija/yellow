package ba.gabela.yellow.utils;

import org.modelmapper.Condition;
import org.modelmapper.spi.MappingContext;

public class IgnoreNullCondition<S, D> implements Condition<S, D> {
    @Override
    public boolean applies(MappingContext<S, D> mappingContext) {
        return mappingContext.getSource() != null;
    }
}
