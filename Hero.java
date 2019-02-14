import javax.swing.JComponent;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;

public class Hero{
	
	public BufferedImage image; 
	public URL resource = getClass().getResource("run/run0.png");


	// circle's position
	public int x = 5;
	public int y = 530;
	public int height;
	public int width;
	public int gravity = 530;

	public boolean superS = false;
	public boolean runback = false;
	public boolean right = true;
	public boolean isAttacking = false;
	public int state = 0;

	Draw drawing;



	public Hero(Draw draw){

		this.drawing = draw;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public Hero(int x, int y, Draw draw){

		this.x = x;
		this.y = y;

		this.drawing = draw;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth() + 5;
	}

	public Rectangle heroBounds(){
		return(new Rectangle (x, y, width, height));
	}



public void reloadImage0(){
		state++;
		runback = false;
		if(state == 0){
			resource = getClass().getResource("run/run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run/run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run/run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run/run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run/run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run/run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				isAttacking = true;
				for(int ctr = 0; ctr < 11; ctr++){
					try {
						if (right == true){
							resource = getClass().getResource("attack/attack"+ctr+".png");
						}
						else{
							resource = getClass().getResource("attack/attac"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						drawing.repaint();
				        Thread.sleep(1000/30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				isAttacking = false;
				
			}
		});
		thread1.start();
	}	
			
	public void attack(){
		attackAnimation();
	}

	public void moveUp(){ 
		if(y < 490) {
		y = 490;	
		}
		y = y - 5;
		drawing.repaint();
	}

	public void moveDown(){
		if(y > 490){
		 y = 490;
		}
		y = y + 5;
		drawing.repaint();
	}

	public void moveLeft(){
		right = false;
		x = x - 5;
		reloadImage0();
		drawing.repaint();
	}

	public void moveRight(){
		right = true;	
		if(x > 540){
			x = 540;
		}
		x = x + 5;
		reloadImage0();
		drawing.repaint();
	}
}