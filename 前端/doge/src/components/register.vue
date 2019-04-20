<template>
    <div class="register">
        <div class="form-wrap">
            <router-view></router-view>
            <h2>Doge</h2>

            <Form ref="registerData" :model="registerData" :rules="ruleValidate">
                <FormItem prop="email">
                    <Input type="text" v-model="registerData.email" placeholder="邮箱"></Input> 
                </FormItem>

                <FormItem prop="password">
                    <Input type="password" v-model="registerData.password" placeholder="密码"></Input>
                </FormItem>

                <FormItem class="form-footer">
                    <Button style="width:100%" type="primary" @click="register('registerData')">注册</Button>
                </FormItem>
            </Form>

            <Divider />
            <div class="form-wrap-footer">
                已有账号？
                <a>
                    <router-link :to="{name: 'login'}">
                        登录
                    </router-link>
                </a>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        var emailValidator = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('账号不能为空'));
            } else {
                 this.axios.get("http://localhost:80/findByEmail",{
                     params: {
                         email:this.registerData.email
                     }
                 })
                .then(resp => {
                    if (resp.data.status === 10001) {
                        callback(new Error('该邮箱已被注册'));
                    } else {
                        if (value !== '') { 
                            var reg=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                            if(!reg.test(value)){
                                callback(new Error('邮箱格式错误'));
                            }
                        }
                        callback();
                    }
                })
                .catch(err => {
                    callback(new Error('请求出错'));
                });
            }
        };

        return {
            registerData: {
                email:'',
                password:'',
            },
            ruleValidate: {
                email: [
                    { required: true, message: '账号不能为空', trigger: 'blur' },
                    { validator: emailValidator, trigger: 'blur'}
                ],
                password: [
                    { required: true, message: '密码不能为空', trigger: 'blur' },
                    { type: 'string', min: 6, max: 16, message: '密码长度6-16个字符', trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        register (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    this.axios.post("http://localhost:80/register",this.registerData)
                    .then(resp => {
                        this.$Message.success("注册成功，激活后即可登录");
                    })
                    .catch(err => {
                        this.$Message.error(err.data.message);
                    });
                } else {
                    this.$Message.error('注册信息有误！')
                }
            })
        },
    }
}
</script>

<style>
    .register .form-wrap{
        position: fixed;
        left: 50%;
        margin-left: -200px;
        top: 50%;
        margin-top: -150px;
        width: 400px;
        height: 280px;
        border-radius: 10px;
        background-color: #fff;
        padding: 20px 30px;
    }
    .register h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    .register FormItem {
        margin-bottom: 15px;
    }
    .register .form-footer {
        text-align: center;
    }
    .form-wrap-footer{
        display: block;
        text-align: center;
        font-size: 16px;
        margin-top: -15px;
    }
    .ivu-form-item-required .ivu-form-item-label:before {
        display: none;
    }
   
</style>