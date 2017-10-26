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
		String match = extracted(matcher);
		datagram.setZuluTime(match);
	}

	private void datagramSetTemp(String message) {
		Matcher matcher = DatagramUtil.PAT_TEMP_C.matcher(message);
		String match = extracted(matcher);

System.out.println(match);

		double airTemp = Double.parseDouble(matcher.group(2));
		double dewTemp = Double.parseDouble(matcher.group(4));

		if ("M".equals(matcher.group(1))) airTemp = -airTemp;
		if ("M".equals(matcher.group(3))) dewTemp = -dewTemp;

		datagram.getTemp().setAirTemp(airTemp);
		datagram.getTemp().setDewTemp(dewTemp);
	}

	private String extracted(Matcher matcher) {
		if (matcher.find()) {
			return matcher.group().trim();
		} else {
			return "not found";
		}
	}
}
