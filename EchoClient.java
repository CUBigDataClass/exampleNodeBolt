import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EchoClient {

    private static String readFile(String path, Charset encoding) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    } 

    //private static String garbage = "36.164327,-86.7785035,b 43.01591790,-83.57919076,b 45.534666,-122.668396,b 54.41970608,-116.61286259,b 40.48747502,-85.61650001,b 42.4946163,-92.3400598,b 40.43692259,-81.37210121,b 30.16873213,-85.79393219,b 29.7090737,-95.1545905,b 37.91917113,-83.34972541,b 42.68552846,-83.02110739,b 34.27220548,-118.69158304,b 21.2897438,40.45142,w 35.60993874,-97.56314729,b 41.35409749,-83.65460763,b 32.9705,-96.4697,b 45.51592703,-122.66571416,b 28.89899760,-81.17133324,b 37.59329615,-122.37177709,b 33.71961527,-112.23888064,b 44.99949189,-123.04922193,b 28.22076928,-82.68068737,w 24.7239299,46.6735372,b 0.03883838,-51.06492519,b 46.5625589,-87.4065705,b 32.64870196,-117.07672988,b 0.03883838,-51.06492519,b 33.11846731,-97.15593081,b 36.4381605,-82.9861439,b 35.61019810,-97.56293282,b 35.74598551,-95.40022367,b 38.73913268,-90.64502623,b 47.64902744,-122.34464549,b 33.94462934,-118.13635076,b 21.31131779,-157.86119372,w 40.172183,-92.1778328,w 47.2192549,-122.4075429,w 106.8632246,-6.2594378,w 32.77230661,-117.07586937,w 106.7455009,-6.2363456,w 34.04501051,-118.28734933,w 33.24590269,-117.28333530,b 30.17556667,-85.80671667,b 33.71202379,-117.98906637,w 19.40409722,-99.17019,b 34.04494258,-118.28744095,b 33.29261715,-93.23692572,b 29.93918066,-90.12631499,b 45.15565991,-93.29658784,w 30.35568154,-81.59736019,b 39.70992994,-104.86315169,b 40.39319873,-74.21916199,b 32.18028271,-110.87857736,b 45.15590357,-93.29717509,b 34.08368187,-117.69533581,b 32.29422423,-95.27710525,w 151.201905,-33.871528,b 48.30441483,-116.51040288,b 32.64102715,-117.02083538,w 42.7171738,-85.7092168,b 42.9269069,-78.8883313,b 0.03883838,-51.06492519,b 40.76098989,-73.96294644,b 26.22175545,-98.27912059,b 55.04156856,82.92935525,b";
    public static void main(String[] args) throws IOException, InterruptedException {

    String garbage = readFile("json.txt", StandardCharsets.UTF_8);
        //String hostName = "54.187.141.69";
        String hostName = "54.187.141.69";
        int portNumber = 1337;
        
        try {

            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String things[] = garbage.split("\n\n");

            for(short i = 0; i < things.length; i++) {
                out.println(things[i]);
                Thread.sleep(1000);
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        } 
        String things[] = garbage.split("\n\n");
        for(short i = 0; i < things.length; i++) {
            System.out.println("RECORD---------------\n" + things[i]);
        }
    }
}