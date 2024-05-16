import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PreGameMenu extends JFrame {
    final private JFrame preGameMenuFrame = new JFrame();

    String[] items = {
            "4x4",
            "5x5",
            "6x6"
    };
    final private JComboBox<String> comboBoxSelectGrids = new JComboBox<>(items);
    final private JPanel comboBoxPanel = new JPanel();
    final private JButton buttonGoToPlay = new JButton("Start");
    final private JPanel buttonGoToPlayPanel = new JPanel();
    final private JLabel welcomeLabel = new JLabel("<html><center>Welcome to the 2048 game!<br> To start the game select the size and click the START button.</html>");
    private JLabel Board4x4Label = new JLabel();
    private JLabel Board5x5Label = new JLabel();
    private JLabel Board6x6Label = new JLabel();



    public void OpenFrame() {
        preGameMenuFrame.setTitle("2048");
        preGameMenuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        preGameMenuFrame.setSize(1100, 700);
        preGameMenuFrame.setLocationRelativeTo(null);
        preGameMenuFrame.setResizable( false );
        preGameMenuFrame.setLayout(null);

        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(preGameMenuFrame.getWidth()/2 - 340, 50, 650, 80);

        comboBoxPanel.setLayout(new BorderLayout());
        comboBoxPanel.add(comboBoxSelectGrids, BorderLayout.CENTER);
        comboBoxPanel.setBounds(preGameMenuFrame.getWidth()/2 - 200, preGameMenuFrame.getHeight() -150, 400, 40);

        buttonGoToPlayPanel.setLayout(new BorderLayout());
        buttonGoToPlayPanel.add(buttonGoToPlay, BorderLayout.CENTER);
        buttonGoToPlayPanel.setBounds(preGameMenuFrame.getWidth()/2 - 100, preGameMenuFrame.getHeight() - 90, 200, 40);

        try {
            ImageIcon pictureIcon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("4x4.png")));
            Board4x4Label.setIcon(pictureIcon);
            Board4x4Label.setBounds(15, 220, pictureIcon.getIconWidth(), pictureIcon.getIconHeight());
            preGameMenuFrame.add(Board4x4Label);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImageIcon pictureIcon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("5x5.png")));
            Board5x5Label.setIcon(pictureIcon);
            Board5x5Label.setBounds(15 + 300, 200, pictureIcon.getIconWidth(), pictureIcon.getIconHeight());
            preGameMenuFrame.add(Board5x5Label);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImageIcon pictureIcon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("6x6.png")));
            Board6x6Label.setIcon(pictureIcon);
            Board6x6Label.setBounds(315+ 350, 160, pictureIcon.getIconWidth(), pictureIcon.getIconHeight());
            preGameMenuFrame.add(Board6x6Label);
        } catch (IOException e) {
            e.printStackTrace();
        }

        preGameMenuFrame.add(welcomeLabel);
        preGameMenuFrame.add(comboBoxPanel);
        preGameMenuFrame.add(buttonGoToPlayPanel);

        buttonGoToPlay.addActionListener(e -> {
            int selectedGrid = comboBoxSelectGrids.getSelectedIndex();
            if (selectedGrid == 0) {
                Game newGame = new Game();
                newGame.OpenFrame(newGame, 4);
                preGameMenuFrame.dispose();
            } else if (selectedGrid == 1) {
                Game newGame = new Game();
                newGame.OpenFrame(newGame, 5);
                preGameMenuFrame.dispose();
            } else if (selectedGrid == 2) {
                Game newGame = new Game();
                newGame.OpenFrame(newGame, 6);
                preGameMenuFrame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(preGameMenuFrame, "Please select a grid size!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        preGameMenuFrame.setVisible(true);

    }

}
