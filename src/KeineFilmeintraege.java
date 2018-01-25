import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class KeineFilmeintraege {
    public JPanel kfPanel;
    private JButton okButton;

    public void akzeptieren(JFrame frame1){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
