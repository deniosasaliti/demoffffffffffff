<#import "springBind.ftl" as spring />
<#macro signup >

    <div class="pt-5 ">



        <form action="/validationForm" method="post">



            <div class="form-group row">
                <label class="col-sm-2 col-form-label">User Name :</label>
                <div class="col-sm-6">
            <@spring.formInput "user.name","form-control","Name"/>
                </div>

                <div class="col-sm-2">
            <@spring.showErrors "<br>","color: #d87d56"/>
                </div>

            </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Email :</label>
                    <div class="col-sm-6">
            <@spring.formInput "user.email","form-control","Email"/>
                    </div>

                    <div class="col-sm-2">
                        <@spring.showErrors "<br>","color: #d87d56"/>
                    </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Password :</label>
                        <div class="col-sm-6">
            <@spring.formInput "user.password","form-control","Password"/>
                        </div>

                        <div class="col-sm-2">
                            <@spring.showErrors "<br>","color: #d87d56"/>
                        </div>
                    </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>


</#macro>