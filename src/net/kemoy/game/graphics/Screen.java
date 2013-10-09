package net.kemoy.game.graphics;

import java.awt.Color;
import java.awt.Graphics;

import net.kemoy.game.Core;
import net.kemoy.game.gui.Font;

public class Screen extends Bitmap {
	static int dx = 0;
	static int dy = 0;
	static int bw = 64;
	static int bh = 16;
	static boolean isFreeX = false;
	static boolean isFreeY = false;

	public static void render(Graphics g) {
		fill();

		draw(new Color(255, 100, 100), dx, dy, bw, bh);

		Font.drawString("FPS: " + Core.fps, 2 + dx, 12 + dy);
	}
	
	public static void tick() {
		if (dx < (width - bw) && !isFreeX) {
			dx++;
		} else {
			isFreeX = true;
			dx--;
		}
		
		if (dy < (height - bh) && !isFreeY) {
			dy++;
		} else {
			isFreeY = true;
			dy--;
		}
	}
}