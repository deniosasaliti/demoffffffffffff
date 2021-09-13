<#import "textArea.ftl" as textArea>
<#macro createPost>

    <div>
    <button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"  data-whatever="@mdo">create post</button>


    <div class="modal fade " id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form  id="createForm" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">description:</label>
                            <input type="text" class="form-control" name="description">
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">categories:</label>
                            <select class="form-control" id="exampleFormControlSelect1" name="categories">
                                <option>GOODNESS</option>
                                <option>EVIL</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">FileName:</label>
                            <input type="file" class="form-control" name="file"  >
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Message:</label>
                        <@textArea.textArea></@textArea.textArea>
                        </div>
                        <div class="modal-footer">
                            <button id="CloseModal" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button  id="submit_1" type="button"   class="btn btn-primary">create post</button>
                        </div>
                    </form>


                </div>

            </div>
        </div>
    </div>
    </div>
</#macro>