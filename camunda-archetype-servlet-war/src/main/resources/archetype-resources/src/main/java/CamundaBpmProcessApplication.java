package ${package};

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.JakartaServletProcessApplication;

/**
 * Process Application exposing this application's resources to the process engine.
 */
@ProcessApplication
public class CamundaBpmProcessApplication extends JakartaServletProcessApplication {

}
