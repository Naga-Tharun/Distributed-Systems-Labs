import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import HelloWorldApp.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class Server {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            HelloWorldImpl helloWorld = new HelloWorldImpl();

            // Register the HelloWorld object with the ORB
            // orb.connect(helloWorld);

            // Get the reference to the RootPOA and activate the POAManager
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("RootPOA");
            POA rootpoa = POAHelper.narrow(objRef);
            rootpoa.the_POAManager().activate();

            // Associate the HelloWorldImpl object with the ORB
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloWorld);
            HelloWorld href = HelloWorldHelper.narrow(ref);

            // Obtain a reference to the Naming service
            objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("HelloWorld");
            ncRef.rebind(path, href);

            System.out.println("\nName: Naga Tharun Makkena");
            System.out.println("Roll No: SE20UCSE105");


            System.out.println("Server is ready and waiting for client requests...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
