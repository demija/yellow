package ba.gabela.yellow.config;

import ba.gabela.yellow.database.model.StatusEnum;
import ba.gabela.yellow.utils.IgnoreNullCondition;
import ba.gabela.yellow.utils.IntegerToEnumConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(converter());
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setPropertyCondition(new IgnoreNullCondition<>());

        return modelMapper;
    }

    @Bean
    public Converter<Integer, StatusEnum> converter() {
        return new IntegerToEnumConverter();
    }
}
