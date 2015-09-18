package feuchtwanger.physics;

public class ProjectileMain {
	public static void main(String[] args) {
		double angle = 31.0;
		int velocity = 20;
		double seconds = 0.0;

		Projectile p = new Projectile(angle, seconds, velocity);
		
		for (double i = 0.0; i <= 3.0; i += 0.1) {
			System.out.println("X = " + p.getX());
			System.out.println("Y = " + p.getY());
			p.setTime();
		}
	}

}
