package Lab_8_test;

import org.example.Lab_8.Scans;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParametrizedScansTest {

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

    @Parameters({"name", "n", "expectedOutput"})
    @Test
    public void testGetInfo(String name, int n, String expectedOutput) {
        Scans scans = new Scans();
        scans.setName(name);
        scans.setAge(n);
        assertEquals(expectedOutput, scans.getInfo());
    }

}
