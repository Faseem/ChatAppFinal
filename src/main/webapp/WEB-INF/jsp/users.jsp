<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglibs.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$(".removeTrigger").click(function(e){
			e.preventDefault();
			$("#removeModal .btn-remove").attr("href",$(this).attr("href"));
			$("#removeModal").modal();
		});
	});
</script>

<table class="table table-striped table-bordered table-hover">
<thead>
	<td>
		User Name
	</td>
</thead>
<tbody>
	<c:forEach items="${users}" var="user">
	<tr>
		<td>
			<a href='<spring:url value="/users/${user.id}.html"/>'>
				<c:out value="${user.name}"></c:out>
			</a>
		</td>
		<td>
			<a href='<spring:url value="/users/remove/${user.id}.html"/>' class="btn btn-danger removeTrigger">
				Remove User
			</a>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>


<div class="modal fade" id="removeModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Remove User</h4>
			</div>
			<div class="modal-body">

				Are You Sure You Want to Remove the User.

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<a href="" class="btn btn-danger btn-remove">Remove</a>
			</div>
		</div>
	</div>
</div>