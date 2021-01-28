package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void getName() {
        Person test = new Person("test",20);
        String testString = "test";

        assertEquals(testString,test.getName());
    }

    @Test
    void getAge() {
        Person test = new Person("test",20);
        int testAge = 20;

        assertEquals(testAge,test.getAge());
    }

    @Test
    void setName() {
        Person test = new Person();
        test.setName("test");
        String testString = "test";

        assertEquals(testString,test.getName());
    }

    @Test
    void setAge() {
        Person test = new Person();
        test.setAge(20);
        int testAge = 20;

        assertEquals(testAge,test.getAge());
    }

    @Test
    void equals(){
        Person a = new Person("A",22);
        Person b = new Person("A",22);

        assertEquals(a,b);
    }

}