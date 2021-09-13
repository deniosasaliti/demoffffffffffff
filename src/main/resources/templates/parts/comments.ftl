<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="/css/style.css">


            <title>Title</title>
    </head>
        <body>

        <#include "navbar.ftl">
        <div class="mb-lg-5 pb-5"></div>

        <div class="container">

        <div id="alertBlock${Post.getPostId()}" class="alert alert-primary" role="alert" style="display:none;">

        </div>


        <div class="card mb-4">

            <div class="card-footer text-muted mb-1">

                <div class="btn-group-vertical">
                    <div class="col-sm-3 col-md-3 col-lg-3">
                        <div  class="input-group">
                            <button   onclick="upPost(${Post.getPostId()})" >Upvote</button>
                            <div id="counterBlock${Post.getPostId()}">
                                ${Post.getVoteCount()}
                            </div>
                            <button   onclick="downPost(${Post.getPostId()})" >DownVote</button>
                        </div>
                    </div>
                </div>

                ${Post.getCreatedDate()}, by
                <a href="/userPage/${Post.getUser().getId()}">${Post.getUser().getName()}</a>
<#--                <a href="/page/${currentPage}/${Post.getCategories()}">${Post.getCategories()}</a>-->
<#--                <#if  categoryFilter !="nf">-->
<#--                    <a href="/page/${currentPage}/nf">canselFilter</a>-->
<#--                </#if>-->

            </div>
            <#if Post.getImage()!="">
                <img class="card-img-top" src="/uploads/${Post.getImage()}"  alt="Card image cap">
            </#if>
            <div class="card-body">

                <p class="card-text">${Post.getDescription()}</p>
<#--                <a href="/postComments/${Post.getPostId()}" class="btn btn-primary">${commentsSize} comments</a>-->



            <div class="form-group">
                <label for="comment">Comment:</label>

                    <textarea id="textArea" class="form-control"  rows="5" ></textarea>


                    <button id="commentButton"  type="button" onclick="addComment(${Post.getPostId()})"   class="btn btn-primary">comment</button>




            </div>

                <div id="12311"></div>



                <div id="commentList">
                    <#if comments??>
                        <#list comments as c>
                            <div class="card mb-4">
                                <div  id="commentBlock${c.getId()}" class="card-body">
                                    ${c.getText()}
                                </div>
                            </div>
                        </#list>
                    </#if>
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
