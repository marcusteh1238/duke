import java.util.ArrayList;

/**
 * This object's role is to produce messages to be displayed by the GUI.
 */
public class Ui {
    private String response;
    private boolean isEmptyResponse;

    private void setResponse(String response) {
        isEmptyResponse = false;
        this.response = response;
    }

    public String getResponse() {
        assert !isEmptyResponse : "Cannot return empty response.";
        return response;
    }

    /**
     * Constructor for the Ui object.
     */
    public Ui() {
        this.isEmptyResponse = true;
    }

    /**
     * Displays the welcome message when the user starts the program.
     */
    public String welcomeMessage() {
        return "Hello from\n"
            + " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n"
            + "What can I do for you?";
    }

    /**
     * Generic response template for displaying an error.
     * @param e The error message to be displayed.
     */
    public void printException(DukeException e) {
        setResponse(" " + ((char) 0x2639) + " OOPS!!! " + e.toString());
    }

    /**
     * Prints the whole list of items in the order as stored by the program.
     * @param listItems The list of all the items in the task list.
     */
    protected void printList(ArrayList<Task> listItems) {
        if (listItems.isEmpty()) {
            setResponse("You currently have no tasks!");
        } else {
            StringBuilder sb = new StringBuilder("Here are the tasks in your list:");
            for (int i = 1; i <= listItems.size(); i++) {
                sb.append("\n  ")
                        .append(i)
                        .append(". ")
                        .append(listItems.get(i - 1));
            }
            setResponse(sb.toString());
        }
    }

    /**
     * Prints the list of items stored by the program that matched the keyword given by the user.
     * @param listItems The list of matched items in the task list.
     */
    protected void printMatchList(ArrayList<Task> listItems) {
        if (listItems.isEmpty()) {
            setResponse("Sorry, there are no matching tasks!");
        } else {
            StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:");
            for (int i = 1; i <= listItems.size(); i++) {
                sb.append("\n  ")
                        .append(i)
                        .append(". ")
                        .append(listItems.get(i - 1));
            }
            setResponse(sb.toString());
        }
    }

    /**
     * Displays a message to say goodbye to the user.
     */
    protected void byeMessage() {
        setResponse("Hope to see you again soon!");
    }

    /**
     * Displays a message when a task has been added to the task list.
     * @param taskString The String representation of the added task.
     * @param listSize The new size of the list.
     */
    protected void taskListAdd(String taskString, int listSize) {
        String taskSingular = listSize == 1 ? "task" : "tasks";
        setResponse("Got it. I've added this task: \n"
                + "  " + taskString + "\n"
                + "Now you have " + listSize + " " + taskSingular + " in the list.");
    }

    /**
     * Displays a message when a task in the task list has been set as Done.
     * @param taskString The String representation of the modified task.
     */
    protected void taskListDone(String taskString) {
        setResponse("Nice! I've marked this task as done: \n"
                + "  " + taskString);
    }

    /**
     * Displays a message when a task in the task list has been deleted.
     * @param taskString The String representation of the deleted task.
     * @param listSize The new size of the list.
     */
    protected void taskListDelete(String taskString, int listSize) {
        setResponse("I've removed this task:\n"
                + "  " + taskString + "\n"
                + "Now you have " + listSize + " tasks in the list.");
    }

}
