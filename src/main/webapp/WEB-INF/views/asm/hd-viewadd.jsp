<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/20/2024
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="pt-4">
<div class="container border border-primary rounded-4" style="width: 500px">
    <h3>Tạo hoá đơn</h3>
    <form action="/asm/bh-add" method="post" class="py-4">
<%--        <div class="mb-3">--%>
<%--            <label for="id" class="form-label">ID</label>--%>
<%--            <input type="text" class="form-control" id="id" name="id">--%>
<%--        </div>--%>
        <div class="mb-3">
            <label for="khachHang" class="form-label">Tên khách hàng</label>
            <select class="form-select" aria-label="Default select example" name="khachHang" id="khachHang">
                <c:forEach items="${danhSachKH}" var="kh">
                    <option value="${kh.id}" label="${kh.ten}"></option>
                </c:forEach>
        </select>
        </div>
        <div class="mb-3">
            <label for="nhanVien" class="form-label">Tên nhân viên</label>
            <select class="form-select" aria-label="Default select example" name="nhanVien" id="nhanVien">
                <c:forEach items="${danhSachNV}" var="nv">
                    <option value="${nv.id}" label="${nv.ten}"></option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="ngayMuaHang" class="form-label">Ngày mua Hàng</label>
            <input type="date" class="form-control" id="ngayMuaHang" name="ngayMuaHang" value="${ngayHienTai}" readonly>
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="false" checked>
                <label class="form-check-label">
                    Chưa thanh toán
                </label>
            </div>
<%--            <div class="form-check">--%>
<%--                <input class="form-check-input" type="radio" name="trangThai" value="false">--%>
<%--                <label class="form-check-label">--%>
<%--                    Đã thanh toán--%>
<%--                </label>--%>
<%--            </div>--%>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không?')">Xác nhận</button>
    <a href="/asm/bh-hienthi" class="btn btn-primary">Quay lại</a>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
