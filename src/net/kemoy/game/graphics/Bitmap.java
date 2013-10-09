package net.kemoy.game.graphics;

import java.awt.Color;
import java.awt.Graphics;

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
	
	public static void fill() {
		draw(0, 0, width, height);
	}
	
	static Graphics getGraphics() {
		return Core.canvas.getGraphics();
	}
}
