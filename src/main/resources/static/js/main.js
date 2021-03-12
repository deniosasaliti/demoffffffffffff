
var counter = function(){
    var con = 0;
    var  btn = $('#testBtnDown');
    btn.button('loading');



    return function(){
        setTimeout(function(){
            con--;
            btn.button('reset');
            btn.text('  ' + con);
        },0);
    }
}

$('#testBtnDown').click(counter());