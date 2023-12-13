public class ExampleSubscriber implements Subscriber {
    private String name;

    public ExampleSubscriber(String name) {
        this.name = name;
        // Register the subscriber with the PubSubService
        PubSubServiceImpl.addSubscriber(this);
    }

    @Override
    public void notify(String message) {
        System.out.println("Subscriber " + name + " received message: " + message);
    }
}
