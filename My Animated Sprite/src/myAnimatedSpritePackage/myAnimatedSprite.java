package myAnimatedSpritePackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class myAnimatedSprite extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static BufferedImage[] myAnimation;
	public static int myCounter = 1;

	public static void main(String[] args) {
		createFrame();
		bufferImages();

	}
	
	public static void createFrame() {
		myAnimatedSprite c = new myAnimatedSprite();
		JFrame frame = new JFrame("My Animation");
		frame.setSize(500,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(c);
		frame.setVisible(true);
	}
	
	public static void bufferImages() {
		String mySource = "src/sprite_idle/";
		String myFilename = "Idle";
		String myFiletype = "png";
		int myCount = 15;
		myAnimation = new BufferedImage[myCount];
		generateArray(mySource, myFilename, myFiletype, myCount);
	}
	
	public static void loadImage(File myPath, int i) {
		try {
			myAnimation[i] = ImageIO.read(myPath);
		} catch (IOException e) {
			System.out.println("Failed To Load Image. Please Check Filepath");
		}		
	}
	
	public static void generateArray(String mySource, String myFilename, String myFiletype, int myCount) {
		for(int i=0; i<myCount; i++) {
			String myString = mySource + myFilename + " (" + (i+1) + ")." + myFiletype;
			File myPath = new File(myString);
			loadImage(myPath, i);
		}
	}
	
	Timer timer = new Timer(20, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	repaint();
	    	myCounter++;
	    	if(myCounter>14) myCounter = 1;
	    }    
	});
	
	public void paintComponent(Graphics g) {		
		super.paintComponent(g);
		timer.start();		
		try {
			ImageIcon img = new ImageIcon(myAnimation[myCounter]);
			img.paintIcon(this, g, 50, 50);
		} catch(Exception e) {
			System.out.println("Image Not Yet Loaded");
		}
	}

	
}
