


public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;       // number of employees currently stored
    private int capacity;   // total array capacity

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    
    public boolean addEmployee(Employee emp) {
        if (size == capacity) {
            System.out.println("Cannot add employee: array is full (capacity = " + capacity + ").");
            return false;
        }
        employees[size] = emp;
        size++;
        return true;
    }

    // ---------- SEARCH (by employeeId) ----------
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // not found
    }

    // ---------- TRAVERSE ----------
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // ---------- DELETE (by employeeId) ----------
    public boolean deleteEmployee(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return false;
        }

        // Shift all subsequent elements one position to the left
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // clear the now-duplicate last reference
        size--;
        return true;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        system.addEmployee(new Employee(101, "Aditi Sharma", "Software Engineer", 75000));
        system.addEmployee(new Employee(102, "Rahul Verma", "Data Analyst", 65000));
        system.addEmployee(new Employee(103, "Priya Nair", "Product Manager", 95000));

        System.out.println("--- All Employees ---");
        system.traverseEmployees();

        System.out.println("\n--- Search Employee ID 102 ---");
        Employee found = system.searchEmployee(102);
        System.out.println(found != null ? found : "Employee not found.");

        System.out.println("\n--- Delete Employee ID 102 ---");
        system.deleteEmployee(102);
        system.traverseEmployees();

        System.out.println("\n--- Search deleted employee ID 102 ---");
        System.out.println(system.searchEmployee(102));
    }
}
