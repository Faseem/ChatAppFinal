<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglibs.jsp"%>

<form:form commandName="user" cssClass="form-horizontal form-Register">
<c:if test="${ param.success eq true}">
	<div class="alert alert-success">
		Successfully Registered
	</div>
</c:if>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name : </label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control"/>
			<form:errors path="name"/>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email : </label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control"/>
			<form:errors path="email"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password : </label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control"/>
			<form:errors path="password"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password_again" class="col-sm-2 control-label">Password-Again : </label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<input type="submit" value="SAVE" class="btn btn-g btn-primary"/>
	</div>

</form:form>


<script type="text/javascript">
	$(document).ready(function(){
		$(".form-Register").validate({
			rules:{
				name:{
					required:true,
					minlength:3,
					remote : {
						url : "<spring:url value='/register/available.html' />",
						type : "get",
						data : {
							username : function(){
									return $("#name").val();
								}
							}
						}
				},
				email:{
					required:true,
					email:true
				},
				password:{
					required:true,
					minlength : 3				
				},
				password_again:{
					required : true,
					minlength : 3,
					equalTo: "#password"
				}
			},
			highlight: function (element) {
		        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		    },
		    unhighlight: function (element) {
		        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
		    },
		    messages:{
		    	name : {
		    		remote : "Such name already exists !!!"
		    	}
		    }
		});
	});
</script>