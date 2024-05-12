import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener {
    static Game newGame = new Game();
    Board game = new Board();
    static JFrame frame = new JFrame( "2048" );
    String gameBoard = game.toString();
    public static void OpenFrame() {
        frame.addKeyListener( newGame );
        frame.getContentPane().add( newGame );
        frame.setSize( 600, 400 );
        frame.setLocationRelativeTo(null);
        frame.setVisible( true );
        frame.setResizable( false );
    }
    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                game.up();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                game.down();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                game.left();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                game.right();
                break;
            case KeyEvent.VK_ENTER:
                game = new Board();
                game.spawn();
                game.spawn();
                break;
            default:
                return;
        }

        game.spawn();
        gameBoard = game.toString();
        frame.repaint();
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
        int tileValue = block.getValue();
        int length = String.valueOf( tileValue ).length();
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor( Color.lightGray );
        g2.fillRoundRect( x, y, 50, 50, 5, 5 );
        g2.setColor( Color.black );
        if ( tileValue > 0 )
        {
            g2.setColor( block.getBlockColor() );
            g2.fillRoundRect( x, y, 50, 50, 5, 5 );
            g2.setColor( Color.black );
            g.drawString( "" + tileValue, x + 25 - 3 * length, y + 25 );
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
        if ( game.blackOut() )
        {
            g2.drawString( "Press 'Enter' to restart", 200, 355 );
        }
        g2.setColor( Color.gray );
        g2.fillRect( 140, 50, 250, 250 );
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                drawBlocks( g, game.board[i][j], j * 60 + 150, i * 60 + 60 );
            }
        }
        if ( game.gameOver() )
        {
            g2.setColor( Color.gray );
            g2.fillRect( 140, 50, 250, 250 );
            for ( int i = 0; i < 4; i++ )
            {
                for ( int j = 0; j < 4; j++ )
                {
                    g2.setColor( Color.RED );
                    g2.fillRoundRect( j * 60 + 150, i * 60 + 60, 50, 50, 5, 5 );
                    g2.setColor( Color.black );
                    g.drawString( "GAME", j * 60 + 160, i * 60 + 75 );
                    g.drawString( "OVER", j * 60 + 160, i * 60 + 95 );
                }
            }
        }
    }

}
