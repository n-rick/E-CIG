<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<% request.setAttribute("titre", "Erreur 404"); %>
    
<!-- head bootstrap de la page -->
<jsp:include page="../../include/head.jsp" />

 <!-- navbar bootstrap de la page -->
<jsp:include page="../../include/navbar.jsp" />

<section class="page-section clearfix">
	<div class="container">
		<%
				String message = null;
			if (request.getAttribute("message") != null) {
				message = (String) request.getAttribute("message");
			} %>

		<div class="intro-text left-0 text-center bg-faded p-5 rounded bg-danger text-white">
			<h2 class="section-heading mb-5">
				<span class="section-heading-upper">Oups ! </span> <span
					class="section-heading-lower"> <%=message %>
				</span>
			</h2>
		</div>
	</div>


</section>

<!--  Footer de la page -->
<jsp:include page="../../include/footer.jsp" />