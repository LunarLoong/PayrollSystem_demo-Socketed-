package staffManagement;

import salaryCalculation.SalaryStrategy;

import java.io.Serializable;


public abstract class Employee implements Serializable {
    private String EID;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String address;
    private SalaryStrategy salaryStrategy;
    private String password;

    public Employee() {

    }

    public Employee(String EID, String name, String sex, String age, String phone, String address) {
        this.EID = EID;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }



    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract double getSalary();


}
