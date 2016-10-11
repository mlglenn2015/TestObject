package prv.mark.test.springlifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * http://www.journaldev.com/2637/spring-bean-life-cycle
 *
 * Created by mlglenn on 10/10/2016.
 */
public class EmployeeServicePostConstructBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServicePostConstructBean.class);

    public EmployeeServicePostConstructBean(){
        LOGGER.debug("EmployeeServicePostConstructBean: no-args constructor called");
    }


    @PostConstruct
    public void init(){
        LOGGER.debug("EmployeeServicePostConstructBean.init() method called");
    }

    @PreDestroy
    public void destroy(){
        LOGGER.debug("EmployeeServicePostConstructBean.destroy() method called");
    }

}
