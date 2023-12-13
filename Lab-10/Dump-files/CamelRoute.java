import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:publish")
        .to("jms:topic:exampleTopic"); // Publish to JMS topic
        
        from("jms:topic:exampleTopic")
        .to("log:subscribers"); // Log received messages from the topic
    }
}