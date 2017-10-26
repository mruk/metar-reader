package mruk.metarreader;

import java.util.regex.Pattern;

/**
 * Util model class.
 *
 */

public class DatagramUtil {
	private static final String REG_DATAGRAM_TYPES = "(METAR)|(SA)|(SPECI)|(SP)";
	private static final String REG_AIRPORT_CODE = " [A-Z]{4} ";
	private static final String REG_TIME_UTC = "(\\d\\d)(\\d\\d)(\\d\\d)?Z";

	/**
	 * Temperature Match
	 * Group1: "M", indicates negative air.temp.
	 * Group2: \d{2}, air temp. [C]
	 * Group3: "M", indicates negative dev.temp.
	 * Group4: \d{2}, dev.temp. [C]
	 */
	private static final String REG_TEMP_C = "[^R](M)?(\\d{2})\\/(M)?(\\d{2})";
	public static final Pattern PAT_DATAGRAM_TYPE = Pattern.compile(DatagramUtil.REG_DATAGRAM_TYPES);
	public static final Pattern PAT_AIRPORT_CODE = Pattern.compile(DatagramUtil.REG_AIRPORT_CODE);
	public static final Pattern PAT_TIME_UTC = Pattern.compile(DatagramUtil.REG_TIME_UTC);
	public static final Pattern PAT_TEMP_C = Pattern.compile(DatagramUtil.REG_TEMP_C);
}
