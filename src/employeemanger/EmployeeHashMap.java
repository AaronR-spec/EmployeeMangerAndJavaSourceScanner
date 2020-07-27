
package employeemanger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Custom Employee hash map that is used to encapsulate the employee map
 *
 * @author Aaron Reihill/D00222467
 */
public class EmployeeHashMap
{

    private final HashMap< String, Employee> map;

    /**
     * Constructor that initializes the hash map
     */
    public EmployeeHashMap()
    {
        this.map = new HashMap<>();
    }

    /**
     * Method to insert a copy employee object using its id as the key
     *
     * @param id
     * @param e
     * @return true if added and false if not added
     */
    public boolean put(String id, Employee e)
    {
        return map.put(id, new Employee(e)) == null;
    }

    /**
     * Method to return a copy of an employee object
     *
     * @param key
     * @return true if found and false if not found
     */
    public Employee get(String key)
    {
        Employee e = map.get(key);
        if (e != null)
        {
            return e;
        }
        return null;

    }

    /**
     * Removes an employee object from hash map of registered employees
     *
     * @param key
     * @return
     */
    public boolean remove(String key)
    {
        return map.remove(key) != null;
    }

    /**
     * Gets the keySet of the hash map
     *
     * @return a Set of Strings containing the keys
     */
    public Set<String> keySet()
    {
        return map.keySet();
    }

    /**
     * gets all employees in the hash map
     *
     * @return a list of employees
     */
    public List getAllEmployees()
    {
        List<Employee> list = new ArrayList<>();

        for (Map.Entry<String, Employee> e : map.entrySet())
        {
            list.add(new Employee(e.getValue()));
        }
        return list;
    }
}
