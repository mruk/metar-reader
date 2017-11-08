package mruk.metarreader;

/**
 * POJO for Wind
 *
 */
public class DatagramWind {
  private Boolean WIND_VRB;
	private long WIND_DIR;
	private long WIND_SPD;
  private long WIND_GUST;

  public void setVrb(Boolean vrb) {
      this.WIND_VRB = vrb;
      //this.WIND_SPD = new Double(null);
  }

	public void setDirection(long dir) {
		this.WIND_DIR = dir;
	}

	public void setSpeed(long spd) {
		this.WIND_SPD = spd;
	}

  public void setGust(long gust) {
    this.WIND_GUST = gust;
  }

  public Boolean getVrb(){
    return WIND_VRB;
  }

	public long getDirection() {
		return this.WIND_DIR;
	}

	public long getSpeed() {
		return this.WIND_SPD;
	}

  public long getGust() {
    return this.WIND_GUST;
  }
}
