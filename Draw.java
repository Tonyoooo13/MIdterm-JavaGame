import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

public class Draw extends JComponent{

	public BufferedImage image;
	public BufferedImage backgroundImage;
	public Hero hero;

	public int gravity = 530;

	public Random randomizer;

	public int enemyCount;
	Monster[] monsters = new Monster[5];
	public ArrayList<Monster> monsterlist = new ArrayList<>();



	public Draw(){
		randomizer = new Monster[5];
		hero = new Hero(5,530,this);

		try{
			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsterlist.size(); c++){
							if(monsterlist.size()! = 0){
								monsterlist.get(c).moveTo(hero.x, hero.y);
								repaint();
							}
							if(monsterlist.get(c).life <= 0){
								monsterlist.remove(c);
							}
						}
						Thread.sleep(100);
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start()
	}

	public void enemySpawn(){
		if(enemyCount < 5){
			int random = randomizer.nextInt(500);
			if(random < 500 || random < 30){
			monsters[enemyCount] = new Monster(random, 530, this);
			monsterlist.add(monsters[enemyCount]);
			enemyCount++;
			}
		}
	}
	
	public void checkCollision(){

		for(int i=0; i < monsterlist.size(); i++){
			if(hero.isAttacking == true){
				if(hero.heroBounds().intersects(monsterlist.get(i).monsterBounds())){
					monsterlist.get(i).life -= 10;
				}
			}
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);	
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(hero.image, hero.x, hero.y, this);

		g.drawImage(charP, 5, 5, this);

		g.setColor(Color. RED);
		g.fillRect(60, 15, 300, 20);

		g.setColor(Color. BLUE);
		g.fillRect(60, 15, life * 2, 20);
		
		g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);
		g.drawImage(monster2.image, monster2.xPos, monster2.yPos, this);
		g.drawImage(monster3.image, monster3.xPos, monster3.yPos, this);
		g.drawImage(monster4.image, monster4.xPos, monster4.yPos, this);
		g.drawImage(monster5.image, monster5.xPos, monster5.yPos, this);
	}
}