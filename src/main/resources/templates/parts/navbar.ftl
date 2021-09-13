<#include "security.ftl">
<#import "loginPath.ftl" as l>
<#import "createPost.ftl" as p>


<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top ">
    <a class="navbar-brand" href="/">Вжух_сук</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">


            <#if aut>
            <li class="nav-item">
                <div class="mr-1">
                    <@p.createPost>

                    </@p.createPost>
                </div>
            </li>
            </#if>

        </ul>



        <div class="navbar-text mr-3" >${name}</div>
        <#if aut>
        <div class="mr-1">
        <@l.logout/>
        </div>
            <#else>
                <div class="mr-1">
            <@l.signup/>
                </div>
                <div class="mr-1">
            <@l.login/>
                </div>

        </#if>


    </div>
</nav>
