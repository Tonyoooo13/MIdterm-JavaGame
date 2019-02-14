import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	public BufferedImage image;
	public BufferedImage backgroundImage;
	public Hero hero;

	// circle's position
	public int x = 30;
	public int y = 30;

	// animation states
	public int state = 0;

	Monster monster1;
	Monster monster2;
	Monster monster3;
	Monster monster4;
	Monster monster5;

	public Draw(){
		monster1 = new Monster(200, 200);
		monster2 = new Monster(300, 300);
		monster3 = new Monster(400, 400);
		monster4 = new Monster(500, 500);
		monster5 = new Monster(600, 600);
		hero = new Hero(x,y, this);

		try{
			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);	
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(hero.image, hero.x, hero.y, this);

		g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);
		g.drawImage(monster2.image, monster2.xPos, monster2.yPos, this);
		g.drawImage(monster3.image, monster3.xPos, monster3.yPos, this);
		g.drawImage(monster4.image, monster4.xPos, monster4.yPos, this);
		g.drawImage(monster5.image, monster5.xPos, monster5.yPos, this);
	}
}