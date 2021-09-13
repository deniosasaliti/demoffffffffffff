
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="/css/style.css">

    <!------ Include the above in your HEAD tag ---------->

</head>





<body>

<#include "parts/navbar.ftl">
<div class="mb-lg-5 pb-5"></div>

<div class="container ">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>User Profile</h4>
            </div>
            <div class="panel-body">
                <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                    <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive">


                </div>
                <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8" >

                    <div class="container" >
                        <h2>${user1.getName()}</h2>
                    </div>


                    <div>
                    <hr>
                    <ul class="container details" >
                        <li><p><span class="glyphicon glyphicon-envelope one" style="width:50px;"></span>${user1.getEmail()}</p></li>
                    </ul>
                    <hr>

                </div>
            </div>
        </div>
    </div>
    </div>
</div>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="/js/main.js" crossorigin="anonymous"></script>
<script src="/js/test.js" crossorigin="anonymous"></script>

</body>
</html>