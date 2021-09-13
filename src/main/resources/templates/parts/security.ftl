<#assign aut = SPRING_SECURITY_CONTEXT??/>
<#if aut>

    <#assign

        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getName()

    />

    <#else>

    <#assign

        name = "Гость"


    />


</#if>