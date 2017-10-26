package mruk.metarreader;

/**
 * Decoded METAR JSON container
 *
 */
public class DecodedMetar {

  private DatagramAirport dataAirport;
  private DatagramTemperature dataTemp;
  //private DatagramTime dataTime;

	private String reportType;
	private String zuluTime;
	private String temp;

	public DecodedMetar() {
    dataAirport = new DatagramAirport();
    dataTemp = new DatagramTemperature();
	}

	public void setReportType(String datagram) {
		reportType = datagram;
	}

  public void setAirport(DatagramAirport dataAirport) {
    this.dataAirport = dataAirport;
  }

	public void setZuluTime(String str) {
		zuluTime = str;
	}

	public void setTemp(DatagramTemperature dataTemp) {
		this.dataTemp = dataTemp;
	}

	public String getType() {
		return reportType;
	}

  public DatagramAirport getAirport() {
    return dataAirport;
  }

	public String getUtc() {
		return zuluTime;
	}

	public DatagramTemperature getTemp() {
		return dataTemp;
	}
}
