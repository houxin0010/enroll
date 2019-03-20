$('.left.fixed a').removeClass("active");
$('#teacherSchoolMenu').addClass("active");
$('#topTip').text("教师报名信息查询");
function resst() {
    $('form').form('clear');
}

function queryTeacherApplyInfo(page) {
    let $form = $('.ui.segment form');
    let allFields = $form.form('get values');
    allFields.page = page;
    allFields.size = 10;
    console.log(allFields);
    let url = "/backstage/teacher/getTeacherApplyInfo";
    $.ajax({
        url: url,
        type: 'POST',
        data: allFields,
        success: function (data) {
            $('#teacherApplyInfoList').html(data);
        }
    });
}

function getTeacherDetail(id) {
    $('.long.modal') .modal('show');
    let url = "/backstage/teacher/detail";
    $.ajax({
        url: url,
        type: 'POST',
        data: {id:id},
        success: function (data) {
            console.log(data)
            $('#teacherApplyDetailResult').html(data);


        }
    });
}
