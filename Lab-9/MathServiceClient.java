// MathServiceClient.java

public class MathServiceClient {
    public static void main(String[] args) {
    // Prepare input for the composed service
        MathInputMessage input = new MathInputMessage();
        input.setA(5);
        input.setB(3);

        // Invoke the composed service
        MathServiceCompositionProcess process = new MathServiceCompositionProcess();
        MathOutputMessage output = process.composeServices(input);
        
        // Display the output
        System.out.println("Sum: " + output.getSum());
        System.out.println("Difference: " + output.getDifference());
        System.out.println("Sine: " + output.getSine());
        System.out.println("Cosine: " + output.getCosine());
    }
}