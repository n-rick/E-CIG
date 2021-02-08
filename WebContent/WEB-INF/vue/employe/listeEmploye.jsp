<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="metier.Employe" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.Dao" %>
<jsp:useBean id="employe" class="metier.Employe" scope="session" />
<jsp:useBean id="employeSelec" class="metier.Employe" scope="request" />
<jsp:useBean id="message" class="java.lang.String" scope="request"/>
<% ArrayList<Employe> employes = (ArrayList<Employe>) request.getAttribute("employes"); %>

<% request.setAttribute("titre", "liste des employés");%> 

<!-- head bootstrap de la page -->
<%@ include file="/WEB-INF/include/head.jsp"%>

<!-- navbar bootstrap de la page -->
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<!--  Page liste des employés -->

<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!-- breadcrumb-->
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/index.jsp">Accueil</a></li>
						<li aria-current="page" class="breadcrumb-item active">Gestion
							des Employ&eacute;s</li>
					</ol>
				</nav>
			</div>
			<div class="col-lg-2">
				<!--
              *** Encadré du responsable ***
              _________________________________________________________
              -->
				<div class="card sidebar-menu mb-4">
					<div class="card-header">
						<h3 class="h4 card-title">Responsable</h3>
					</div>
					<div class="card-body">
						<ul class="nav nav-pills flex-column">
							<li><p class="text-info fw-bold text-uppercase"><%=employe.getNomEmploye() %></p></li>
							<li><p class="text-info fw-bold"><%=employe.getPrenomEmploye() %></p></li>
							<li><p class="text-info fw-bold"><%=employe.getDateNaissEmploye() %></p></li>
						</ul>
					</div>
				</div>
				<!-- *** Fin encadré du responsable ***-->
			</div>
			<div class="col-lg-10">
				<div id="contact" class="box rounded">
					<h1>Gestion des employés</h1>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="box rounded">
					<h3>
						Liste de l'ensemble des employ&eacute;s <a
							href="<%=request.getContextPath()%>/e-cig/creaEmp">
							<button type="button"
								class="btn btn-outline-primary navbar-toggler btn-lg">
								<span class="sr-only">cr&eacute;er</span> <i
									class="fa fa-user-plus"></i>Cr&eacute;er
							</button>
						</a>
					</h3>
					<hr>
					<!--  DEBUT FOMRULAIRE MODIFICATION D'UN EMPLOYE -->
					<div id="modif" class="collapse">
						<div class="container">

							<div class="box">
								<form role="modif" action="<%=request.getContextPath()%>/modif" method="post">
									<div class="form-group">
										<div class="row">
											<div class="col-md-4">
												<label for="idEmploye">Identifiant de l'employ&eacute;</label>
												<input id="idEmploye" class="form-control bg-secondary"
													type="text" name="refEmploye" value="<%=employeSelec.getIdEmploye()%>" disabled>
											</div>
											<div class="col-md-4 text-center d-flex align-items-md-center">
												<div
													class="custom-control custom-control-inline custom-radio">
													<input type="radio" class="custom-control-input"
														id="civRadioMonsieur" name="radioBtnEmploye"> <label
														class="custom-control-label" for="civRadioMonsieur">Monsieur</label>
												</div>
												<div
													class="custom-control custom-control-inline custom-radio">
													<input type="radio" class="custom-control-input"
														id="civRadioMadame" name="radioBtnEmploye"> <label
														class="custom-control-label" for="civRadioMadame" checked
														disabled>Madame</label>
												</div>
											</div>
										</div>

									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-md-4">
												<label for="nomEmploye">Nom</label> <input id="nomEmploye"
													class="form-control bg-secondary" type="text" name="nomEmploye"
													placeholder="nomEmploye" value="<%=employeSelec.getNomEmploye() %>" size="50" disabled>
											</div>
											<div class="col-md-4">
												<label for="prenomEmploye">Pr&eacute;nom usuel</label> <input
													id="prenom" class="form-control bg-secondary" type="text"
													name="prenomEmploye" placeholder="prénom" size="50" value="<%=employeSelec.getPrenomEmploye() %>"
													disabled>
											</div>
											<div class="col-md-3">
												<label for="ageEmploye">Date de naissance</label> <input
													id="ageEmploye" class="form-control bg-secondary" type="date" 
													name="ageEmploye" placeholder="date" value="<%=employeSelec.getNumTelEmploye() %>"
       												min="01/01/1970" max="31/12/2000" required pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" disabled>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-md-6">
												<label for="mail">Mail</label> <input id="mail"
													class="form-control" type="text" name="mailEmploye"
													placeholder="votremail@email.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" 
													size="60" value="<%= employeSelec.getEmailEmploye()%>">
											</div>
											<div class="col-md-3">
												<label for="tel">T&eacute;l&eacute;phone portable
												</label> <input id="tel" class="form-control" type="tel"
													name="portableEmploye" placeholder="06.12.23.34.45"
													value="<%=employeSelec.getNumTelEmploye() %>" pattern="[0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2}.[0-9]{2}">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-md-6">
												<label for="adrEmploye">Adresse</label> <input
													id="adrEmploye" class="form-control" type="text"
													name="adrEmploye" placeholder="Entrer votre adresse"
													value="<%=employeSelec.getAdressRueEmploye() %> " size="70">
											</div>
											<div class="col-md-2">
												<label for="cdpEmploye">Code postal</label> <input
													id="cdpEmploye" class="form-control" type="number"
													name="cdpEmploye" placeholder="13006" value="<%=employeSelec.getCdpEmploye()%>"
													size="5" min="01000" max="97400">
											</div>
											<div class="col-md-4">
												<label for="villeEmploye">Ville</label> <input
													id="villeEmploye" class="form-control" type="text"
													name="villeEmploye" placeholder="Marseille" size="60"
													value="<%=employeSelec.getNomVille() %> ">
											</div>

										</div>
									</div>
									<button data-bs-toggle="popover"
										title="Modification effectuée!"
										data-bs-content="La modification a bien été prise en compte. Merci."
										data-toggle="collapse" data-target="#modif" type="submit"
										formaction="<%=request.getContextPath() %>/admin/modif"
										class="btn btn-primary">Modifier</button>
								</form>
							</div>
						</div>

					</div>
				</div>
				<!--  DEBUT DE LA LISTE -->
				<form method="post" action="#">
					<input class="form-control" type="text"
						placeholder="Rechercher par ville">
					<table class="table table-hover table-striped table-dark">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">R&eacute;f.</th>
								<th scope="col">Nom</th>
								<th scope="col">Pr&eacute;nom</th>
								<th scope="col">Mail</th>
								<th scope="col">Ville</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
						<% for (Employe employ : employes) { %>
							<tr>
								<th scope="row"><input name="selectEmploye" type="radio"
									value="<%=employ.getIdEmploye() %>"></th>
								<td><%=employ.getRefEmploye()%></td>
								<td><%=employ.getNomEmploye()%></td>
								<td><%=employ.getPrenomEmploye() %></td>
								<td><%=employ.getEmailEmploye() %></td>
								<td><%=employ.getNomVille() %></td>
								<td>
									<div>
										<button type="submit" data-toggle="collapse"
											data-target="#modif" class="btn btn-info navbar-toggler"
											formaction="<%=request.getContextPath() %>/admin/affich">
											<span class="sr-only">modifier</span> <i
												class="fa fa-pencil-square-o"></i>
										</button>
										<button class="btn btn-danger navbar-toggler"
											data-bs-toggle="popover" title="Suppression effectuée!"
											data-bs-content="La suppression a bien été prise en compte. Merci."
											type="submit" id="btnSupp" formaction="<%=request.getContextPath() %>/admin/supp">
											<input name="selectEmploye" type="radio"
									value="<%=employ.getIdEmploye() %>">
											<span class="sr-only">supprimer</span> <i
												class="fa fa-user-times"></i>
										</button>
									</div>
								</td>
							</tr>
							<% } %>
							</tbody>
					</table>
				</form>
				<!--  FIN DE LISTE -->
			</div>
		</div>
		<!-- /.col-lg-9-->
	</div>
</div>
<!--  Footer de la page -->
<%@ include file="/WEB-INF/include/footer.jsp"%>