
class Lesson5 {
    public static void main (String[] args) {
        getEmployees();
    }

    public static void getEmployees() {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivan", "Nikitin", "manager", "test@test.com",
                "1234567890", 30000, 30);
        employeeArray[1] = new Employee("Vladimir", "Titov", "developer", "test2@test.com",
                "1234567890", 40000, 40);
        employeeArray[2] = new Employee("John", "Smith", "junior developer", "test2@test.com",
                "1234567890", 40000, 25);
        employeeArray[3] = new Employee("Alex", "Cost", "senior developer", "test2@test.com",
                "1234567890", 40000, 45);
        employeeArray[4] = new Employee("Alexey", "Jovi", "team lead", "test2@test.com",
                "1234567890", 40000, 42);

        for (Employee person: employeeArray ) {
            if (person.getAge() > 40) {
                System.out.println(person.getFirstName() + " " + person.getLastName() + ", " +
                                   person.getPosition()  + ", " + person.getEmail()    + ", " +
                                   person.getPhone() + ", " + person.getSalary() + ", " + person.getAge());
            }
        }

        System.out.println("end");
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee(String firstName, String lastName, String position, String email, String phone, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

}
