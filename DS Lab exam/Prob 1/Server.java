import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import Arithmetic.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            CalculatorImpl calculatorImpl = new CalculatorImpl();

            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(calculatorImpl);
            Arithmetic.Calculator href = Arithmetic.CalculatorHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("Calculator");
            ncRef.rebind(path, href);

            System.out.println("\nName: Naga Tharun Makkena");
            System.out.println("Roll No: SE20UCSE105\n");
            System.out.println("Server is ready and waiting for client requests...");
            
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
