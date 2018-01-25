import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class Suchergebnisse {
    public JPanel sePanel;
    private JButton speichernButton;
    private JButton sucheButton;
    public JButton hauptmenuButton;
    private JTextArea eintragarea0;
    private JTextArea eintragarea1;
    private JTextArea eintragarea2;
    private JTextArea eintragarea3;
    private JTextArea eintragarea4;
    private JTextArea eintragarea5;
    private JTextArea eintragarea6;
    private JTextArea eintragarea7;
    private JTextArea eintragarea8;
    private JTextArea eintragarea9;
    private JTextArea eintragarea10;
    private JTextArea eintragarea11;
    private JTextArea eintragarea12;
    private JTextArea eintragarea13;
    private JTextArea eintragarea14;
    private JTextArea eintragarea15;
    private JTextArea eintragarea16;
    private JTextArea eintragarea17;
    private JTextArea eintragarea18;
    private JTextArea eintragarea19;
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


        for (int i = 0; i < teile.length; i++) {
            Field f = null;
                try {
                    f = c.getDeclaredField("eintragarea" + i);
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

                if (speichernCheckBox0.isSelected()) {
                    if (eintragarea0.getText() != null) {
                        String s = teile [0] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox1.isSelected()) {
                    if (eintragarea1.getText() != null) {
                        String s = teile [1] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox2.isSelected()) {
                    if (eintragarea2.getText() != null) {
                        String s = teile [2] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox3.isSelected()) {
                    if (eintragarea3.getText() != null) {
                        String s = teile [3] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox4.isSelected()) {
                    if (eintragarea4.getText() != null) {
                        String s = teile [4] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox5.isSelected()) {
                    if (eintragarea5.getText() != null) {
                        String s = teile [5] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox6.isSelected()) {
                    if (eintragarea6.getText() != null) {
                        String s = teile [6] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox7.isSelected()) {
                    if (eintragarea7.getText() != null) {
                        String s = teile [7] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox8.isSelected()) {
                    if (eintragarea8.getText() != null) {
                        String s = teile [8] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox9.isSelected()) {
                    if (eintragarea9.getText() != null) {
                        String s = teile [9] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox10.isSelected()) {
                    if (eintragarea10.getText() != null) {
                        String s = teile [10] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox11.isSelected()) {
                    if (eintragarea11.getText() != null) {
                        String s = teile [11] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox12.isSelected()) {
                    if (eintragarea12.getText() != null) {
                        String s = teile [12] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox13.isSelected()) {
                    if (eintragarea13.getText() != null) {
                        String s = teile [13] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox14.isSelected()) {
                    if (eintragarea14.getText() != null) {
                        String s = teile [14] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox15.isSelected()) {
                    if (eintragarea15.getText() != null) {
                        String s = teile [15] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox16.isSelected()) {
                    if (eintragarea16.getText() != null) {
                        String s = teile [16] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox17.isSelected()) {
                    if (eintragarea17.getText() != null) {
                        String s = teile [17] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox18.isSelected()) {
                    if (eintragarea18.getText() != null) {
                        String s = teile [18] + "€";
                        liste.writeToFavoritenliste(s);
                    }
                }

                if (speichernCheckBox19.isSelected()) {
                    if (eintragarea19.getText() != null) {
                        String s = teile [19] + "€";
                        liste.writeToFavoritenliste(s);
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
}