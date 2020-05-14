<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5 col-md-6 offset-md-3">
    <form:form action="/cat/create" method="post" modelAttribute="category" class="bordered rounded">
        <div class="form-group">
            <label for="name">Category Name</label>
            <form:input type="text" name="name" path="name" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-sm btn-primary">Create</button>
    </form:form>
</div>