import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeineSuchergebnisse {
    public JPanel ksePanel;
    private JButton okButton;

    public void keineSuchergebnisse(JFrame keinErgebnis) {

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keinErgebnis.dispose();
            }
        });

    }
}
