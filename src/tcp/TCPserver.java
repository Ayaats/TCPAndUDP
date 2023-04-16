package tcp;
import java.net.*;
import java.io.*;
public class TCPserver {
    public static void main(String args[])throws IOException {

        ServerSocket serverSocket = new ServerSocket(1122);

        while (true) {

            System.out.println("Ready to Connect !!");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted client connection from " + clientSocket.getInetAddress());


            OutputStream S_out = clientSocket.getOutputStream();
            DataOutputStream Dos_out = new DataOutputStream(S_out);
            InputStream S_in = clientSocket.getInputStream();
            DataInputStream Dos_in = new DataInputStream(S_in);
                String word;
                while ((word = Dos_in.readUTF()) != null) {
                    if (word.equals("ping")) {
                        Dos_out.writeUTF("pong");
                    } else if (word.equals("Exit")) {
                        Dos_out.writeUTF("The Connection Closed");
                        System.out.println("Closed connection from " + clientSocket);
                        break;
                    } else {
                        Dos_out.writeUTF(word + ' ' + ": Not the right message");
                    }
                }
            }

        }
    }
