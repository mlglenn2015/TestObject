package prv.mark.test.springlifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * http://www.journaldev.com/2637/spring-bean-life-cycle
 *
 * Created by mlglenn on 10/10/2016.
 */
public class EmployeeServiceInitializingBean implements InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceInitializingBean.class);
    private Employee employee;


    public Employee getEmployee() {
        LOGGER.debug("EmployeeServiceInitializingBean.getEmployee()");
        return employee;
    }

    public void setEmployee(Employee employee) {
        LOGGER.debug("EmployeeServiceInitializingBean.setEmployee({})", employee);
        this.employee = employee;
    }

    public EmployeeServiceInitializingBean(){
        LOGGER.debug("EmployeeServiceInitializingBean: no-args constructor called");
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.debug("EmployeeServiceInitializingBean.destroy(): Closing resources");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.debug("EmployeeServiceInitializingBean.afterPropertiesSet(): initializing to dummy value");
        if (employee != null) {
            if (employee.getName() == null) {
                employee.setName("Mark");
            }
        }
    }
}
