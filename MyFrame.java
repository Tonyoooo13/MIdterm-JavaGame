import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_W){
			drawing.hero.moveUp();
			System.out.println("pos: " + drawing.hero.x + ", " + drawing.hero.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){
			drawing.hero.moveRight();
			System.out.println("pos: " + drawing.hero.x + ", " + drawing.hero.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.hero.moveDown();
			System.out.println("pos: " + drawing.hero.x + ", " + drawing.hero.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			drawing.hero.moveLeft();
			System.out.println("pos: " + drawing.hero.x + ", " + drawing.hero.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_J){
			drawing.hero.attack();
			System.out.println("attack");
		}
	}

	public void keyReleased(KeyEvent e){

	}

	public void keyTyped(KeyEvent e){
		
	}

	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(600,600);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("practical programming");
	}
}