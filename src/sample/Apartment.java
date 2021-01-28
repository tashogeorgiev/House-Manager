package sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Apartment {
    private int apartmentNumber;
    private int floor;
    private int area;
    private double tax = 0;
    private boolean hasPet;
    private boolean isTaxPaid = false;
    private Person owner;
    private ArrayList<Person> inhabitants;
    private Date paymentDeadline;
    private Date dateOfPayment;

    public Apartment(){}

    public Apartment(int apartmentNumber, int floor, int area,boolean hasPet, Person owner){
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
        this.area = area;
        this.hasPet = hasPet;
        this.owner = owner;
        inhabitants = new ArrayList<Person>();
        inhabitants.add(owner);
    }

    public void addInhabitant(Person person){
        inhabitants.add(person);
    }
    public void removeInhabitant(Person person){
        inhabitants.remove(person);
    }
    public void removeOwner(){
        inhabitants.remove(owner);
    }

    public double calculateTax(double areaTax, double adultTax, double petTax, double elevatorTax){
        tax = 0;

        for(Person person : inhabitants){
            if(person.getAge() > 7){ //if person is above 7 years add tax
                tax+=adultTax;
                if(floor>2){ //if apartment is above the first or second floor add tax per person
                    tax+=elevatorTax;
                }
            }
        }
        if(hasPet){ //add tax for pet
            tax+=petTax;
        }

        tax += area*areaTax;

        return tax;
    }


    public double payTax(){
        dateOfPayment = new Date();

        isTaxPaid = true;
        return tax;
    }


    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public void setArea(int area) {
        this.area = area;
    }
    public void setHasPet(boolean hasPet) {
        this.hasPet = hasPet;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
        inhabitants.set(0, owner);
    }
    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public void setIsTaxPaid(boolean isTaxPaid) {
        this.isTaxPaid = isTaxPaid;
    }
    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }


    public int getApartmentNumber() {
        return apartmentNumber;
    }
    public int getFloor() {
        return floor;
    }
    public int getArea() {
        return area;
    }
    public boolean getHasPet() {
        return hasPet;
    }
    public Person getOwner() {
        return owner;
    }
    public double getTax() {
        return tax;
    }
    public Date getDateOfPayment() {
        return dateOfPayment;
    }
    public boolean isTaxPaid() {
        return isTaxPaid;
    }
    public Date getPaymentDeadline() {
        return paymentDeadline;
    }
    public ArrayList<Person> getInhabitants() {
        return inhabitants;
    }


    @Override
    public String toString() {
        return "Apartment number: " + apartmentNumber + ", floor: " + floor + ", area: " + area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return apartmentNumber == apartment.apartmentNumber && owner.equals(apartment.owner);
    }


    @Override
    public int hashCode() {
        return Objects.hash(apartmentNumber, owner);
    }
}