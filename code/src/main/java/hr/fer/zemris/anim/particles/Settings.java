package hr.fer.zemris.anim.particles;

public class Settings {
	
	public int doorWidth;
	public int doorHeight;
	
	public int screenWidth;
	public int screenHeight;
	
	public int initialNumOfDoors;
	
	public float minVelocity;
	public float maxVelocity;
	
	public int percent;
	
	public int fallenMax;
	
	public Settings() {
		// default values
		doorWidth = 20;
		doorHeight = 30;
		screenWidth = 720;
		screenHeight = 540;
		
		initialNumOfDoors = 5;
		fallenMax = 20;
		
		// difficulty settings impact the following
		minVelocity = 0.1f;
		maxVelocity = 3.0f;
		percent = 20;
	}

	public int getDoorWidth() {
		return doorWidth;
	}

	public void setDoorWidth(int doorWidth) {
		this.doorWidth = doorWidth;
	}

	public int getDoorHeight() {
		return doorHeight;
	}

	public void setDoorHeight(int doorHeight) {
		this.doorHeight = doorHeight;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public int getInitialNumOfDoors() {
		return initialNumOfDoors;
	}

	public void setInitialNumOfParticles(int initialNumOfDoors) {
		this.initialNumOfDoors = initialNumOfDoors;
	}

	public float getMinVelocity() {
		return minVelocity;
	}

	public void setMinVelocity(float minVelocity) {
		this.minVelocity = minVelocity;
	}

	public float getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(float maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getFallenMax() {
		return fallenMax;
	}

	public void setFallenMax(int fallenMax) {
		this.fallenMax = fallenMax;
	}
	
}
