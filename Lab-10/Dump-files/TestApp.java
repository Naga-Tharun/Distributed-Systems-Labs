import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestApp implements CommandLineRunner {
    private final MessagePublisher messagePublisher;
    
    public TestApp(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    public void run(String... args) throws Exception {
        // Publish a message
        messagePublisher.publishMessage("Hello, subscribers!");
    }
}