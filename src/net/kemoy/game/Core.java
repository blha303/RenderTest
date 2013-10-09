package net.kemoy.game;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import net.kemoy.game.graphics.Bitmap;
import net.kemoy.game.graphics.Screen;

public class Core extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static int width = 640;
	public static int height = width / 4 * 3;
	public static int scale = 3;
	
	public static Dimension size = new Dimension(width, height);
	public static Dimension sized = new Dimension(width / scale, height / scale);
	
	public static Image canvas;
	
	public static String fps = "30";
	
	static boolean running = false;
	static boolean setup = false;
	
	public Core() {
		setSize(size);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
	}
	
	public void start() {
		if (!running) running = true;

		new Bitmap();
		
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
	}
	
	public void run() {
		canvas = createVolatileImage(size.width, size.height);
		
		int frames = 0;

		double unprocessedSeconds = 0;
		long lastTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;

		requestFocus();

		while (running) {
			long now = System.nanoTime();
			long passedTime = now - lastTime;
			lastTime = now;
			if (passedTime < 0)
				passedTime = 0;
			if (passedTime > 100000000)
				passedTime = 100000000;

			unprocessedSeconds += passedTime / 1000000000.0;

			boolean ticked = false;
			while (unprocessedSeconds > secondsPerTick) {
				tick();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;

				tickCount++;
				if (tickCount % 60 == 0) {
					fps = "" + frames;
					lastTime += 1000;
					frames = 0;
				}
			}

			if (ticked) {
				render();
				frames++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void tick() {
		Screen.tick();
	}
	
	public void render() {
		Graphics g = canvas.getGraphics();
		
		if (!setup) {
			setupCanvas();
		}

		Screen.render(g);
		
		g = getGraphics();
		
		g.drawImage(canvas, 0, 0, size.width, size.height, 0, 0, sized.width, sized.height, null);
	}
	
	public void setupCanvas() {
		Bitmap.fill();
		
		errPrint("Canvas Setup", Debug.INFO);
		setup = true;
	}
	
	public static void main(String[] args) {
		// Toolkit t = Toolkit.getDefaultToolkit();
		// Dimension ss = t.getScreenSize();
		JFrame frame = new JFrame("3D Test"); 
		Core core = new Core();
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setLocation((ss.width / 2) - (size.width / 2), (ss.height / 2) - (size.height / 2));
		frame.setLocation(16, 16);
		frame.add(core);
		frame.setVisible(true);
		frame.pack();
		
		core.start();
	}
	
	public static void errPrint(String msg, Debug err) {
		switch(err) {
		case INFO: 
			msg = "[INFO] " + msg;
			break;
		case WARNING:
			msg = "[WARNING] " + msg;
			break;
		case SEVERE:
			msg = "[SEVERE] " + msg; 
			break;
		}
		
		System.out.println(msg);
	}
	
	public enum Debug {
		INFO, WARNING, SEVERE;
	}
}
