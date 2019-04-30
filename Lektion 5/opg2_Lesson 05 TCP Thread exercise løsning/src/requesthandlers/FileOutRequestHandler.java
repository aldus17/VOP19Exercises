/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesthandlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AleksanderSTUD
 */
public class FileOutRequestHandler extends AbstractRequestHandler {

    private String fileName;
    private File file;

    public FileOutRequestHandler(Socket socket) {
        super(socket);
    }

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        if (fileName.isEmpty()) {
            System.out.println("ERROR - no filename found, possible empty file name length");
        }
        this.fileName = fileName;
        this.file = new File(fileName);

    }

    public String writeInformation() {

        Date currentDate = new Date();
        String getConnectString = socket.getInetAddress() + ":" + socket.getPort();

        StringBuilder buildString = new StringBuilder();
        buildString.append("TimeStamp: ")
                .append(currentDate.toString())
                .append("\t")
                .append("The client is: ")
                .append(getConnectString)
                .append("\t")
                .append("Recieved string: ")
                .append(this.fileName);

        return buildString.toString();

    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for " + socket.getPort());

        try (Scanner scanner = new Scanner(socket.getInputStream());
                PrintWriter pw = new PrintWriter(new FileOutputStream(file), true);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Server ready. Type your massage to be logged in text file:" + this.fileName);

            String information = writeInformation();
            String yourMessage = "";
            while (scanner.hasNextLine()) {

                yourMessage = scanner.nextLine();

                pw.println(yourMessage + " *LOGGED* " + information);
                writer.println("Message: " + yourMessage + " -> has been logged: " + information);
               
            }

            System.out.println("RequestHandler DONE!!!!");
        } catch (IOException ex) {
            Logger.getLogger(FlipRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
