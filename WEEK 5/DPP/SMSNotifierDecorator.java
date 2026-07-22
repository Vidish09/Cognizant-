/**
 * Concrete decorator: adds SMS notification on top of whatever it wraps.
 */
public class SMSNotifierDecorator implements Notifier {

    private final Notifier notifier;

    public SMSNotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message); // let the wrapped notifier(s) send first
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}