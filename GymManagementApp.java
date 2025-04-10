import java.util.*;

public class GymManagementApp {

    static Scanner sc = new Scanner(System.in);
    static String loggedInUser = "";

    // Simulated user database
    static Map<String, String> users = new HashMap<>();

    // Exercise planner
    static List<String> exerciseList = new ArrayList<>();

    public static void main(String[] args) {
        initializeUsers();

        System.out.println("========== Welcome to Gym Management System ==========");
        System.out.println("1. Login");
        System.out.println("2. Exit");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (choice == 1) {
            login();
        } else {
            System.out.println("Exiting the system. Goodbye!");
            return;
        }

        // After login
        if (!loggedInUser.isEmpty()) {
            showMenu();
        }
    }

    static void initializeUsers() {
        // Default users (username, password)
        users.put("karan", "1234");
        users.put("admin", "admin");
    }

    static void login() {
        System.out.println("---- Login Page ----");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            System.out.println("Login successful! Welcome, " + loggedInUser + " 👋");
        } else {
            System.out.println("Invalid credentials! Please try again.");
        }
    }

    static void showMenu() {
        int option;
        do {
            System.out.println("\n------ Main Menu ------");
            System.out.println("1. View Profile");
            System.out.println("2. Add Exercise to Planner");
            System.out.println("3. View Planned Exercises");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    addExercise();
                    break;
                case 3:
                    viewExercises();
                    break;
                case 4:
                    System.out.println("Logged out successfully. Bye, " + loggedInUser + "!");
                    loggedInUser = "";
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (!loggedInUser.isEmpty());
    }

    static void viewProfile() {
        System.out.println("👤 Username: " + loggedInUser);
    }

    static void addExercise() {
        System.out.print("Enter Exercise Name: ");
        String exercise = sc.nextLine();
        exerciseList.add(exercise);
        System.out.println("✅ '" + exercise + "' added to your planner!");
    }

    static void viewExercises() {
        System.out.println("📋 Your Exercise Plan:");
        if (exerciseList.isEmpty()) {
            System.out.println("No exercises added yet.");
        } else {
            for (int i = 0; i < exerciseList.size(); i++) {
                System.out.println((i + 1) + ". " + exerciseList.get(i));
            }
        }
    }
}