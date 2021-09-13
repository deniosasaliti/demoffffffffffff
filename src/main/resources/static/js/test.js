$(document).ready(function () {



    $("#submit_1").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        // Get form
        var form = $('#createForm')[0];

        // Create an FormData object
        var data = new FormData(form);

        // If you want to add an extra field for the FormData
        data.append("CustomField", "This is some extra data, testing");

        // disabled the submit button
        $("#btnSubmit").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "http://localhost:5000/addPost",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (result) {
                $('#createForm')[0].reset();
                $('.modal-backdrop').remove();
                $('#exampleModal').modal('hide');
                // $("#result").text(data);
                // console.log("SUCCESS : ", data);
                // $("#btnSubmit").prop("disabled", false);




                $("#globalPostBlock").before("<div id=\"globalPostBlock\">\n" +
                    "        <div id=\"alertBlock"+result.postId+"\" class=\"alert alert-primary\" role=\"alert\" style=\"display:none;\">\n" +
                    "\n" +
                    "        </div>\n" +
                    "\n" +
                    "\n" +
                    "          <div class=\"card mb-4\">\n" +
                    "            <div class=\"card-footer text-muted mb-1\">\n" +
                    "\n" +
                    "                <div class=\"btn-group-vertical\">\n" +
                    "                    <div class=\"col-sm-3 col-md-3 col-lg-3\">\n" +
                    "                        <div  class=\"input-group\">\n" +
                    "                            <button   onclick=\"upPost("+result.postId+")\" >Upvote</button>\n" +
                    "                            <div id=\"counterBlock"+result.postId+"\">\n" +
                    "                               0" +
                    "                            </div>\n" +
                    "                                 <button   onclick=\"downPost("+result.postId+")\" >DownVote</button>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "               "+result.createdDate+"\n" +
                    "                <a href=\"/userPage/"+result.userId+"\">"+result.userName+"</a>\n" +
                    "                <a href=\"/page/"+result.category+"\">"+result.category+"</a>\n" +
                    "                \n" +
                    "                    <a id='filter1' href=\"/page/nf\">canselFilter</a>\n" +
                    "                \n" +
                    "\n" +
                    "            </div>\n" +
                    "          \n" +
                    "                <img id='image1' class=\"card-img-top\" src=\"/uploads/"+result.image+"\"  alt=\"Card image cap\">\n" +
                    "           \n" +
                    "            <div class=\"card-body\">\n" +
                    "                <p class=\"card-text\">"+result.description+"</p>\n" +
                    "                <a href=\"/postComments/"+result.postId+"/0\" class=\"btn btn-primary\">0 comments</a>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>");
                var image = document.getElementById("image1");
                if (result.image !==""){
                    image.style.display = 'block';
                }
                var filterOn = document.getElementById("filter1");
                if (result.filter){
                    filterOn.style.display = 'block'
                }

            },
            error: function (e) {

                $("#result").text(e.responseText);
                console.log("ERROR : ", e);
                $("#btnSubmit").prop("disabled", false);

            }
        });

    });

});


function upPost(id){

    let formData = {
        id: id
    };

    $.ajax({

        contentType : "application/json",
        data : JSON.stringify(formData),
        dataType : 'json',
        method: 'POST',
        url: 'http://localhost:5000/postUp',
        success : function (result, status, xhr) {

                $("#counterBlock" + id).html(
                    result.voteCount);





        },
        error: function (xhr, result, status) {


            let parsedJson = JSON.parse(xhr.responseText);

            $('#alertBlock' + id).show(100);
            $("#alertBlock" + id).html(
                parsedJson.errorMessage);

            setTimeout(function() {
                $('#alertBlock' + id).hide(100);
            }, 3000);



        }



    });
}

function downPost(id){

    let formData = {
        id: id
    };
    $.ajax({

        contentType : "application/json",
        data : JSON.stringify(formData),
        dataType : 'json',
        method: 'POST',
        url: 'http://localhost:5000/postDown',
        success : function (result) {


            $("#counterBlock" + id).html(
                 result.voteCount);

        },
        error: function (xhr, result, status) {


            let parsedJson = JSON.parse(xhr.responseText);

            $('#alertBlock' + id).show(100);
            $("#alertBlock" + id).html(
                parsedJson.errorMessage);

            setTimeout(function() {
                $('#alertBlock' + id).hide(100);
            }, 3000);



        }



    });
}

    $('#commentButton').attr('disabled', true);

    $('#textArea').on('keyup',function() {
        const textarea_value = $("#textArea").val();


        if(textarea_value !== "") {
            $('#commentButton').attr('disabled', false);
        } else {
            $('#commentButton').attr('disabled', true);
        }
    });





function addComment(id) {

    let text = $("#textArea").val();


    let formData = {
        id: id,
        text: text

    };


    $.ajax({

        contentType: "application/json",
        data: JSON.stringify(formData),
        dataType: 'json',
        method: 'POST',
        url: 'http://localhost:5000/addComment',
        success: function (result) {

            let counter = parseInt(window.location.href[window.location.href.length-1])
          let myCurrentUrl  = window.location.href;
            myCurrentUrl = myCurrentUrl.slice(0, myCurrentUrl.length-1) + ++counter

                history.pushState("state", "title",myCurrentUrl)


            $("#commentList").before("<div class=\"card mb-4\">\n" +
                "                                <div   class=\"card-body\">\n" +
                                                    text + "\n" +
                "                                </div>\n" +
                "                            </div>");

            document.getElementById('textArea').value = "";
            $('#commentButton').attr('disabled', true);

        },
        error: function (xhr, result, status) {


        }


    });
}


function addPost(id) {

    let formData = {
        id: id,
    };

    $.ajax({

        contentType: "application/json",
        data: JSON.stringify(formData),
        dataType: 'json',
        method: 'POST',
        url: 'http://localhost:5000/addPost',
        success: function (result) {

            $("#Pagination").before("<div> <h1>ok</h1> </div>");



        },
        error: function (xhr, result, status) {


        }


    });
}





