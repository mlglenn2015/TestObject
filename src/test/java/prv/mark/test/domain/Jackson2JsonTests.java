package prv.mark.test.domain;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mlglenn on 8/17/2016.
 */
public class Jackson2JsonTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(Jackson2JsonTests.class);
    private static final String EMPTY = "";

    @Before
    public void setUp() {
        LOGGER.debug("Jackson2JsonTests.setUp()");
    }

    @Test
    public void testConvertObjectToJson() {
        Staff employee = createDummyObject();
        assertNotNull(employee);
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert object to JSON string and save into a file directly
            mapper.writeValue(new File("employee.json"), employee);

            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(employee);
            LOGGER.debug("Raw JSON String:{}", jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            LOGGER.debug("Pretty JSON String:{}", jsonInString);

        } catch (JsonGenerationException | JsonMappingException  e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
08-17-2016 16:36:19.080 DEBUG p.mark.test.domain.Jackson2JsonTests - Raw JSON String:{"fname":"FirstName","lname":"LastName","mname":"MiddleName","otherName":"","gender":"M","birthDate":{"year":1970,"month":"NOVEMBER","dayOfYear":316,"leapYear":false,"dayOfMonth":12,"monthValue":11,"dayOfWeek":"THURSDAY","era":"CE","chronology":{"id":"ISO","calendarType":"iso8601"}},"idNumber":"SSN123456789","position":"Developer","salary":7500,"skills":["java","python","oracledb"],"age":45}

08-17-2016 16:36:19.088 DEBUG p.mark.test.domain.Jackson2JsonTests - Pretty JSON String:{
  "fname" : "FirstName",
  "lname" : "LastName",
  "mname" : "MiddleName",
  "otherName" : "",
  "gender" : "M",
  "birthDate" : {
    "year" : 1970,
    "month" : "NOVEMBER",
    "dayOfYear" : 316,
    "leapYear" : false,
    "dayOfMonth" : 12,
    "monthValue" : 11,
    "dayOfWeek" : "THURSDAY",
    "era" : "CE",
    "chronology" : {
      "id" : "ISO",
      "calendarType" : "iso8601"
    }
  },
  "idNumber" : "SSN123456789",
  "position" : "Developer",
  "salary" : 7500,
  "skills" : [ "java", "python", "oracledb" ],
  "age" : 45
}
     */

    @Test
    public void testConvertJsonToJavaObject() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert JSON record in file to Java object
            Staff employee = mapper.readValue(new File("employee.json"), Staff.class);
            LOGGER.debug("Staff: {}", employee.toString());

            // Convert object to JSON string and pretty print
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            LOGGER.debug("Pretty JSON String:{}", jsonInString);

        } catch (JsonGenerationException | JsonMappingException  e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
   08-17-2016 16:55:33.491 DEBUG p.mark.test.domain.Jackson2JsonTests - Jackson2JsonTests.setUp()
08-17-2016 16:55:33.732 DEBUG p.mark.test.domain.Jackson2JsonTests - Staff: Staff{position='Developer', salary=7500}
08-17-2016 16:55:33.760 DEBUG p.mark.test.domain.Jackson2JsonTests - Pretty JSON String:{
  "fname" : "FirstName",
  "lname" : "LastName",
  "mname" : "MiddleName",
  "otherName" : "",
  "gender" : "M",
  "idNumber" : "SSN123456789",
  "position" : "Developer",
  "salary" : 7500,
  "skills" : [ "java", "python", "oracledb" ]
}
     */

    @Test
    public void testJsonViews() {
        JsonViewEmployee employee = createJsonViewEmployee();
        assertNotNull(employee);
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Salary will be hidden
            LOGGER.debug("Normal View");
            String normalView = mapper.writerWithView(Views.Normal.class).writeValueAsString(employee);
            LOGGER.debug(normalView);

            // Display everything
            System.out.println("\nManager View");
            String managerView = mapper.writerWithView(Views.Manager.class).writeValueAsString(employee);
            System.out.println(managerView);

        } catch (JsonGenerationException | JsonMappingException  e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    08-17-2016 17:12:47.396 DEBUG p.mark.test.domain.Jackson2JsonTests - Jackson2JsonTests.setUp()
08-17-2016 17:12:47.594 DEBUG p.mark.test.domain.Jackson2JsonTests - Normal View
08-17-2016 17:12:47.675 DEBUG p.mark.test.domain.Jackson2JsonTests - {"fname":"FirstName","lname":"LastName","mname":"MiddleName","otherName":"","gender":"M","position":"Developer","skills":[]}

Manager View
{"fname":"FirstName","lname":"LastName","mname":"MiddleName","otherName":"","gender":"M","idNumber":"SSN123456789","position":"Developer","salary":7500,"skills":[]}
     */




    private JsonViewEmployee createJsonViewEmployee() {
        Staff staff = createDummyObject();
        JsonViewEmployee emp = new JsonViewEmployee(staff.getFname(), staff.getLname(), staff.getMname(), staff.getOtherName(),
                staff.getGender(), staff.getIdNumber(), staff.getPosition(), staff.getSalary(), new ArrayList<>());
        return emp;
    }

    private Staff createDummyObject() {
        Staff staff = new Staff();
        staff.setFname("FirstName");
        staff.setLname("LastName");
        staff.setMname("MiddleName");
        staff.setOtherName(EMPTY);
        staff.setGender("M");
        staff.setIdNumber("SSN123456789");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.getDefault() );
        LocalDate date = LocalDate.parse("1970-11-12", formatter);
        //staff.setBirthDate(date);

        staff.setPosition("Developer");
        staff.setSalary(new BigDecimal("7500"));
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        skills.add("oracledb");
        staff.setSkills(skills);
        return staff;
    }
}
