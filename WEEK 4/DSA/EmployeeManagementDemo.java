public class EmployeeManagementDemo {
    private Employee[] employees;
    private int count;

    public EmployeeManagementDemo(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count >= employees.length) {
            System.out.println("Cannot add employee. Capacity full.");
            return;
        }
        employees[count++] = employee;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[--count] = null;
    }

    public static void main(String[] args) {
        EmployeeManagementDemo ems = new EmployeeManagementDemo(5);

        ems.addEmployee(new Employee(101, "Aditi Sharma", "Software Engineer", 75000));
        ems.addEmployee(new Employee(102, "Rahul Verma", "Data Analyst", 65000));
        ems.addEmployee(new Employee(103, "Priya Nair", "Product Manager", 95000));

        System.out.println("--- All Employees ---");
        ems.traverseEmployees();

        System.out.println("\n--- Searching for ID 102 ---");
        Employee found = ems.searchEmployee(102);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\n--- Deleting ID 102 ---");
        ems.deleteEmployee(102);
        ems.traverseEmployees();

        System.out.println("\n--- Searching for deleted ID 102 ---");
        System.out.println(ems.searchEmployee(102));
    }
}
