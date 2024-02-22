import java.io.*;
import java.net.*;

public class reqHandler {
    public static void handReq(Socket clSocket){
        try{
            BufferedReader red = new BufferedReader(new InputStreamReader(clSocket.getInputStream()));

            String line = red.readLine();
            String[] reqs = line.split(" ");
            String method = reqs[0];
            String getFile = reqs[1]; 

            System.out.printf("\nNEW CONNECTION\n");
            System.out.println(line);
            System.out.println(getFile.substring(1));
            


            if(method.equals("GET")){
                String response = "HTTP/1.1 200 OK\r\n\r\nConnection Estabilished";
                OutputStream oStr = clSocket.getOutputStream();
                oStr.write(response.getBytes());
            }
            else if(method.equals("POST")){
                String response = "HTTP/1.1 501 NOT IMPLIMENTED\r\n\r\nServer Error: NOT IMPLIMENTED";
                OutputStream oStr = clSocket.getOutputStream();
                oStr.write(response.getBytes());
            }
            else{
                String response = "HTTP/1.1 500 Internal Server Error\r\n\r\nServer Error: Internal Server Error";
                OutputStream oStr = clSocket.getOutputStream();
                oStr.write(response.getBytes());
            }

            red.close();
            clSocket.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
