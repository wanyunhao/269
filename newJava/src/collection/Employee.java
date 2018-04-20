package collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Employee {
    private int id;
    private String name;
    private int salary;
    private String departmengt;
    private Date hireDate;


    public Employee(int id, String name, int salary, String departmengt, String  hireDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmengt = departmengt;

        DateFormat format = new SimpleDateFormat("yyyy-MM");
        try {
            this.hireDate = format.parse(hireDate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartmengt() {
        return departmengt;
    }

    public void setDepartmengt(String departmengt) {
        this.departmengt = departmengt;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
