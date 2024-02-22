import java.io.*;
import java.net.*;

public class reqHandler {
    public static void handReq(Socket clSocket){
        try{
            BufferedReader red = new BufferedReader(new InputStreamReader(clSocket.getInputStream()));

            String line;


            System.out.printf("\nNEW CONNECTION\n");

            while((line = red.readLine()) != null & !line.isEmpty()){
                System.out.println(line);
            }



            String response = "HTTP/1.1 200 OK\r\n\r\nConnection Estabilished";
            OutputStream oStr = clSocket.getOutputStream();
            oStr.write(response.getBytes());

            oStr.close();
            red.close();
            clSocket.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
