import java.net.*; 
import java.io.*;

public class servertcp
{
    public static void main(String args[]) throws IOException
    {
        ServerSocket ss=new ServerSocket(12);
        Socket s=ss.accept();
        System.out.println("Connection from "+s);

        PrintWriter pw1 = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br3 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("i m ready");

        String s1, s2;

        while(true)
        {
            do
            {
                s1 = br4.readLine();
                pw1.println(s1);
            }
            while(!s1.equals("over"));
            do
            {
                s2=br3.readLine();
                System.out.println(s2);
            }
            while(!s2.equals("over"));
        }
    }
}