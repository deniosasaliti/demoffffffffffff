<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<H1>

    <p>
        <select name="action">
            <#list person.actions as actions,value>
                <option value="${actions}">${value}</option>

            </#list>
        </select>
    </p>






</H1>

</body>
</html>