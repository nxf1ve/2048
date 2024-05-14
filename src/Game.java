import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener {
    private boolean gameOver = false;
    static Game newGame = new Game();
    Board game = new Board(4);
    static JFrame frame = new JFrame( "2048" );
    public static void OpenFrame() {
        frame.addKeyListener( newGame );
        frame.getContentPane().add( newGame );
        frame.setSize( 600, 400 );
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible( true );
        frame.setResizable( false );
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) {
            if (e.getKeyCode() != KeyEvent.VK_ENTER) {
                return;
            }
        }

        char keyChar = e.getKeyChar();
        int keyCode = e.getKeyCode();

        boolean moved = false;
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                moved = game.up();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                moved = game.down();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                moved = game.left();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                moved = game.right();
                break;
            case KeyEvent.VK_ENTER:
                game = new Board(game.getGrids());
                game.spawn();
                game.spawn();
                gameOver = false;
                break;
            default:
                return;
        }

        if (moved && !game.isBoardFilled()) {
            game.spawn();
        }
        frame.repaint();
        if (game.getHighBlock() == 2048) {
            gameOver = true;
            JOptionPane.showMessageDialog(frame, "Congratulations, you've won!\nYou can restart the game, press ENTER", "Winner", JOptionPane.INFORMATION_MESSAGE);
        }
//        if (game.isGameLost()) {
//            gameOver = true;
//            JOptionPane.showMessageDialog(frame, "You lose\nYou can restart the game, press ENTER", "Game Over", JOptionPane.INFORMATION_MESSAGE);
//        }
    }

    @Override
    public void keyReleased( KeyEvent e )
    {

    }


    @Override
    public void keyTyped( KeyEvent e )
    {

    }

    public void drawBlocks( Graphics g, Block block, int x, int y )
    {
        int blockValue = block.getValue();
        int length = String.valueOf( blockValue ).length();
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor( Color.lightGray );
        g2.fillRoundRect( x, y, 50, 50, 5, 5 );
        g2.setColor( Color.black );
        if ( blockValue > 0 )
        {
            g2.setColor( block.getBlockColor() );
            g2.fillRoundRect( x, y, 50, 50, 5, 5 );
            g2.setColor( Color.black );
            g.drawString( "" + blockValue, x + 25 - 3 * length, y + 25 );
        }
    }
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString( "2048", 250, 20 );
        g2.drawString( "Score: " + game.getScore(),
                200 - 4 * String.valueOf( game.getScore() ).length(),
                40 );
        g2.drawString( "Highest Block: " + game.getHighBlock(),
                280 - 4 * String.valueOf( game.getHighBlock() ).length(),
                40 );
        g2.drawString( "Press 'Enter' to Start", 210, 315 );
        g2.drawString( "Use 'wasd' or Arrow Keys to move", 180, 335 );

        g2.setColor( Color.gray );
        g2.fillRect( 140, 50, 250, 250 );
        for ( int i = 0; i < game.getGrids(); i++ )
        {
            for ( int j = 0; j < game.getGrids(); j++ )
            {
                drawBlocks( g, game.board[i][j], j * 60 + 150, i * 60 + 60 );
            }
        }
    }

}
