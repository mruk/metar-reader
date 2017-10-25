package mruk.metarreader;

/**
 * Decoded METAR JSON container
 *
 */
public class DecodedMetar {

	private String reportType;
	private String airport;
	private String zuluTime;
	private String temp;

	public DecodedMetar() {
	}

	public void setReportType(String datagram) {
		reportType = datagram;
	}

	public void setAirport(String str) {
		airport = str;
	}

	public void setZuluTime(String str) {
		zuluTime = str;
	}
	
	public void setTemp(String str) {
		temp = str;
	}

	public String getType() {
		return reportType;
	}

	public String getAirport() {
		return airport;
	}

	public String getUtc() {
		return zuluTime;
	}
	
	public String getTemp() {
		return temp;
	}
}
