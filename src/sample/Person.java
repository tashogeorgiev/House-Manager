package sample;

import java.util.Objects;

public class Person{
    private String name;
    private int age;

    public Person(){}

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return name + " " + age + " years old";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}