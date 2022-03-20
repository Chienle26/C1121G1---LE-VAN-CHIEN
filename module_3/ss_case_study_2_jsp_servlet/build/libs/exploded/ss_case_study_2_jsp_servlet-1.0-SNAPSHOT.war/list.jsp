<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/21/2022
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./style.css">
    <style>
        html{
            font-size: 62.5%;
        }

        body{
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            height: 120rem;
        }

        .header{
            position: fixed;
            width: 100%;
            height: 12rem;
            background-color: white;
            z-index: 5;
        }

        .logo{
            margin-top: 1rem;
            margin-left: 3rem;
        }

        .my-name{
            font-size: 3rem;
            font-weight: bold;
            position: absolute;
            right: 4rem;
            top: 50%;
            transform: translateY(-50%);
            display: inline-block;
            background-image: linear-gradient(to right, #ffd96a,#ff4895);
            color: transparent;
            -webkit-background-clip: text;
            background-clip: text;
        }

        .nav{
            width: 100%;
            height: 10rem;
            background-color: rgba(236, 232, 232, 0.568);
            position: fixed;
            top: 12rem;
            left: 0;
            z-index: 5;
        }

        .botton-gradient input{
            border-radius: 2rem;
            width: 22rem;
            height: 3rem;
            position: absolute;
            right: 3rem;
            top: 50%;
            transform: translateY(-50%);
        }

        .botton-gradient span{
            position: absolute;
            right: 28rem;
            top: 50%;
            transform: translateY(-50%);
            font-size: large;
            color: black;
        }


        .botton-gradient{
            padding: 1rem 0;
            text-decoration: none;
            margin: 2rem;
            color: white;
            border-radius: 6px;
            font-weight: bold;
            text-transform: uppercase;
            font-size: 1.6rem;
            text-align: center;
            width: 15rem;
        }

        .botton-gradient-1{
            display: inline-block;
            background-image: linear-gradient(to right,#63eaa5,#4bc8c6 );
            box-shadow: 3px 5px 10px 1px rgb(75 200 198 / 56%);
            position: absolute;
            top: 50%;
            left: 25rem;
            margin-top: -18.75px;
        }
        .botton-gradient-2{
            display: inline-block;
            background-image: linear-gradient(to right,#a7e0ff,rgb(109, 178, 229) );
            box-shadow: 3px 5px 10px 1px rgb(109 178 229 / 56%);
            position: absolute;
            top: 50%;
            left: 45rem;
            margin-top: -18.75px;
        }
        .botton-gradient-3{
            display: inline-block;
            background-image: linear-gradient(to right,#a8b3ff,rgb(168, 134, 246) );
            box-shadow:  3px 5px 10px 1px rgb(168 134 246 / 56%);
            position: absolute;
            top: 50%;
            left: 65rem;
            margin-top: -18.75px;
        }
        .botton-gradient-4{
            display: inline-block;
            background-image: linear-gradient(to right,#eabc85,rgb(233, 136, 77) );
            box-shadow: 3px 5px 10px 1px rgb(233 136 77 / 56%);
            position: absolute;
            top: 50%;
            left: 85rem;
            margin-top: -18.75px;
        }
        .botton-gradient-5{
            display: inline-block;
            background-image: linear-gradient(to right,#eaa899,rgb(215, 100, 98) );
            box-shadow: 3px 5px 10px 1px rgb(215 100 98 / 56%);
            position: absolute;
            top: 50%;
            left: 105rem;
            margin-top: -18.75px;
        }

        .sidebar{
            width: 15%;
            height: 100%;
            background-color: #ccc;
            position: fixed;
            top: 22rem;
            text-align: center;
        }

        .sidebar a{
            display: block;
            text-decoration: none;
            font-weight: bold;
            font-size: 1.8rem;
            /* margin-top: 5rem; */
            padding: 1.5rem;
            color: black;
        }

        .sidebar a:first-child{
            margin-top: 5rem;
        }
        .body{
            width: 85%;
            position: absolute;
            top: 22rem;
            right: 0;
        }

        .footer{
            width: 100%;
            height: 12rem;
            background-color: #046056;
            position: absolute;
            top: 110rem;
            left: 0;
            text-align: center;
        }

        .footer h3{
            margin-bottom: 0;
            margin-top: 1rem;
            font-size: 1.6rem;
        }

        .footer p{
            margin: 0;
            font-size: 1.6rem;
        }

    </style>
</head>
<body>
<div class="header">
    <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png" alt="" class="logo">
    <span class="my-name">LE VAN CHIEN</span>
</div>

<div class="nav">
    <div class="botton-gradient">
        <a href="#" class="botton-gradient botton-gradient-1">Home</a></li>
        <a href="#" class="botton-gradient botton-gradient-2">Employee</a>
        <a href="#" class="botton-gradient botton-gradient-3">Customer</a>
        <a href="#" class="botton-gradient botton-gradient-4">Service</a>
        <a href="#" class="botton-gradient botton-gradient-5">Contract</a>
        <span>Search</span>
        <input type="text">
    </div>
</div>

<div class="sidebar">
    <a href="#">Home</a>
    <a href="#">Employee</a>
    <a href="#">Customer</a>
    <a href="#">Service</a>
    <a href="#">Contract</a>
</div>

<div class="body">

</div>

<div class="footer">
    <h3>Liên hệ</h3>
    <p>
        103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam <br>
        Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666 <br>
        Email: reservation@furamavietnam.com * www.furamavietnam.com
    </p>
</div>

</body>
</html>
