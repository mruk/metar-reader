package mruk.metarreader;

/**
 * POJO for Airport
 *
 */
public class DatagramAirport {
  // four letter Location Indicator
  private String ICAO;
  private String IATA;
  private String FULL_NAME;
  private double LAT;
  private double LON;
  private long AMSL;

  public String getIcao() {
    return this.ICAO;
  }

  public String getIata() {
    return this.IATA;
  }

  public String getFullName() {
    return this.FULL_NAME;
  }

  public double getLat() {
    return this.LAT;
  }

  public double getLon() {
    return this.LON;
  }

  public long getAmsl() {
    return this.AMSL;
  }

  public void setIcao(String str) {
    this.ICAO = str;
  }

  public void setIata(String str) {
    this.IATA = str;
  }

  public void setFullName(String str) {
    this.FULL_NAME = str;
  }

  public void setLat(double val) {
    this.LAT = val;
  }

  public void setLon(double val) {
    this.LON = val;
  }

  public void setAmsl(long val) {
    this.AMSL = val;
  }
}
