package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Building {
    private String address;
    private int floors;
    private int numberOfApartments;
    private boolean hasCompany = false;
    private double taxToCollect = 0;
    private double collectedTax = 0;
    private ArrayList<Apartment> apartments;


    public Building(String address, int floors, int numberOfApartments) throws IOException {
        this.address = address;
        if(!isValidAddress(address)) {
            throw new IOException();
        }
        this.address = address;
        this.floors = floors;
        this.numberOfApartments = numberOfApartments;
        apartments = new ArrayList<>(numberOfApartments);
    }

    public double calculateTaxesForAllApartments(double areaTax, double adultTax, double petTax, double elevatorTax){
        taxToCollect = 0;
        for(Apartment apartment : apartments){
            if(!apartment.isTaxPaid()) {
                taxToCollect += apartment.calculateTax(areaTax, adultTax, petTax, elevatorTax);
            }
        }
        return taxToCollect;
    }

    public double collectTaxForBuilding(){
        for(Apartment apartment : apartments){
            if(!apartment.isTaxPaid()) {
                collectedTax += apartment.getTax();
                apartment.payTax();
            }
        }
        return collectedTax;
    }

    public void addApartment(Apartment apartment){
        if(apartments.size() < numberOfApartments) {
            apartments.add(apartment);
        }else throw new ArrayIndexOutOfBoundsException();
    }
    public void removeApartment(Apartment apartment){
        if(apartments.size() > 0) {
            apartments.remove(apartment);
        }else throw new NullPointerException();
    }


    public ArrayList<Person> sortInhabitantsByName(){
        ArrayList<Person> inhabitantsArray = new ArrayList<>();
        for(Apartment apartment : apartments){
            inhabitantsArray.addAll(apartment.getInhabitants());
        }

        inhabitantsArray.sort(Comparator.comparing(Person::getName));

        return inhabitantsArray;
    }


    public ArrayList<Person> sortInhabitantsByAge(){
        ArrayList<Person> inhabitantsArray = new ArrayList<>();
        for(Apartment apartment : apartments){
            inhabitantsArray.addAll(apartment.getInhabitants());
        }

        inhabitantsArray.sort(Comparator.comparingInt(Person::getAge));

        return inhabitantsArray;
    }


    public boolean isValidAddress(String address){
        Pattern r = Pattern.compile("[a-zA-z\\s]+(\\-)+([a-zA-Z\\s?\\.?\\-])+(\\-)+\\d?\\w");
        Matcher m = r.matcher(address);
        return m.find();
    }


    public int numOfInhabitants(){
        int num = 0;
        for(Apartment apartment : apartments){
            num += apartment.getInhabitants().size();
        }
        return num;
    }


    public void addToCollectedTax(double tax){
        collectedTax+=tax;
    }


    public void setAddress(String address) throws IOException {
        if(!isValidAddress(address)) {
            throw new IOException();
        }
        this.address = address;
    }
    public void setFloors(int floors) {
        this.floors = floors;
    }
    public void setHasCompany(boolean hasCompany) {
        this.hasCompany = hasCompany;
    }
    public void setNumberOfApartments(int numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }
    public void setCollectedTax(double collectedTax) {
        this.collectedTax = collectedTax;
    }

    public String getAddress() {
        return address;
    }
    public int getFloors() {
        return floors;
    }
    public int getNumberOfApartments() {
        return numberOfApartments;
    }
    public boolean hasCompany() {
        return hasCompany;
    }
    public double getCollectedTax() {
        return collectedTax;
    }
    public double getTaxToCollect() {
        return taxToCollect;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }


    @Override
    public String toString() {
        return address + ", floors:" + floors + ", apartments:" + getApartments().size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return address.equals(building.address);
    }


    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}