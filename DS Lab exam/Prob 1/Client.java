import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import Arithmetic.*;

public class Client {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("Calculator");
            Arithmetic.Calculator calculator = Arithmetic.CalculatorHelper.narrow(ncRef.resolve(path));

            double a = 15;
            double b = 5;

            System.out.println("\nName: Naga Tharun Makkena");
            System.out.println("Roll No: SE20UCSE105\n");
            System.out.println("Addition: " + calculator.add(a, b));
            System.out.println("Subtraction: " + calculator.subtract(a, b));
            System.out.println("Multiplication: " + calculator.multiply(a, b));
            System.out.println("Division: " + calculator.divide(a, b));

            orb.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
