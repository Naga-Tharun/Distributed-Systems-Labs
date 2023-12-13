// MathServiceCompositionProcess.java

public class MathServiceCompositionProcess {
    public MathOutputMessage composeServices(MathInputMessage input) {

        // Invoke ArithmeticService
        ArithmeticService arithmeticService = new ArithmeticService();
        ArithmeticOutputMessage arithmeticResult = arithmeticService.arithmeticOperation(input);

        // Invoke TrigonometricService
        TrigonometricService trigonometricService = new TrigonometricService();
        TrigonometricOutputMessage trigonometricResult =
        trigonometricService.trigonometricOperation(
        new TrigonometricInputMessage(arithmeticResult.getSum() + arithmeticResult.getDifference()));
        
        // Combine results
        MathOutputMessage output = new MathOutputMessage();
        output.setSum(arithmeticResult.getSum());
        output.setDifference(arithmeticResult.getDifference());
        output.setSine(trigonometricResult.getSine());
        output.setCosine(trigonometricResult.getCosine());
        return output;
    }
}