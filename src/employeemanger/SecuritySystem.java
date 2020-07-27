
package employeemanger;


/**
 * Security system that stores and scans employee objects
 * @author Aaron Reihill/D00222467
 */
public class SecuritySystem
{

    private EmployeeHashMap employees = new EmployeeHashMap();

    /**
     * Empty constructor
     */
    public SecuritySystem()
    {
    }

    /**
     *
     * @return returns a hash map of employee objects which are immutable and
     * map is in capsulated
     */
    public EmployeeHashMap getEmployees()
    {
        return employees;
    }

    /**
     * Adds an Employee object to the systems hash map of Employee objects If
     * invalid Employee is entered error message is displayed informing the user
     *
     * @param e
     */
    public void addEmployee(Employee e)
    {

        if (employees.put(e.getId(), e) != false)
        {
            System.out.println("Employee Registered");
        }
        else
        {
            System.err.println("Employee Could Not Be Registered");
        }
    }

    /**
     * Adds an Employee object to the system but has no messages as it would
     * span the fill method
     *
     * @param e
     */
    public void addSilentEmployee(Employee e)
    {
        employees.put(e.getId(), e);
    }

    /**
     * Removes Employee from system hash map of Employee objects If Employee is
     * not found an error message is displayed to inform the user
     *
     * @param e
     */
    public void removeEmployee(Employee e)
    {
        if (employees.remove(e.getId()) != false)
        {
            System.out.println("Employee Removed");
        }
        else
        {
            System.err.println("Employee Not Found");
        }
    }

    /**
     * Removes Employee by Id which is stored as a String, from system hash map
     * of Employee objects If Employee is not found an error message is
     * displayed to inform the user
     *
     * @param id
     */
    public void removeEmployee(String id)
    {
        if (employees.remove(id) != false)
        {
            System.out.println("Employee Removed");
        }
        else
        {
            System.err.println("Employee Not Found");
        }
    }

    /**
     * Displays all Employee Id's that are currently registered to the system
     */
    public void regEmployeesId()
    {
        int count = 0;
        int nextLine = 5;
        for (String s : this.getEmployees().keySet())
        {
            System.out.print("(" + this.employees.get(s).getId() + ") ");
            count++;
            if (count >= nextLine)
            {
                System.out.println("");
                count = 0;
            }
        }

    }

    /**
     * Takes employee id and displays the Employee object details
     *
     * @param id
     */
    public void scan(String id)
    {
        Employee e = employees.get(id);
        if (e != null)
        {
            System.out.println("");
            e.display();
        }
        else
        {
            System.err.println("Employee Not Found");
        }
    }

    /**
     * Displays all Employee details that are currently registered
     */
    public void displayAll()
    {
        String line = "----------------------------------------------------------------------------------";
        System.out.println(line);
        System.out.println(String.format("%-15s %10s %20s %15s %15s  %n", "Photo", "ID", "Name", "Department", "Clearance"));
        System.out.println(line);
        for (String s : this.getEmployees().keySet())
        {
            this.employees.get(s).display();
        }
        System.out.println(line);

    }

    /**
     * Default display call that returns a String of employee details
     *
     * @return String of employee details
     */
    @Override
    public String toString()
    {
        return "SecuritySystem{" + "employees=" + employees + '}';
    }

}
