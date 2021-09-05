public interface requirement1 {
	ArrayList<Employee> getEmployeesWithoutEmail(ArrayList<Employee> employees);
}

public interface requirement2 {
	
}

public interface requirement3 {
	
}

class Requirements implements requirement3, requirement2, requirement1 {
	private ArrayList<Employee> employeeRecords;

	public Requirements(HashSet<Employee> employees) {
		employeeRecords = new ArrayList<>();
		for (Employee employee : employees)
			employeeRecords.add(employee);
	}
}

class Employee {
	private String name;
	private String email;
	private int id;	
	private Employee manager;
	private HashSet<Employee> managing;

	public Employee(String name, String id){
		this.name = name;
		this.id = id;
		manager = new HashMap<>();
		managing = new HashMap<>();
	}

	// getter and setter 
	public String getName(){return this.name;}
	public void setName(String name){this.name = name;}
	public int getID(){return this.id;}

	public void addManager(Employee manager) {
		if(this.manager == null)
			this.manager = manager;
	}

	public void addManaging(ArrayList<Employee> managing) {
		for (Employee man : managing) {
			this.managing.add(man);
		}
	}

	public ArrayList<Employee> getManaging() {
		return new ArrayList<Employee>(this.managing);
	}

	public Employee getManager() {
		return this.manager;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}

}