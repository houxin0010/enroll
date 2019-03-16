$('#birthdate').on('focus', function () {
    weui.datePicker({
        start: 1960,
        end: new Date(),
        defaultValue: [1990, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#birthdate').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'birthdate'
    });
});

$('#educationExperience_startTime1').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#educationExperience_startTime1').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'educationExperience_startTime1'
    });
});

$('#educationExperience_startTime2').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#educationExperience_startTime2').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'educationExperience_startTime2'
    });
});

$('#educationExperience_endTime1').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#educationExperience_endTime1').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'educationExperience_endTime1'
    });
});

$('#educationExperience_endTime2').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#educationExperience_endTime2').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'educationExperience_endTime2'
    });
});

$('#workExperience_startTime1').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#workExperience_startTime1').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'workExperience_startTime1'
    });
});

$('#workExperience_endTime1').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#workExperience_endTime1').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'workExperience_endTime1'
    });
});

$('#workExperience_startTime2').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#workExperience_startTime2').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'workExperience_startTime2'
    });
});

$('#workExperience_endTime2').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#workExperience_endTime2').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'workExperience_endTime2'
    });
});

$('#promotionDate1').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#promotionDate1').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'promotionDate1'
    });
});

$('#promotionDate2').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#promotionDate2').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'promotionDate2'
    });
});

$('#trainingExperience_startTime1').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#trainingExperience_startTime1').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'trainingExperience_startTime1'
    });
});

$('#trainingExperience_endTime1').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#trainingExperience_endTime1').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'trainingExperience_endTime1'
    });
});

$('#trainingExperience_startTime2').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#trainingExperience_startTime2').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'trainingExperience_startTime2'
    });
});

$('#trainingExperience_endTime2').on('focus', function () {
    weui.datePicker({
        start: 1980,
        end: new Date(),
        defaultValue: [2000, 1, 1],
        onConfirm: function (result) {
            console.log(result);
            $('#trainingExperience_endTime2').val(result[0].label + result[1].label + result[2].label);
        },
        id: 'trainingExperience_endTime2'
    });
});

let uploadCount = 0;
let filePath = "";
weui.uploader('#uploader', {
    url: '/teacherWanted/upload',
    auto: true,
    type: 'file',
    fileVal: 'file',
    compress: false,
    onBeforeQueued: function (files) {
        console.log(this, files);
        // `this` 是轮询到的文件, `files` 是所有文件
        if (["image/jpg", "image/jpeg", "image/png"].indexOf(this.type) < 0) {
            weui.alert('请上传正确图片');
            return false; // 阻止文件添加
        }
        if (this.size > 10 * 1024 * 1024) {
            weui.alert('请上传不超过10M的图片');
            return false;
        }
        if (files.length > 1) { // 防止一下子选择过多文件
            weui.alert('最多只能上传1张图片，请重新选择');
            return false;
        }
        if (uploadCount + 1 > 3) {
            weui.alert('最多只能上传3张图片');
            return false;
        }

        ++uploadCount;
    },
    onQueued: function () {
        if (uploadCount > 1) {
            $("#uploaderFiles").find("li").eq(0).remove();
        }
    },
    onSuccess: function (ret) {
        console.log(ret);
        if (ret.uploadCode === '00') {
            filePath = ret.uploadText;
        } else {
            weui.alert('图片上传失败');
        }
    },
    onError: function (err) {
        console.log(err);
        weui.alert('图片上传失败');
    }
});

