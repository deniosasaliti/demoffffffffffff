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
            url: "http://localhost:8080/addPost",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                $('#createForm')[0].reset();
                $('#exampleModal').modal('hide');
                $('.modal-backdrop').remove();
                $("#result").text(data);
                console.log("SUCCESS : ", data);
                $("#btnSubmit").prop("disabled", false);

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
        url: 'http://localhost:8080/postUp',

    });
}