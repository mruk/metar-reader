package mruk.metarreader;

/**
 * Decoded METAR JSON container
 *
 */
public class DecodedMetar {

	private DatagramAirport dataAirport;
	private DatagramTime dataTime;
	private DatagramTemperature dataTemp;
	private DatagramWind dataWind;

	private String reportType;

	public DecodedMetar() {
		dataAirport = new DatagramAirport();
		dataTime = new DatagramTime();
		dataTemp = new DatagramTemperature();
		dataWind = new DatagramWind();
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

	public DatagramTemperature getTemp() {
		return dataTemp;
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

	public DatagramWind getWind() {
		return dataWind;
	}

	public void setWind(DatagramWind dataWind) {
		this.dataWind = dataWind;
	}
}
