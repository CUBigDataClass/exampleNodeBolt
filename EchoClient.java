import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException, InterruptedException {
      
        String hostName = "localhost";
        int portNumber = 1337;
        
        try {

            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            short i = 1;
            while(true) {
                out.println("msg " + i);
                i++;
                Thread.sleep(1000);
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        } 
    }
}