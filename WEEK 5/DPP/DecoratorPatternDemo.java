/**
 * Demonstrates composing notification channels dynamically via decorators.
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        // 1. Plain email notification, no decoration
        System.out.println("--- Email only ---");
        Notifier emailOnly = new EmailNotifier();
        emailOnly.send("Your order has shipped.");

        // 2. Email + SMS
        System.out.println("\n--- Email + SMS ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send("Your order has shipped.");

        // 3. Email + SMS + Slack, all stacked dynamically
        System.out.println("\n--- Email + SMS + Slack ---");
        Notifier allChannels = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(
                                        new EmailNotifier()));
        allChannels.send("Your order has shipped.");

        // 4. Email + Slack only (skip SMS) — shows channels can be combined
        //    in any order/combination without new subclasses.
        System.out.println("\n--- Email + Slack ---");
        Notifier emailAndSlack = new SlackNotifierDecorator(new EmailNotifier());
        emailAndSlack.send("Your order has shipped.");
    }

    /** Adds SMS delivery to an existing notification channel. */
    private static class SMSNotifierDecorator implements Notifier {
        private final Notifier wrappedNotifier;

        SMSNotifierDecorator(Notifier wrappedNotifier) {
            this.wrappedNotifier = wrappedNotifier;
        }

        @Override
        public void send(String message) {
            wrappedNotifier.send(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    /** Adds Slack delivery to an existing notification channel. */
    private static class SlackNotifierDecorator implements Notifier {
        private final Notifier wrappedNotifier;

        SlackNotifierDecorator(Notifier wrappedNotifier) {
            this.wrappedNotifier = wrappedNotifier;
        }

        @Override
        public void send(String message) {
            wrappedNotifier.send(message);
            System.out.println("Sending Slack message: " + message);
        }
    }
}