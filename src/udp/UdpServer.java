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

                DatagramPacket requestDatagramPacket =
                new DatagramPacket(
                        sendData , sendData.length
                        ,receivePacket.getAddress()
                        ,receivePacket.getPort());
                serverSocket.send(requestDatagramPacket);

            } else if (message.equals("Exit")) {
                System.out.println(message);
                sendData= "Exit".getBytes();
                DatagramPacket ExitDatagramPacket =
                        new DatagramPacket(
                                sendData, sendData.length
                                , receivePacket.getAddress()
                                , receivePacket.getPort());
                serverSocket.send(ExitDatagramPacket);
                availability = false;
                serverSocket.close();
            }
            else{
                sendData = "Not the right message".getBytes();
                DatagramPacket request =
                new DatagramPacket(
                        sendData,sendData.length, receivePacket.getAddress()
                        ,receivePacket.getPort());
                serverSocket.send(request);
            }
        }


    }
}




