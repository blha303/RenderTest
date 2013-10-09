package net.kemoy.game.gui;

import java.awt.Color;
import java.awt.Graphics;

import net.kemoy.game.Core;

public class Font {
	public static void drawString(String msg, int xOffs, int yOffs) {
		Graphics g = Core.canvas.getGraphics();
		
		g.setColor(Color.BLACK);
		g.drawString(msg, xOffs - 1, yOffs - 1);
		
		g.setColor(Color.WHITE);
		g.drawString(msg, xOffs, yOffs);
	}
}
