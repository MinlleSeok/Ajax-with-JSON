<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- import Jquery -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	$(function(){
		// id 속성값이 checkJson 태그를 선택해 클릭했을 때...
		// when clicking tag have id="checkJson"
		$("#checkJson").click(function(){
			// 서블릿으로 전송할 회원정보를 JSON데이터 형식의 문자열을 만들어서 저장
			// save JSON data type String for sending to Servlet
			var _jsonInfo = '{"name":"박지성","age":"25","gender":"남자","nickname":"날쌘돌이"}';
			
			$.ajax(
					{
						type:"post",
						url:"<%=request.getContextPath()%>/json",
						async:false,
						data:{jsonInfo:_jsonInfo}, 
						// 매개변수 이름 jsonInfo로 JSON 데이터 형식의 문자열을 ajax기술로 전송함
						// send variable "jsonInfo" through ajax
						success:function(data,textStatus){
							
						},
						error:function(){
							alert("통신에러가 발생했습니다.");
						},
						complete:function(){
							alert("정상적인 통신");
						}
						
					}
				);
		
		});	
	
	});

</script>

</head>
<body>
<!-- 북치기 -->
	<a id="checkJson" style="cursor: pointer;">Submit</a>
</body>
</html>