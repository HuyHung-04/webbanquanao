<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Document</title>
</head>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap');
    *{
        font-family: 'Poppins', sans-serif;
    }
    .wrapper {
        background-image: url('<c:url value="/image/login3.webp"/>');
        padding: 0 20px 0 20px;
    }



    .main{
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    .side-image{
        background-image: url('<c:url value="/image/login2.jpg"/>');
        background-position: center;
        background-size: cover;
        background-repeat: no-repeat;
        border-radius: 10px 0 0 10px;
        position: relative;
    }
    .row{
        width:  900px;
        height:550px;
        border-radius: 10px;
        background: #fff;
        padding: 0px;
        box-shadow: 5px 5px 10px 1px rgba(0,0,0,0.2);
    }
    .text{
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    .text p{
        color: #fff;
        font-size: 20px;
    }
    i{
        font-weight: 400;
        font-size: 15px;
    }
    .right{
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
    }
    .input-box{
        width: 330px;
        box-sizing: border-box;
    }
    img{
        width: 35px;
        position: absolute;
        top: 30px;
        left: 30px;
    }
    .input-box header{
        font-weight: 700;
        text-align: center;
        margin-bottom: 45px;
    }
    .input-field{
        display: flex;
        flex-direction: column;
        position: relative;
        padding: 0 10px 0 10px;
    }
    .input{
        height: 45px;
        width: 100%;
        background: transparent;
        border: none;
        border-bottom: 1px solid rgba(0, 0, 0, 0.2);
        outline: none;
        margin-bottom: 20px;
        color: #40414a;
    }
    .input-box .input-field label{
        position: absolute;
        top: 10px;
        left: 10px;
        pointer-events: none;
        transition: .5s;
    }
    .input-field input:focus ~ label
    {
        top: -10px;
        font-size: 13px;
    }
    .input-field input:valid ~ label
    {
        top: -10px;
        font-size: 13px;
        color: #5d5076;
    }
    .input-field .input:focus, .input-field .input:valid{
        border-bottom: 1px solid #743ae1;
    }
    .submit{
        border: none;
        outline: none;
        height: 45px;
        background: #ececec;
        border-radius: 5px;
        transition: .4s;
    }
    .submit:hover{
        background: rgba(37, 95, 156, 0.937);
        color: #fff;
    }
    .signin{
        text-align: center;
        font-size: small;
        margin-top: 25px;
    }
    span a{
        text-decoration: none;
        font-weight: 700;
        color: #000;
        transition: .5s;
    }
    span a:hover{
        text-decoration: underline;
        color: #000;
    }
    @media only screen and (max-width: 768px){
        .side-image{
            border-radius: 10px 10px 0 0;
        }
        img{
            width: 35px;
            position: absolute;
            top: 20px;
            left: 47%;
        }
        .text{
            position: absolute;
            top: 70%;
            text-align: center;
        }
        .text p, i{
            font-size: 16px;
        }
        .row{
            max-width:420px;
            width: 100%;
        }
    }
</style>
<body>
<div class="wrapper">
    <div class="container main">
        <div class="row">
            <div class="col-md-6 side-image">
            </div>
            <div class="col-md-6 right">

                <div class="input-box">
                    <form action="/asm/login" method="post">
                        <header>Create account</header>
                        <c:if test="${not empty error}">
                            <p style="color: red; text-align: center;">${error}</p>
                        </c:if>
                        <div class="input-field">
                            <input type="text" class="input" id="email" required="" name="user"autocomplete="off">
                            <label for="email">Email</label>
                        </div>
                        <div class="input-field">
                            <input type="password" class="input" id="pass" required="" name="pass">
                            <label for="pass">Password</label>
                        </div>
                        <div class="input-field">
                            <input type="submit" class="submit" value="Login">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>