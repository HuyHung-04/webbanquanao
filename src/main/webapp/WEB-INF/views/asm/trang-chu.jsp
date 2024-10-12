<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2024
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<style>
    .navbar-nav .nav-link:hover {
        color: #ffcc00;
        text-shadow: 1px 1px 5px rgba(255, 255, 255, 0.7);
    }
    .btn:hover {
        background-color: #004085;
        transition: background-color 0.3s ease;
    }
    .carousel-item {
        transition: opacity 1s ease-in-out;
    }
    .navbar, .carousel-item, .btn {
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }
    body {
        background: linear-gradient(135deg, #ffcc00, #ff5733);
        animation: gradient 5s infinite;
    }

    @keyframes gradient {
        0% {
            background-position: 0% 50%;
        }
        50% {
            background-position: 100% 50%;
        }
        100% {
            background-position: 0% 50%;
        }
    }
    .navbar.scrolled {
        background-color: rgba(0, 123, 255, 1);
    }
    .carousel-item img {
        transition: transform 0.5s ease-in-out, opacity 0.5s ease-in-out;
    }
    .carousel-item.active img {
        transform: scale(1.05);
        opacity: 1;
    }
    .carousel-item img {
        opacity: 0.7;
    }
    .navbar, .carousel-control-prev, .carousel-control-next {
        background: linear-gradient(45deg, #007bff, #00ccff);
        box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.2);
    }
    .btn {
        position: relative;
        overflow: hidden;
    }
    .carousel-item img {
        border-radius: 10px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }
</style>
<body>
<nav class="navbar navbar-expand-lg bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/asm/bh-hienthi">Bán hàng</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/asm/nv-hienthi">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/asm/kh-hienthi">Khách hàng</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Sản phẩm
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/asm/sp-hienthi">Sản phẩm</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/asm/spct-hienthi">Sản phẩm chi tiết</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Hoá đơn
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/asm/hd-hienthi">Hoá đơn</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/asm/hdct-hienthi">Hoá đơn chi tiết</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Thuộc tính
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/asm/ms-hienthi">Màu sắc</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/asm/kt-hienthi">Kích thước</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-dark" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="3000">
            <img src="/image/slider_4.webp" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item" data-bs-interval="3000">
            <img src="/image/slider_3.webp" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item" data-bs-interval="3000">
            <img src="/image/slider_2.webp" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
