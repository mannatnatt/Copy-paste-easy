/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readease2;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Mannat Natt
 */
public class ListNavigation extends CreateList {

    private String pad = "";
    final private Clipboard cb = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();

    public void forward() {

        int num = list.size() / 25;
        int mp = num * 25;
        if (list.size() > mp) {
            num += 1;
        }
        page++;

        if (page <= num && lock == true) {
            pad = "";
            for (int i = page - 1; i == page - 1; i++) {
                int lt = (i * 25) + 24;

                if (lt >= list.size() - 1) {

                    for (int j = i * 25; j < list.size(); j++) {

                        pad = pad.concat(list.get(j));
                        String line = System.lineSeparator();
                        pad = pad.concat(line);
                    }

                } else {

                    for (int k = i * 25; k <= lt; k++) {

                        pad = pad.concat(list.get(k));
                        String line = System.lineSeparator();
                        pad = pad.concat(line);
                    }

                }
            }
        } else {
            page--;
        }
        StringSelection asd = new StringSelection(pad);
        cb.setContents(asd, asd);

    }

    public void back() {

        int num = list.size() / 25;
        int mp = num * 25;
        if (list.size() > mp) {
            num += 1;
        }
        page--;

        if (page >= 1 && lock == true) {
            pad = "";
            for (int i = page - 1; i == page - 1; i++) {
                int lt = (i * 25) + 24;

                if (lt >= list.size() - 1) {

                    for (int j = i * 25; j < list.size(); j++) {

                        pad = pad.concat(list.get(j));
                        String line = System.lineSeparator();
                        pad = pad.concat(line);
                    }

                } else {

                    for (int k = i * 25; k <= lt; k++) {

                        pad = pad.concat(list.get(k));
                        String line = System.lineSeparator();
                        pad = pad.concat(line);
                    }

                }
            }
        } else {
            page++;
        }
        StringSelection asd = new StringSelection(pad);
        cb.setContents(asd, asd);

    }

    public void check() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(list.get(i));

        }

    }

}
