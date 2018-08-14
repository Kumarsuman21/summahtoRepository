package com.weatherapplication;

public class Weather {
	private double min_temp;
	public Weather() {
		
	}
	public Weather(double min_temp, double max_temp, double humidity, double pressure) {
		super();
		this.min_temp = min_temp;
		this.max_temp = max_temp;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	private double max_temp;
	private double humidity;
	private double pressure;
	
	public void setMin_temp(double min_temp) {
		this.min_temp = min_temp;
	}
	public void setMax_temp(double max_temp) {
		this.max_temp = max_temp;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	public double getMin_temp() {
		return min_temp;
	}
	public double getMax_temp() {
		return max_temp;
	}
	public double getHumidity() {
		return humidity;
	}
	public double getPressure() {
		return pressure;
	}
}
