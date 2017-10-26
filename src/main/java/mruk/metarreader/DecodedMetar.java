package mruk.metarreader;

/**
 * Decoded METAR JSON container
 *
 */
public class DecodedMetar {

	private DatagramAirport dataAirport;
	private DatagramTemperature dataTemp;
	private DatagramTime dataTime;

	private String reportType;

	public DecodedMetar() {
		dataAirport = new DatagramAirport();
		dataTime = new DatagramTime();
		dataTemp = new DatagramTemperature();
	}

	public void setReportType(String datagram) {
		reportType = datagram;
	}

	public void setAirport(DatagramAirport dataAirport) {
		this.dataAirport = dataAirport;
	}

	public DatagramTime getTime() {
		return dataTime;
	}

	public void setTime(DatagramTime dataTime) {
		this.dataTime = dataTime;
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

	public DatagramTemperature getTemp() {
		return dataTemp;
	}
}
