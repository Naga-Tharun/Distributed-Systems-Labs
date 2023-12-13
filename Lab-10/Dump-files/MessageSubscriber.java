import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {
    public void processMessage(String message) {
        System.out.println("Received message: " + message);
    }
}