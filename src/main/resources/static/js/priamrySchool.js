$('.left.fixed a').removeClass("active");
$('.left.fixed a:first').addClass("active");

function resst() {
    $('form').form('clear');
}

function queryStudentInfo() {
    let $form = $('.ui.segment form');
    let allFields = $form.form('get values');
    console.log(allFields);
    let url = "/backstage/primary/getPrimaryStudentInfo";
    $.ajax({
        url: url,
        type: 'POST',
        data: allFields,
        success: function (data) {
            $('#primaryStudentInfoList').html(data);
        }
    });
}
