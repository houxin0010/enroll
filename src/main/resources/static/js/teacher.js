$('.left.fixed a').removeClass("active");
$('#teacherSchoolMenu').addClass("active");
$('#topTip').text("教师报名信息查询");
function resst() {
    $('form').form('clear');
}

function queryTeacherApplyInfo() {
    let $form = $('.ui.segment form');
    let allFields = $form.form('get values');
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
