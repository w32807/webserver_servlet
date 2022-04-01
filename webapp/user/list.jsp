<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="kr">
	<jsp:include page="../layout/layout_header.jsp"/><!-- 서블릿의 url을 기반으로 상대경로로 적어줘야 됨 -->
	<body>
		<jsp:include page="../layout/layout_nav.jsp"/>
		<jsp:include page="../layout/layout_subnav.jsp"/>
		<div class="container" id="main">
		   <div class="col-md-10 col-md-offset-1">
		      <div class="panel panel-default">
		          <table class="table table-hover">
		              <thead>
		                <tr>
		                    <th>#</th> <th>사용자 아이디</th> <th>이름</th> <th>이메일</th><th></th>
		                </tr>
		              </thead>
		              <tbody>
		                  <c:forEach items="${users}" var="user" varStatus="status">
		                      <tr>
		                          <th scope="row">${status.count}</th>
		                          <td>${user.userId}</td>
		                          <td>${user.name}</td>
		                          <td>${user.email}</td>
		                          <td><a href="/user/edit?userId=${user.userId}" class = "btn btn-success" role="button">수정</a></td>
		                      </tr>
		                  </c:forEach>
		              </tbody>
		          </table>
		        </div>
		    </div>
		</div>
		<jsp:include page="../layout/layout_script.jsp"/>
	</body>
</html>