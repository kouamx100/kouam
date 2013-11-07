<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
  String etat = (String)request.getAttribute("etat");
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>formulaire des etudiants</title>
<link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="default" />

</head>
<body> 
<!-- Start: page-top-outer -->
<div id="page-top-outer">    

<!-- Start: page-top -->
<div id="page-top">

	<!-- start logo -->
	<div id="logo">
	<a href=""><img src="images/shared/logo.png" width="156" height="40" alt="" /></a>
	</div>
	<!-- end logo -->
	
	<!--  start top-search -->
	<div id="top-search">
	<h1 id="kouam">Facscience Request</h1>
	<img src="images/logouniv.jpg" width="70" height="85"  />
 	<!--  end top-search -->
 	<div class="clear"></div>

</div>
<!-- End: page-top -->

</div>
<!-- End: page-top-outer -->
	
<div class="clear">&nbsp;</div>
 
<!--  start nav-outer-repeat................................................................................................. START -->
<div class="nav-outer-repeat"> 
<!--  start nav-outer -->
<div class="nav-outer"> 

		<!-- start nav-right -->
		<div id="nav-right">
		
			<div class="nav-divider">&nbsp;</div>
			<div class="showhide-account"><img src="images/shared/nav/nav_myaccount.gif" width="93" height="14" alt="" /></div>
			<div class="nav-divider">&nbsp;</div><form action="Deconnection" name="Deconnection">
			<a href="Deconnection" id="logout"><img src="images/shared/nav/nav_logout.gif" width="64" height="14" alt="" /></a>
			   </form>
			<div class="clear">&nbsp;</div>
		
			<!--  start account-content -->	
			<div class="account-content">
			<div class="account-drop-inner">
				<a href="" id="acc-settings">configurations</a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="" id="acc-details">mot de passe</a>
				<div class="clear">&nbsp;</div>
				<div class="acc-line">&nbsp;</div>
				<a href="" id="acc-project">Statistiques</a>
				<div class="clear">&nbsp;</div>
			</div>
			</div>
			<!--  end account-content -->
		
		</div>
		<!-- end nav-right -->


		<!--  start nav -->
<div class="nav">
		<div class="table">
		
		<ul class="select"><li><a href="Requette"><b>Requettes </b></a>
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		                    
		<ul class="select"><li><a href="GestionChoix"><b>notes</b></a>
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		                    
		<ul class="select"><li><a href="formEnseignant.jsp"><b>enseignants</b></a>
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		                    
		<ul class="select"><li><a href="formFiliere.jsp"><b>filieres</b></a>
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		
		<ul class="select"><li><a href="formEtudiant.jsp"><b>etudiants</b></a>
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		
		<ul class="select"><li><a href="formMatiere.jsp"><b>matieres</b></a>
		</li>
		</ul>
		<div class="nav-divider">&nbsp;</div>
		
		<ul class="select"><li><a href="text.jsp"><b>home</b></a>
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		
		<ul class="select"><li><a href="text.jsp"><b>home</b></a>
		</li>
		</ul>
		
		
		<div class="clear"></div>
		</div>
		<div class="clear"></div>
		</div>
		<!--  start nav -->

</div>
<div class="clear"></div>
<!--  start nav-outer -->
</div>
<!--  start nav-outer-repeat................................................... END -->
 
 <div class="clear"></div>
 
<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>ajouter un etudiant
<font color="green"> <% 
if("ok".equals(etat)){
	out.println("   insertion reussie ");
}
%></font>
</h1></div>


<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
<tr>
	<th rowspan="3" class="sized"><img src="images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
	<th class="topleft"></th>
	<td id="tbl-border-top">&nbsp;</td>
	<th class="topright"></th>
	<th rowspan="3" class="sized"><img src="images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
