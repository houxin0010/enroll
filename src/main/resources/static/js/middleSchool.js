$('.left.fixed a').removeClass("active");
$('#middleSchoolMenu').addClass("active");
$('div.content').text("初中报名信息查询");

function resst() {
    $('form').form('clear');
}

function queryStudentInfo() {
    let $form = $('.ui.segment form');
    let allFields = $form.form('get values');
    console.log(allFields);
    let url = "/backstage/getMiddleStudentInfo";
    $.ajax({
        url: url,
        type: 'POST',
        data: allFields,
        success: function (data) {
            $('#middleStudentInfoList').html(data);
        }
    });
}

function pass() {
    let url = "/backstage/getMiddleStudentInfo";
    $.ajax({
        url: url,
        type: 'POST',
        data: allFields,
        success: function (data) {
            $('#middleStudentInfoList').html(data);
        }
    });
}
