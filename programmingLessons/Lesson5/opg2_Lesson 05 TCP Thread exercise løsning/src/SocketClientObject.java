
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import lesson05SerialIOExercise.Species;

public class SocketClientObject {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 3333);
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {
            System.out.println("Send to server the following information");
            Species s = new Species("Oct", 20, 30);
            outputStream.writeObject(s);
            System.out.println(s.toString());
        } catch (IOException ex) {
            System.out.println("input error");
        }
    }
}
