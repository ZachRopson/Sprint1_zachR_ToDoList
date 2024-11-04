public class Task {
    private String description;
    private boolean isCompleted;

    // Constructor
    public Task(String description) {
        this.description = description;
        this.isCompleted = false; // default status is incomplete
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Method to mark the task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Method to get the completion status
    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return description + " (Status: " + (isCompleted ? "Completed" : "Pending") + ")";
    }
}

