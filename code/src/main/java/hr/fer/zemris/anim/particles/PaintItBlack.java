package hr.fer.zemris.anim.particles;

import processing.core.*;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class PaintItBlack extends PApplet {
	
	public static Settings settings;
	
	public static boolean clicked = false;

	/** sustav čestica */
	DoorSystem system;
	
	/** broja palih vratiju */ 
	int currentFallenTotal = 0;
	
	/** broj crvenih */
	int redTotal = 0;
	
	/** broj crnih */
	int blackTotal = 0;
	
	/** ukupno u igri */
	int doorsTotal = 0;
	
	/** jesu li vrata pala (dosegla dno) **/
	boolean fallen = false;

	/** mijenja metodu setup alata Processing */
	public void settings() {
		system = new DoorSystem();
		system.initialize();
		size(settings.getScreenWidth(), settings.getScreenHeight());
	}
	
	/** metoda koja pokreće crtanje */
	public void draw() {
		background(Math.max(200 - blackTotal * 5, 20));
		system.run();
		
		if (random(0,100) < settings.getPercent()) {
			system.addDoor(new PVector(random (0, settings.getScreenWidth()), 0));
		}
		
	}
	
	/** detekcija klika mišem */
	public void mousePressed() {
		clicked = true;
	}

	/** modeliranje vratiju */
	class Door {

		/** pozicija */
		PVector position;
		
		/** brzina */ 
		PVector velocity;
		
		/** akceleracija */
		PVector acceleration;
		
		/** intenzitet crvene boje u rgb sustavu*/
		int red;
		
		/** čestica */
		Door(PVector l) {
			acceleration = new PVector(0, 0.00981f);
			velocity = new PVector(0, random(settings.getMinVelocity(), settings.getMaxVelocity()));
			position = l.copy();
			red = 200;
		}
	
		/** korak u prikazu */ 
		public void update() {
			
			if (position.y + settings.getDoorHeight() / 2 > height) {
				fallen = true;
				
				if (currentFallenTotal > settings.getFallenMax()-1) {
					
					SwingUtilities.invokeLater(() -> {
						new ResultsGUI(redTotal, blackTotal).setVisible(true);
						dispose();
					});
					
				}
			} else {
				velocity.add(acceleration);
				position.add(velocity);
			}
			
			// vrata
			fill(red,0,0);
			rectMode(CENTER);
			rect(position.x, position.y, settings.getDoorWidth(), settings.getDoorHeight());
		}
		
		/** jesu li vrata pala na dno */ 
		public boolean hasFallen() {
			return fallen;
		}
	}

	/** sustav */ 
	class DoorSystem {
		
		/** sva vrata */
		ArrayList<Door> doors;
		
		/** izvor u prostoru */
		PVector origin;
	
		/** konstruktor */ 
		DoorSystem() {
		}
		
		/** inicijalizacija */ 
		public void initialize() {
			doors = new ArrayList<Door>();
			
			int screenWidth = settings.getScreenWidth();
			int numOfParticles = settings.getInitialNumOfDoors();
			int doorWidth = settings.getDoorWidth();
			
			int k = screenWidth / (numOfParticles);
			
			for (int i = 0; i < numOfParticles; i++) {
				addDoor(new PVector(i*k+doorWidth, 0));
			}
			
		}
	
		/** dodavanje vratiju */ 
		public void addDoor(PVector origin) {
			doors.add(new Door(origin));
			redTotal++;
			doorsTotal++;
		}
	
		/** pokretanje čitavog sustava */ 
		public void run() {
			
			int w = settings.getDoorWidth();
			int h = settings.getDoorHeight();
			currentFallenTotal = 0;
			
			for (Door d : doors) {
				
				if (PaintItBlack.clicked) {
					
					if (Math.abs(d.position.x - mouseX) * 2 < w && Math.abs(d.position.y - mouseY) * 2 < h) {
						d.red = 0;
						blackTotal++;
						redTotal--;
					}			
				}
				
				if (d.hasFallen()) {
					currentFallenTotal++;
				}
				
				d.update();
			}
			
			clicked = false;
			
		}
	}

	/** glavni program */ 
	public static void main(String[] args) {
		
		settings = new Settings();
		
		SwingUtilities.invokeLater(() -> {
			new SettingsGUI().setVisible(true);
		});
		
	}
}
