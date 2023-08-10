package newtest.common;

import io.cucumber.spring.CucumberContextConfiguration;
import newtest.ReportApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ReportApplication.class })
public class CucumberSpingConfiguration {}
