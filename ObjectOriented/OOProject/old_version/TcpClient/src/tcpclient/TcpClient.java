
package tcpclient;

import java.io.*;
import java.net.*;
import java.util.*;


public class TcpClient{
    public Socket socket;
    public DataOutputStream output;
    public DataInputStream input;
    //public BufferedReader input;
    public String ip = "127.0.0.1";
    public int port = 8882;
    public String serverMessage;
    public String outMessage;


    TcpClient() throws Exception{
        socket = new Socket(ip,port);
        input = new DataInputStream(socket.getInputStream());
        //input = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        
        output = new DataOutputStream(socket.getOutputStream());
        serverMessage = input.readUTF();
        System.out.println(serverMessage);
        while(true){
            outMessage = readLine();
            if(!outMessage.equals("ov") ){
                output.writeUTF(outMessage);
                //System.out.println("hello");
            }
            else {
                output.writeUTF(outMessage);
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
        new TcpClient();

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
