$('#birthdate').on('focus', function () {
    weui.datePicker({
        start: 1999,
        end: new Date(),
        defaultValue: [2012, 1, 1],
        onConfirm: function (result) {
            $('#birthdate').val(result[0].label.replace("年", "-") + result[1].label.replace("月", "-") + result[2].label.replace("日", ""));
        },
        id: 'birthdate'
    });
});

$('#domicile_place').on('focus', function () {
    weui.picker([
        {
            label: '北京市',
            value: 0,
            children: [
                {
                    label: '东城区',
                    value: 0
                },
                {
                    label: '西城区',
                    value: 2
                },
                {
                    label: '朝阳区',
                    value: 3
                },
                {
                    label: '丰台区',
                    value: 4
                },
                {
                    label: '石景山区',
                    value: 5
                },
                {
                    label: '海淀区',
                    value: 6
                },
                {
                    label: '门头沟区',
                    value: 7
                },
                {
                    label: '房山区',
                    value: 8
                },
                {
                    label: '通州区',
                    value: 9
                },
                {
                    label: '顺义区',
                    value: 10
                },
                {
                    label: '昌平区',
                    value: 11
                },
                {
                    label: '大兴区',
                    value: 12
                },
                {
                    label: '怀柔区',
                    value: 13
                },
                {
                    label: '平谷区',
                    value: 14
                },
                {
                    label: '密云区',
                    value: 15
                },
                {
                    label: '延庆区',
                    value: 16
                }
            ]
        },
        {
            label: '其他',
            value: 1,
            children: [
                {
                    label: '北京市',
                    value: 0,
                    disabled: true // 不可用
                },
                {
                    label: '天津市',
                    value: 1
                },
                {
                    label: '上海市',
                    value: 2
                },
                {
                    label: '重庆市',
                    value: 3
                },
                {
                    label: '河北省',
                    value: 4
                },
                {
                    label: '山西省',
                    value: 5
                },
                {
                    label: '辽宁省',
                    value: 6
                },
                {
                    label: '吉林省',
                    value: 7
                },
                {
                    label: '黑龙江省',
                    value: 8
                },
                {
                    label: '江苏省',
                    value: 9
                },
                {
                    label: '浙江省',
                    value: 10
                },
                {
                    label: '安徽省',
                    value: 11
                },
                {
                    label: '福建省',
                    value: 12
                },
                {
                    label: '江西省',
                    value: 13
                },
                {
                    label: '山东省',
                    value: 14
                },
                {
                    label: '河南省',
                    value: 15
                },
                {
                    label: '湖北省',
                    value: 16
                },
                {
                    label: '湖南省',
                    value: 17
                },
                {
                    label: '广东省',
                    value: 18
                },
                {
                    label: '海南省',
                    value: 19
                },
                {
                    label: '四川省',
                    value: 20
                },
                {
                    label: '贵州省',
                    value: 21
                },
                {
                    label: '云南省',
                    value: 22
                },
                {
                    label: '陕西省',
                    value: 23
                },
                {
                    label: '甘肃省',
                    value: 24
                },
                {
                    label: '青海省',
                    value: 25
                },
                {
                    label: '台湾省',
                    value: 26
                },
                {
                    label: '内蒙古自治区',
                    value: 27
                },
                {
                    label: '广西壮族自治区',
                    value: 28
                },
                {
                    label: '西藏自治区',
                    value: 29
                },
                {
                    label: '宁夏回族自治区',
                    value: 30
                },
                {
                    label: '新疆维吾尔自治区',
                    value: 31
                },
                {
                    label: '香港特别行政区',
                    value: 32
                },
                {
                    label: '澳门特别行政区',
                    value: 33
                }
            ]
        }
    ], {
        className: 'custom-classname',
        container: 'body',
        defaultValue: [0, 0],
        onChange: function (result) {
            console.log(result)
        },
        onConfirm: function (result) {
            $('#domicile_place').val(result[0].label + "-" + result[1].label);
        },
        id: 'doubleLinePicker'
    });
});

$('#formSubmitBtn').click(function () {
    weui.form.validate('#base_info_form', function (error) {
        if (!error) {
            var fatherFormData = $('#father_info_form').serializeArray();
            var motherFormData = $('#mother_info_form').serializeArray();
            var baseFormData = $('#base_info_form').serializeArray();

            console.log(baseFormData, fatherFormData, motherFormData);
            if (fatherFormData.length === 0 && motherFormData.length===0) {
                weui.topTips('请至少填写一位家庭成员信息', 3000);
            }
            // weui.form.validate('#father_info_form', function (error) {
            //
            // });
            // let loading = weui.loading('提交中...');
            // setTimeout(function () {
            //     loading.hide();
            //     weui.toast('提交成功', 3000);
            // }, 1500);
        }
        // return true; // 当return true时，不会显示错误
    });
});

