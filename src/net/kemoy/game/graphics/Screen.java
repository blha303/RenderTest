package net.kemoy.game.graphics;

import java.util.Random;


public class Screen extends Bitmap {
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
		
		for (int i = 0; i < dw * dh; i++) {
			int r1 = new Random().nextInt(0xFFFF);
			t.pixels[i] = r1 * i;
		}
	}
	
	public void render() {
		for (int i = 0; i < pixels.length; i++) {
			int r1 = new Random().nextInt(0xFF);
			int r2 = new Random().nextInt(0xFF);
			int r3 = new Random().nextInt(0xFF);
			pixels[i] = r1 + r2 + r3;
		}

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