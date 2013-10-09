package net.kemoy.game.graphics;

import net.kemoy.game.Game;

public class Bitmap3D extends Bitmap {
	public Bitmap3D(int width, int height) {
		super(width, height);
	}

	public void render(Game game) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000;
		}
	}
}
