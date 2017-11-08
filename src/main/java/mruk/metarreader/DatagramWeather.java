package mruk.metarreader;

/**
 * POJO for Weather Phenomena
 *
 */
public class DatagramWeather {
  private String PHENOMENE;

  public void setOccurence(String str) {
      this.PHENOMENE = str;
  }

	public String getOccurence() {
		return this.PHENOMENE;
	}
}
