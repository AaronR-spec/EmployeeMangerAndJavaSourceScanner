package employeemanger;

import employeemanger.SecuritySystem;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Menu of the security system
 *
 * @author Aaron Reihill/D00222467
 */
public class SystemMenu
{

    static Scanner keyboard = new Scanner(System.in);
    static SecuritySystem s = new SecuritySystem();

    /**
     * Start of the project and only public method as to limit the user being
     * able to call other functions,Acts as a gate way Invalid input will be
     * caught and dealt with then a error message will be displayed
     */
    public static void main(String[] args)
    {
        SystemMenu.start();
    }

    public static void start()
    {
        String INVALID_MESSAGE = "Invalid Input";
        fill(s);
        System.out.println("\nSecurity System");
        boolean exit = false;
        while (!exit)
        {
            System.out.println("\n(0) Exit");
            System.out.println("(1) Scan");
            System.out.println("(2) Register");
            System.out.println("(3) Remove");
            System.out.println("(4) Display All");
            System.out.print("Option: ");
            try
            {
                int option = keyboard.nextInt();
                switch (option)
                {
                    case 0:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    case 1:
                        scan();
                        enterToReturn();
                        break;
                    case 2:
                        register();
                        enterToReturn();
                        break;
                    case 3:
                        remove();
                        break;
                    case 4:
                        display();
                        enterToReturn();
                        break;
                    default:
                        System.err.println(INVALID_MESSAGE);
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println(INVALID_MESSAGE);
                keyboard.nextLine();
            }
        }
    }

    private static void scan()
    {

        System.out.print("ID: ");
        String id = keyboard.next();
        keyboard.nextLine();
        s.scan(id.toUpperCase());
    }

    private static void register()
    {
        keyboard.nextLine();
        System.out.print("Name: ");
        String name = keyboard.nextLine();
        System.out.print("Department: ");
        String dept = keyboard.nextLine();
        Boolean exit = false;
        System.out.println("('Q' to Quit)Clearance Levels... ");
        List<Integer> clear = new ArrayList<>();
        while (!exit)
        {
            try
            {

                System.out.print("Level: ");
                int num = keyboard.nextInt();
                if (num > 3 || num < -1)
                {
                    throw new IllegalArgumentException();
                }
                clear.add(num);

            }
            catch (InputMismatchException | IllegalArgumentException e)
            {
                keyboard.nextLine();
                exit = true;
            }
        }
        Employee emp = new Employee("Photo Of " + name, name, dept, clear);
        s.addEmployee(emp);
    }

    private static void display()
    {
        s.displayAll();
        keyboard.nextLine();
    }

    private static void enterToReturn()
    {
        System.out.print("Press Enter To Return: ");
        keyboard.nextLine();
    }

    private static void remove()
    {
        keyboard.nextLine();
        s.regEmployeesId();
        System.out.print("\nID: ");
        String id = keyboard.nextLine();
        s.removeEmployee(id);

    }

    private static void fill(SecuritySystem s)
    {
        List<Integer> clearenceLow = new ArrayList<>();
        clearenceLow.add(-1);
        clearenceLow.add(1);

        List<Integer> clearenceMid = new ArrayList<>();
        clearenceMid.add(-1);
        clearenceMid.add(1);
        clearenceMid.add(2);

        List<Integer> clearenceHigh = new ArrayList<>();
        clearenceHigh.add(-1);
        clearenceHigh.add(1);
        clearenceHigh.add(2);
        clearenceHigh.add(3);

        s.addSilentEmployee(new Employee("Photo Of Bob", "Bob Duffy", "IT", clearenceLow));
        s.addSilentEmployee(new Employee("Photo Of Kevin", "Kevin Duffy", "IT", clearenceLow));
        s.addSilentEmployee(new Employee("Photo Of Tim", "Tim Conlon", "HR", clearenceLow));

        s.addSilentEmployee(new Employee("Photo Of Sarah", "Sarah Duffy", "Management", clearenceMid));
        s.addSilentEmployee(new Employee("Photo Of Kalvin", "Kalvin Clarke", "HR", clearenceMid));
        s.addSilentEmployee(new Employee("Photo Of Ryan", "Ryan Quinn", "IT", clearenceMid));

        s.addSilentEmployee(new Employee("Photo Of Adam", "Adam Richards", "CEO", clearenceHigh));
    }
}
