<template>
    <div class="register">
        <div class="form-wrap">
            <router-view></router-view>
            <h2>Doge</h2>

            <Form ref="registerData" :model="registerData" :rules="ruleValidate">
                <FormItem prop="acct">
                    <Input type="text" v-model="registerData.acct" placeholder="邮箱"></Input>
                </FormItem>

                <FormItem prop="pass">
                    <Input type="password" v-model="registerData.pass" placeholder="密码"></Input>
                </FormItem>

                <FormItem class="form-footer">
                    <Button type="primary" @click="handleSubmit('registerData')">注册</Button>
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
        return {
            registerData: {
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
        },
        handleReset (name) {
            this.$refs[name].resetFields();
        },
        login(){
            this.$router.push('/login')
        }
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
    button{
        width: 100%;
    }
    .ivu-form-item-required .ivu-form-item-label:before {
        display: none;
    }
   
</style>