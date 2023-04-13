package tcp;
import java.net.*;
import java.io.*;
public class Server {
    public static void main(String args[])throws IOException{

         ServerSocket serverSocket=new ServerSocket(1122);

         while (true){

             Socket socket=serverSocket.accept();
             OutputStream S_out=socket.getOutputStream();
             DataOutputStream Dos_out =new DataOutputStream(S_out);
             InputStream S_in=socket.getInputStream();
             DataInputStream Dos_in =new DataInputStream(S_in);

             String word;

             while ((word = Dos_in.readUTF()) != null) {
                 if (word.equals("Ping")) {
                     System.out.println(word);
                     Dos_out.writeUTF("Pong");
                     break;
                 } else {
                     Dos_out.writeUTF("Wrong Answer!!");
                     break;
                 }
         }

    }
}
}
