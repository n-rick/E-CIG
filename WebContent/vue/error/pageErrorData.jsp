<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page isErrorPage="true" %>

<% request.setAttribute("titre", "Page d'erreur"); %>
    
<!-- head bootstrap de la page -->
<jsp:include page="/WEB-INF/include/head.jsp" />

 <!-- navbar bootstrap de la page -->
<jsp:include page="/WEB-INF/include/navbar.jsp" />

<section class="page-section clearfix">
	<div class="container">
		<%
				String message = null;
			if (request.getAttribute("message") != null) {
				message = (String) request.getAttribute("message");
			} %>

		<div class="intro-text left-0 text-center bg-faded p-5 rounded">
			<h2 class="section-heading mb-5">
				<span class="section-heading-upper">Erreur Interne ! </span>
				<span class="section-heading-lower">Exception : <%=exception %></span>
				<span class="section-heading-lower">ErrorData : <%=pageContext.getErrorData().getStatusCode() %></span>
				<span class="section-heading-lower">ErrorData : <%=pageContext.getErrorData().getRequestURI()  %></span>
				<span class="section-heading-lower">Veuillez retourner à l'accueil</span>
			</h2>
		</div>
	</div>


</section>

<!--  Footer de la page -->
<jsp:include page="/WEB-INF/include/footer.jsp" />