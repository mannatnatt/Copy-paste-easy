/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readease2;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;


/**
 *
 * @author Mannat Natt
 */
public class CreateList {

    static int page = 0;
    static String response;
    static ArrayList<String> list = new ArrayList<>();
    static boolean lock;

    public CreateList() {
        try {
            
            list.clear();
            page = 0;

            DataFlavor df = DataFlavor.stringFlavor;
            if (java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().isDataFlavorAvailable(df)) {
                String data = (String) java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                for (String red : data.split("\\n")) {
                    list.add(red);
                }
                response = "Data accepted";

                lock = true;
            } else {
                response = "Wrong data";

                lock = false;
            }

        } catch (UnsupportedFlavorException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

}
