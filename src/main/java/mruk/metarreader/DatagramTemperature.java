package mruk.metarreader;

/**
 * POJO for Temperature [C]
 *
 */
public class DatagramTemperature {
  private double AIR_TEMP;
  private double DEW_TEMP;

  public void setAirTemp(double temp) {
    this.AIR_TEMP = temp;
  }

  public void setDewTemp(double temp) {
    this.DEW_TEMP = temp;
  }

  public double getAirTemp() {
    return this.AIR_TEMP;
  }

  public double getDewTemp() {
    return this.DEW_TEMP;
  }
}
