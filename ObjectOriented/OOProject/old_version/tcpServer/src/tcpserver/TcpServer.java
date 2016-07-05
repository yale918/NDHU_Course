
package tcpserver;
import java.io.*;
import java.net.*;

public class TcpServer{
    
    
    
    public int port = 8882;
    public ServerSocket serverSocket;
    public Socket socket;
    //public InputStream input;
    public DataOutputStream output;
    public DataInputStream input;
    //public BufferedReader input;
    public String clientMessage;
    TcpServer() throws Exception{
        serverSocket = new ServerSocket(port);
        System.out.println("service listen on port: "+ port);
        
        while(true){
        socket = serverSocket.accept();
        System.out.printf("[%s] 連線進來!\n", socket.getRemoteSocketAddress() );
        output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF("你好 歡迎光臨 server");
        //input = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        input = new DataInputStream(socket.getInputStream());
        while(true){

            clientMessage =  input.readUTF();
            //clientMessage =  input.readLine();
            //if( clientMessage == input.readLine())  {   System.out.println("hello"); throw new disconnectException();    } 
           if( !clientMessage.equals("ov"))
                System.out.println("["+socket.getRemoteSocketAddress()+"]" +" says: "+ clientMessage);
            else{
                System.out.printf("[%s] 斷線!\n", socket.getRemoteSocketAddress() );
                break;
            }
            
        }
        //output.writeBytes(clientMessage);
        }
    }
    
    public class disconnectException extends Exception{
        public disconnectException(){
            System.out.printf("[%s] 斷線!\n", socket.getRemoteSocketAddress() );
        }
        
    }
    
    
    
    public static void main(String args[]) throws Exception{
        new TcpServer();
    }



}
























/*
package tcpserver;
import java.io.*;
import java.net.*;

public class TcpServer extends Thread{
   
    public int port = 8881;
    public ServerSocket serverSocket;
    public Socket socket;
    //public InputStream input;
    public DataOutputStream output;
    public BufferedReader input;
    public String clientMessage;
    TcpServer() throws IOException{
        serverSocket = new ServerSocket(port);
        System.out.println("service listen on port: "+ port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new DataOutputStream(socket.getOutputStream());
        
        while(true){
        socket = serverSocket.accept();
        System.out.printf("[%s] 連線進來!\n", socket.getRemoteSocketAddress() );
        output.writeBytes("welcome to tcp_multiple_server\n");
        
        
        //output.writeBytes(clientMessage);
        }
    }
    
    public void run() throws Exception{
        while(true){

            clientMessage =  input.readLine();
            
           if( !clientMessage.equals("ov"))
                System.out.println("["+socket.getRemoteSocketAddress()+"]" +" says: "+ clientMessage);
            else{
                System.out.printf("[%s] 斷線!\n", socket.getRemoteSocketAddress() );
                break;
            }
            
        }
    
    
    
    }
    
    
 
    
    
    public class disconnectException extends Exception{
        public disconnectException(){
            System.out.printf("[%s] 斷線!\n", socket.getRemoteSocketAddress() );
        }
        
    }
    
    
    
    public static void main(String args[]) throws Exception{
        new TcpServer();
    }



}
*/






























/*
public class TcpServer {
    public String clientSentence;
    //public String capitalizedSentence;
    public int port = 8887;
    public ServerSocket serverSocket;
    public Socket socket;
    public BufferedReader input;
    public DataOutputStream output;
    public String inputMessage;
    
    
    
    
    
    TcpServer() throws Exception{
        System.out.println("server running on port: "+port);
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        while(true){
           input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           output = new DataOutputStream(socket.getOutputStream());
           output.writeBytes("hello I am server\n");
           output.writeBytes("hello I am server2\n");
           inputMessage = input.readLine();
           System.out.println(inputMessage);
           
        }
    }
    
    public static void main(String[] args) throws Exception{
        new TcpServer();
    }
    
}


*/




/*

public class TcpServer {
    public static int port = 8888;
    public ServerSocket serverSocket;
    public Socket socket;
    public InputStream input;
    public OutputStream output;
    public StringBuffer buffer;

    TcpServer() throws Exception{
        
        serverSocket = new ServerSocket(port);
        System.out.println("[*] tcpServer start on port: " + port);

        socket = serverSocket.accept();

        InputStream input = socket.getInputStream();
        buffer = new StringBuffer();
        output.write("helloClient".getBytes("UTF-8"));
        try{
            while(true){
                int x = input.read(); 
                //count++;
                if(x==-1) break;
                byte b = (byte) x;
                buffer.append((char) b);
            }
        }catch(Exception e){
            System.out.println("> client: disconnect ");
            input.close();
            output.close();
            serverSocket.close();
        }
 
    }
    public static void main(String[] args) throws Exception{
        new TcpServer();
    }
    
}

*/