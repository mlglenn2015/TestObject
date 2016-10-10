package prv.mark.test.springlifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.journaldev.com/2637/spring-bean-life-cycle
 *
 * Created by mlglenn on 10/10/2016.
 */
public class EmployeeServiceCustomInitBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceCustomInitBean.class);
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeServiceCustomInitBean(){
        LOGGER.debug("EmployeeServiceCustomInitBean: no-args constructor called");
    }

    //pre-destroy method
    public void destroy() throws Exception {
        LOGGER.debug("EmployeeServiceCustomInitBean.destroy() Closing resources");
    }

    //post-init method
    public void init() throws Exception {
        LOGGER.debug("EmployeeServiceCustomInitBean.init() initializing to dummy value");
        if ((employee != null) && (employee.getName() == null)) {
            employee.setName("Mark");
        }
    }

}
