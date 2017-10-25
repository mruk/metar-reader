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
	private static final String REG_TEMP_C = " (M)?(\\d\\d)\\/(M)?(\\d\\d) ";

	public static final Pattern PAT_DATAGRAM_TYPE = Pattern.compile(DatagramUtil.REG_DATAGRAM_TYPES);
	public static final Pattern PAT_AIRPORT_CODE = Pattern.compile(DatagramUtil.REG_AIRPORT_CODE);
	public static final Pattern PAT_TIME_UTC = Pattern.compile(DatagramUtil.REG_TIME_UTC);
	public static final Pattern PAT_TEMP_C = Pattern.compile(DatagramUtil.REG_TEMP_C);
}
