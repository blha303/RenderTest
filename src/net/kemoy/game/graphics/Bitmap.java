package net.kemoy.game.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import net.kemoy.game.Core;

public class Bitmap {
	static int width = Core.sized.width;
	static int height = Core.sized.height;
	
	public static void draw(int xOffs, int yOffs, int w, int h) {
		Graphics g = getGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(xOffs, yOffs, w, h);
	}
	
	public static void draw(Color col, int xOffs, int yOffs, int w, int h) {
		Graphics g = getGraphics();
		
		g.setColor(col);
		g.fillRect(xOffs, yOffs, w, h);
	}
	
	public static void drawGradient(Color col, int xOffs, int yOffs, int w, int h) {
		Graphics g = getGraphics(); 
		
		for (int i = 0; i < 2; i++) {
//			for (int ic = 0; ic < 100; ic++) {
//				g.setColor(new Color(col.getRed() - ic, col.getGreen() - ic, col.getBlue() - ic));
//			}
			g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
			
			for (int ii = 0; ii < i * h / 2; ii++) {
				g.fillRect(xOffs, yOffs, w, ii);
			}
		}
	}
	
	public static void fill() {
		draw(0, 0, width, height);
	}
	
	static Graphics getGraphics() {
		return Core.canvas.getGraphics();
	}
}
