package testLearn;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExampleDataProvider {

    @DataProvider(name = "testData1")
    public Object[][] testData1() {
            return new Object[][] { { 1, 2, 3 }, { 1, 2, 4 }, { 1, 3, 4 },
                    { -1, 3, 2 } };
    }

    @DataProvider
    public Object[][] testData2() {
        return new Object[][] { { 5, 2, 3 }, { 1, 2, 4 }, { 1, -3, 4 },
                { 6, 3, 2 } };
    }

    @DataProvider(name = "testData3")
    public Object[][] createData(){
        return new Object[][] {{"Cedric",new Integer(36)},{"Anne",new Integer(37)}};
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("This is Before Class");
    }
    @Test(groups = { "add" }, dataProvider = "testData1")
    public void addTest(int a, int b, int c) {
        System.out.println("This is test add method.  "+a+" + "+ b+" = "+c);
        Assert.assertEquals(add(a, b), c);
    }

    @Test(groups = { "minus" }, dataProvider = "testData2")
    public void minusTest(int a, int b, int c) {
        System.out.println("This is test minus method.  "+a+" - "+ b+" = "+c);
        Assert.assertEquals(minus(a, b), c);
    }

    @Test(groups = { "create"}, dataProvider = "testData3")
    public void createTest(String a, Integer b) {
        System.out.println(a + " " + b);
    }

    @Test(groups = { "create"}, dataProvider = "create",dataProviderClass = StaticProvider.class)
    public void createTest1(String a, String b) {
        System.out.println(a + " " + b);
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("This is Before Method");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("This is After Method");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("This is After Class");
    }
}