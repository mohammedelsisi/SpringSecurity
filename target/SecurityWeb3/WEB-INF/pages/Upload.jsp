<%@include file="include/header.jsp" %>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Login Form</h5>
        <form method="post" action="uploadPic" enctype="multipart/form-data">
            <label>Upload A photo</label>
            <input type="file" name="userPhoto">
            <br>
            <input type="submit" class="btn btn-primary mt-4" value="Upload">

        </form>
    </div>
</div>


<%@include file="include/footer.jsp" %>

