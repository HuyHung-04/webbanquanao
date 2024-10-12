<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/20/2024
  Time: 9:54 PM
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
    <h3>Sửa sản phẩm</h3>
    <form action="/asm/spct-update" method="post" class="py-4">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${spct.id}" readonly>
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${spct.ma}">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Tên sản phẩm</label>
            <select class="form-select" aria-label="Default select example" name="sanPham">
                <c:forEach items="${danhSachSP}" var="sp">
                    <option value="${sp.id}" label="${sp.ten}" ${spct.sanPham.id == sp.id?"selected":""}></option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="soLuong" class="form-label">Số lượng</label>
            <input type="text" class="form-control" id="soLuong" name="soLuong" value="${spct.soLuong}">
        </div>
        <div class="mb-3">
            <label for="donGia" class="form-label">Đơn giá</label>
            <input type="text" class="form-control" id="donGia" name="donGia" value="${spct.donGia}">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Màu sắc</label>
            <select class="form-select" aria-label="Default select example" name="mauSac">
                <c:forEach items="${danhSachMS}" var="ms">
                    <option value="${ms.id}" label="${ms.ten}" ${spct.mauSac.id == ms.id?"selected":""}></option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Kích thước</label>
            <select class="form-select" aria-label="Default select example" name="kichThuoc">
                <c:forEach items="${danhSachKT}" var="kt">
                    <option value="${kt.id}" label="${kt.ten}" ${spct.kichThuoc.id == kt.id?"selected":""}></option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="true" ${spct.trangThai?"checked":""}>
                <label class="form-check-label">
                    Đang hoạt động
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="false" ${!spct.trangThai?"checked":""}>
                <label class="form-check-label">
                    Dừng hoạt động
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn sửa không?')">Sửa</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
