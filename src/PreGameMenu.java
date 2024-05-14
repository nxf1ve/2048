import javax.swing.*;
import java.awt.*;

public class PreGameMenu extends JFrame {
    final private JFrame preGameMenuFrame = new JFrame();

    String[] items = {
            "4x4",
            "5x5",
            "6x6"
    };
    final private JComboBox<String> comboBoxSelectGrids = new JComboBox<>(items);

    public void OpenFrame() {
        preGameMenuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        preGameMenuFrame.setSize(300, 200);
        preGameMenuFrame.setLocationRelativeTo(null);
        preGameMenuFrame.setResizable( false );
        preGameMenuFrame.setLayout(null);

        preGameMenuFrame.add(comboBoxSelectGrids);
        comboBoxSelectGrids.setBounds(preGameMenuFrame.getWidth() -250, preGameMenuFrame.getHeight() - 100, 200, 80);


        preGameMenuFrame.setVisible(true);

    }

}
