import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        welcomeMessage();

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("bye")) {
            command = scanner.nextLine();
            processCommand(command);
        }
        scanner.close();
        System.exit(1);
    }

    public static void processCommand(String command) {
        System.out.println("\t____________________________________________________________");
        if (command.equals("bye")) {
            System.out.println("\tBye. Hope to see you again soon!");
        } else {
            System.out.println("\t" + command);
        }
        System.out.println("\t____________________________________________________________");
    }

    public static void welcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke\n\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");
    }
}
