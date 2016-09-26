<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglibs.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$('.nav-tabs a:first').tab('show');
		$(".triggerremove").click(function(e){
			e.preventDefault();
			$("#removeModal .btn-remove").attr("href",$(this).attr("href"));
			$("#removeModal").modal();
		});
	});
</script>

<h1>${user.name}</h1>

<h3>${user.email}</h3>
<br />

<div>

	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs}" var="blog">
			<li><a href="#blog_${blog.id}" data-toggle="tab">${blog.name}</a>
			</li>
		</c:forEach>
	</ul>
	<!-- Nav tabs -->

	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs}" var="blog">
			<div class="tab-pane" id="blog_${blog.id}">
				<table class="table table-striped table-bordered table-hover">
					<tr>
						<td>${blog.name}</td>
						<td><a class="btn btn-danger triggerremove"
							href="<spring:url value="/blog/remove/${blog.id}.html"/>">Remove</a></td>
						<td>${blog.url}</td>
						<c:if test="${not empty blog.items}">
							<td>
								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<td>
											<th colspan="3" align="center">Items</th>
										</tr>
									</thead>
									<tbody>

										<tr>
											<th>Title</th>
											<th>Link</th>
											<th>PublishedDate</th>
										</tr>
										<c:forEach items="${blog.items}" var="item">
											<tr>
												<td>${item.title}</td>
												<td>${item.link}</td>
												<td>${item.publishedDate}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</td>
						</c:if>
					</tr>
				</table>
			</div>
		</c:forEach>
	</div>
</div>



<div class="modal fade" id="removeModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
			</div>
			<div class="modal-body">

				Are You Sure You Want to Remove the blog.

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<a href="" class="btn btn-danger btn-remove">Remove</a>
			</div>
		</div>
	</div>
</div>

