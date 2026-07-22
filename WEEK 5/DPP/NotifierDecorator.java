
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    protected NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        // Base behavior: delegate to whatever this decorator wraps.
        // Concrete subclasses override this to add their own channel on top.
        wrappedNotifier.send(message);
    }
}