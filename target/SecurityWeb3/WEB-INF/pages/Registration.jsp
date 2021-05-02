<%@include file="include/header.jsp" %>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Login Form</h5>
        <form:form method="post" modelAttribute="newUser" action="signup">
            <label>User Name</label>
            <form:input path="userName" cssClass="form-control form-control-user"/>
            <form:errors path="userName" cssClass="alert-danger"/>

            <br>
            <label>Password</label>
            <form:password path="password" cssClass="form-control form-control-user"/>
            <form:errors path="password" cssClass="alert-danger"/>

            <br>

            <label>Email</label>
            <form:input path="email" cssClass="form-control form-control-user"/>
            <form:errors path="email" cssClass="alert-danger"/>


            <br>
            <label>Phone Number</label>
            <form:input path="phoneNumber" cssClass="form-control form-control-user"/>
            <form:errors path="phoneNumber" cssClass="alert-danger"/>
            <br>
            <input class="btn btn-primary mt-4" type="submit">
        </form:form>
    </div>
</div>
<%@include file="include/footer.jsp" %>
