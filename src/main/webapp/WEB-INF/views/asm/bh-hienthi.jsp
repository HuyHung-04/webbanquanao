<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/20/2024
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<style>
    body {
        background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
        color: #333;
    }
    .container {
        background: rgba(255, 255, 255, 0.95);
        padding: 20px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    }
    h6 {
        color: #1e3c72;
        font-weight: bold;
    }

    .table {
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    h6 {
        color: #3b5998;
        font-weight: 700;
        letter-spacing: 1px;
    }

    h3 {
        color: #1e3c72;
        font-weight: bold;
        text-align: center;
        margin-bottom: 20px;
    }


    .table thead {
        background-color: #1e3c72;
        color: #fff;
    }

    .table tbody tr:hover {
        background-color: #f1f1f1;
    }

    .btn-primary, .btn-danger {
        background: linear-gradient(45deg, #1e3c72, #2a5298);
        border: none;
        border-radius: 30px;
        padding: 10px 20px;
        color: white;
        font-weight: 600;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .btn-primary:hover, .btn-danger:hover {
        transform: translateY(-3px);
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.15);
    }
    .container {
        background: rgba(255, 255, 255, 0.9);
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }

    .form-control, .form-select {
        border-radius: 10px;
        border: 2px solid #1e3c72;
        padding: 10px;
        transition: border-color 0.3s ease;
    }

    .form-control:focus, .form-select:focus {
        border-color: #2a5298;
        box-shadow: 0 0 10px rgba(0, 123, 255, 0.2);
    }
    .container form {
        background-color: #f1f1f1;
        padding: 20px;
        border-radius: 15px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }
    table {
        margin-bottom: 30px;
    }

    h6 {
        margin-bottom: 20px;
    }

    button {
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    button:hover {
        background-color: #3b5998;
        transform: scale(1.05);
    }
    .container form {
        margin-bottom: 20px;
    }
    .container h3 {
        color: #3b5998;
    }

    h3 {
        text-align: center;
        color: #1e3c72;
    }
    table {
        margin-bottom: 30px;
    }
    button {
        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    }
    .container form {
        margin-right: 20px;
    }
</style>
<body >
<div class="pt-2 ps-2">
    <div class="row">
        <div class="col-8">
            <h6>Hoá đơn</h6>
            <table class="table table-bordered border-primary">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên khách hàng</th>
                    <th>Tên nhân viên</th>
                    <th>Ngày mua hàng</th>
                    <th>Trạng thái</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${danhSachHD}" var="hd">
                <tr>
                    <td>${hd.id}</td>
                    <td>${hd.khachHang.ten}</td>
                    <td>${hd.nhanVien.ten}</td>
                    <td>${hd.ngayMuaHang}</td>
                    <td>${hd.trangThai ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                </tr>
                </c:forEach>

            </table>
            <h6>Giỏ hàng</h6>
            <table class="table table-bordered border-primary">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>ID hoá đơn</th>
                    <th>Mã sản phẩm chi tiết</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th colspan="2">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${danhSachHDCT}" var="hdct">
                    <tr>
                        <td>${hdct.id}</td>
                        <td>${hdct.hoaDon.id}</td>
                        <td>${hdct.sanPhamChiTiet.ma}</td>
                        <td>${hdct.soLuong}</td>
                        <td>${hdct.donGia}</td>
                        <td>
                        <form action="/asm/hdct-delete" method="post">
                            <input type="hidden" name="id" value="${hdct.id}">
                            <button type="submit" class="btn btn-danger">Xoá</button>
                        </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <h6>Sản phẩm chi tiết</h6>
            <table class="table table-bordered border-primary">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Mã SPCT</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th>Màu sắc</th>
                    <th>Kích thước</th>
                    <th>Trạng thái</th>
                    <th colspan="3">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${danhSachSPCT}" var="spct">
                    <tr>
                        <td>${spct.id}</td>
                        <td>${spct.ma}</td>
                        <td>${spct.sanPham.ten}</td>
                        <td>${spct.soLuong}</td>
                        <td>${spct.donGia}</td>
                        <td>${spct.mauSac.ten}</td>
                        <td>${spct.kichThuoc.ten}</td>
                        <td>${spct.trangThai?"Đang hoạt động":"Dừng hoạt động"}</td>
                            <c:forEach var="hd" items="${danhSachHD}">
                        <td>
                            <form action="/asm/add-cart" method="post">
                                <input type="hidden" name="idHoaDon" value="${hd.id}">
                                <input type="hidden" name="idSanPhamChiTiet" value="${spct.id}">
                                <button type="submit" class="btn btn-danger">Add cart</button>
                            </form>
                        </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="/asm/trang-chu">Quay lại trang chủ</a>
        </div>
        <div class="col-4 pt-4" >
            <div class="container">
                <h3>Tạo hoá đơn</h3>
                <form action="/asm/bh-add" method="post" class="py-4">
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
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không?')">Tạo hoá đơn</button>
                </form>
                <c:if test="${not empty danhSachHDCT}">
                    <form action="/asm/thanh-toan" method="post">
                        <input type="hidden" name="idHoaDon" value="${danhSachHDCT[0].hoaDon.id}">
                        <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có chắc chắn muốn thanh toán?')">Thanh toán</button>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
