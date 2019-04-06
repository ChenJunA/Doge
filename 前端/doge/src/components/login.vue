<template>
    <div class="login">
        <div class="form-wrap">
            <h2>Doge</h2>

            <Form ref="loginData" :model="loginData" :rules="ruleValidate">
                <FormItem prop="acct">
                    <Input type="text" v-model="loginData.acct" placeholder="用户名或邮箱"></Input>
                </FormItem>

                <FormItem prop="pass">
                    <Input type="password" v-model="loginData.pass" placeholder="密码"></Input>
                </FormItem>

                <FormItem class="form-footer">
                    <Button type="primary" @click="handleSubmit('loginData')">登录</Button>
                </FormItem>
            </Form>

            <Divider />
            <div class="form-wrap-footer">
                没有账号？
                <a>
                    <router-link :to="{name: 'register'}">
                        注册
                    </router-link>
                </a>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
            loginData: {
                acct:'',
                pass:''
            },
            ruleValidate: {
                acct: [
                    { required: true, message: '账号不能为空', trigger: 'blur' },
                    { min: 3, max: 16, message: '账号长度3-16个字符', trigger: 'blur' }
                ],
                pass: [
                    { required: true, message: '密码不能为空', trigger: 'blur' },
                    { type: 'string', min: 6, max: 16, message: '密码长度6-16个字符', trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        handleSubmit (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                this.$Message.success('提交成功!')
                } else {
                this.$Message.error('表单验证失败!')
                }
            })
            this.$router.push('/home')
        },
        handleReset (name) {
            this.$refs[name].resetFields();
        },
        register(){
            this.$router.push('/register')
        }
    }
}
</script>

<style>
    .login .form-wrap{
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
    .login h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    .login FormItem {
        margin-bottom: 15px;
    }
    .login .form-footer {
        text-align: center;
    }
    .form-wrap-footer{
        text-align: center;
        font-size: 16px;
        display: block;
        margin-top: -15px;
    }
    button{
        width: 100%;
    }
    .ivu-form-item-required .ivu-form-item-label:before {
        display: none;
    }
   
</style>