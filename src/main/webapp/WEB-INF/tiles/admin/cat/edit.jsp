<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-info text-center mb-4">Category Edit</h1>
<div class="container my-5 col-md-6 offset-md-3">
    <form:form action="/cat/edit" modelAttribute="category"  method="post" >
        <div class="form-group">
            <label for="name">Category Name</label>
            <form:input type="text" name="name" path="name" value="${category.name}" class="form-control"/>
            <form:input type="hidden" name="id" path="id" value="${category.id}" />
        </div>
        <button type="submit" class="btn btn-sm btn-primary">Update</button>
    </form:form>
</div>
