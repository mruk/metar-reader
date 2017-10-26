/**
 * 
 */
package mruk.metarreader;

/**
 * @author Konrad
 *
 */
public class DatagramTime {

	private int day;
	private int hr;
	private int min;
	private long unix;

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}
	
	public void setHr(String hr) {
		this.hr = Integer.parseInt(hr);
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public void setMin(String min) {
		this.min = Integer.parseInt(min);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void setDay(String day) {
		this.day = Integer.parseInt(day);
	}
	
	public long getUnix() {
		return unix;
	}

	public void setUnix() {
		this.unix = DatagramUtil.getUnix(day, hr, min) / 1000l;
	}
}
