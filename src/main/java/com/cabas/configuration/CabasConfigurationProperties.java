package com.cabas.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cabas")
@Getter @Setter
public class CabasConfigurationProperties {

    private String notificationBaseUrl;

}
