package io.inventi.swagger

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
@ConfigurationProperties('swagger')
class Config {

  String baseurl
  String title
  String description
  List<String> apis

  @Bean
  CorsFilter corsFilter() {
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin(CorsConfiguration.ALL);
    config.addAllowedHeader(CorsConfiguration.ALL);
    config.addAllowedMethod(CorsConfiguration.ALL);

    UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    configSource.registerCorsConfiguration("/**", config);
    return new CorsFilter(configSource);
  }
}
