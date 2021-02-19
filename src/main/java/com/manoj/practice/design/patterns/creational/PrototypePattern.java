package com.manoj.practice.design.patterns.creational;

import java.util.ArrayList;
import java.util.List;

public class PrototypePattern {

    public static void main(String args[]) {
        Address a1 = new Address("Blr", "Kar", "Ind");
        List<Address> addrList = new ArrayList<>();
        addrList.add(a1);

        EmployeePrototype e1 = new EmployeePrototype("1", "Manoj", addrList);

        System.out.println(String.format("HashCode of e1: %s", e1.hashCode()));

        EmployeePrototype e2 = e1.clone();

        System.out.println(String.format("HashCode of e2: %s", e2.hashCode()));
    }
}

class EmployeePrototype implements Cloneable {

    private String empId;
    private String name;
    private List<Address> addressList;

    public EmployeePrototype(String empId, String name, List<Address> addressList) {
        this.empId = empId;
        this.name = name;
        this.addressList = addressList;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "EmployeePrototype [empId=" + empId + ", name=" + name + ", addressList=" + addressList + "]";
    }

    @Override
    public EmployeePrototype clone() {

        List<Address> addrList = new ArrayList<>();
        this.addressList.forEach(a -> addrList.add(a.clone()));
        EmployeePrototype n = new EmployeePrototype(this.empId, this.name, addrList);

        return n;
    }

}

class Address {

    private String city;
    private String state;
    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "AddressPrototype [city=" + city + ", state=" + state + ", country=" + country + "]";
    }

    @Override
    public Address clone() {
        return new Address(this.city, this.state, this.country);
    }

}