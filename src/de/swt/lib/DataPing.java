package de.swt.lib;

import java.util.Date;

public class DataPing {
	private String IPv4;
	private Long latenz;
	private Date timeStamp;

	public String getIPv4() {
		return IPv4;
	}

	public void setIPv4(String iPv4) {
		IPv4 = iPv4;
	}

	public Long getLatenz() {
		return latenz;
	}

	public void setLatenz(Long latenz) {
		this.latenz = latenz;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
