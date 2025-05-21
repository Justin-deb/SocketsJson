import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Server {
    private ServerSocket ss = null;
    private Socket  s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private ObjectMapper mapper = null;

    public Server(int port){
        try {
            System.out.println("1");
            ss = new ServerSocket(port);
            System.out.println("Server started waiting for client");

            s = ss.accept();
            System.out.println("Client connected");

            in = new DataInputStream(new BufferedInputStream(s.getInputStream()));

            out = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));

            mapper = new ObjectMapper();

            Person p;

            while(true){
                String json = in.readUTF();
                System.out.println(json);
                p = mapper.readValue(json, Person.class);
                out.writeUTF("Server successfully grabbed the JSON");
                out.flush();
                break;
            }

            System.out.println(p.name());

            in.close();
            out.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server s =new Server(5000);
    }
}
