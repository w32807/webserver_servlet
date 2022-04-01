<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="kr">
	<jsp:include page="../layout/layout_header.jsp"/><!-- 서블릿의 url을 기반으로 상대경로로 적어줘야 됨 -->
	<body>
		<jsp:include page="../layout/layout_nav.jsp"/>
		<jsp:include page="../layout/layout_subnav.jsp"/>
		<div class="container" id="main">
		   <div class="col-md-6 col-md-offset-3">
		      <div class="panel panel-default content-main">
		          <form name="question" method="post" action="/user/edit">
		              <div class="form-group">
		                  <label for="userId">사용자 아이디</label>
		                  <input class="form-control" id="userId" name="userId" placeholder="User ID" value="${user.userId }" readonly="readonly">
		              </div>
		              <div class="form-group">
		                  <label for="password">비밀번호</label>
		                  <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="${user.password }">
		              </div>
		              <div class="form-group">
		                  <label for="name">이름</label>
		                  <input class="form-control" id="name" name="name" placeholder="Name" value="${user.name }">
		              </div>
		              <div class="form-group">
		                  <label for="email">이메일</label>
		                  <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${user.email }">
		              </div>
		              <button type="submit" class="btn btn-success clearfix pull-right">수정</button>
		              <div class="clearfix" />
		          </form>
		        </div>
		    </div>
		</div>
		<jsp:include page="../layout/layout_script.jsp"/>
	</body>
</html>



