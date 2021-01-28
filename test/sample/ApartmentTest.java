package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {
    Apartment testApartment;

    @BeforeEach
    void init(){
        testApartment = new Apartment(1,3,100,true,new Person("John",30));
        testApartment.getInhabitants().add(new Person("Mark",20));
    }


    @Test
    void addInhabitant() {
        ArrayList<Person> expected = new ArrayList<Person>(){
            {
                add(new Person("John",30));
                add(new Person("Mark",20));
                add(new Person("Peter",55));
            }
        };

        testApartment.addInhabitant(new Person("Peter",55));

        assertIterableEquals(expected,testApartment.getInhabitants());
    }

    @Test
    void removeInhabitant() {
        ArrayList<Person> expected = new ArrayList<Person>(){
            {
                add(new Person("John",30));
            }
        };

        testApartment.removeInhabitant(new Person("Peter",55));
        testApartment.removeInhabitant(new Person("Mark",20));

        assertIterableEquals(expected,testApartment.getInhabitants());
    }

    @Test
    void removeOwner() {
        ArrayList<Person> expected = new ArrayList<Person>(){
            {
                add(new Person("Mark",20));
            }
        };

        testApartment.removeOwner();

        assertIterableEquals(expected,testApartment.getInhabitants());
    }

    @Test
    void calculateTax() {
        double expected = 44;
        double actual = testApartment.calculateTax(0.2,5,10,2);
        assertEquals(expected, actual);
    }

    @Test
    void payTax() {
        testApartment.payTax();
        assertTrue(testApartment.isTaxPaid());
    }

}