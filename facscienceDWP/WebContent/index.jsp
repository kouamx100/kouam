<%-- 
    Document   : index
    Created on : 3 oct. 2013, 12:09:30
    Author     : kouam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>acceuil faculté des sciences</title>
<link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="default" />
<!--  jquery core -->
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>

<!-- Custom jquery scripts -->
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>

<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
<script src="js/jquery/jquery.pngFix.pack.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
$(document).pngFix( );
});

</script>

</head>
<body id="login-bg"> 
 
<!-- Start: login-holder -->
<div id="login-holder">

	<!-- start logo -->
	<div id="logo-login">
		
	</div>
	<!-- end logo -->
	
	<div class="clear"></div>
	
	<!--  start loginbox ................................................................................. -->
	<div id="loginbox">
	
	<!--  start login-inner -->
	<div id="login-inner">
            <form action="Connection" name="connection" method="post">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th>Matricule</th>
                        <td><input type="text" name="matricule" class="login-inp" id="matricule" required autofocus/></td>
		</tr>
		<tr>
			<th>Password</th>
                        <td><input type="password" name="passwd" value="" id="passwd"  onfocus="this.value=''" class="login-inp" required /></td>
                        
		</tr>
		<tr>
			<th></th>
			<td valign="top"><input type="checkbox" class="checkbox-size" id="login-check" /><label for="login-check">Remember me</label></td>
		</tr>
            <tr>
			<th></th>
                        <td><input type="submit" class="submit-log" name="connection" value="connection"/></td>
		</tr>
		</table>
            </form>
	</div>
 	<!--  end login-inner -->
	<div class="clear"></div>
        <a href="" class="forgot-pw" alt="espace reservé aux enseignants"><b id="erreur">Bienvenu</b></a>
 </div>
 <!--  end loginbox -->


</div>
<!-- End: login-holder -->
</body>
</html>