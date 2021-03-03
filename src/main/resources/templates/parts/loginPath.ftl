<#macro lofin path error>

    <div>
    <form action=${path} method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User Name :</label>
            <div class="col-sm-6">
                <input type="text"  name="name" class="form-control" placeholder="User name"/>
            </div>
            <#if error>
                <div class="col-sm-2">
                    <span style="color: #ff0000">bad credentials</span>
                </div>
            </#if>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Password" />
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
        </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <button class="btn btn-primary" type="submit">Log Out</button>
    </form>

</#macro>

<#macro login>
    <form action="/login" method="get">
        <button class="btn btn-primary" type="submit">Log In</button>
    </form>
</#macro>

<#macro signup>
    <form action="/signup" method="get">
        <button class="btn btn-primary" type="submit">Sign up</button>
    </form>
</#macro>

