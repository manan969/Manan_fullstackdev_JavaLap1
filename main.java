import java.util.Random;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class CredentialService {
    private Employee employee;

    public CredentialService(Employee employee) {
        this.employee = employee;
    }

    public String generateEmailAddress(String department, String company) {
        return String.format("%s%s@%s.%s.com",
                employee.getFirstName().toLowerCase(),
                employee.getLastName().toLowerCase(),
                department.toLowerCase(),
                company.toLowerCase());
    }

    public String generatePassword() {
        String passwordCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;:'\",.<>?";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        password.append(Character.toUpperCase(employee.getFirstName().charAt(0)));
        password.append(Character.toLowerCase(employee.getLastName().charAt(0)));
        password.append(random.nextInt(10)); // Add a random digit
        password.append(passwordCharacters.charAt(random.nextInt(passwordCharacters.length()))); // Add a special character

        for (int i = 0; i < 8; i++) {
            password.append(passwordCharacters.charAt(random.nextInt(passwordCharacters.length())));
        }

        return password.toString();
    }

    public void showCredentials(String department, String company) {
        String emailAddress = generateEmailAddress(department, company);
        String password = generatePassword();

        System.out.println("Dear " + employee.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email ---> " + emailAddress);
        System.out.println("Password ---> " + password);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting employee details
        System.out.print("Enter employee first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter employee last name: ");
        String lastName = scanner.nextLine();

        // Creating an employee
        Employee newEmployee = new Employee(firstName, lastName);

        // Creating CredentialService for the employee
        CredentialService credentialService = new CredentialService(newEmployee);

        // Getting department choice
        System.out.println("Select department:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        System.out.print("Enter department choice (1-4): ");
        int departmentChoice = scanner.nextInt();

        String department;
        switch (departmentChoice) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "HumanResource";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                System.out.println("Invalid department choice. Exiting.");
                return;
        }

        // Providing company information
        String company = "abc";

        // Generating and displaying credentials
        credentialService.showCredentials(department, company);

        scanner.close();
    }
}
