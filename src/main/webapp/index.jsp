<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Registration</title>
<style>
body {
	/*font-family: Calibri, Helvetica, sans-serif;*/
	background-color: lightpink;
}

.container {
	padding: 50px;
	background-color: white;
}

.heading {
	background-color: rgb(52, 173, 52);
}

input[type=text], input[type=password], textarea {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: lightblue;
	outline: none;
}

div {
	padding: 10px 0;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
	font-size: large;
}

.registerbtn:hover {
	opacity: 1;
}
</style>
</head>
<body>
	<form name="registration" method="POST" action="registrationServlet">
		<div class="container">
			<div class="heading">
				<!--<center>-->
				<h1 align="center">Patient Registration</h1>
				<!--</center>  -->
			</div>

			<hr>
			<label> Firstname </label> 
				<input type="text" name="firstname" placeholder="Firstname" size="15" required />
			<label> Lastname: </label> 
			<input type="text" name="lastname" placeholder="Lastname" size="15" required />
			<div>
				<label> Gender : </label><br> <input type="radio" value="Male"
					name="gender" required> Male <input type="radio"
					value="Female" name="gender"> Female <input type="radio"
					value="Other" name="gender"> Other

			</div>
			
			<div>
			<label>   
				Aadhaar UID :  
			</label>  
				 
			<input type="text" name="aadhaar" placeholder="Aadhar UID" size="12" pattern="[1-9]{1}[0-9]{11}" 
			     title="12 digit Aadhaar No."required>   
			</div>
			
			<div>
			<label>   
				Phone :  
			</label>  
				<input type="text" name="country code" placeholder="Country Code"  value="+91" size="2" >   
			<input type="text" name="phone" placeholder="phone no." size="10" pattern="[1-9]{1}[0-9]{9}" 
			     title="Ten digit phone number"required>   
			</div>
			<div>
				<label> Date of Birth : </label> <input type="date" placeholder="dd-mm-yyyy" id="birthday"
					name="birthday" required>
			</div>
			<div>
				<label> Pincode : </label> <input type="text" id="pincode"
					name="pincode" pattern="[1-9]{1}[0-9]{5}" title="Six digit pincode"
					required>
			</div>

			<button type="submit" class="registerbtn">Register</button>
		</div>
	</form>
</body>
</html>