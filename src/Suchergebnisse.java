import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Suchergebnisse {

    public JPanel sePanel;
    private JButton speichernButton;
    private JButton sucheButton;
    public JButton hauptmenuButton;
    private JTextArea eintragArea0;
    private JTextArea eintragArea1;
    private JTextArea eintragArea2;
    private JTextArea eintragArea3;
    private JTextArea eintragArea4;
    private JTextArea eintragArea5;
    private JTextArea eintragArea6;
    private JTextArea eintragArea7;
    private JTextArea eintragArea8;
    private JTextArea eintragArea9;
    private JTextArea eintragArea10;
    private JTextArea eintragArea11;
    private JTextArea eintragArea12;
    private JTextArea eintragArea13;
    private JTextArea eintragArea14;
    private JTextArea eintragArea15;
    private JTextArea eintragArea16;
    private JTextArea eintragArea17;
    private JTextArea eintragArea18;
    private JTextArea eintragArea19;
    private JCheckBox speichernCheckBox0;
    private JCheckBox speichernCheckBox1;
    private JCheckBox speichernCheckBox2;
    private JCheckBox speichernCheckBox3;
    private JCheckBox speichernCheckBox4;
    private JCheckBox speichernCheckBox5;
    private JCheckBox speichernCheckBox6;
    private JCheckBox speichernCheckBox7;
    private JCheckBox speichernCheckBox8;
    private JCheckBox speichernCheckBox9;
    private JCheckBox speichernCheckBox10;
    private JCheckBox speichernCheckBox11;
    private JCheckBox speichernCheckBox12;
    private JCheckBox speichernCheckBox13;
    private JCheckBox speichernCheckBox14;
    private JCheckBox speichernCheckBox15;
    private JCheckBox speichernCheckBox16;
    private JCheckBox speichernCheckBox17;
    private JCheckBox speichernCheckBox18;
    private JCheckBox speichernCheckBox19;
    private JButton favoritenButton;
    private Hauptmenu hm1;
    private Suche sa1;
    private ListenVerwaltung liste;
    private Favoriten fl1;

    public void ergebnisanzeigen(String ergenbnisse, JFrame frame) {

        this.hm1 = new Hauptmenu(frame);
        this.liste = new ListenVerwaltung();
        this.sa1 = new Suche();
        this.fl1 = new Favoriten();

        String searchChar = "€";
        String[] teile = ergenbnisse.split(searchChar);

        Class<?> c = this.getClass();
        Suchergebnisse self = this;

        for (int i = 0; i < teile.length; i++) {
            Field f = null;
            try {
                f = c.getDeclaredField("eintragArea" + i);
                f.setAccessible(true);
                JTextArea y = (JTextArea) f.get(this);
                y.setText((teile[i]) + "€");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        frame.setSize(1200, 800);

        hauptmenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(hm1.hmPanel);
                hm1.hmPanel.setPreferredSize(hm1.hmPanel.getPreferredSize());
                frame.setSize(400, 300);
                frame.invalidate();
                frame.validate();
            }
        });

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 20; i++) {
                    try {
                        Field eintragAreaField = c.getDeclaredField("eintragArea" + i);
                        eintragAreaField.setAccessible(true);
                        JTextArea eintragAreaX = (JTextArea) eintragAreaField.get(self);

                        Field speichernCheckBoxField = c.getDeclaredField("speichernCheckBox" + i);
                        speichernCheckBoxField.setAccessible(true);
                        JCheckBox speichernCheckBoxX = (JCheckBox) speichernCheckBoxField.get(self);

                        if (speichernCheckBoxX.isSelected()) {
                            if (eintragAreaX.getText() != null) {
                                String s = teile[i] + "€";
                                liste.writeToFavoritenliste(s);
                            }
                        }
                    } catch (NoSuchFieldException e1) {
                        e1.printStackTrace();
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        sucheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(sa1.saPanel);
                frame.setSize(400, 300);
                sa1.sucheFunktionen(frame);
                frame.invalidate();
                frame.validate();
            }
        });

        favoritenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(fl1.flPanel);
                frame.setSize(1200, 500);
                fl1.favoritenlisteFunktionen(frame);
                frame.invalidate();
                frame.validate();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}