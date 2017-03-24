package ${package};

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.value.FileValue;
import org.camunda.bpm.engine.variable.value.TypedValue;


@WebServlet(value = "/file-variable", loadOnStartup = 1)
public class FileVariableServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    RuntimeService runtimeService = BpmPlatform.getDefaultProcessEngine().getRuntimeService();

//    String taskId = request.getParameter("taskId");
//    String variableName = request.getParameter("variableName");
//    byte pdf[] = (byte[]) runtimeService.getVariable(taskId, variableName);

    String variableId = request.getParameter("variableId");
    TypedValue typedValue = runtimeService.createVariableInstanceQuery()
      .variableId(variableId)
      .singleResult().getTypedValue();
    if (typedValue instanceof FileValue) {
      FileValue fileValue = (FileValue) typedValue;
      response.setContentType(fileValue.getMimeType());
      InputStream inputStream = fileValue.getValue();
      IOUtils.copy(inputStream, response.getOutputStream());
    }


  }
}
