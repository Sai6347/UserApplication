<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<style>
	body
	{
		background:linear-gradient(to right,#a9a9a9,#f5f5dd);
	}
	button
	{
		padding:5px;
		margin-bottom:20px;
		border-radius:5px;
	}
	button:hover
	{
		background-color:green;
		color:white;
		border:green;
	}
	input
	{
		padding:10px;
		width:150px;
		border-radius:5px;
	}
</style>
</head>
<script> 
    function loadData()
	{	 
		var xhttp =  new XMLHttpRequest();
		xhttp.onreadystatechange = function()
		{
			if(this.readyState == 4 && this.status === 200) 
			{
				document.getElementById("demo").innerHTML = xhttp.responseText;
			}
		};
		
		xhttp.open("GET","http://localhost:8080/SpringRestApiJdbc/getAll");
		
		xhttp.send();
	}
    
    function submitForm(event) 
    {
	  // Prevent the form from submitting.
	  event.preventDefault();
	  // Set url for submission and collect data.
	  //const url = "http://localhost:8080/SpringRestApiJdbc/create";
	  const formData = new FormData(event.target);
	  // Submit the data.
	  const data = {};
  	  	formData.forEach((value, key) => (data[key] = value));
  	  	const jsonString = JSON.stringify(data);
  	  	// Log the data.
  	  	console.log(data);
  	  	
  	  	var json = JSON.parse(jsonString);
  	  	//console.log(json);
	  let xhr = new XMLHttpRequest();
	  xhr.open('POST','/SpringRestApiJdbc/create');
	  xhr.setRequestHeader('Content-Type','application/json');
	  xhr.onload = function()
	  {
		  if(xhr.status === 200)
		   {
			  console.log("Data Saved");
		   }
		  else
			{
			  console.log("Error Saving");
			}
	  }
	  xhr.send(jsonString);
	}
 
    </script>
<body>
<center>
	<h2>Welcome to Home</h2>
	<form action="" method="post" onsubmit="submitForm(event)" id="myForm">
		<input type="text" name="name" placeholder="Enter Your Name"> <br> <br>
		<input type="text" name="mobile" placeholder="Enter Your Mobile" required> <br> <br>
		<input type="email" name="email" placeholder="Enter Your Email" required> <br> <br>
		<input type="password" name="password" placeholder="Enter Your Password"> <br><br>
		<input type="password" name="cPassword" placeholder="Confirm Your Password"> <br><br>
		<button >Submit</button> <br> <br>
		<button onclick="loadData()">Get Users</button> <br>
   	</form>
    <div id="demo"></div>
</center>
</body>
</html>
