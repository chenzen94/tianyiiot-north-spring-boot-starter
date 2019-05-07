package com.jadendong.tianyiiot.auto;

import com.jadendong.tianyiiot.Hello;
import com.jadendong.tianyiiot.template.PostDeviceCommandTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jaden
 */
@Configuration
@EnableConfigurationProperties(IotProperties.class)
@ConditionalOnClass(IotProperties.class)
@ConditionalOnProperty(prefix = "iot", value = "enabled", matchIfMissing = true)
public class IotAutoConfiguration {

    private final IotProperties iotProperties;

    public IotAutoConfiguration(IotProperties iotProperties) {
        this.iotProperties = iotProperties;
    }

    @Bean
    @ConditionalOnMissingBean(IotProperties.class)
    public Hello hello() {
        return new Hello(iotProperties);
    }

    @Bean
    @ConditionalOnMissingBean(IotProperties.class)
    public PostDeviceCommandTemplate northApiService() {
        return new PostDeviceCommandTemplate(iotProperties);
    }
}
