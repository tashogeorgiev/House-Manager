package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    Person John;
    Person Kate;
    Person Mark;
    Person Ana;
    Person Will;
    Apartment apartment1;
    Apartment apartment2;
    Building testBuilding;

    @BeforeEach
    void init() throws IOException {
        John = new Person("John",31);
        Kate = new Person("Kate",29);
        Mark = new Person("Mark",6);
        Ana = new Person("Ana",19);
        Will = new Person("Will",43);

        apartment1 = new Apartment(1,1,80,false,John);
        apartment1.addInhabitant(Kate);
        apartment1.addInhabitant(Mark);

        apartment2 = new Apartment(2,2,80,true,Will);
        apartment1.addInhabitant(Ana);



        testBuilding = new Building("Sofia-Tsarigradsko Shose-50",2,3);
        testBuilding.getApartments().add(apartment1);
        testBuilding.getApartments().add(apartment2);
    }

    @Test
    void calculateTaxesForAllApartments() {
        double expected = 62;
        double actual = testBuilding.calculateTaxesForAllApartments(0.2,5,10,2);
        assertEquals(expected,actual);
    }

    @Test
    void collectTaxForBuilding() {
        testBuilding.calculateTaxesForAllApartments(0.2,5,10,2);
        double expected = 62;
        double actual = testBuilding.collectTaxForBuilding();
        assertEquals(expected,actual);
    }

    @Test
    void addApartment() {
        ArrayList<Apartment> expected = new ArrayList<Apartment>(){
            {
                add(new Apartment(1,1,80,false,John));
                add(new Apartment(2,2,80,true,Will));
                add(new Apartment(3,2,80,true,new Person("Peter",34)));
            }
        };

        testBuilding.addApartment(new Apartment(3,2,80,true,new Person("Peter",34)));

        assertIterableEquals(expected, testBuilding.getApartments());
    }

    @Test
    void removeApartment() {
        ArrayList<Apartment> expected = new ArrayList<Apartment>(){
            {
                add(new Apartment(1,1,80,false,John));
            }
        };

        testBuilding.removeApartment(apartment2);

        assertIterableEquals(expected, testBuilding.getApartments());
    }

    @Test
    void sortInhabitantsByName() {
        ArrayList<Person> expected = new ArrayList<Person>(){
            {
                add(new Person("Ana",19));
                add(new Person("John",31));
                add(new Person("Kate",29));
                add(new Person("Mark",6));
                add(new Person("Will",43));
            }
        };

        ArrayList<Person> actual = new ArrayList<>(testBuilding.sortInhabitantsByName());

        assertIterableEquals(expected, actual);
    }

    @Test
    void sortInhabitantsByAge() {
        ArrayList<Person> expected = new ArrayList<Person>(){
            {
                add(new Person("Mark",6));
                add(new Person("Ana",19));
                add(new Person("Kate",29));
                add(new Person("John",31));
                add(new Person("Will",43));
            }
        };

        ArrayList<Person> actual = new ArrayList<>(testBuilding.sortInhabitantsByAge());

        assertIterableEquals(expected, actual);
    }

    @Test
    void isValidAddress() throws IOException {
        assertTrue(testBuilding.isValidAddress("Sofia-prof.d-r Ivan Strinski-1c"));

    }

    @Test
    void numOfInhabitants() {
        int expected = 5;
        int actual = testBuilding.numOfInhabitants();

        assertEquals(expected, actual);
    }


}