<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/21/2024
  Time: 1:24 PM
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
    <form action="/hoadonchitiet/hdct-add" method="post" class="py-4">
<%--        <div class="mb-3">--%>
<%--            <label for="id" class="form-label">ID</label>--%>
<%--            <input type="text" class="form-control" id="id" name="id">--%>
<%--        </div>--%>
        <div class="mb-3">
            <label for="idSPCT" class="form-label">ID sản phẩm chi tiết</label>
            <input type="text" class="form-control" id="idSPCT" name="idSPCT">
        </div>
        <div class="mb-3">
            <label for="idHoaDon" class="form-label">ID hoá đơn</label>
            <input type="text" class="form-control" id="idHoaDon" name="idHoaDon">
        </div>
        <div class="mb-3">
            <label for="soLuong" class="form-label">Số lượng</label>
            <input type="text" class="form-control" id="soLuong" name="soLuong">
        </div>
        <div class="mb-3">
            <label for="donGia" class="form-label">Đơn giá</label>
            <input type="text" class="form-control" id="donGia" name="donGia">
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="true" checked>
                <label class="form-check-label">
                    Chưa thanh toán
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="false">
                <label class="form-check-label">
                    Đã thanh toán
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không?')">Thêm</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
