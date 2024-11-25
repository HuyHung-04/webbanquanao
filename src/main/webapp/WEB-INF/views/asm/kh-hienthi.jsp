<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/18/2024
  Time: 9:17 PM
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
    <h3>Khách hàng</h3>
    <table class="table table-bordered border-primary">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã khách hàng</th>
            <th>Tên khách hàng</th>
            <th>Số điện thoại</th>
            <th>Trạng thái</th>
            <th colspan="3">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSach}" var="kh">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.sdt}</td>
                <td>${kh.trangThai?"Đang hoạt động":"Dừng hoạt động"}</td>
                <td class="d-flex justify-content-evenly">
                    <a class="btn btn-primary" href="/asm/kh-detail?id=${kh.id}">Chi tiết</a>
                    <a class="btn btn-danger" href="/asm/kh-delete?id=${kh.id}">Xoá</a>
                    <a class="btn btn-warning" href="/asm/kh-viewupdate/${kh.id}">Sửa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="/asm/kh-viewadd">Thêm khách hàng</a>
    <a class="btn btn-primary" href="/asm/trang-chu">Quay Lại trang chủ</a>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
