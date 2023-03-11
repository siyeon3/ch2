package com.fastcampus.ch22;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoiltellerMVC6 {
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex,  BindingResult result ) {
    		System.out.println("result="+result);
    		FieldError error = result.getFieldError();
    	
    	System.out.println("code"+error.getCode());
    	System.out.println("field"+error.getField());
    	System.out.println("msg"+error.getDefaultMessage());
    		
    	ex.printStackTrace();
    	return "yoilError";
    }
	
	
	@RequestMapping("/getYoilMVC6") // http://localhost:/ch22/getYoilMVC6
	//public String main(@ModelAttribute("mydate") MyDate date, Model model) { 아래와 동일
	public String main( MyDate date, BindingResult result ) {
		System.out.println("result="+result);
			   
		
	if(!isValid(date)) 	
		return "yoilError";
   

    //    public static void main(String[] args) {
   // public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
        // 2. 처리
    		char yoil = getYoil(date);
    	// 3. 계산한 결과를 model에 저장
    		
    		//model.addAttribute("myDate", date);
    		//model.addAttribute("yoil", yoil);
    		
    		
    		
    		
    		
    		return "yoil"; // /web-INF/views/yoil.jsp

    }

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
		
	}


	private @ModelAttribute	("Yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}


	private boolean isValid(int year, int month, int day) {
		if(year==-1 || month==-1|| day==-1)
			return true;
	
		return (1<=month && month<=12) && (1<day && day<=31);
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return  " 일월화수목금토".charAt(dayOfWeek);
	}
}