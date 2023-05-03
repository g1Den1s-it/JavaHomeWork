package Lab_8_test;

import org.example.Lab_8.Scans;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataProviderScansTest {

    @DataProvider
    private Object[][] GetInfoProvider(){
        int n = 3;
        int m = 3;

        Object[][] res = new Object[n][m];
        res[0] = new Object[]{"John", 30, "Your name is John\nyour age is 30"};
        res[1] = new Object[]{"Denys", 19, "Your name is Denys\nyour age is 19"};
        res[2] = new Object[]{"Miky", 28, "Your name is Miky\nyour age is 28"};

        return res;
    }


    @Test
    public void testSetName() {
        Scans scans = new Scans();
        String name = "John";
        scans.setName(name);
        assertEquals(name, scans.getName());
    }

    @Test
    public void testSetAge() {
        Scans scans = new Scans();
        int age = 30;
        scans.setAge(age);
        assertEquals(age, scans.getAge());
    }

    @Test(dataProvider = "GetInfoProvider")
    public void testGetInfo(String name, int n, String expectedOutput) {
        Scans scans = new Scans();
        scans.setName(name);
        scans.setAge(n);
        assertEquals(expectedOutput, scans.getInfo());
    }
}
