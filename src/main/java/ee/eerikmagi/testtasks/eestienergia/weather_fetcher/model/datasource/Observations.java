package ee.eerikmagi.testtasks.eestienergia.weather_fetcher.model.datasource;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="observations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Observations {
	@XmlElement(name="station")
	private List<Station> stations;
	@XmlAttribute(name="timestamp")
	private int timestamp;
	
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
}
