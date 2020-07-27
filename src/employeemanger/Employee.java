
package employeemanger;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee Object
 * @author Aaron Reihill/D00222467
 */
public final class Employee
{

    private final String photo, name, idStart = "SFT20", id, department;
    private final List<Integer> clearance = new ArrayList<>();
    private static int index;

    /**
     * Employee constructor
     *
     * @param e
     */
    public Employee(Employee e)
    {

        this.photo = e.getPhoto();
        this.name = e.getName();
        this.id = e.getId();
        this.department = e.getDepartment();
        this.clearance.addAll(e.getClearance());
    }

    Employee(String photo, String name, String department)
    {
        this.photo = photo;
        this.name = name;
        this.id = this.idStart + index;
        this.department = department;
        Employee.index++;
    }

    /**
     * Employee constructor
     *
     * @param photo
     * @param name
     * @param department
     * @param clearance
     */
    public Employee(String photo, String name, String department, List<Integer> clearance)
    {
        this.photo = photo;
        this.name = name;
        this.id = this.idStart + index;
        this.department = department.toUpperCase();
        this.clearance.addAll(clearance);
        Employee.index++;
    }

    /**
     * gets the employee photo
     *
     * @return
     */
    public String getPhoto()
    {
        return photo;
    }

    /**
     * gets the employee name
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * gets the employee id
     *
     * @return
     */
    public String getId()
    {
        return id;
    }

    /**
     * gets the employee department
     *
     * @return
     */
    public String getDepartment()
    {
        return department;
    }

    /**
     * gets the employees list of clearance
     *
     * @return
     */
    public List<Integer> getClearance()
    {
        return clearance;
    }

    /**
     * displays the employee details
     */
    public void display()
    {
        /*
        @TODO make get clearance a method to make array display better
         */
        System.out.println(String.format("%-15s %10s %20s %15s %15s %-15s  %n", this.getPhoto(), this.getId(), this.getName(), this.getDepartment(), "Floor:", this.getClearance()));
    }

    /**
     * employee default display
     *
     * @return string of the employee details
     */
    @Override
    public String toString()
    {
        return "Employee{" + "photo=" + this.getPhoto() + ", name=" + this.getName() + ", id=" + this.getId() + ", department=" + this.getDepartment() + ", clearance=" + this.getClearance() + '}';
    }

}
