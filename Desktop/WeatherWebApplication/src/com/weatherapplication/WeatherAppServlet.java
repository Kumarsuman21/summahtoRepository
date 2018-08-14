package com.weatherapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WeatherWebApp")
public class WeatherAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WeatherAppServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		Weather wheatherInfoObject=WeatherService.getWeatherInfo();
		if(wheatherInfoObject!=null){
		      StringBuilder outputContent=new StringBuilder();//Unless the need of thread-safe,
		      outputContent.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Insert title here</title></head><body><form action=\"weather\" method=\"GET\"><select name=\"city\"><option value =\"beijing\">北京</option> <option value =\"shanghai\">上海</option><option value =\"xian\">西安</option></select><input type=\"submit\" value=\"Submit\"></form>");
		      outputContent.append("Min Temperature : "+wheatherInfoObject.getMin_temp());
		      outputContent.append("<br/>");
		      outputContent.append("Max Temperature : " + wheatherInfoObject.getMax_temp());
//		      outputContent.append("℃");
		      outputContent.append("<br/>");
		      outputContent.append("Humidity : " + wheatherInfoObject.getHumidity());
		      outputContent.append("<br/>");
		      outputContent.append("Pressure : "+wheatherInfoObject.getPressure());
		      outputContent.append("</body></html>");
		      
		      response.setContentType("text/html; charset=utf-8");
		      response.getWriter().write(outputContent.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
