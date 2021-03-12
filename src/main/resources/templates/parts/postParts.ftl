<#macro postPart list>
    <#list list as postList>
        <!-- Latest compiled and minified CSS -->


          <div class="card mb-4">
            <div class="card-footer text-muted mb-1">

                <div class="btn-group-vertical">
                    <div class="col-sm-3 col-md-3 col-lg-3">
                        <div class="input-group">



                                <button class="glyphicon-arrow-up"  onclick="upPost(${postList.getPostId()})" >Upvote</button>




                            <button type="button"
                                    id="testBtnDown"
                                    class="btn btn-success glyphicon glyphicon-thumbs-down" data-loading-text=" ... ">
                               -</button>
                        </div>
                    </div>
                </div>


                Posted on January 1, 2020 by
                <a href="#">Start Bootstrap</a>
            </div>
            <#if postList.getImage()!="">
                <img class="card-img-top" src="/uploads/${postList.getImage()}"  alt="Card image cap">
            </#if>
            <div class="card-body">

                <p class="card-text">${postList.getDescription()}</p>
                <a href="#" class="btn btn-primary">Read More &rarr;</a>
            </div>
        </div>

    </#list>
</#macro>