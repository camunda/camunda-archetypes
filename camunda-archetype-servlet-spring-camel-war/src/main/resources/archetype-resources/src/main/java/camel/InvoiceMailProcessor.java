package ${package}.camel;

import java.util.Map;

import javax.activation.DataHandler;
import javax.mail.internet.MimeMultipart;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InvoiceMailProcessor implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    Map<String, Object> map = exchange.getIn().getHeaders();
    
    Object body = exchange.getIn().getBody();
    if (body instanceof MimeMultipart) {
      String emailBody = ((MimeMultipart) body).getBodyPart(0).getContent().toString();
      map.put("emailBody", emailBody);
    }
    
    Map<String, DataHandler> attachments = exchange.getIn().getAttachments();
    if (attachments.size() > 0) {
      for (String name : attachments.keySet()) {
        DataHandler dh = attachments.get(name);
        // get the file name
        String filename = dh.getName();

        // get the content and convert it to byte[]
        byte[] data = exchange.getContext().getTypeConverter().convertTo(byte[].class, dh.getInputStream());
        map.put("invoiceDocumentName", filename); // TODO use Camunda file variable
        map.put("invoiceDocument", data);
        break; // TODO handle multiple attachments
      }
    }
    exchange.getIn().setBody(map);
  }

}
