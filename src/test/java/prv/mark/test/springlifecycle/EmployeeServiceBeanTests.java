package prv.mark.test.springlifecycle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * http://www.journaldev.com/2637/spring-bean-life-cycle
 *
 * Created by mlglenn on 10/10/2016.
 */
public class EmployeeServiceBeanTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceBeanTests.class);
    private ApplicationContext context;
    private Employee employeeBean;

    @Before
    public void setUp() {
        LOGGER.debug("setUp()");
        context = new AnnotationConfigApplicationContext(EmployeeServiceConfig.class);
        assertNotNull(context);
        employeeBean = (Employee) context.getBean("employeeBean");
        assertNotNull(employeeBean);
    }

    @After
    public void tearDown() {
        LOGGER.debug("tearDown()");
        context = null;
    }

    @Test
    public void testEmployeeServiceInitializingBean() {
        LOGGER.debug("EmployeeServiceBeanTests.testEmployeeServiceInitializingBean()");

        EmployeeServiceInitializingBean initializingBean =
                (EmployeeServiceInitializingBean) context.getBean("employeeServiceInitializingBean");
        assertNotNull(initializingBean);
        LOGGER.debug("initializingBean.getEmployee(): {}", initializingBean.getEmployee());
        employeeBean.setName("testEmployeeServiceInitializingBean()");
        initializingBean.setEmployee(employeeBean);
        LOGGER.debug("***** Employee name: {}", initializingBean.getEmployee().getName());
        /*TODO not understanding why... the destroy() method not being called unless I explicitly call it ...
        try {
            initializingBean.destroy();
        } catch (Exception e) {
            LOGGER.debug("Exception caught: {}", e);
        }*/
        /*
        10-10-2016 18:46:12.283 DEBUG p.m.t.s.EmployeeServiceBeanTests - EmployeeServiceBeanTests.testEmployeeServiceInitializingBean()
        10-10-2016 18:46:12.616 DEBUG p.m.t.s.EmployeeServiceInitializingBean - EmployeeServiceInitializingBean: no-args constructor called
        10-10-2016 18:46:12.619 DEBUG p.m.t.s.EmployeeServiceInitializingBean - EmployeeServiceInitializingBean.afterPropertiesSet(): initializing to dummy value
        10-10-2016 18:46:12.637 DEBUG p.m.t.s.EmployeeServiceInitializingBean - EmployeeServiceInitializingBean.getEmployee()
        10-10-2016 18:46:12.639 DEBUG p.m.t.s.EmployeeServiceInitializingBean - EmployeeServiceInitializingBean.setEmployee(prv.mark.test.springlifecycle.Employee@52de51b6)
        10-10-2016 18:46:12.639 DEBUG p.m.t.s.EmployeeServiceBeanTests - Employee name: testEmployeeServiceInitializingBean()
        10-10-2016 18:46:12.639 DEBUG p.m.t.s.EmployeeServiceInitializingBean - EmployeeServiceInitializingBean.destroy(): Closing resources
         */
    }

    @Test
    public void testEmployeeServiceCustomInitBean() {
        LOGGER.debug("EmployeeServiceBeanTests.testEmployeeServiceCustomInitBean()");

        EmployeeServiceCustomInitBean initializingBean =
                (EmployeeServiceCustomInitBean) context.getBean("employeeServiceCustomInitBean");
        assertNotNull(initializingBean);
        LOGGER.debug("initializingBean.getEmployee(): {}", initializingBean.getEmployee());
        employeeBean.setName("testEmployeeServiceCustomInitBean()");
        initializingBean.setEmployee(employeeBean);
        LOGGER.debug("*** Employee name: {}", initializingBean.getEmployee().getName());

        /*TODO not understanding why... the destroy() method not being called unless I explicitly call it ...
        try {
            initializingBean.destroy();
        } catch (Exception e) {
            LOGGER.debug("Exception caught: {}", e);
        }*/
        /*
        10-10-2016 18:44:02.653 DEBUG p.m.t.s.EmployeeServiceBeanTests - EmployeeServiceBeanTests.testEmployeeServiceCustomInitBean()
        10-10-2016 18:44:02.989 DEBUG p.m.t.s.EmployeeServiceCustomInitBean - EmployeeServiceCustomInitBean: no-args constructor called
         */
    }

    @Test
    public void testEmployeeServicePostConstructBean() {
        LOGGER.debug("EmployeeServiceBeanTests.testEmployeeServicePostConstructBean()");

        EmployeeServicePostConstructBean postConstructBean =
                (EmployeeServicePostConstructBean) context.getBean("employeeServicePostConstructBean");
        assertNotNull(postConstructBean);
        LOGGER.debug("postConstructBean: {}", postConstructBean);

        //postConstructBean.destroy();
        /*
        10-10-2016 18:42:18.853 DEBUG p.m.t.s.EmployeeServicePostConstructBean - EmployeeServicePostConstructBean.init() method called
        10-10-2016 18:42:18.859 DEBUG p.m.t.s.EmployeeServiceBeanTests - initializingBean: prv.mark.test.springlifecycle.EmployeeServicePostConstructBean@64a8c844
         */
    }
}
