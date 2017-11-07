package mruk.metarreader;

/**
 * POJO for Wind
 *
 */
public class DatagramWind {
	private double WIND_DIR;
	private double WIND_SPD;

	public void setDirection(double dir) {
		this.WIND_DIR = dir;
	}

	public void setSpeed(double spd) {
		this.WIND_SPD = spd;
	}

	public double getDirection() {
		return this.WIND_DIR;
	}

	public double getSpeed() {
		return this.WIND_SPD;
	}
}
