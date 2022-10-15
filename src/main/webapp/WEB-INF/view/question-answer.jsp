<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Secure q/a</title>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between">

			<h3>Question and answer functionality available to lecturers
				only</h3>
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">

				<input type="submit" class="btn btn-primary" value="Logout" />
			</form:form>
		</div>
		<hr>
		<h5>Status : ${message}</h5>
		<hr>

		<div class="container mt-5">
			<form:form action="push" method="POST">
				<div class="form-group">
					<label for="exampleInputEmail1">Question</label> <input type="text"
						class="form-control" placeholder="Enter question" name="ques">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Answer</label> <input
						type="text" class="form-control"
						placeholder="Type the answer here" name="ans">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Area of knowledge</label> <input
						type="text" class="form-control" name="att"
						placeholder="eg. plants, computers, earth, places">
				</div>
				<button type="submit" class="btn btn-success">Submit</button>
			</form:form>
			<a href="${pageContext.request.contextPath}/"> Back to Home Page
			</a>

		</div>
		<hr>
		<br>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>