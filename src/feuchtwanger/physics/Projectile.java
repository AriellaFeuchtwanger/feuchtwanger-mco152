package feuchtwanger.physics;

public class Projectile {

	private double angle;
	private double time;
	private double velocity;
	private double radians;

	public Projectile(double angle, double velocity, double seconds) {
		this.angle = angle;
		radians = Math.toRadians(angle);
		this.time = seconds;
		this.velocity = velocity;
	}

	public double getX() {
		return ((Math.sin(radians)) * velocity * time);
	}

	public double getY() {
		return ((Math.cos(radians)) * velocity * time - (0.5 * 9.8 * time * time));
	}
	
	public void setTime(){
		time += 0.1;
	}
}
