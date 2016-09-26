<%@page import="com.fsm.app.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>WelCome</h1>



<table class="table table-striped table-bordered table-hover">
<tr>
<td align="center">Select User Below</td>
</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td class="btn-user" data-target="#myModal_${user.id}" data-toggle="modal" ><a href="/chat/${user.id}.html"> <c:out value="${user.name}"></c:out></a>	
			</td>
		</tr>
	</c:forEach>
</table>



<%-- <c:forEach items="${users}" var="user">
<!-- Modal -->
	<div class="modal fade" id="myModal_${user.id}" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel" align="center">Chat With User : ${user.name}</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name : </label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name"/>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Url : </label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
							<form:errors path="url"/>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<!-- <input type="submit" class="btn btn-primary" value="Save" /> -->
				</div>
			</div>
		</div>
	</div>
	</c:forEach> --%>