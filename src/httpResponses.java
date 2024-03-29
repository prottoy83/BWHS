import java.io.*;
import java.nio.file.*;

public class httpResponses {
    public static String HTMLResponse(String path) throws IOException{
        try{
            Path filePath = Paths.get("src/htsrc", path);
            String content = new String(Files.readAllBytes(filePath));
            return "HTTP/1.1 200 OK\r\n\r\n" + content;
        }
        catch(IOException e){
            e.printStackTrace();
            Path fileErrorPath = Paths.get("src/htsrc/error.html");
            String contentErr = new String(Files.readAllBytes(fileErrorPath));
            return "HTTP/1.1 404 Not Found\r\n\r\n"+contentErr;
        }
        
    }
}
