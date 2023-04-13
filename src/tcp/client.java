package tcp;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client  {
public static void main(String[] args) throws IOException {

    Scanner S =new Scanner(System.in);


    Socket socket = new Socket("localhost", 1122);

    OutputStream S_out=socket.getOutputStream();
    DataOutputStream Dos_out =new DataOutputStream(S_out);
    InputStream S_in=socket.getInputStream();
    DataInputStream Dos_in =new DataInputStream(S_in);

    System.out.println("Enter Ping");
    String message=S.nextLine();


    Dos_out.writeUTF(message);

    String Ans=Dos_in.readUTF();

    Dos_in.close();
    Dos_out.close();
    socket.close();
}
}

