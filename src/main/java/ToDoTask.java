public class ToDoTask extends Task {
    public ToDoTask(String details) {
        super(details);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
