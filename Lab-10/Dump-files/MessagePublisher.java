import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {
    @Autowired
    private ProducerTemplate producerTemplate;

    public void publishMessage(String message) {
        producerTemplate.sendBody("direct:publish", message);
    }
}

