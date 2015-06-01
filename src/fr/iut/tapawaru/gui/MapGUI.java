package fr.iut.tapawaru.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapGUI extends JPanel {

	private static final int DEFAULT_MAP_SIZE = 50;
	private Image floor;
	private Image wall;
	private Image target;
	private Image block;
	private Image player;

	public MapGUI() {
		try {
			this.wall = ImageIO.read(new File("img/wall.png"));
			this.floor = ImageIO.read(new File("img/floor.png"));
			this.target = ImageIO.read(new File("img/target2.png"));
			this.block = ImageIO.read(new File("img/block.png"));
			this.player = ImageIO.read(new File("img/player.png"));
			
			//this.setSize(300, 300);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void paintComponent(Graphics g) {
		for (int width = 0; width < 8; width++) {
			for (int height = 0; height < 8; height++) {

				g.drawImage(floor, width * DEFAULT_MAP_SIZE, height
						* DEFAULT_MAP_SIZE, this);

			}

		}
	}
}
