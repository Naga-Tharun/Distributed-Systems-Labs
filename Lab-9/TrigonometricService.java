// TrigonometricService.java
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(targetNamespace = "http://example.com/TrigonometricService")

public class TrigonometricService {

    @WebMethod
    public TrigonometricOutputMessage trigonometricOperation(TrigonometricInputMessage input) {
        TrigonometricOutputMessage output = new TrigonometricOutputMessage();
        output.setSine(Math.sin(input.getAngle()));
        output.setCosine(Math.cos(input.getAngle()));
        return output;
    }
}