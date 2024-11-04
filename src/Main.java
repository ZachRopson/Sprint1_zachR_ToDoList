import java.util.Scanner;

public class Main {
    private static User[] users = new User[10]; // Array of users (max 10 for simplicity)
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create User\n2. Add Task\n3. Mark Task as Completed\n4. View Tasks\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    markTaskCompleted(scanner);
                    break;
                case 4:
                    viewTasks(scanner);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createUser(Scanner scanner) {
        if (userCount >= users.length) {
            System.out.println("Maximum user limit reached.");
            return;
        }
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        users[userCount++] = new User(name);
        System.out.println("User created successfully.");
    }

    private static void addTask(Scanner scanner) {
        User user = selectUser(scanner);
        if (user != null) {
            System.out.print("Enter task description: ");
            String description = scanner.nextLine();
            user.addTask(description);
            System.out.println("Task added successfully.");
        }
    }

    private static void markTaskCompleted(Scanner scanner) {
        User user = selectUser(scanner);
        if (user != null) {
            user.displayTasks(); // Display current tasks
            System.out.print("Enter task index to mark as completed: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (user.markTaskAsCompleted(index)) {
                System.out.println("Task marked as completed.");
            } else {
                System.out.println("Invalid task index.");
            }
        }
    }

    private static void viewTasks(Scanner scanner) {
        User user = selectUser(scanner);
        if (user != null) {
            System.out.println("Tasks for " + user.getName() + ":");
            user.displayTasks();
        }
    }

    private static User selectUser(Scanner scanner) {
        System.out.println("Select a user:");
        for (int i = 0; i < userCount; i++) {
            System.out.println(i + ". " + users[i].getName());
        }
        System.out.print("Enter user index: ");
        int userIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (userIndex >= 0 && userIndex < userCount) {
            return users[userIndex];
        } else {
            System.out.println("Invalid user index.");
            return null;
        }
    }
}


