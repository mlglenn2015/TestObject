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
        EmployeeServiceInitializingBean bean = new EmployeeServiceInitializingBean();
        return bean;
    }

    /*
    <beans default-init-method="customInit" default-destroy-method="customDestroy">
        <bean id="demoBean" class="com.howtodoinjava.task.DemoBean"></bean>
    </beans>
     */
    @Bean
    public EmployeeServiceCustomInitBean employeeServiceCustomInitBean() {
        EmployeeServiceCustomInitBean bean = new EmployeeServiceCustomInitBean();
        return bean;
    }


    @Bean
    public EmployeeServicePostConstructBean employeeServicePostConstructBean() {
        EmployeeServicePostConstructBean bean = new EmployeeServicePostConstructBean();
        return bean;
    }
}
