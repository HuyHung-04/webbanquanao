<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/20/2024
  Time: 3:22 PM
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
    <h3>Chi tiết sản phẩm</h3>
    <form class="py-4">
        <div class="mb-3">
            <label class="form-label">ID: </label>
            ${spct.id}
        </div>
        <div class="mb-3">
            <label class="form-label">Mã: </label>
            ${spct.ma}
        </div>
        <div class="mb-3">
            <label class="form-label">Tên sản phẩm: </label>
            ${spct.sanPham.ten}
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng: </label>
            ${spct.soLuong}
        </div>
        <div class="mb-3">
            <label class="form-label">Đơn giá: </label>
            ${spct.donGia}
        </div>
        <div class="mb-3">
            <label class="form-label">Màu sắc: </label>
            ${spct.mauSac.ten}
        </div>
        <div class="mb-3">
            <label class="form-label">Kích thước: </label>
            ${spct.kichThuoc.ten}
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái: </label>
            ${spct.trangThai?"Đang hoạt động":"Dừng hoạt động"}
        </div>
        <a href="/asm/spct-hienthi" class="btn btn-primary">Quay lại</a>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
