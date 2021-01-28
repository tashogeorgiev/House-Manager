package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee testEmployee;

    @BeforeEach
    void init(){
        testEmployee = new Employee("test",20,5);
    }

    @Test
    void increaseNumberOfBuildings() {
        testEmployee.increaseNumberOfBuildings();

        assertEquals(1,testEmployee.getNumberOfBuildings());
    }

    @Test
    void reduceNumberOfBuildings() {
        testEmployee.setNumberOfBuildings(1);
        testEmployee.reduceNumberOfBuildings();

        assertEquals(0,testEmployee.getNumberOfBuildings());

    }

    @Test
    void addToCollectedTax() {
        testEmployee.addToCollectedTax(50);

        assertEquals(50,testEmployee.getCollectedTax());
    }

    @Test
    void setName() {
        testEmployee.setName("test2");

        assertEquals("test2",testEmployee.getName());
    }

    @Test
    void setAge() {
        testEmployee.setAge(30);

        assertEquals(30,testEmployee.getAge());
    }

    @Test
    void setSalary() {
        testEmployee.setSalary(3000);

        assertEquals(3000,testEmployee.getSalary());
    }

    @Test
    void setEmployeeID() {
        testEmployee.setEmployeeID(55);

        assertEquals(55,testEmployee.getEmployeeID());
    }

    @Test
    void setNumberOfBuildings() {
        testEmployee.setNumberOfBuildings(8);

        assertEquals(8,testEmployee.getNumberOfBuildings());
    }

    @Test
    void setWorksForCompany() {
        Company testCompany = new Company("TestCompany");
        testEmployee.setWorksForCompany(testCompany);

        assertEquals(new Company("TestCompany"),testEmployee.getWorksForCompany());
    }

    @Test
    void setTaxToCollect() {
        testEmployee.setTaxToCollect(800);

        assertEquals(800,testEmployee.getTaxToCollect());
    }

    @Test
    void setCollectedTax() {
        testEmployee.setCollectedTax(500);

        assertEquals(500,testEmployee.getCollectedTax());
    }

    @Test
    void setWorkExperience() {
        testEmployee.setWorkExperience(12);

        assertEquals(12,testEmployee.getWorkExperience());
    }

    @Test
    void getName() {
        assertEquals("test",testEmployee.getName());
    }

    @Test
    void getAge() {
        assertEquals(20,testEmployee.getAge());
    }

    @Test
    void getSalary() {
        testEmployee.setSalary(4000);
        int result = testEmployee.getSalary();

        assertEquals(4000,result);
    }

    @Test
    void getEmployeeID() {
        testEmployee.setEmployeeID(4);
        int result = testEmployee.getEmployeeID();

        assertEquals(4,result);
    }

    @Test
    void getWorkExperience() {
        assertEquals(5,testEmployee.getWorkExperience());
    }

    @Test
    void getNumberOfBuildings() {
        testEmployee.setNumberOfBuildings(21);
        int result = testEmployee.getNumberOfBuildings();

        assertEquals(21,result);
    }

    @Test
    void getWorksForCompany() {
        Company testCompany = new Company("TestCompany");
        testEmployee.setWorksForCompany(testCompany);
        Company newCompany = testEmployee.getWorksForCompany();

        assertEquals(testCompany, newCompany);
    }

    @Test
    void getTaxToCollect() {
        testEmployee.setTaxToCollect(1200);
        double result = testEmployee.getTaxToCollect();


        assertEquals(1200,result);
    }

    @Test
    void getCollectedTax() {
        testEmployee.setCollectedTax(1000);
        double result = testEmployee.getCollectedTax();


        assertEquals(1000,result);
    }

    @Test
    void equals(){
        Employee testEmployee2 = new Employee("test",20,5);

        assertEquals(testEmployee,testEmployee2);
    }
}