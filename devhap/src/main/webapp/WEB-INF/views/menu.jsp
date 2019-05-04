<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu">
	<!--  -->
    <h3>menuHeaderText here</h3>
    <div>
    	<a><h3>menuAddContact</h3></a>
    </div>
    
    <!--  -->
    <div id="login">
       <form name="loginForm" action="" method="post">
           <table>
               <caption align="left">Login:</caption>
               <tr>
                   <td>User Name:</td>
                   <td><input type="text" name="j_username"/></td>
               </tr>
               <tr>
                   <td>Password:</td>
                   <td><input type="password" name="j_password"/></td>
               </tr>
               <tr>
                   <td colspan="2" align="center"><input name="submit" type="submit" value="Login"/></td>
               </tr>           
           </table>
       </form>
    </div>
</div>
