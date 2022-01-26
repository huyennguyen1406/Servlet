package model;

public class Student {
    int id;
    String name;
    int age;
    String address;
    double pga;

    public Student(int id, String name, int age, String address, double pga) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.pga = pga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPga() {
        return pga;
    }

    public void setPga(double pga) {
        this.pga = pga;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", pga=" + pga +
                '}';
    }
}
