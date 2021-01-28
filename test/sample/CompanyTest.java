package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Person John;
    Person Kate;
    Person Mark;
    Person Ana;
    Person Will;
    Person Aria;
    Person Josh;
    Person Mia;
    Person Michael;
    Person Bob;
    Person Henry;
    Person David;
    Person Hannah;
    Person Emily;
    Apartment apartment1;
    Apartment apartment2;
    Apartment apartment3;
    Apartment apartment4;
    Apartment apartment5;
    Apartment apartment6;
    Building testBuilding1;
    Building testBuilding2;
    Building testBuilding3;
    Employee employee1;
    Employee employee2;
    Employee employee3;
    Company testCompany;

    @BeforeEach
    void init() throws IOException {
        John = new Person("John",30);
        Kate = new Person("Kate",25);
        Henry = new Person("Henry",9);
        apartment1 = new Apartment(1,1,80,false,John);
        apartment1.addInhabitant(John);
        apartment1.addInhabitant(Kate);
        apartment1.addInhabitant(Henry);


        Mark = new Person("Mark",41);
        Emily = new Person("Emily",42);
        apartment2 = new Apartment(2,2,80,true,Mark);
        apartment2.addInhabitant(Mark);
        apartment2.addInhabitant(Emily);

        Will = new Person("Will",50);
        Aria = new Person("Peter",45);
        Hannah = new Person("Hannah",16);
        apartment3 = new Apartment(1,1,100,false,Will);
        apartment3.addInhabitant(Will);
        apartment3.addInhabitant(Aria);
        apartment3.addInhabitant(Hannah);

        Josh = new Person("Josh",40);
        Ana = new Person("Ana",33);
        Michael = new Person("Michael",5);
        apartment4 = new Apartment(2,2,100,true,Josh);
        apartment4.addInhabitant(Josh);
        apartment4.addInhabitant(Ana);
        apartment4.addInhabitant(Michael);

        David = new Person("David",24);
        Mia = new Person("Mia",24);
        apartment5 = new Apartment(1,1,120,false,David);
        apartment5.addInhabitant(Mia);
        apartment5.addInhabitant(David);

        Bob = new Person("Bob",65);
        apartment6 = new Apartment(2,2,120,false,Bob);
        apartment6.addInhabitant(Bob);

        testBuilding1 = new Building("Sofia-bul. Tsarigradsko Shose-29",2,3);
        testBuilding1.addApartment(apartment1);
        testBuilding1.addApartment(apartment2);

        testBuilding2 = new Building("Sofia-Narodno Horo-76",2,3);
        testBuilding2.addApartment(apartment3);
        testBuilding2.addApartment(apartment4);

        testBuilding3 = new Building("Sofia-prof. Asen Zlatarov-29",2,2);
        testBuilding3.addApartment(apartment5);
        testBuilding3.addApartment(apartment6);


        employee1 = new Employee("Ivan",25,5);
        employee2 = new Employee("Matt",40,17);
        employee3 = new Employee("Antony",36,9);
        testCompany = new Company("testCompany");
        testCompany.addEmployee(employee1);
        testCompany.addEmployee(employee2);
        testCompany.addEmployee(employee3);
        testCompany.addBuilding(testBuilding1);
        testCompany.addBuilding(testBuilding2);

    }



    @Test
    void addEmployee() {
        Set<Employee> expectedSet = new HashSet<>(){
            {
                add(new Employee("Ivan",25,5));
                add(new Employee("Matt",40,17));
                add(new Employee("Antony",36,9));
                add(new Employee("David",50,20));
            }
        };

        testCompany.addEmployee(new Employee("David",50,20));

        assertIterableEquals(expectedSet, testCompany.ShowEmployees());
    }

    @Test
    void removeEmployee() {
        Set<Employee> expectedSet = new HashSet<>(){
            {
                add(new Employee("Ivan",25,5));
                add(new Employee("Matt",40,17));
            }
        };

        testCompany.removeEmployee(new Employee("Antony",36,9));

        assertIterableEquals(expectedSet, testCompany.ShowEmployees());
    }


    @Test
    void addBuilding() throws IOException {
        Set<Building> expectedSet = new HashSet<>() {
            {
                add(new Building("Sofia-bul. Tsarigradsko Shose-29", 2, 3));
                add(new Building("Sofia-Narodno Horo-76", 2, 3));
                add(new Building("Sofia-prof. Asen Zlatarov-29", 2, 2));
            }
        };


        testCompany.addBuilding(testBuilding3);
        Set<Building> actualSet = new HashSet<>();
        for (Map.Entry<Employee, Set<Building>> entry : testCompany.getEmployeeBuildings().entrySet()) {
            Set<Building> buildings = entry.getValue();
            actualSet.addAll(buildings);
        }

        assertIterableEquals(expectedSet,actualSet);
    }


    @Test
    void calculateTaxToCollect() {
        double expected = 162;
        testCompany.calculateTaxToCollect();
        double actual = testCompany.getTaxToCollect();
        assertEquals(expected,actual);
    }

    @Test
    void collectTax() {
        double expected = 162;
        testCompany.calculateTaxToCollect();
        testCompany.collectTax();
        double actual = testCompany.getTaxCollected();
        assertEquals(expected,actual);
    }

    @Test
    void collectTaxForApartment() {
        //total tax collected in test class is 0, so after collecting the tax, it should be equal to the apartment's tax
        double expected = apartment1.calculateTax(testCompany.getAreaTax(),testCompany.getAdultTax(),testCompany.getPetTax(),testCompany.getElevatorTax());
        testCompany.collectTaxForApartment(apartment1);
        double actual = testCompany.getTaxCollected();
        assertEquals(expected,actual);
    }


    @Test
    void sortEmployeesByName() {
        ArrayList<Employee> expectedList = new ArrayList<>(){
            {
                add(new Employee("Antony",36,9));
                add(new Employee("Ivan",25,5));
                add(new Employee("Matt",40,17));
            }
        };

        assertIterableEquals(expectedList, testCompany.sortEmployeesByName());
    }

    @Test
    void sortEmployeesByNumOfBuildings() {
        ArrayList<Employee> expectedList = new ArrayList<>(){
            {
                add(new Employee("Ivan",25,5));
                add(new Employee("Antony",36,9));
                add(new Employee("Matt",40,17));
            }
        };

        assertIterableEquals(expectedList,testCompany.sortEmployeesByNumOfBuildings());
    }

    @Test
    void showEmployees() {
        Set<Employee> employeeSet = new HashSet<Employee>();
        employeeSet.add(new Employee("Ivan",25,5));
        employeeSet.add(new Employee("Matt",40,17));
        employeeSet.add(new Employee("Antony",36,9));


        assertEquals(employeeSet, testCompany.ShowEmployees());
    }

    @Test
    void buildingsByEmployee() throws IOException {
        Set<Building> testSet = new HashSet<Building>();
        Building testBuilding = new Building("Sofia-bul. Tsarigradsko Shose-29",2,3);
        testSet.add(testBuilding);

        assertEquals(testSet,testCompany.BuildingsByEmployee(employee3));
    }

    @Test
    void setDateToPay() {
       testCompany.setDateToPay(new Date());

       assertEquals(apartment1.getPaymentDeadline(),new Date());
    }

    @Test
    void removeBuilding() {
        HashSet<Building> buildingHashSet = new HashSet<Building>();
        buildingHashSet.add(testBuilding1);

        testCompany.removeBuilding(testBuilding2);

        assertEquals(buildingHashSet, testCompany.BuildingsByEmployee(employee3));

    }

    @Test
    void containsBuilding() {
        assertTrue(testCompany.containsBuilding(testBuilding1));
    }

    @Test
    void containsApartment() {
        assertTrue(testCompany.containsApartment(apartment1));
    }


}