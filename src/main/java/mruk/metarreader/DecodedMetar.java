package mruk.metarreader;

/**
 * Decoded METAR JSON container
 *
 */
public class DecodedMetar {

  private String reportType;
  private String airport;

  public DecodedMetar() {
  }

  public void setReportType(String datagram) {
    reportType = datagram;
  }

  public void setAirport(String str) {
    airport = str;
  }

  public String getType() {
    return reportType;
  }

  public String getAirport() {
    return airport;
  }
}
