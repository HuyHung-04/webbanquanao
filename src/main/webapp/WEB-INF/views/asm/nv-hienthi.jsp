<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/18/2024
  Time: 10:53 PM
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
    <h3>Nhân viên</h3>
    <table class="table table-bordered border-primary">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã nhân viên</th>
            <th>Tên nhân viên</th>
            <th>Tên đăng nhập</th>
            <th>Mật khẩu</th>
            <th>Trạng thái</th>
            <th colspan="3">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSach}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.tenDangNhap}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.trangThai?"Còn làm":"Nghỉ làm"}</td>
                <td class="d-flex justify-content-evenly">
                    <a class="btn btn-primary" href="/asm/nv-detail?id=${nv.id}">Chi tiết</a>
                    <a class="btn btn-danger" href="/asm/nv-delete?id=${nv.id}">Xoá</a>
                    <a class="btn btn-warning" href="/asm/nv-viewupdate/${nv.id}">Sửa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="/asm/nv-viewadd">Thêm nhân viên</a>
    <a class="btn btn-primary" href="/asm/trang-chu">Quay Lại trang chủ</a>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
