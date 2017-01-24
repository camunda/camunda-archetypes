package ${package};

import java.util.logging.Logger;

import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class ${class-name-prefix}ParseListener extends AbstractBpmnParseListener implements BpmnParseListener {

  private final Logger LOGGER = Logger.getLogger(${class-name-prefix}ParseListener.class.getName());

  @Override
  public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl startEvent) {
    LOGGER.info("Parsing Start Event "
        + ", activtyId=" + startEvent.getId()
        + ", activtyName='" + startEvent.getName() + "'"
        + ", scopeId=" + scope.getId()
        + ", scopeName=" + scope.getName());
  }

}
