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
			
			$.ajax({
				type:"post",
				async:false,
				url:"<%=request.getContextPath()%>/json2",
				success:function(data,textStatus){
					
					// 서블릿으로부터 응답받은 문자열 형태의 JSONObject -> JSONObject 객체로 변환
					var jsonInfo = JSON.parse(data); // String -> JSONObject
					
					var memberInfo = "회원정보<br>";
					
					for(var i in jsonInfo.members) {
						
						memberInfo += "===========<br>";
						memberInfo += "이름 : " + jsonInfo.members[i].name + "<br>";
						memberInfo += "나이 : " + jsonInfo.members[i].age + "<br>";
						memberInfo += "성별 : " + jsonInfo.members[i].gender + "<br>";
						memberInfo += "별명 : " + jsonInfo.members[i].nickname + "<br><br><br>";
					}
					
					$("#output").html(memberInfo);
					
				}
			});
		
		});	// click()
	
	}); // $(function(){});

</script>

</head>
<body>
<!-- 북치기 -->
	<a id="checkJson" style="cursor: pointer;">회원정보 수신하기</a>
	<br><br>
	<div id="output"></div>
</body>
</html>