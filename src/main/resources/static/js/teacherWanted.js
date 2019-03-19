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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        defaultValue: [2010, 1, 1],
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
        if (uploadCount + 1 > 5) {
            weui.alert('最多只能上传5张图片');
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

$('#formSubmitBtn').click(function () {
    weui.form.validate('#base_info_form', function (error) {
        if (!error) {
            var baseFormData = $('#base_info_form').serializeArray();

            console.log(baseFormData);
            let loading = weui.loading('提交中...');
            let teacherInfoVo = {
                pictureUrl: filePath,
                name: baseFormData[0].value,
                sex: baseFormData[1].value,
                nation: baseFormData[2].value,
                birthdate: baseFormData[3].value,
                idNo: baseFormData[4].value,
                politicsStatus: baseFormData[5].value,
                domicilePlace: baseFormData[6].value,
                accountProperties: baseFormData[7].value,
                maritalStatus: baseFormData[8].value,
                email: baseFormData[9].value,
                phoneNo: baseFormData[10].value,
                education: baseFormData[11].value,
                profession: baseFormData[12].value,
                englishLevel: baseFormData[13].value,
                teacherCertification: baseFormData[14].value,
                professionalTitle: baseFormData[15].value,
                applyPhaseStudying: baseFormData[16].value,
                applySubject: baseFormData[17].value
            };
            let educationExperienceVos = [{
                startTime: baseFormData[18].value,
                endTime: baseFormData[19].value,
                schoolName: baseFormData[20].value,
                education: baseFormData[21].value,
                profession: baseFormData[22].value,
                credential: baseFormData[23].value
            }, {
                startTime: baseFormData[24].value,
                endTime: baseFormData[25].value,
                schoolName: baseFormData[26].value,
                education: baseFormData[27].value,
                profession: baseFormData[28].value,
                credential: baseFormData[29].value
            }];
            let workExperienceVos = [{
                startTime: baseFormData[30].value,
                endTime: baseFormData[31].value,
                workUnit: baseFormData[32].value,
                position: baseFormData[33].value,
                certifierName: baseFormData[34].value,
                certifierPhone: baseFormData[35].value,
                reasonsResignation: baseFormData[36].value
            }, {
                startTime: baseFormData[37].value,
                endTime: baseFormData[38].value,
                workUnit: baseFormData[39].value,
                position: baseFormData[40].value,
                certifierName: baseFormData[41].value,
                certifierPhone: baseFormData[42].value,
                reasonsResignation: baseFormData[43].value
            }];
            let jobExperienceVos = [{
                jobTitle: baseFormData[44].value,
                promotionDate: baseFormData[45].value,
                promotionUnit: baseFormData[46].value,
                ratifyUnit: baseFormData[47].value
            }, {
                jobTitle: baseFormData[48].value,
                promotionDate: baseFormData[49].value,
                promotionUnit: baseFormData[50].value,
                ratifyUnit: baseFormData[51].value
            }];
            let trainingExperienceVos = [{
                startTime: baseFormData[52].value,
                endTime: baseFormData[53].value,
                trainingContent: baseFormData[54].value,
                trainingInstitution: baseFormData[55].value,
                trainingResult: baseFormData[56].value
            }, {
                startTime: baseFormData[57].value,
                endTime: baseFormData[58].value,
                trainingContent: baseFormData[59].value,
                trainingInstitution: baseFormData[60].value,
                trainingResult: baseFormData[61].value
            }];
            $.ajax({
                url: '/teacherWanted/apply',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({
                    teacherInfoVo: teacherInfoVo,
                    educationExperienceVos: educationExperienceVos,
                    workExperienceVos: workExperienceVos,
                    jobExperienceVos: jobExperienceVos,
                    trainingExperienceVos: trainingExperienceVos
                }),
                success: function (data) {
                    loading.hide();
                    weui.toast('提交成功', 3000);
                    window.location.href = "/teacherWanted/applySuccess";
                },
                error: function () {
                    loading.hide();
                    weui.toast('系统繁忙,请稍后再试!', 3000);
                    setTimeout(function () {
                        window.location.href = "/teacherWanted/index";
                    }, 2000);

                }
            });
        }
    }, {
        regexp: {
            IDNUM: /(?:^\d{15}$)|(?:^\d{18}$)|^\d{17}[\dXx]$/,
            EMAIL: /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
        }
    });
});
