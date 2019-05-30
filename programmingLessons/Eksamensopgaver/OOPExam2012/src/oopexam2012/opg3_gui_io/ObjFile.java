/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopexam2012.opg3_gui_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PCATG
 */
public class ObjFile implements FileIOInterface, Serializable {

    private static File file = new File("Opg4File.obj");
    private String txt;
    private List<Object> listStrings;

    public String getTxt() {
        return txt;
    }

    @Override
    public void writeToFile(String text) {
        this.txt = text;

        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(txt + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String readFromFile() {
//        listStrings = new ArrayList<>();
//        boolean cont = true;
        try (ObjectInputStream o
                = new ObjectInputStream(new FileInputStream(file))) {
//            while (cont) {
//                Object obj = (String) o.readObject();
//                if (obj != null) {
//                    listStrings.add(obj);
//                } else {
//                    cont = false;
//                }
//            }
            this.txt = (String) o.readObject();

//            listStrings.add(getTxt());

        } catch (FileNotFoundException ex) {
            return "Object file not found";
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObjFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return getTxt();
    }

}
