<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/21/2024
  Time: 3:12 PM
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
    <h3>Thêm kích thước</h3>
    <form action="/asm/kt-add" method="post" class="py-4">
<%--        <div class="mb-3">--%>
<%--            <label for="id" class="form-label">ID</label>--%>
<%--            <input type="text" class="form-control" id="id" name="id">--%>
<%--            <span ng-show="(frm.id.$error.required && frm.id.$touched) || (frm.id.$error.required && frm.$submitted)" class="text-danger">--%>
<%--                ID không được để trống--%>
<%--            </span>--%>
<%--        </div>--%>
        <div class="mb-3">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma">
<%--            <span ng-show="(frm.ma.$error.required && frm.ma.$touched) || (frm.ma.$error.required && frm.$submitted)" class="text-danger">--%>
<%--                Mã không được để trống--%>
<%--            </span>--%>
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten">
<%--            <span ng-show="(frm.ten.$error.required && frm.ten.$touched) || (frm.ten.$error.required && frm.$submitted)" class="text-danger">--%>
<%--                Tên không được để trống--%>
<%--            </span>--%>
        </div>
        <div class="mb-3">
            <label class="form-label">Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="true" checked>
                <label class="form-check-label">
                    Còn hàng
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="false">
                <label class="form-check-label">
                    Hết hàng
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không?')">Thêm</button>
          <a href="/asm/kt-hienthi" class="btn btn-primary">Quay lại</a>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</html>
