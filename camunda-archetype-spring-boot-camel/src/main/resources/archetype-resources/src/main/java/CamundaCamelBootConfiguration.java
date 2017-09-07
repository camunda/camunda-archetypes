package ${package};

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.camunda.bpm.camel.component.CamundaBpmComponent;
import org.camunda.bpm.camel.spring.CamelServiceImpl;
import org.camunda.bpm.engine.ProcessEngine;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CamundaCamelBootConfiguration {

	@Autowired
	CamelContext camelContext;

	@Autowired
	ProcessEngine processEngine;

	@Bean(name = "camel")
	public CamelServiceImpl camel() {
		CamelServiceImpl camelServiceImpl = new CamelServiceImpl();
		camelServiceImpl.setCamelContext(camelContext);
		camelServiceImpl.setProcessEngine(processEngine);
		return camelServiceImpl;
	}
	
	
	@Bean
	CamelContextConfiguration nameConfiguration() {
		return new CamelContextConfiguration() {
			@Override
			public void beforeApplicationStart(CamelContext camelContext) {
				CamundaBpmComponent component = new CamundaBpmComponent(processEngine);
				SpringProcessEngineConfiguration config =  (SpringProcessEngineConfiguration)processEngine.getProcessEngineConfiguration();
				config.getBeans().put("camel", camel());
				camelContext.addComponent("camunda-bpm", component);
			}

			@Override
			public void afterApplicationStart(CamelContext arg0) {

			}
		};
	}
	
}
