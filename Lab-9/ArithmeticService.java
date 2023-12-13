// ArithmeticService.java
import com.example.ArithmeticInputMessage;
import com.example.ArithmeticOutputMessage;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(targetNamespace = "http://example.com/ArithmeticService")

public class ArithmeticService {

    @WebMethod
    public ArithmeticOutputMessage arithmeticOperation(ArithmeticInputMessage input) {
        ArithmeticOutputMessage output = new ArithmeticOutputMessage();
        output.setSum(input.getA() + input.getB());
        output.setDifference(input.getA() - input.getB());
        return output;
    }
}