package sample;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Company {
    private String name;
    private double taxToCollect = 0;
    private double taxCollected = 0;
    private Set<Employee> employeeSet;
    private TreeMap<Employee, Set<Building>> employeeBuildings;
    private int employeeID = 0;
    private double adultTax = 5;
    private double petTax = 10;
    private double elevatorTax = 2;
    private double areaTax = 0.2;

    public Company() {
        employeeSet = new HashSet<>();
        employeeBuildings = new TreeMap<>();
    }

    public Company(String name) {
        this.name = name;
        employeeSet = new HashSet<>();
        employeeBuildings = new TreeMap<>();
    }

    public Set<Employee> ShowEmployees(){
        return employeeSet;
    }

    //When adding an employee, set his id,
    //set the company he's working for to be this one
    //and add him to the data sets in the company
    public void addEmployee(Employee employee) {
        employeeID++;
        employee.setEmployeeID(employeeID);
        employee.setWorksForCompany(this);
        employeeSet.add(employee);
        employeeBuildings.put(employee, new HashSet<>());
    }

    Set<Building> BuildingsByEmployee(Employee employee) {
        return employeeBuildings.get(employee);
    }

    public void calculateTaxToCollect() {
        taxToCollect = 0;
        for(Employee employee : employeeSet){
            double taxPerEmployee = 0;
            Set<Building> buildings = employeeBuildings.get(employee);

            for (Building building : buildings) {
                double temp = building.calculateTaxesForAllApartments(areaTax, adultTax, petTax, elevatorTax);
                taxToCollect += temp;//Will accumulate for all buildings
                taxPerEmployee += temp;//Will calculate only for each employee
            }
            employee.setTaxToCollect(taxPerEmployee);
        }
    }

    public void collectTax(){//collects for all buildings
        for(Employee employee : employeeSet){
            double payedTaxPerEmployee = 0;
            Set<Building> buildings = employeeBuildings.get(employee);

            for(Building building : buildings) {
                double temp = building.collectTaxForBuilding();
                taxCollected += temp;
                payedTaxPerEmployee += temp;
            }
            employee.setCollectedTax(payedTaxPerEmployee);
        }
    }

    public void setDateToPay(Date deadline){
        for(Employee employee : employeeSet){
            for(Building building : employeeBuildings.get(employee)){
                for(Apartment apartment : building.getApartments()){
                    apartment.setPaymentDeadline(deadline);
                }
            }
        }
    }

    public void collectTaxForApartment(Apartment apartment){
        for (Map.Entry<Employee, Set<Building>> entry : employeeBuildings.entrySet()) {
            Employee employee = entry.getKey();
            Set<Building> buildings = entry.getValue();

            //find apartment to pay tax and add the payment to its building, the building's employee and the company's income
            for(Building building1 : buildings){
                for(Apartment apartment1 : building1.getApartments()){
                    if(apartment1 == apartment){
                        if(!apartment.isTaxPaid()) {
                            apartment1.calculateTax(areaTax,adultTax,petTax,elevatorTax);
                            building1.addToCollectedTax(apartment1.payTax());
                            employee.addToCollectedTax(apartment1.payTax());
                            this.taxCollected += apartment1.payTax();
                            break;
                        }
                    }
                }
            }
        }
    }


    public void addBuilding(Building building) { //find the employee working on the least amount of buildings and add the building to him
        Employee temp = new Employee();
        int lowestNum = employeeBuildings.firstEntry().getValue().size();


        for (Map.Entry<Employee, Set<Building>> entry : employeeBuildings.entrySet()) {
            Employee employee = entry.getKey();
            Set<Building> buildings = entry.getValue();

            if (buildings.size() <= lowestNum) {
                lowestNum = buildings.size();
                temp = employee;
            }
        }

        employeeBuildings.get(temp).add(building);
        temp.increaseNumberOfBuildings();
        building.setHasCompany(true);
    }

    public void removeBuilding(Building building){
        for (Map.Entry<Employee, Set<Building>> entry : employeeBuildings.entrySet()) {
            Employee employee = entry.getKey();
            Set<Building> buildings = entry.getValue();

            if(buildings.remove(building)){
                employee.reduceNumberOfBuildings();
                break;
            }
        }
    }

    public boolean containsBuilding(Building building) {
        for (Map.Entry<Employee, Set<Building>> entry : employeeBuildings.entrySet()) {
            Set<Building> buildings = entry.getValue();
            if (buildings.contains(building)) {
                return true;
            }
        }
        return false;
    }

    //this function is needed when showing taxes for individual apartments
    //because there is no way to calculate their taxes without knowing
    //which company's tax rates to use
    public boolean containsApartment(Apartment apartment){
        for (Map.Entry<Employee, Set<Building>> entry : employeeBuildings.entrySet()) {
            Set<Building> buildings = entry.getValue();

            for(Building building : buildings){
                for(Apartment apartment1 : building.getApartments()){
                    if(building.getApartments().contains(apartment1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void removeEmployee(Employee employee) {// get the employee's buildings set and transfer buildings after releasing him
        Set<Building> buildings = employeeBuildings.get(employee);
        employeeBuildings.remove(employee,employeeBuildings.get(employee));
        employeeSet.remove(employee);

        if(buildings!=null) {//transfer buildings to other employees
            for (Building building : buildings) {
                addBuilding(building);
            }
        }
    }

    public ArrayList<Employee> sortEmployeesByName(){
        ArrayList<Employee> nameList = new ArrayList<>(employeeSet);
        nameList.sort(Comparator.comparing(Employee::getName));
        return nameList;
    }


    public ArrayList<Employee> sortEmployeesByNumOfBuildings() {
        ArrayList<Employee> numList = new ArrayList<>(employeeSet);
        numList.sort(Comparator.comparing(Employee::getNumberOfBuildings));
        return numList;
    }

    public void writeTaxesToFile() throws IOException {
        try {
            FileWriter writer = new FileWriter(this.name+".txt");
            if(taxCollected > 0) {
            writer.write("Company: " + this.name + "\n");
                for (Employee employee : employeeSet) {
                    if (employee.getCollectedTax() > 0) {
                        writer.write("Employee: " + employee.getName() + "\n");
                        for (Building building : employeeBuildings.get(employee)) {
                            if (building.getCollectedTax() > 0) {
                                writer.write("Building: " + building.getAddress() + "\n");
                                for (Apartment apartment : building.getApartments()) {
                                    if(apartment.isTaxPaid()) {
                                        writer.write("Apartment #" + apartment.getApartmentNumber() + ", Tax: " + apartment.getTax()
                                                + ", Payment date: " + apartment.getDateOfPayment() + "\n");
                                    }
                                }
                            }
                        }
                        writer.write("===============================\n");
                    }
                }
            }
            writer.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void setAreaTax(double areaTax) {
        this.areaTax = areaTax;
    }
    public void setAdultTax(double childTax) {
        this.adultTax = childTax;
    }
    public void setElevatorTax(double elevatorTax) {
        this.elevatorTax = elevatorTax;
    }
    public void setPetTax(double petTax) {
        this.petTax = petTax;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setTaxToCollect(double taxToCollect) {
        this.taxToCollect = taxToCollect;
    }
    public void setEmployeeBuildings(TreeMap<Employee, Set<Building>> employeeBuildings) {
        this.employeeBuildings = employeeBuildings;
    }
    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTaxCollected(double taxCollected) {
        this.taxCollected = taxCollected;
    }

    public String getName() {
        return name;
    }
    public double getTaxToCollect() {
        return taxToCollect;
    }
    public double getTaxCollected() {
        return taxCollected;
    }
    public double getAreaTax() {
        return areaTax;
    }
    public double getAdultTax() {
        return adultTax;
    }
    public double getElevatorTax() {
        return elevatorTax;
    }
    public double getPetTax() {
        return petTax;
    }
    public TreeMap<Employee, Set<Building>> getEmployeeBuildings() {
        return employeeBuildings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return name.equals(company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Company " +name;
    }
}