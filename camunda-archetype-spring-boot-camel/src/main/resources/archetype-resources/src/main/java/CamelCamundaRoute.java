package ${package};

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelCamundaRoute extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		

		from("timer://camundaStarter?fixedRate=true&period=60000")
		.id("camel-camunda-starter")
		.to("log:start_camunda_bpmn_from_camel_route")
		.setBody(constant("test"))
		.to("camunda-bpm://start?processDefinitionKey=camunda-camel");

		
		
		from("direct:2camel")
		.routeId("2camel") //
		.id("2camel")
		.to("log:camunda_bpmn_called_camel_route");


	

	}
}
