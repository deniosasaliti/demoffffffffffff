<#import "parts/comon.ftl" as c>
<#import "parts/signup.ftl" as signup>


<@c.page>

    <#if user?? && noError??>

        <div class="text-xl-center">
            <h3>регистрация прошла успешно</h3>
        </div>



<#else>
    <@signup.signup/>

    </#if>
</@c.page>