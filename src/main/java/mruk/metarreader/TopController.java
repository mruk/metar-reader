package mruk.metarreader;

import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public TopData topData(@RequestParam(value="message", defaultValue="empty") String message) {
      datagram = new DecodedMetar();
      datagramSetType(message);
      datagramSetAirport(message);

      TopData td = new TopData();
      td.setDatagram(datagram);
      return td;
    }

    private void datagramSetType(String message) {
      Pattern pattern = Pattern.compile(DatagramUtil.REG_DATAGRAM_TYPES);
      Matcher matcher = pattern.matcher(message);

      if (matcher.find()) {
        datagram.setReportType(matcher.group());
      } else {
        datagram.setReportType("not found");
      }
    }

    private void datagramSetAirport(String message) {
      Pattern pattern = Pattern.compile(DatagramUtil.REG_AIRPORT_TYPES);
      Matcher matcher = pattern.matcher(message);

      if (matcher.find()) {
        datagram.setAirport(matcher.group());
      } else {
        datagram.setAirport("not found");
      }
    }
}
