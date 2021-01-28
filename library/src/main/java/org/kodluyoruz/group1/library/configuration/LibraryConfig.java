package org.kodluyoruz.group1.library.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
