package com.in28minutes.springboot.learnspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * CurrencyServiceConfiguration은 환율 서비스와 관련된 속성을 보유하는 설정 클래스입니다.
 * 이 클래스는 Currency Service와 관련된 속성을 보유하고 있으며, 구성 속성(prefix="currency-service")으로 지정됩니다.
 */
@ConfigurationProperties(prefix="currency-service")
@Component
@Getter
@Setter
public class CurrencyServiceConfiguration {
  private String url;
  private String username;
  private String key;
  
}
