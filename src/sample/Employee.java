package sample;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private int salary;
    private int workExperience;
    private int employeeID;
    private int numberOfBuildings = 0;
    private Company worksForCompany;
    private double taxToCollect = 0;
    private double collectedTax = 0;


    public Employee(){}


    public Employee(String name, int age, int workExperience){
        this.age = age;
        this.name = name;
        this.workExperience = workExperience;
    }

    public void increaseNumberOfBuildings(){
        numberOfBuildings++;
    }

    public void reduceNumberOfBuildings(){
        numberOfBuildings--;
    }

    public void addToCollectedTax(double tax){
        collectedTax+=tax;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setNumberOfBuildings(int numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }
    public void setWorksForCompany(Company worksForCompany) {
        this.worksForCompany = worksForCompany;
    }
    public void setTaxToCollect(double taxToCollect) {
        this.taxToCollect = taxToCollect;
    }
    public void setCollectedTax(double collectedTax) {
        this.collectedTax = collectedTax;
    }
    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }


    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getSalary() {
        return salary;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public int getWorkExperience() {
        return workExperience;
    }
    public int getNumberOfBuildings() {
        return numberOfBuildings;
    }
    public Company getWorksForCompany() {
        return worksForCompany;
    }
    public double getTaxToCollect() {
        return taxToCollect;
    }
    public double getCollectedTax() {
        return collectedTax;
    }

    @Override
    public String toString() {
        return name + " id:" + employeeID + ", age:" + age;
    }


    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.employeeID,o.employeeID);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && workExperience == employee.workExperience && name.equals(employee.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age, workExperience);
    }
}