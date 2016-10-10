package prv.mark.test.springlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * http://www.journaldev.com/2637/spring-bean-life-cycle
 *
 * Created by mlglenn on 10/10/2016.
 */
@Configuration
//@Profile("test")
public class EmployeeServiceConfig {

    @Bean(name="employeeBean")
    public Employee employee() {
        return new Employee();
    }

    @Bean(name="employeeServiceInitializingBean")
    public EmployeeServiceInitializingBean employeeServiceInitializingBean() {
        return new EmployeeServiceInitializingBean();
    }

    @Bean
    public EmployeeServiceCustomInitBean employeeServiceCustomInitBean() {
        return new EmployeeServiceCustomInitBean();
    }

    @Bean
    public EmployeeServicePostConstructBean employeeServicePostConstructBean() {
        return new EmployeeServicePostConstructBean();
    }
}
