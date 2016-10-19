package lifegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * @author BruceLi.
 *
 */
@SuppressWarnings("serial")
public class LifeGame extends JFrame {
  /**
   * �����Ա����ȷ����Ϸ�Ŀ�չ����.
  */
  private final  World world;
  
  /**
 * @param rows ��Ϸ���������.
 * @param columns ��Ϸ���������
 */
  public LifeGame(final int rows, int columns) {
    super();
    world = new World(rows, columns);
    new Thread(world).start();
    add(world);
  }
  
  /**
   * @param args.
  */
  public static void main( final String[] args) {
    final LifeGame frame = new LifeGame(80, 100);
      
    final JMenuBar menu = new JMenuBar();
       
    frame.setJMenuBar(menu);
        
    final JMenu options = new JMenu("Options");
    menu.add(options);
        
    final JMenuItem love = options.add("Love");
    love.addActionListener(frame.new LoveActionListener());
        
    final JMenuItem square = options.add("Square");
    square.addActionListener(frame.new SquareActionListener());        
        
    final  JMenu help = new JMenu("Help");
        
    final JMenuItem about = help.add("About");
    about.addActionListener(new ActionListener() {
      
      /**
       * @ActionEvent event
       * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
       * return void
      */
      @Override
      public void actionPerformed(final ActionEvent event) {
                    
      }
    });
    menu.add(help);
        
        
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1007, 859);
    frame.setTitle("Game of Life");
    frame.setVisible(true);
    frame.setResizable(false);
  }  
    
  /**
   * @author BruceLi.
  */
  class LoveActionListener implements ActionListener {
    /**
     * @author BruceLi.
    */
    public void actionPerformed(final ActionEvent event) {
      world.setLove();
    }
  }
    
  /**
   * @author BruceLi.
  */
  class SquareActionListener implements ActionListener {
    /**
     * @author BruceLi.
     */
    public void actionPerformed(final ActionEvent event) {
      world.setSquare();
    }
  }    
}
