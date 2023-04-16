package udp;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String args[]) throws IOException {


        DatagramSocket clientSocket = new DatagramSocket();
        Scanner S = new Scanner(System.in);
        boolean availability = true;

        while (availability) {

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int ServerPort = 1122;


            System.out.println("Enter Your Message");
            String message = S.nextLine();

            byte[] outData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(
                    outData, outData.length, serverAddress, ServerPort);

            clientSocket.send(sendPacket);

            byte[] inData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(
                    inData, inData.length);
            clientSocket.receive(receivePacket);

            String input = new String(
                    receivePacket.getData(),
                    0, receivePacket.getLength());

            if (message.equals("ping")) {
                System.out.println("Received Data : "+' '+ input);

            }else {
                System.out.println("The Server Say : "+' '+ input);
                clientSocket.close();
                availability = false;
            }

        }
    }
}