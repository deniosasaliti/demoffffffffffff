<#macro PostPage currentPage totalPages categoryFilter >
    <!Doctype html>
    <html lang="en">
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="/css/style.css">






        <title>ss</title>


    </head>
    <body>

<#include "navbar.ftl">


<div class="d-flex flex-column" style="min-height: 100vh;">
    <header></header>
    <div class="container flex-grow-1">
        <div class="mb-lg-5 pb-5"></div>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <!-- Blog Entries Column -->
                <div id="startPostBlock" class="col-md-8">


                <div id="globalPostBlock">
                    <#nested>
                </div>


                    <!-- Pagination -->
                    <div id="Pagination" >

                        <#if  currentPage <= 0>
                                <#assign minElement = 1/>
                                <#assign maxElement = 2/>
                            <#else >
                                <#assign minElement = currentPage-3/>
                                <#assign maxElement = currentPage+3/>
                        </#if>

                        <#if totalPages gte 2>
                            <#if minElement <= 2 >
                                <#assign minElement = 2/>
                            </#if>
                        </#if>


<#--                        gte -it means sign ">="-->

                            <#if maxElement gte totalPages >
                                <#assign maxElement = totalPages-1/>

                            </#if>




                        <#assign pag = minElement..maxElement/>





                    </div>


                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">


                            <#if currentPage = 0>
                            <li class="page-item  disabled">
                            <a class="page-link" href="/page/${currentPage-1}/${categoryFilter}">Previous</a>
                        <#else>
                            <li class="page-item ">
                                <a class="page-link" href="/page/${currentPage-1}/${categoryFilter}">Previous</a>
                                </#if>

                            </li>


                            <#if pag[0]-2=currentPage >
                                <li class="page-item active"><a class="page-link" href="/page/${0}/${categoryFilter}">${1}</a></li>
                            <#else >
                                <li class="page-item "><a class="page-link" href="/page/${0}/${categoryFilter}">${1}</a></li>

                            </#if>

<#--########################################################################################-->
                            <#if totalPages gte 3 >
                                <#list pag  as p>

                                    <#if p-1=currentPage >

                                        <li class="page-item active"><a class="page-link" href="/page/${p-1}/${categoryFilter}">${p}</a></li>
                                    <#else >
                                        <li class="page-item "><a class="page-link" href="/page/${p-1}/${categoryFilter}">${p}</a></li>

                                    </#if>

                                </#list>
                            </#if>

<#--#####################################################################################-->
                            <#if totalPages gte 2 >
                                <#if totalPages-1 = currentPage  >
                                <li class="page-item active"><a class="page-link" href="/page/${totalPages-1}/${categoryFilter}">${totalPages}</a></li>
                            <#else >
                                <li class="page-item "><a class="page-link" href="/page/${totalPages-1}/${categoryFilter}">${totalPages}</a></li>

                            </#if>
                            </#if>




                            <#if  currentPage+1  < totalPages>
                            <li class="page-item">
                                <a class="page-link" href="/page/${currentPage+1}/${categoryFilter}">Next</a>
                                <#else>
                            <li class="page-item disabled">
                                <a class="page-link" href="/page/${currentPage}/${categoryFilter}">Next</a>
                                </#if>


                            </li>
                        </ul>
                    </nav>
                </div>

                <!-- Sidebar Widgets Column -->
                <div class="col-md-4">

                    <!-- Categories Widget -->
                    <div class="card  py-5 sticky-top ">
                        <h5 class="card-header  ">Categories</h5>
                        <div class="card-body ">

                            <div class="row">
                                <div class="col-lg-6">
                                    <ul class="list-unstyled mb-0">
                                        <li>
                                            <a href="/page/${currentPage}/GOODNESS">ДОБРО</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-lg-6">
                                    <ul class="list-unstyled mb-0">
                                        <li>
                                            <a href="/page/${currentPage}/EVIL">ЗЛО</a>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>



            </div>


            <!-- /.row -->

        </div>
    </div>
    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
        </div>
        <!-- /.container -->
    </footer>
</div>


<script src="/js/main.js" crossorigin="anonymous"></script>
<script src="/js/test.js" crossorigin="anonymous"></script>

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>



    </body>
</html>
</#macro>
