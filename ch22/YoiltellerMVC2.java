package com.fastcampus.ch22;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoiltellerMVC2 {
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex) {
    	ex.printStackTrace();
    	return "yoilError";
    }
	
	
	@RequestMapping("/getYoilMVC2") // http://localhost:/ch22/getYoilMVC?year=2021&month=10&day=1
    public String main(@RequestParam(required=true) int year, //throws IOException {
	@RequestParam(required=true) int month,
	@RequestParam(required=true) int day, Model model) {
	
    	if(!isValid(year, month, day))
		return "yoilError";
   

    //    public static void main(String[] args) {
   // public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        // 2. 처리
    		char yoil = getYoil(year, month, day);
    	// 3. 계산한 결과를 model에 저장
    		model.addAttribute("year", year);
    		model.addAttribute("month", month);
    		model.addAttribute("day", day);
    		model.addAttribute("yoil", yoil);
    		
    		
    		
    		
    		
    		return "yoil"; // /web-INF/views/yoil.jsp

    }

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return  " 일월화수목금토".charAt(dayOfWeek);
	}
}