import java.util.HashMap;

public class Project {
	// Fields
	private String projectName;
	private String description;
	private String deadline;
	private HashMap<String, Employee> employees = new HashMap<>();

	public Project(String projectName, String description, String deadline) {
		this.projectName = projectName;
		this.description = description;
		this.deadline = deadline;
		this.employees = new HashMap<>();
	}

	public void addEmployee(Employee employee) {
		employees.put(employee.getFirstName(), employee);
	}

	// Getters
	public String getProjectName() {
		return projectName;
	}
	
	public String getDescription() {
		return description;
	}

	public String getDeadline() {
		return deadline;
	}

	// Setters
	public void setName(String projectName) {
		this.projectName = projectName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Project Name: " + projectName + "\n");
		sb.append("Description: " + description + "\n");
		sb.append("Deadline: " + deadline + "\n");
		sb.append("Employees: \n");
		for(Employee employee : employees.values()) {
			sb.append(employee + "\n");
		}

		return sb.toString();
	}
}
