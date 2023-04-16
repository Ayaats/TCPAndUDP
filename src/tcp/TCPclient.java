package tcp;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPclient {
public static void main(String[] args) throws IOException {

    boolean isConnected ;

    isConnected = true;

    Scanner S =new Scanner(System.in);
    Socket socket = new Socket("localhost", 1122);

    OutputStream S_out=socket.getOutputStream();
    DataOutputStream Dos_out =new DataOutputStream(S_out);
    InputStream S_in=socket.getInputStream();
    DataInputStream Dos_in =new DataInputStream(S_in);

    while(isConnected){

    System.out.println("Please enter your message:");
    String message=S.nextLine();

    Dos_out.writeUTF(message);

    String Answer;
    Answer = Dos_in.readUTF();
        System.out.println(Answer);

    if(Answer.equals("The Connection Closed")){
        Dos_in.close();
        Dos_out.close();
        socket.close();
        isConnected=false;
    }
}
}
}

