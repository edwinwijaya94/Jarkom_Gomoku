package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author davidkwan
 */
public class Client {

    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String serverMessage = "";
        String message = "";
        
        // Ask for name
        System.out.println("What's your name?");
        message = sc.nextLine();
        
        System.out.println("Connecting...");
        socket = new Socket("localhost", 7777);
        System.out.println("Connection Successful");
        
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(message);
        System.out.println(in.readUTF());
        
        while(true){
            while(!serverMessage.equals("Game Started")){
                System.out.println("Enter message:");
                message = sc.nextLine();
                out.writeUTF(message);
                serverMessage = in.readUTF();
                System.out.println(serverMessage);
            }
            out.writeUTF("\\dummy");

            while(!serverMessage.equals("Game Ended")){
                serverMessage = in.readUTF();
                if(serverMessage.equals("Your Move")){
                    System.out.println(serverMessage);

                    System.out.println("Enter i coordinate");
                    int i = sc.nextInt();
                    out.writeUTF(Integer.toString(i));

                    // Should be enter j coordinate
                    System.out.println("Enter j coordinate");
                    int j = sc.nextInt();
                    out.writeUTF(Integer.toString(j));
                }
                else{
                    System.out.println(serverMessage);
                }

            }
        }
    }
    
}