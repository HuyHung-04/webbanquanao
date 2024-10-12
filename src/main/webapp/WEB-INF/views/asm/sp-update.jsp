<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2024
  Time: 11:04 PM
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
    <form action="/asm/sp-update" method="post" class="py-4">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${sp.id}" readonly>
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${sp.ma}">
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${sp.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="true" ${sp.trangThai?"checked":""}>
                <label class="form-check-label">
                    Đang hoạt động
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="false" ${!sp.trangThai?"checked":""}>
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
