import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.example.PubSubService")
public class PubSubServiceImpl implements PubSubService {
    private static List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void publish(String message) {
        // Notify all subscribers with the published message
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(message);
        }
    }

    public static void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public static void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
}