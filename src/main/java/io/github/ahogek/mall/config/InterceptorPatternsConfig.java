package io.github.ahogek.mall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "interceptor")
@Data
public class InterceptorPatternsConfig {

    private String pathPatterns;

    private String[] excludePathPatterns;
}
