package Lab_8_test;

import org.example.Lab_8.Scans;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ScansTest {

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

    @Test
    public void testGetInfo() {
        Scans scans = new Scans();
        scans.setName("John");
        scans.setAge(30);
        String expectedOutput = "Your name is John\nyour age is 30";
        assertEquals(expectedOutput, scans.getInfo());
    }
}
