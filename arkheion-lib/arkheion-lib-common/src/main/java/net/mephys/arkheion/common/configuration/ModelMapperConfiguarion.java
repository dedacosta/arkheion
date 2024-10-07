package net.mephys.arkheion.common.configuration;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ModelMapperConfiguarion {

    private final Converter<List<String>, String> LIST_TO_STRING_CONVERTER = new AbstractConverter<>() {
        @Override
        protected String convert(List<String> strings) {
            return strings == null ? null : String.join("; ", strings);
        }
    };

    private final Converter<String, List<String>> STRING_TO_LIST_CONVERTER = new AbstractConverter<>() {
        @Override
        protected List<String> convert(String string) {
            return string == null ? null : Arrays.asList(string.split(";\\s*"));
        }
    };

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true).
                setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        //.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        modelMapper.addConverter(LIST_TO_STRING_CONVERTER);
        modelMapper.addConverter(STRING_TO_LIST_CONVERTER);
        return modelMapper;
    }

}
