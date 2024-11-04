public class TaskList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // Add a new task to the list
    public void addTask(Task newTask) {
        Node newNode = new Node(newTask);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Mark a task as completed by index
    public boolean markTaskAsCompleted(int index) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                current.task.markAsCompleted();
                return true;
            }
            count++;
            current = current.next;
        }
        return false; // Index out of bounds
    }

    // Display all tasks with their status
    public void displayAllTasks() {
        Node current = head;
        int index = 0;

        while (current != null) {
            System.out.println(index + ". " + current.task.getDescription() + " - " +
                    (current.task.isCompleted() ? "Completed" : "Pending"));
            current = current.next;
            index++;
        }
    }
}

