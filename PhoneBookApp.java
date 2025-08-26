import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private String phoneNumber;
    private String nationality;

    public Person(String name, String phoneNumber, String nationality) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }
}

class PhoneBook {
    private List<Person> people = new ArrayList<>();

    // Add new person
    public void addPerson(Person person) {
        people.add(person);
    }

    // Display table
    public void displayTable() {
        if (people.isEmpty()) {
            System.out.println("\nNo records found. Please add data first.\n");
            return;
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s%n", "Name", "Phone Number", "Nationality");
        System.out.println("---------------------------------------------------------------");

        for (Person p : people) {
            System.out.printf("%-20s %-20s %-20s%n", p.getName(), p.getPhoneNumber(), p.getNationality());
        }

        System.out.println("---------------------------------------------------------------\n");
    }
}

public class PhoneBookApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("===== Phone Book Application =====");
            System.out.println("1. Add Person");
            System.out.println("2. Display Records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                        try {
                                System.out.print("Enter Phone Number (10-digits): ");
                                String phone = sc.nextLine();

                                // Validate phone number: must be exactly 10 digits
                                if (!phone.matches("\\d{10}")) {
                                    System.out.println("❌ Invalid phone number. Please enter exactly 10 digits.\n");
                                    continue; // ask again
                                }

                                System.out.print("Enter Nationality: ");
                                String nationality = sc.nextLine();

                                Person person = new Person(name, phone, nationality);
                                phoneBook.addPerson(person);
                                System.out.println("✔ Person added successfully!\n");
                                break; // exit loop if successful

                        } catch (Exception e) {
                            System.out.println("❌ Something went wrong. Please try again.\n");
                        }
                                break;
                case 2:
                    phoneBook.displayTable();
                    break;

                case 3:
                    System.out.println("Exiting... Thank you for using the Phone Book App!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
