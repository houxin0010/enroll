$('.left.fixed a').removeClass("active");
$('#middleSchoolMenu').addClass("active");
$('#topTip').text("初中报名信息查询");

function resst() {
    $('form').form('clear');
}

function queryStudentInfo(page) {
    let $form = $('.ui.segment form');
    let allFields = $form.form('get values');
    allFields.page = page;
    allFields.size = 10;
    console.log(allFields);
    let url = "/backstage/middle/getMiddleStudentInfo";
    $.ajax({
        url: url,
        type: 'POST',
        data: allFields,
        success: function (data) {
            $('#middleStudentInfoList').html(data);
        }
    });
}
function  findDetail(id) {

    $('.long.modal') .modal('show');
    let url = "/backstage/middle/student/detail";
    $.ajax({
        url: url,
        type: 'POST',
        data: {id:id},
        success: function (data) {
            $('#studentInfoDetailResult').html(data);
        }
    });
}
