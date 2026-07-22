package week_1.dpp;


public class Logger {

    private static volatile Logger instance;

    private int logCount = 0;

   
    private Logger() {
        System.out.println("[Logger] Instance created: " + this.hashCode());
    }

    @SuppressWarnings("DoubleCheckedLocking")
    public static Logger getInstance() {
        if (instance == null) {                
            synchronized (Logger.class) {
                if (instance == null) {          
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    
    public synchronized void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}
