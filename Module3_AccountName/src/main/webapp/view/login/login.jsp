<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/21/2023
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
            integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>
</head>
<body>
<form method="post" action="/loginServlet">
    <section class="vh-100" style="background-color: #508bfc;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">
                            <h3 class="mb-5">Sign in</h3>
                            <div class="form-outline mb-4">
                                <div class="alert alert-secondary" role="alert">
                                      <p style="color: red">${message}</p>
                                </div>
                                <label class="form-label" for="typeEmailX-2">User</label>
                                <input name="user" type="text" id="typeEmailX-2" class="form-control form-control-lg"/>
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="typePasswordX-2">Password</label>
                                <input name="pass" type="password" id="typePasswordX-2"
                                       class="form-control form-control-lg"/>
                            </div>
                            <!-- Checkbox -->
                            <div class="form-check d-flex justify-content-start mb-4">
                                <input class="form-check-input" type="checkbox" value="" id="form1Example3"/>
                                <label class="form-check-label" for="form1Example3"> Remember password </label>
                            </div>

                            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

                            <hr class="my-4">

                            <%--                        <button class="btn btn-lg btn-block btn-primary" style="background-color: #dd4b39;"--%>
                            <%--                                type="submit"><i class="fab fa-google me-2"></i> Sign in with google</button>--%>
                            <%--                        <button class="btn btn-lg btn-block btn-primary mb-2" style="background-color: #3b5998;"--%>
                            <%--                                type="submit"><i class="fab fa-facebook-f me-2"></i>Sign in with facebook</button>--%>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


</form>

</body>
</html>
