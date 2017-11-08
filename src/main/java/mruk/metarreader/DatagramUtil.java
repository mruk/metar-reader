package mruk.metarreader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * Util model class.
 * REGEXes based on: http://awiacja.imgw.pl/index.php?product=metar-opis
 */

public class DatagramUtil {
	private static final String REG_DATAGRAM_TYPES = "(METAR)|(SA)|(SPECI)|(SP)";
	private static final String REG_AIRPORT_CODE = " [A-Z]{4} ";

	/**
	 * Zulu Time Match
	 * Group1: day of month,
	 * Group2: hour of day [UTC],
	 * Group3: minute of hour.
	 */
	private static final String REG_TIME_UTC = "(\\d\\d)(\\d\\d)(\\d\\d)?Z";

	/**
	 * Temperature Match
	 * Group1: "M", indicates negative air.temp.
	 * Group2: \d{2}, air temp. [C]
	 * Group3: "M", indicates negative dev.temp.
	 * Group4: \d{2}, dev.temp. [C]
	 */
	private static final String REG_TEMP_C = "[^R](M)?(\\d{2})\\/(M)?(\\d{2})";

	/**
	 * Wind General Match
	 * Group1: VRB \d{3}, wind direction, 10deg granularity OR direction is VAR,
	 * Group2: \d{2}, wind speed, knots.
	 * Group4: G		, optional GUST indicator,
	 * Group5: \d{2}, GUST speed, knots.
	 */
	private static final String REG_WIND_GENERAL = "(VRB|\\d{3})(\\d{2})((G)(\\d{2}))?KT";

	private static final String REG_ATM_STATE = " (-|[+])?(DZ|RA|SN|SG|PL|GR|GS|UP|BR|FG|FU|VA|DU|SA|HZ|PO|SQ|FC|SS|DS|MI|BC|PR|DR|BL|SH|TS|FZ|NSW)(DZ|RA|SN|SG|PL|GR|GS|UP|BR|FG|FU|VA|DU|SA|HZ|PO|SQ|FC|SS|DS|MI|BC|PR|DR|BL|SH|TS|FZ)? ";

	/**
	 * Wind General Match
	 * Group1: Q, pressure indicator,
	 * Group2: \d{4}, pressure hPa.
	 */
	private static final String REG_QNH = "(Q)(\\d{4})";

	public static final Pattern PAT_DATAGRAM_TYPE = Pattern.compile(DatagramUtil.REG_DATAGRAM_TYPES);
	public static final Pattern PAT_AIRPORT_CODE = Pattern.compile(DatagramUtil.REG_AIRPORT_CODE);
	public static final Pattern PAT_TIME_UTC = Pattern.compile(DatagramUtil.REG_TIME_UTC);
	public static final Pattern PAT_TEMP_C = Pattern.compile(DatagramUtil.REG_TEMP_C);
	public static final Pattern PAT_WIND_GENERAL = Pattern.compile(DatagramUtil.REG_WIND_GENERAL);
	public static final Pattern PAT_ATM_STATE = Pattern.compile(DatagramUtil.REG_ATM_STATE);
	public static final Pattern PAT_QNH = Pattern.compile(DatagramUtil.REG_QNH);

	public static long getUnix(int day, int hr, int min){
		TimeZone tz = TimeZone.getTimeZone("UTC");
	    Calendar cal = Calendar.getInstance(tz);
	    cal.set(Calendar.DAY_OF_MONTH, day);
	    cal.set(Calendar.HOUR_OF_DAY, hr);
	    cal.set(Calendar.MINUTE, min);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);

	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    simpleDateFormat.setTimeZone(tz);
	    System.out.println(simpleDateFormat.format(cal.getTime()));

		return cal.getTimeInMillis();
	}
}
