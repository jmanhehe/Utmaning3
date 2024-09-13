import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    private static HashMap<String, Project> projects = new HashMap<>();
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Doe", "19900112-1212", 0700000001L, "JohnDoe@mail.com");
        Employee employee2 = new Employee("Jane", "Doe", "19900112-1202", 0700000002L, "JaneDoe@mail.com");

        employees.add(employee1);
        employees.add(employee2);

        Project project1 = new Project("Project1", "This is our first project", "2024-01-01");
        Project project2 = new Project("Project2", "This is our second project", "2024-01-01");

        project1.addEmployee(employee1);
        project2.addEmployee(employee2);

        projects.put(project1.getProjectName(), project1);
        projects.put(project2.getProjectName(), project2);

        while(true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Add employee");
            System.out.println("2. List employees");
            System.out.println("3. Add project");
            System.out.println("4. Add employee to project");
            System.out.println("5. List projects");

            int choice = scanner.nextInt();
            
            // Clear the buffer
            scanner.nextLine();

            switch(choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    listEmployees();
                    break;

                case 3:
                    addProject();
                    break;

                case 4:
                    addEmployeeToProject();
                    break;
                case 5:
                    listProjects();
                    break;
            }
        }
    }

    public static void addEmployee() {
        System.out.printf("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.printf("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.printf("Enter ssn: ");
        String ssn = scanner.nextLine();

        System.out.printf("Enter phone: ");
        long phone = scanner.nextLong();

        // Clear the buffer
        scanner.nextLine();

        System.out.printf("Enter email: ");
        String email = scanner.nextLine();

        Employee employee = new Employee(firstName, lastName, ssn, phone, email);
    
        try {
            if(findEmployee(employees, ssn) != null) {
                System.out.println("Employee already exists");
                throw new IllegalArgumentException("Employee already exists");
            }
            employees.add(employee);
            System.out.println("Employee added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Employee findEmployee(List<Employee> employees, String ssn) {
        for(Employee employee : employees) {
            if(employee.getSsn().equalsIgnoreCase(ssn)) {
                return employee;
            }
        }
        return null;
    }

    public static void addProject() {
        System.out.println("Enter project name: ");
        String projectName = scanner.nextLine();

        System.out.println("Enter description: ");
        String description = scanner.nextLine();

        System.out.println("Enter deadline: ");
        String deadline = scanner.nextLine();

        Project project = new Project(projectName, description, deadline);
        projects.put(project.getProjectName(), project);

        System.out.println("Project added successfully");
    }

    public static void addEmployeeToProject() {
        System.out.println("Enter employee ssn: ");
        String ssn = scanner.nextLine();
        
        Employee employee = findEmployee(ssn);
        if(employee == null) {
            System.out.println("Employee not found");
            return;
        }

        System.out.println("Enter project name: ");
        String projectName = scanner.nextLine();

        if(!projects.containsKey(projectName)) {
            System.out.println("Project not found");
            return;
        }

        Project project = findProject(projectName);
        project.addEmployee(employee);

        System.out.println("Employee added to project successfully");

    }

    public static Employee findEmployee(String ssn) {
        for(Employee employee : employees) {
            if(employee.getSsn().equalsIgnoreCase(ssn)) {
                return employee;
            }
        }
        return null;
    }

    public static Project findProject(String projectName) {
        if(projects.containsKey(projectName)) {
            return projects.get(projectName);
        }
        return null;
    }

    public static void listProjects() {
        for(Project project : projects.values()) {
            System.out.println(project);
        }
    }

    public static void listEmployees() {
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }
}