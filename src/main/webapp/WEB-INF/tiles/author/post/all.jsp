<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <a href="/post/create" class="btn btn-sm btn-primary mb-3">Create <i class="fa fa-plus"></i></a>
    <table class="table table-bordered bg-dark text-white">
        <thead>
        <tr class="text-center">
            <th scope="col">id</th>
            <th scope="col">Author</th>
            <th scope="col">Category</th>
            <th scope="col">title</th>
            <th scope="col">image</th>
            <th scope="col">content</th>
            <th scope="col">Date</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="post" items="${posts}">
            <tr class="text-center">
                <td>${post.id}</td>
                <td>${post.user_id}</td>
                <td>${post.cat_id}</td>
                <td>${post.title}</td>
                <td>
                    <img src="/assets/imgs/${post.image}" width="50" height="50" />
                </td>
                <td>${post.content}</td>
                <td>${post.created_at}</td>
                <td>
                    <a href="/post/edit/${post.id}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                    <a href="/post/delete/${post.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>