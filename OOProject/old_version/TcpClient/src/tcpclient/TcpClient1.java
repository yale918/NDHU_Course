
import java.io.*;
import java.net.*;
import java.util.*;


public class TcpClient1{
    public Socket socket;
    public DataOutputStream output;
    public BufferedReader input;
    public String ip = "127.0.0.1";
    public int port = 8881;
    public String serverMessage;
    public String outMessage;


    TcpClient1() throws Exception{
        socket = new Socket(ip,port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new DataOutputStream(socket.getOutputStream());
        serverMessage = input.readLine();
        System.out.println(serverMessage);
        while(true){
            outMessage = readLine();
            if(!outMessage.equals("ov") ){
                output.writeBytes(outMessage+"\n");
                //System.out.println("hello");
            }
            else {
                output.writeBytes(outMessage+"\n");
                break;
            }
        }
        System.out.println("socket terminated");
        input.close();
        output.close();
        socket.close();
    }

    public String readLine(){
        return new Scanner(System.in).nextLine();
    }

    public static void main(String args[]) throws Exception{
        new TcpClient1();

    }

}






















/*
public class TcpClient {
    public int port = 8887;
    public Socket socket;
    public BufferedReader input;
    public DataOutputStream output;


    public String lineScan(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    TcpClient() throws Exception{
        //System.out.println("hello world");
        socket = new Socket("127.0.0.1", port);
        input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        output = new DataOutputStream(socket.getOutputStream());
        //String inputMessage = input.readLine();
        System.out.println(input.readLine());
        System.out.println(input.readLine());
        output.writeBytes(lineScan()+"\n");


    }
    public static void main(String args[]) throws Exception{
        new TcpClient();

    }
}
*/
