package getlandestate.pojos.advert_controller;

import java.io.Serializable;

public class AdvertsCitiesLimitPojo implements Serializable {
	private int cityId;
	private String cityName;
	private int cityQuantity;


	public AdvertsCitiesLimitPojo(){}

	public AdvertsCitiesLimitPojo(int cityId, String cityName, int cityQuantity){
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityQuantity = cityQuantity;
	}

	public void setCityId(int cityId){
		this.cityId = cityId;
	}

	public int getCityId(){
		return cityId;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}

	public String getCityName(){
		return cityName;
	}

	public void setCityQuantity(int cityQuantity){
		this.cityQuantity = cityQuantity;
	}

	public int getCityQuantity(){
		return cityQuantity;
	}

	@Override
	public String toString() {
		return "AdvertsCitiesLimitPojo{" +
				"cityId=" + cityId +
				", cityName='" + cityName + '\'' +
				", cityQuantity=" + cityQuantity +
				'}';
	}
}