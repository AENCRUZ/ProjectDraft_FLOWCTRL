import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CycleManager manager = new CycleManager();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("          \uD83D\uDCA7 FlowCtrl System \uD83D\uDCA7");
        System.out.println("    Your Personal Cycle Companion");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("[1] Sign Up");
            System.out.println("[2] Log In");
            System.out.println("[3] Exit");
            System.out.println("----------------------------------------");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    signUp();
                    break;
                case "2":
                    logIn();
                    break;
                case "3":
                    running = false;
                    System.out.println("Goodbye! Stay kind to yourself 🌷");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void signUp() {
        System.out.println();
        System.out.println("--- SIGN UP ---");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        if (manager.userExists(name)) {
            System.out.println("An account with that name already exists.");
            return;
        }

        System.out.print("Create a password: ");
        String pw1 = scanner.nextLine();
        System.out.print("Confirm password: ");
        String pw2 = scanner.nextLine();

        if (!pw1.equals(pw2)) {
            System.out.println("Passwords do not match. Sign up failed.");
            return;
        }

        // For demo: alternate users become Premium to show inheritance
        boolean premium = manager.totalUsers() % 2 == 1; // every 2nd user is premium (example)
        if (premium) {
            manager.addUser(new PremiumUser(name, pw1));
        } else {
            manager.addUser(new User(name, pw1));
        }

        System.out.println("Account created successfully! \uD83C\uDF1F");
        System.out.println("\nReturning to main menu...");
    }

    private static void logIn() {
        System.out.println();
        System.out.println("--- LOG IN ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String pw = scanner.nextLine();

        User user = manager.authenticate(name, pw);
        if (user == null) {
            System.out.println("Login failed. Check credentials.");
            return;
        }

        System.out.printf("Login successful! Welcome back, %s \uD83C\uDF38\n", user.getName());
        userMenu(user);
    }

    private static void userMenu(User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("[1] Add New Cycle");
            System.out.println("[2] View Cycle History");
            System.out.println("[3] Predict Next Cycle");
            System.out.println("[4] Export Report");
            System.out.println("[5] Logout");
            System.out.println("----------------------------------------");
            System.out.print("Enter choice: ");

            String c = scanner.nextLine().trim();
            switch (c) {
                case "1":
                    addCycle(user);
                    break;
                case "2":
                    manager.viewHistory(user);
                    break;
                case "3":
                    manager.predictNextCycle(user);
                    break;
                case "4":
                    ReportGenerator generator = new ReportGenerator();
                    generator.generateReport(user);
                    break;
                case "5":
                    loggedIn = false;
                    System.out.println("Logging out...");
                    System.out.printf("Goodbye, %s! Remember: flow with kindness \uD83C\uDF37\n", user.getName());
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addCycle(User user) {
        System.out.println();
        System.out.println("--- ADD NEW CYCLE ---");
        try {
            System.out.print("Enter start date (YYYY-MM-DD): ");
            String start = scanner.nextLine().trim();
            System.out.print("Enter end date (YYYY-MM-DD): ");
            String end = scanner.nextLine().trim();
            System.out.print("Mood summary (optional): ");
            String mood = scanner.nextLine();
            System.out.print("Any symptoms? (comma-separated): ");
            String symptoms = scanner.nextLine();

            user.addCycle(start, end, mood, symptoms);
            System.out.println("\nCycle recorded successfully! \uD83D\uDC8C");
        } catch (InvalidDateException ide) {
            System.out.println("Error: " + ide.getMessage());
        } catch (Exception ex) {
            System.out.println("Unexpected error while adding cycle: " + ex.getMessage());
        }
    }
}
