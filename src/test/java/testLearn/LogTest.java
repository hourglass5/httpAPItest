package testLearn;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
    private static final Log log = LogFactory.getLog("getLogger");

    @BeforeClass
    public void beforeclass() {
        System.out.println("this is befor class");
    }

    @AfterClass
    public void afterclass() {
        System.out.println("this is after class");
    }

    @Test
    public void testParameters() {
        log.info("111");
        log.debug("222");
        log.warn("333");
        log.warn("555");
    }
}