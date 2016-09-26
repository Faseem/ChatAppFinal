<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ param.success eq true}">
	<div class="alert alert-success">
		Successfully Registered
	</div>
</c:if>