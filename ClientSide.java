import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientSide {
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private ObjectMapper mapper = null;
    private Scanner scanner;
    
    public ClientSide(String address, int port){
        try {
            s = new Socket(address,port);

            in = new DataInputStream(new BufferedInputStream(s.getInputStream()));

            out = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));

            scanner = new Scanner(System.in);

            System.out.println("Hello user. Please enter your name");
            String name = scanner.nextLine();

            System.out.println(name+" enter your age");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println(name+" enter your address");
            String addressUser = scanner.nextLine();

            System.out.println(name+" enter your id.");
            int id = scanner.nextInt();

            mapper = new ObjectMapper();

            String json = String.format("{\"ID\":%s,\"name\":\"%s\",\"age\":%s,\"address\":\"%s\"}", String.valueOf(id),name,String.valueOf(age),addressUser);

            Person p = mapper.readValue(json, Person.class);

            while(true){
                out.writeUTF(json);
                out.flush();
                System.out.println(in.readUTF());
                break;
            }

            in.close();
            out.close();
            s.close();
            System.out.println(p.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ClientSide s = new ClientSide("localhost", 5000);
    }
}
