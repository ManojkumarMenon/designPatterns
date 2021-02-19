package com.manoj.practice.design.patterns.creational;

import com.manoj.practice.design.patterns.creational.EmployeeObject.EmployeeObjectBuilder;

public class BuilderPattern {

    public static void main(String args[]) {
        EmployeeObjectBuilder builder = new EmployeeObjectBuilder("1234", "Manoj");
        EmployeeObject employee = builder.addCity("Bangalore").build();
        System.out.println(employee);
    }
}

class EmployeeObject {

    private String empId;
    private String empName;
    private String city;
    private String state;

    private EmployeeObject(EmployeeObjectBuilder builder) {
        this.empId = builder.empId;
        this.empName = builder.empName;
        this.city = builder.city;
        this.state = builder.state;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "EmployeeObject [empId=" + empId + ", empName=" + empName + ", city=" + city + ", state=" + state + "]";
    }

    static class EmployeeObjectBuilder {
        private String empId;
        private String empName;
        private String city;
        private String state;

        EmployeeObjectBuilder(String empId, String empName) {
            this.empId = empId;
            this.empName = empName;
        }

        public EmployeeObjectBuilder addCity(String city) {
            this.city = city;
            return this;
        }

        public EmployeeObjectBuilder addState(String state) {
            this.state = state;
            return this;
        }

        public EmployeeObject build() {
            return new EmployeeObject(this);
        }
    }

}