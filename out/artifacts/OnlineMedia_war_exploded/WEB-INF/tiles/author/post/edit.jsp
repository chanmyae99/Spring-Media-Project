<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-8 offset-md-2 container my-5">
    <h1 class="text-center text-info mb-3">Edit Post</h1>
    <form:form method="post" modelAttribute="post" action="/post/edit" enctype="multipart/form-data">
        <div class="form-group">
            <label for="title">Title</label>
            <form:input type="text" class="form-control" id="tittle" name="title" path="title" value="${post.title}"/>
        </div>
        <div class="form-group">
            <label for="cat_id">Category</label>
            <form:select class="form-control" id="cat_id" name="cat_id" path="cat_id">
                <c:forEach var="cat" items="${cats}">
                    <option value="${cat.id}">${cat.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <label for="file">Post Image</label>
            <form:input type="file" class="form-control-file" id="file" name="file" path="file"/>
        </div>
        <div class="form-group">
            <label for="content">Post Content</label>
            <form:textarea class="form-control" id="content" name="content" path="content" rows="3" value="${post.content}"/>
        </div>
        <form:input path="id" name="id" type="hidden" value="${post.id}" />
        <form:input path="user_id" name="user_id" type="hidden" value="${post.user_id}" />
        <form:input path="image" name="image" type="hidden" value="${post.image}" />
        <button type="submit" class="btn btn-sm btn-primary float-right">Update</button>
    </form:form>
</div>

