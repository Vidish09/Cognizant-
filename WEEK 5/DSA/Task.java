public class Task {
    private final int taskId;
    private String taskName;
    private String status; // e.g., "PENDING", "IN_PROGRESS", "COMPLETED"

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return String.format("[ID: %d | Name: %s | Status: %s]", taskId, taskName, status);
    }
}