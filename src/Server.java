import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args){
        int port = 8080; //PORT number for server;
        try (ServerSocket servSoc = new ServerSocket(port)) {
                System.out.println("Server started on port: "+port);

            while(true){
                Socket clSock = servSoc.accept();

                new Thread(() -> reqHandler.handReq(clSock)).start(); //Creates a thread for client request handling
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}