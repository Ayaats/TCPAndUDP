package udp;
import java.net.*;
import java.io.*;
public class UdpServer {
    public static void main(String args[])throws IOException{
        DatagramSocket socket = new DatagramSocket(1122);

        byte[] in = new byte[10000];
        byte[] out = new byte[10000];

        while (true){
            DatagramPacket reply = new DatagramPacket(in,in.length);
            socket.receive(reply);

            String inputLine = new String(reply.getData(), 0, reply.getLength());

            if(inputLine.equals("ping")){
                System.out.println(inputLine);
                out = "pong".getBytes();
                DatagramPacket requestDatagramPacket =
                new DatagramPacket(
                        out , out.length,reply.getAddress(),reply.getPort());
                socket.send(requestDatagramPacket);
            }else{
                out = "Wrong Answer".getBytes();

                DatagramPacket request =
                new DatagramPacket(
                        out,out.length, reply.getAddress(),reply.getPort());
               socket.send(request);

            }
        }


    }
}