</tr>
<tr>
	<td id="tbl-border-left"></td>
	<td>
	<!--  start content-table-inner -->
	<div id="content-table-inner">
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
	<td>
	
	
		<!--  start step-holder -->
		<div id="step-holder">
			<div class="step-no">*</div>
			<div class="step-dark-left"><a href="">veuiller remplir</a></div>
		</div>
		<!--  end step-holder -->
	
		<!-- start id-form -->
	<form action="GestionEtudiant" name="formu" method="post">
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
			<th valign="top" name="nom">Nom</th>
			<td><input type="text" class="inp-form" name="nom"/></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top" name="prenom">prenom</th>
			<td><input type="text" class="inp-form-error" name="prenom"/></td>
			<td>
	
			</td>
		</tr>
 
		<tr>
			<th valign="top" name="motDePass">Mot De Passe:</th>
			<td><input type="password" class="inp-form" name="motDePass"/></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top" name="motDePass1" required>Retaper le Mot De Passe:</th>
			<td><input type="password" class="inp-form" name="motDePass2"/></td>
			<td></td>
		</tr>
		<tr>
		<th valign="top">Date de naissance:</th>
		<td class="noheight">
		
			<table border="0" cellpadding="0" cellspacing="0">
			<tr  valign="top">
				<td>
				
				<select id="d" class="styledselect-day" name="jour">
					<option value="">dd</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
				</select>
				</td>
				<td>
					<select id="m" class="styledselect-month" name="mois">
						<option value="">mmm</option>
						<option value="0">Jan</option>
						<option value="1">Feb</option>
						<option value="2">Mar</option>
						<option value="3">Apr</option>
						<option value="4">May</option>
						<option value="5">Jun</option>
						<option value="6">Jul</option>
						<option value="7">Aug</option>
						<option value="8">Sep</option>
						<option value="9">Oct</option>
						<option value="10">Nov</option>
						<option value="11">Dec</option>
					</select>
				</td>
				<td>
					<select  id="y"  class="styledselect-year" name="annee">
						<option value="">yyyy</option>
						<option value="1986">1986</option>
						<option value="1987">1987</option>
						<option value="1988">1988</option>
						<option value="1989">1989</option>
						<option value="1990">1990</option>
						<option value="1991">1991</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
						<option value="1995">1995</option>
						<option value="1996">1996</option>
						<option value="1997">1997</option>
						<option value="1998">1998</option>
						<option value="1999">1999</option>
						<option value="2000">2000</option>
						<option value="2001">2001</option>
						<option value="2002">2002</option>
						<option value="2003">2003</option>
						<option value="2004">2004</option>
						<option value="2005">2005</option>
					</select>
			
				</td>
				<td></td>
			</tr>
			</table>
		
		</td>
		<td></td>
	</tr>
	
	<tr>
		<th>&nbsp;</th>
		<td valign="top">
			<input type="submit" value="formu" name="formu" class="form-submit" />
			<input type="reset" value="" class="form-reset"  />
		</td>
		<td></td>
	</tr>
	</table>
	
	</form>
	<!-- end id-form  -->

	</td>
	<td>

		<!--  start related-activities -->
	<div id="related-activities">
		
		<!--  start related-act-top -->
		<div id="related-act-top">
		<img src="images/forms/header_related_act.gif" width="271" height="43" alt="" />
		</div>
		<!-- end related-act-top -->
		
		<!--  start related-act-bottom -->
		<div id="related-act-bottom">
		
			<!--  start related-act-inner -->
			<div id="related-act-inner">
			
				<div class="left"><a href=""><img src="images/forms/icon_plus.gif" width="21" height="21" alt="" /></a></div>
				<div class="right">
					<h5>A propos du departement</h5>
					Cette rubrique concerne 
					les differentes filieres du departement
					<ul class="greyarrow">
						<li><a href="">Click ici pour visiter</a></li> 
					</ul>
				</div>
				
				<div class="clear"></div>
				<div class="lines-dotted-short"></div>
				
				<div class="left"><a href=""><img src="images/forms/icon_minus.gif" width="21" height="21" alt="" /></a></div>
				<div class="right">
					<h5>Informations Generales</h5>
					Cette rubrique regroupe les informations
					relatives aux examens
					<ul class="greyarrow">
						<li><a href="">Click ici pour visiter</a></li> 
					</ul>
				</div>
				
				<div class="clear"></div>
				
				<div class="clear"></div>
				
			</div>
			<!-- end related-act-inner -->
			<div class="clear"></div>
		
		</div>
		<!-- end related-act-bottom -->
	
	</div>
	<!-- end related-activities -->
</td>
</tr>
<tr>
<td><img src="images/shared/blank.gif" width="695" height="1" alt="blank" /></td>
<td></td>
</tr>
</table>
 
<div class="clear"></div>
 

</div>
<!--  end content-table-inner  -->
</td>
<td id="tbl-border-right"></td>
</tr>
<tr>
	<th class="sized bottomleft"></th>
	<td id="tbl-border-bottom">&nbsp;</td>
	<th class="sized bottomright"></th>
</tr>
</table>









 





<div class="clear">&nbsp;</div>

</div>
<!--  end content -->
<div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->

 

<div class="clear">&nbsp;</div>
    
<!-- start footer -->         
<div id="footer">
	<!--  start footer-left -->
	<div id="footer-left">
	&copy; Copyright faculÃ© des sciences  All rights reserved.</div>
	<!--  end footer-left -->
	<div class="clear">&nbsp;</div>
</div>
<!-- end footer -->
 
</body>
</html>