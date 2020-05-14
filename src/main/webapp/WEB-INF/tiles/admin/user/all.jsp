<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <a href="/cat/create" class="btn btn-primary btn-sm my-3">Create <i class="fa fa-plus"></i></a>
    <table class="table table-bordered bg-dark text-white">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <c:if test="${user.enabled}">
                    <td><a href="#" class="btn btn-sm btn-danger">ban</a></td>
                </c:if>
                <c:if test="${!user.enabled}">
                    <td><a href="#" class="btn btn-sm btn-primary">active</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
