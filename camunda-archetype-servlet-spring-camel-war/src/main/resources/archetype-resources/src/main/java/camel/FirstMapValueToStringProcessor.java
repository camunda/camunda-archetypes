package ${package}.camel;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FirstMapValueToStringProcessor implements Processor {

  public void process(Exchange exchange) throws Exception {
    @SuppressWarnings("unchecked")
    Map<String, Object> map = exchange.getIn().getBody(Map.class);
    exchange.getIn().setBody(map.values().iterator().next().toString());
  }

}