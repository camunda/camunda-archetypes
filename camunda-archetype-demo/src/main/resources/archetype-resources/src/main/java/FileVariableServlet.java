package ${package};

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.value.FileValue;
import org.camunda.bpm.engine.variable.value.TypedValue;


@WebServlet(value = "/file-variable", loadOnStartup = 1)
public class FileVariableServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private final Logger LOGGER = Logger.getLogger(FileVariableServlet.class.getName());
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      ProcessEngine processEngine = BpmPlatform.getDefaultProcessEngine();
      String variableId = request.getParameter("variableId");
      String taskId = request.getParameter("taskId");
      String variableName = request.getParameter("variableName");
  
      TypedValue typedValue = null;
      if (variableId != null) {
        typedValue = processEngine.getRuntimeService()
          .createVariableInstanceQuery()
          .variableId(variableId)
          .singleResult()
          .getTypedValue();
      } else if (taskId != null && variableName != null) {
        typedValue = processEngine.getTaskService()
            .getVariableTyped(taskId, variableName);
        if (typedValue == null) {
          String processInstanceId = processEngine.getTaskService().createTaskQuery()
            .taskId(taskId)
            .singleResult()
            .getProcessInstanceId();
          typedValue = processEngine.getRuntimeService()
              .createVariableInstanceQuery()
              .processInstanceIdIn(processInstanceId)
              .variableName(variableName)
              .singleResult()
              .getTypedValue();
        }
      }
      if (typedValue instanceof FileValue) {
        FileValue fileValue = (FileValue) typedValue;
        response.setContentType(fileValue.getMimeType());
        InputStream inputStream = fileValue.getValue();
        IOUtils.copy(inputStream, response.getOutputStream());
      }
    } catch (Exception e) {
      LOGGER.warning(e.getMessage());
      InputStream inputStream = this.getClass().getResourceAsStream("/document.pdf");
      response.setContentType("application/pdf");
      IOUtils.copy(inputStream, response.getOutputStream());
    }
  }
}
