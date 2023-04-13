package udp;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String args []) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        Scanner S = new Scanner(System.in);


        System.out.println("Enter ping");
        String m = S.nextLine();

        byte[] out = m.getBytes();

        int ServerPort = 1122;

        InetAddress host = InetAddress.getLocalHost();

        DatagramPacket request = new DatagramPacket(
                out,out.length,host,ServerPort);

       socket.send(request);

        byte[] in = new byte[10000];

        DatagramPacket reply = new DatagramPacket(
                in,in.length);

        socket.receive(reply);

        String inputLine = new String(
                reply.getData(), 0, reply.getLength());

        if(inputLine.equals("pong")) {
            System.out.println("Reply: " + new String(inputLine));
        }else {
            System.out.println("Reply: " + new String(inputLine));
        }


    }
}
