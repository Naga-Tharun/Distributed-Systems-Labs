import java.net.*; 
import java.io.*;

public class clienttcp {
    public static void main(String args[]) throws IOException
    {
        Socket cc=new Socket(InetAddress.getLocalHost(), 12);

        PrintWriter pw = new PrintWriter(cc.getOutputStream(), true);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(cc.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        String str1, str2;

        while(true)
        {
            do
            {
                str1 = br1.readLine();
                System.out.println(str1);
            }
            while(!str1.equals("over"));
            do
            {
                str2=br2.readLine();
                pw.println(str2);
            }
            while(!str2.equals("over"));
        }
    }
}
