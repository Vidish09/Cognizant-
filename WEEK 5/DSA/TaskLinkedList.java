/**
 * Singly Linked List implementation for managing Tasks.
 *
 * Supported operations:
 *  - addTask(task)          : append a new task at the tail   -> O(1) with tail pointer
 *  - addTaskAtFront(task)   : insert a new task at the head   -> O(1)
 *  - searchTask(taskId)     : find a task by ID               -> O(n)
 *  - traverse()             : print all tasks in order        -> O(n)
 *  - deleteTask(taskId)     : remove a task by ID             -> O(n)
 *  - size()                 : number of tasks                 -> O(1)
 */
public class TaskLinkedList {
    /** Minimal task model required by this list implementation. */
    public static class Task {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        public int getTaskId() {
            return taskId;
        }

        @Override
        public String toString() {
            return "Task{id=" + taskId + "}";
        }
    }

    /** Internal node used to link tasks together. */
    private static class TaskNode {
        private final Task task;
        private TaskNode next;

        private TaskNode(Task task) {
            this.task = task;
        }
    }

    private TaskNode head;
    private TaskNode tail; // kept so addTask() is O(1) instead of walking the list each time
    private int size;

    public TaskLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Adds a task to the end of the list. O(1) because we track the tail. */
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Adds a task to the front of the list. O(1). */
    public void addTaskAtFront(Task task) {
        TaskNode newNode = new TaskNode(task);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    /** Searches for a task by ID. Returns the Task or null if not found. O(n). */
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // not found
    }

    /** Traverses and prints every task in insertion order. O(n). */
    public void traverse() {
        if (head == null) {
            System.out.println("No tasks in the system.");
            return;
        }
        TaskNode current = head;
        System.out.println("--- Task List ---");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
        System.out.println("-----------------");
    }

    /**
     * Deletes a task by ID.
     * Returns true if the task was found and deleted, false otherwise.
     * O(n) — must walk from head to find the predecessor of the target node.
     */
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }

        // Case 1: deleting the head node
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            if (head == null) { // list became empty
                tail = null;
            }
            size--;
            return true;
        }

        // Case 2: search for the node whose `next` matches the target
        TaskNode prev = head;
        TaskNode current = head.next;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                prev.next = current.next;
                if (current == tail) { // deleting the tail node
                    tail = prev;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false; // taskId not found
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}