import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ",id=" + id + ",salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int workingHour;

    public PartTimeEmployee(String name, int id, int workingHour, double hourlyRate) {
        super(name, id);
        this.workingHour = workingHour;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workingHour;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Yash shiva", 1, 60000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Anand rao", 2, 20, 25);
        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee("brijesh",3,40000);

        payrollSystem.addEmployee(fullTimeEmployee);
        payrollSystem.addEmployee(partTimeEmployee);

        payrollSystem.displayEmployees();

        payrollSystem.removeEmployee(1);
        payrollSystem.displayEmployees();
        payrollSystem.addEmployee(fullTimeEmployee1);
        payrollSystem.displayEmployees();
        payrollSystem.removeEmployee(3);
        payrollSystem.displayEmployees();
    }
}
