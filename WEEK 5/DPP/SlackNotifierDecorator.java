/**
 * Concrete decorator: adds Slack notification on top of whatever it wraps.
 */
public class SlackNotifierDecorator implements Notifier {

    private final Notifier notifier;

    public SlackNotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message); // let the wrapped notifier(s) send first
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending SLACK notification: " + message);
    }
}