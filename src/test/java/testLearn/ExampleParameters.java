package testLearn;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExampleParameters {
    @BeforeClass
    public void beforeclass() {
        System.out.println("this is befor class");
    }

    @AfterClass
    public void afterclass() {
        System.out.println("this is after class");
    }

    @Parameters({"name","age","sex"})
    @Test
    public void testParameters(String name,int age, String sex) {
        System.out.println("hahaah");
        System.out.println(name + age + sex);
    }


}
