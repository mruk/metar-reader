package mruk.metarreader;

import java.util.regex.Matcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopController {

	private DecodedMetar datagram;

	/**
	 * Start point for TopData JSON configuration.
	 *
	 *
	 */
	@RequestMapping("/decode")
	public TopData topData(@RequestParam(value = "message", defaultValue = "empty") String message) {
		datagram = new DecodedMetar();
		datagramSetType(message);
		datagramSetAirport(message);
		datagramSetZuluTime(message);
		datagramSetTemp(message);
		datagramSetWind(message);
		datagramSetWeather(message);
		datagramSetPressure(message);

		TopData td = new TopData();
		td.setDatagram(datagram);
		return td;
	}

	private void datagramSetType(String message) {
		Matcher matcher = DatagramUtil.PAT_DATAGRAM_TYPE.matcher(message);
		String match = extracted(matcher);
		datagram.setReportType(match);
	}

	private void datagramSetAirport(String message) {
		Matcher matcher = DatagramUtil.PAT_AIRPORT_CODE.matcher(message);
		String match = extracted(matcher);
		datagram.getAirport().setIata(match);
	}

	private void datagramSetZuluTime(String message) {
		Matcher matcher = DatagramUtil.PAT_TIME_UTC.matcher(message);
		System.out.println(extracted(matcher));

		datagram.getTime().setDay(matcher.group(1));
		datagram.getTime().setHr(matcher.group(2));
		datagram.getTime().setMin(matcher.group(3));
		datagram.getTime().setUnix();
	}

	private void datagramSetTemp(String message) {
		Matcher matcher = DatagramUtil.PAT_TEMP_C.matcher(message);
		System.out.println(extracted(matcher));

		double airTemp = Double.parseDouble(matcher.group(2));
		double dewTemp = Double.parseDouble(matcher.group(4));

		if ("M".equals(matcher.group(1)))
			airTemp = -airTemp;
		if ("M".equals(matcher.group(3)))
			dewTemp = -dewTemp;

		datagram.getTemp().setAirTemp(airTemp);
		datagram.getTemp().setDewTemp(dewTemp);
	}

	private void datagramSetWind(String message) {
		Matcher matcher = DatagramUtil.PAT_WIND_GENERAL.matcher(message);
		System.out.println(extracted(matcher));

		// in METAR wind direction can be coded as:
		// \d{3}  - direction rounded to 10deg,
		// VRB		- variable direction.
		if (matcher.group(1).toString().equals("VRB")) {
			datagram.getWind().setVrb(true);
		} else {
			long windDir = Long.valueOf(matcher.group(1));
			datagram.getWind().setVrb(false);
			datagram.getWind().setDirection(windDir);
		}

		long windSpd = Long.valueOf(matcher.group(2));
		datagram.getWind().setSpeed(windSpd);

		if (matcher.group(3) != null) {
			long gust = Long.valueOf(matcher.group(5));
			datagram.getWind().setGust(gust);
		}
	}

	private void datagramSetWeather(String message){
		Matcher matcher = DatagramUtil.PAT_ATM_STATE.matcher(message);
		System.out.println(extracted(matcher));

		datagram.getWeather().setOccurence(extracted(matcher));
	}

	private void datagramSetPressure(String message) {
		Matcher matcher = DatagramUtil.PAT_QNH.matcher(message);
		System.out.println(extracted(matcher));
		if (matcher.group(1) != null) {
			long press = Long.valueOf(matcher.group(2));
			datagram.getPressure().setQnh(press);
		}
	}

	private String extracted(Matcher matcher) {
		if (matcher.find()) {
			return matcher.group().trim();
		} else {
			return "not reported";
		}
	}
}
