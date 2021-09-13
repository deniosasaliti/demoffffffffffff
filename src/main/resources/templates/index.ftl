<#import "parts/PostPage.ftl" as post>
<#import "parts/postParts.ftl" as postParts>





<@post.PostPage currentPage totalPages categoryFilter  >
    <@postParts.postPart list categoryFilter currentPage >
    </@postParts.postPart>
</@post.PostPage>





