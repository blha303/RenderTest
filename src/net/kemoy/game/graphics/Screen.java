package net.kemoy.game.graphics;

import java.util.Random;


public class Screen extends Bitmap {
	private Bitmap tb;
	private Bitmap t;
	
	private int dx = 0;
	private int dy = 0;
	private int dw = 64;
	private int dh = 64;
	private boolean isFreeX = false;
	private boolean isFreeY = false;

	public Screen(int width, int height) {
		super(width, height);
		
		t = new Bitmap(dw, dh);
		tb = new Bitmap(dw + 2, dh + 2);
		
		for (int i = 0; i < dw * dh; i++) {
			int r1 = new Random().nextInt(0xFFFF);
			t.pixels[i] = r1 * i / 8;
		}
	}
	
	public void render() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0xFFCC66;
		}

		draw(tb, dx - 1, dy - 1);
		draw(t, dx, dy);
		
		// X Collisions
		
		if ((dx < width - dw) && !isFreeX) {
			dx++;
		} else {
			dx--;
			isFreeX = true;
		}
		
		if (dx < 0 && isFreeX) {
			isFreeX = false;
		}
		
		// Y Collisions
		
		if ((dy < height - dh) && !isFreeY) {
			dy++;
		} else {
			dy--;
			isFreeY = true;
		}
		
		if (dy < 0 && isFreeY) {
			isFreeY = false;
		}
	}
}