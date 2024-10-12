<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/21/2024
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container pt-2">
    <h3>Màu sắc</h3>
    <table class="table table-bordered border-primary">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã màu</th>
            <th>Tên màu</th>
            <th>Trạng thái</th>
            <th colspan="3">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSach}" var="ms">
            <tr>
                <td>${ms.id}</td>
                <td>${ms.ma}</td>
                <td>${ms.ten}</td>
                <td>${ms.trangThai?"Đang hoạt động":"Dừng hoạt động"}</td>
                <td class="d-flex justify-content-evenly">
                    <a class="btn btn-primary" href="/asm/ms-detail?id=${ms.id}">Chi tiết</a>
                    <a class="btn btn-danger" href="/asm/ms-delete?id=${ms.id}">Xoá</a>
                    <a class="btn btn-warning" href="/asm/ms-viewupdate/${ms.id}">Sửa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="/asm/ms-viewadd">Thêm màu</a>
    <a class="btn btn-primary" href="/asm/trang-chu">Quay Lại trang chủ</a>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
