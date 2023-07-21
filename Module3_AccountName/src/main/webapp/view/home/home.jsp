<%--
  Created by IntelliJ IDEA.
  User: HPT AcerNTR07
  Date: 7/15/2023
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home page</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
        }

        .main {
            width: 100%;
            padding: 0;
            /*height: 1400px;*/

        }

        .header {
            border: solid 1px;
            height: 80px;
            margin-bottom: 5px;
            width: 100%;
            top: 0;
            left: 0;
        }

        .img1 {
            height: 40px;
            margin: 20px;
            float: left;
        }

        .img2 {
            height: 30px;
            margin: 5px;
            float: right;
            display: inline;
        }
         .header a{
              float: right;
              margin: 10px;
        }
         .navbar {
             width: 100%;
             height: 30px;
             line-height: 30px;
             margin-bottom: 5px;
             clear: both;
             display: flex;
             justify-content: center;
             align-items: center;
             margin-top: 40px;
         }
         .navbar ul {
             margin:  0;
             padding:  0 ;
         }
         .navbar ul li {
             padding: 0;
             display: inline;
        }
         .navbar ul li a {
             text-decoration: none;
             margin: 0 auto;
             text-align: center;
             color: black;
             padding: 5px;
         }
         .navbar li a:hover{
             color: blue;
         }
        .leftcontent {
            width: 20%;
            padding: 0;
            margin: 0;
            float: left;
        }
        p {
            padding: 10px;
            font-size: 15px;
        }
        .rightcontent {
            width: 80%;
            float: right;
            padding: 0;
            margin: 0;
        }
        .img3 {
            height: 600px;
        }
        .footer {
            bottom: 0;
            clear: both;
            font-size: 30px;
            text-align: center;
            width: 100%;
            color: white;
            background-color: gray;
            height: 80px;
            padding: 20px 20px 0px 20px;
            margin: 0;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="header">
        <img src="https://th.bing.com/th/id/R.2a1c4bd46cd242f1ae9d968268ad8e5c?rik=DAB6%2be%2bSsk9tIA&pid=ImgRaw&r=0"
             class="img1">
        <img class="img2" src="https://th.bing.com/th/id/R.c3def1fb4d0d6f02f32fc20986f0bed6?rik=zWFcM73pfDAEdw&riu=http%3a%2f%2fcdn.onlinewebfonts.com%2fsvg%2fimg_215059.png&ehk=cpnJPsuf6lEHd7fyViQDbBmwZZJgbettb1OKxGirwRA%3d&risl=&pid=ImgRaw&r=0">
         <a href="/view/login/login.jsp">Account</a>
        </div>
    <div class="navbar">
        <ul>
            <li><a href="/view/home/home.jsp">Home</a></li>
            <li><a href="/employeeServlet">Employee</a></li>
            <li><a href="/CustomerServlet">Customer</a></li>
            <li><a href="/ServiceServlet">Service</a></li>
            <li><a href="/ContractServlet">Contract</a></li>
        </ul>
        </div>
    <div class="leftcontent">
        <p>Item one</p>
        <p>Item two</p>
        <p>Item three</p>
    </div>
    <div class="rightcontent">
        <img class="img3" src="https://th.bing.com/th/id/R.2703a703953a6c5ac7e89fe68a2fc19a?rik=2xdxaASjg9SrVw&pid=ImgRaw&r=0">
    </div>
    <div class="footer">
        <p>>Bản quyền &copy;2023- FURAMA-RESORT</p>
    </div>
</div>
</body>
</html>
