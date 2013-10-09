package net.kemoy.game.graphics;

public class Bitmap {
	public final int width;
	public final int height;
	public final int[] pixels;

	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void draw(Bitmap b, int xo, int yo) {
		for (int y = 0; y < b.height; y++) {
			int yp = y + yo;
			for (int x = 0; x < b.width; x++) {
				int xp = x + xo;
				
				xp++;
				
				if (xp < 0 || yp < 0 || xp >= width || yp >= height) continue;
				
				pixels[xp + yp * width] = b.pixels[x + y * b.width];
				
			}
		}
	}
}
