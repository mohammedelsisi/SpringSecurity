<%@include file="include/header.jsp" %>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Login Form</h5>
        <form:form method="post">
            <label>User Name</label>
            <input type="text" name="userName">
            <br>
            <label>Password</label>
            <input type="password" name="password">
            <br>

            <input type="checkbox" name="remember-me" />
            <label>remember me</label>
            <br>
            <input class="btn btn-primary mt-4" type="submit">
        </form:form>
    </div>
</div>
<%@include file="include/footer.jsp" %>
