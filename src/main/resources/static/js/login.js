$('.ui.form')
    .form({
        fields: {
            username:{
                identifier  : 'username',
                rules: [
                    {
                        type   : 'empty',
                        prompt : "{name}不能为空"
                    }
                ]
            },
            password:{
                identifier  : 'password',
                rules: [
                    {
                        type   : 'empty',
                        prompt : "{name}不能为空"
                    },
                    {
                        type   : 'minLength[6]',
                        prompt : "{name}不能小于6位"
                    }
                ]
            },
        }
    });