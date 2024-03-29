package sec03.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {

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
		
		// Ajax 기술로 전달된 JSON 데이터 형태의 문자열을 request객체의 getParameter()메소드를 이용해서 가져옴
		// bring JSON data string sent through Ajax using getParameter() method of request 
		String jsonInfo = request.getParameter("jsonInfo");
		
		try {
			// 참고 : JSONParser클래스는 JSON데이터 형태의 문자열을 파싱해서
			// JSONObject 객체로 변환하는 기능을 제공함.
			// 
			JSONParser jsonParser = new JSONParser();
			
			// parse(jsonInfo)메소드를 호출하면...
			// JSON 데이터형태의 문자열을 파싱해서 JSONObject 객체로 반환한다.
			// 참고 : JSONObject 객체 내부를 살펴보면... 
			// HashMap의 구조로 각 인덱스 위치에 key:value를 쌍으로 저장
			
			// JSONObject 객체 내부
			// {"gender":"남자","name":"박지성","nickname":"날쌘돌이","age":25 }
			JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonInfo);
			
			// JSONObject 객체 내부에 저장되어 있는 "남자", "박지성", "날쌘돌이", "25" 값 등을 추출해서 얻기
			System.out.println(jsonObject.get("name"));
			System.out.println(jsonObject.get("age"));
			System.out.println(jsonObject.get("gender"));
			System.out.println(jsonObject.get("nickname"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	} // doHandle()
} // class end
