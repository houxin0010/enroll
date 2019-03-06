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

function updateStatus(id) {
    let url = "/backstage/updateStatus";
    $('.basic.modal')
        .modal({
            onDeny: function () {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {
                        id: id,
                        status: 'REJECT'
                    },
                    success: function (data) {
                        $('.mini.modal').modal('show');
                    }
                });
            },
            onApprove: function () {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {
                        id: id,
                        status: 'PASSED'
                    },
                    success: function (data) {
                        $('.mini.modal').modal('show');
                    }
                });
            }
        })
        .modal('show');
}
function updateTeacherStatus(id) {
    let url = "/backstage/updateTeacherStatus";
    $('.basic.modal')
        .modal({
            onDeny: function () {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {
                        id: id,
                        status: 'REJECT'
                    },
                    success: function (data) {
                        $('.mini.modal').modal('show');
                    }
                });
            },
            onApprove: function () {
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {
                        id: id,
                        status: 'PASSED'
                    },
                    success: function (data) {
                        $('.mini.modal').modal('show');
                    }
                });
            }
        })
        .modal('show');
}

