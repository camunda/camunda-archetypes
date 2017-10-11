package ${package}.config;

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class CamundaBpmConfiguration {

  @Bean
  @Order(Ordering.DEFAULT_ORDER + 1)
  public static ProcessEnginePlugin spinPlugin() {
    return new SpinProcessEnginePlugin();
  }
  
  @Bean
  @Order(Ordering.DEFAULT_ORDER + 2)
  public static ProcessEnginePlugin connectPlugin() {
    return new ConnectProcessEnginePlugin();
  }
}
