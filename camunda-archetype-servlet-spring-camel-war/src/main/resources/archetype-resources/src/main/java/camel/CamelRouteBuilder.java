package ${package}.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    from("direct:variableToFile")
      .log(LoggingLevel.INFO, "Writing variable to file")
      .process(new FirstMapValueToStringProcessor())
      .to("file://" + System.getProperty("user.home") + System.getProperty("file.separator") + "camunda-bpm-demo-camel" + System.getProperty("file.separator") + "variableToFile");

//    from("pop3://mail.example.com?username=camunda@example.com&password=camunda&delete=true&unseen=true&consumer.delay=60000")
//      .log(LoggingLevel.INFO, "Received email. Starting process...")
//      .process(new InvoiceMailProcessor())
//      .to("camunda-bpm:start?processDefinitionKey=InvoiceProcess");
    
//    from("direct:invoiceToDB")
//      .log(LoggingLevel.INFO, "Sending invoice to DB");
//      .to("sql:insert into INVOICE set foo=:#myProcessVariable?dataSource=dataSource");
    
  }

}
