
public class TaskManagementDemo {
    private static class Task {
        private final int id;
        private final String description;
        private final String status;

        Task(int id, String description, String status) {
            this.id = id;
            this.description = description;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Task{id=" + id + ", description='" + description
                    + "', status='" + status + "'}";
        }
    }

    private static class TaskLinkedList {
        private static class Node {
            private final Task task;
            private Node next;

            Node(Task task) {
                this.task = task;
            }
        }

        private Node head;
        private int count;

        void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            count++;
        }

        int size() {
            return count;
        }

        void traverse() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        Task searchTask(int id) {
            Node current = head;
            while (current != null) {
                if (current.task.id == id) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        boolean deleteTask(int id) {
            Node previous = null;
            Node current = head;
            while (current != null) {
                if (current.task.id == id) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    count--;
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // 1. Add tasks
        taskList.addTask(new Task(101, "Design database schema", "PENDING"));
        taskList.addTask(new Task(102, "Implement login API", "IN_PROGRESS"));
        taskList.addTask(new Task(103, "Write unit tests", "PENDING"));
        taskList.addTask(new Task(104, "Deploy to staging", "PENDING"));

        System.out.println("Total tasks: " + taskList.size());

        // 2. Traverse
        taskList.traverse();

        // 3. Search
        int searchId = 102;
        Task found = taskList.searchTask(searchId);
        if (found != null) {
            System.out.println("\nFound task " + searchId + ": " + found);
        } else {
            System.out.println("\nTask " + searchId + " not found.");
        }

        // 4. Delete a middle task
        System.out.println("\nDeleting task 102...");
        taskList.deleteTask(102);
        taskList.traverse();

        // 5. Delete the head
        System.out.println("\nDeleting task 101 (head)...");
        taskList.deleteTask(101);
        taskList.traverse();

        // 6. Delete the tail
        System.out.println("\nDeleting task 104 (tail)...");
        taskList.deleteTask(104);
        taskList.traverse();

        // 7. Attempt to delete a non-existent task
        boolean result = taskList.deleteTask(999);
        System.out.println("\nDeleting non-existent task 999 returned: " + result);

        System.out.println("Final total tasks: " + taskList.size());
    }
}