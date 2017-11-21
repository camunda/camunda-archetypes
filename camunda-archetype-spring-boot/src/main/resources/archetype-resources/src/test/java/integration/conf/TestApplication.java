package ${package}.integration.conf;

import ${package}.CamundaApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {CamundaApplication.class})
@EnableAutoConfiguration
@TestConfiguration
public class TestApplication {

}
