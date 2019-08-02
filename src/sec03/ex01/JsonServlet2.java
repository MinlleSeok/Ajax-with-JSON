package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 배열을 저장할 JSONObject 객체 생성
		JSONObject totalObject = new JSONObject();
		
		// HashMap의 구조와 같은 JSONObject 객체들을 저장할 JSONArray 객체 배열 생성
		JSONArray membersArray = new JSONArray();
		
		// 회원 한 명의 정보가 들어갈 JSONObject 객체 생성
		JSONObject memberInfo = new JSONObject();
		
		// 회원 한 명의 정보를 name <- key / value 쌍으로 저장합니다.
		memberInfo.put("name", "Jiseong박");
		memberInfo.put("age", 25);
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname","날쌘돌이");
		
		// 회원 한 명의 정보가 저장되어 있는 JSONObject 객체를? JSONArray 객체 배열에 추가하여 저장함
		membersArray.add(memberInfo);
		
		// 회원 한 명의 정보가 들어갈 JSONObject 객체 생성
		memberInfo = new JSONObject();
		
		// 회원 한 명의 정보를 name/value 쌍으로 저장합니다.
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		
		// 회원 한 명의 정보가 저장되어 있는 JSONObject 객체를? JSONArray 객체 배열에 저장합니다.
		membersArray.add(memberInfo);
		
		// 배열을 저장할 JSONObject 객체에 members라는 name으로 membersArray를 value로 저장합니다.
		totalObject.put("members", membersArray);
		
		// 배열에 저장된 JSONObject객체를 문자열 형태로 변환하여 저장
		String jsonInfo = totalObject.toJSONString();
		
		System.out.println(jsonInfo);
		
		/*
		  {
		  	"members": [
		  					{
		  						"gender":"남자",
		  						"name":"박지성",
		  						"nickname":"날센돌이",
		  						"age":"25"
		  					},
		  					{
		  						"gender":"여자",
		  						"name":"김연아",
		  						"nickname":"칼치",
		  						"age":"21"
		  					}
		  				]
		  	
		  }
		 */
		
		PrintWriter writer = response.getWriter();
		// 문자열 형태로 변환된 JSONObject 객체를 웹브라우저로 전송하여 응답합니다.
		writer.print(jsonInfo);
		
	} // doHandle()
} // class end
