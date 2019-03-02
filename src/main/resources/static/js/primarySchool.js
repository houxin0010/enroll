$('.left.fixed a').removeClass("active");
$('.left.fixed a:first').addClass("active");

$('select.dropdown').dropdown();

$("div.calendar").calendar({
    type: 'date',
    formatter: { // 自定义日期的格式
        date: function (date, settings) {
            if (!date) return '';
            let year = date.getFullYear();
            let month = date.getMonth() + 1;
            let day = date.getDate();

            month = month < 10 ? '0' + month : month;
            day = day < 10 ? '0' + day : day;

            return year + '-' + month + '-' + day;
        }
    }
});

function resst() {
    $('form').form('clear');
}

function queryStudentInfo() {
    let $form = $('.ui.segment form');
    let allFields = $form.form('get values');
    console.log(allFields);
    let url = "/backstage/getPrimaryStudentInfo";
    $.ajax({
        url: url,
        type: 'POST',
        data: allFields,
        success: function (data) {
            $('#primaryStudentInfoList').html(data);
        }
    });

}
