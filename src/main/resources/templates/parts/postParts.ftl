
<#macro postPart list categoryFilter currentPage >
    <#list list as postList>


        <div id="alertBlock${postList.getPostId()}" class="alert alert-primary" role="alert" style="display:none;">

        </div>


          <div class="card mb-4">
            <div class="card-footer text-muted mb-1">

                <div class="btn-group-vertical">
                    <div class="col-sm-3 col-md-3 col-lg-3">
                        <div  class="input-group">
                            <button   onclick="upPost(${postList.getPostId()})" >Upvote</button>
                            <div id="counterBlock${postList.getPostId()}">
                                ${postList.getVoteCount()}
                            </div>
                                 <button   onclick="downPost(${postList.getPostId()})" >DownVote</button>
                        </div>
                    </div>
                </div>

                ${postList.transferDateTimeToString(postList.getCreatedDate())}, by
                <a href="/userPage/${postList.getUser().getId()}">${postList.getUser().getName()}</a>
                <a href="/page/${currentPage}/${postList.getCategories()}">${postList.getCategories()}</a>
                <#if  categoryFilter !="nf">
                    <a href="/page/${currentPage}/nf">cancelFilter</a>
                </#if>

            </div>
            <#if postList.getImage()!="">
                <img class="card-img-top" src="/uploads/${postList.getImage()}"  alt="Card image cap">
            </#if>
            <div class="card-body">
                <p class="card-text">${postList.getDescription()}</p>
                <a href="/postComments/${postList.getPostId()}/${postList.getCommentCount()}" class="btn btn-primary">${postList.getCommentCount()} comments</a>
            </div>
        </div>



    </#list>
</#macro>