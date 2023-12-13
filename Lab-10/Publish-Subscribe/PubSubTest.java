public class PubSubTest {
    public static void main(String[] args) {
        // Create subscribers
        Subscriber subscriber1 = new ExampleSubscriber("Subscriber1");
        Subscriber subscriber2 = new ExampleSubscriber("Subscriber2");
        // Create and publish a message
        PubSubService pubSubService = new PubSubServiceImpl();
        pubSubService.publish("Hello, subscribers!");

        System.out.println("Name: Dhanush Bommavaram");
        System.out.println("RollNo: SE20UCSE039");
    }
}
