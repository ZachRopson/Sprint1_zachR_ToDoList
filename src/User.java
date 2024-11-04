public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    // Add task to the user's list
    public void addTask(String description) {
        taskList.addTask(new Task(description));
    }

    // Mark a task as completed by index
    public boolean markTaskAsCompleted(int index) {
        return taskList.markTaskAsCompleted(index);
    }

    // Print all tasks for the user
    public void displayTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.displayAllTasks();
    }
}

