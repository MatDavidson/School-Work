package prob1;

public class Airport {

	private String code, city, state;
	private double latitude, longitude;
	
	public Airport(String code, double latitude, double longitude, String city, String state){
		this.code = code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}

	public Airport(String code){
		this.code = code;
	}
	
	public String getCode(){return code;}
	
	public double getLatitude(){return latitude;}
	
	public double getLongitude(){return longitude;}

	public String getCity(){return city;}
	public String getState(){return state;}

	@Override
	public boolean equals(Object o){
		if(o instanceof Airport){
			Airport a = (Airport)o;
			return this.getCode().equals(a.getCode());
		}
		return false;
	}
	
	@Override
	public String toString(){
		String msg = String.format("(%s-%s, %s: %5.1f, %5.1f)", code, city, state, latitude, longitude  );
		return msg;
	}
}
