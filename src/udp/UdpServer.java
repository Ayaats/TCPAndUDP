package udp;
import java.net.*;
import java.io.*;
public class UdpServer {
    public static void main(String args[])throws IOException{
        
        DatagramSocket serverSocket= new DatagramSocket(1122);

        boolean availability= true;

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (availability){
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);

            serverSocket.receive(receivePacket);

            String message = new String(receivePacket.getData(),
                    0, receivePacket.getLength());

            if(message.equals("ping")){

                sendData = "pong".getBytes();

                DatagramPacket request =
                new DatagramPacket(
                        sendData , sendData.length
                        ,receivePacket.getAddress()
                        ,receivePacket.getPort());
                serverSocket.send(request);

            }else if (message.equals("Exit")) {
                System.out.println(message);
                sendData= "Successfully Exit".getBytes();
                DatagramPacket ExitRequest =
                        new DatagramPacket(
                                sendData, sendData.length
                                , receivePacket.getAddress()
                                , receivePacket.getPort());
                serverSocket.send(ExitRequest);
                availability = false;
                serverSocket.close();

            }
            else {
                sendData = "Not the right message".getBytes();
                DatagramPacket wrongRequest =
                new DatagramPacket(
                        sendData,sendData.length,
                        receivePacket.getAddress()
                        ,receivePacket.getPort());
                serverSocket.send(wrongRequest);
            }
        }

    }
}




