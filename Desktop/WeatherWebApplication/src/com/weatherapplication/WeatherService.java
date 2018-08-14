package com.weatherapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherService {
    private static final String apiKey="6fac6641c11bcec1b586e57ba86112a1";//change this with yours
    private static final String baseBaiduUrl=
        "http://api.openweathermap.org/data/2.5/forecast?q=Hyderabad, IN&units=metric&APPID="+apiKey;//The constant url should be 
    
    public static Weather getWeatherInfo()
    {
        String jsonResult=getWeatherJsonString();
        Weather weather = new Weather();
        System.out.println(jsonResult);
        try {

			JSONObject obj = new JSONObject(jsonResult);
			JSONArray ja = (JSONArray) obj.get("list");
			JSONObject obj2 = ja.getJSONObject(0);
			JSONObject obj3 = (JSONObject) obj2.get("main");
			double temp_min = obj3.getDouble("temp_min");
			double temp_max = obj3.getDouble("temp_max");
			double pressure = obj3.getDouble("pressure");
			double humidity = obj3.getDouble("humidity");
			
			weather.setMin_temp(temp_min);
			weather.setMax_temp(temp_max);
			weather.setHumidity(humidity);
			weather.setPressure(pressure);
	         
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return weather;
    }
    
    private static String getWeatherJsonString() throws RuntimeException{  
        
        String baiduUrl = baseBaiduUrl;

        StringBuilder strBuf = new StringBuilder();  
        
        HttpURLConnection conn=null;
        BufferedReader reader=null;
        try{  
            URL url = new URL(baiduUrl);  
            conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("apikey",apiKey);
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                              + conn.getResponseCode());
            }
            
	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String output = null;  
            while ((output = reader.readLine()) != null)  
                strBuf.append(output);  
        }catch(MalformedURLException e) {  
            e.printStackTrace();   
        }catch(IOException e){  
            e.printStackTrace();   
        }
        finally
        {
            if(reader!=null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
            {
                conn.disconnect();
            }
        }

        return strBuf.toString();  
    }
}