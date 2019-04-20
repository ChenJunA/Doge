<template>
    <div class="login">
        <div class="form-wrap">
            <h2>Doge</h2>

            <Form ref="loginData" :model="loginData" :rules="ruleValidate">
                <FormItem prop="username">
                    <Input type="text" v-model="loginData.username" placeholder="用户名"></Input>
                </FormItem>

                <FormItem prop="password">
                    <Input type="password" v-model="loginData.password" placeholder="密码"></Input>
                </FormItem>

                <FormItem class="form-footer">
                    <Button style="width:100%" type="primary" @click="login('loginData')">登录</Button>
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
                username:'',
                password:''
            },
            ruleValidate: {
                username: [
                    { required: true, message: '账号不能为空', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '密码不能为空', trigger: 'blur' },
                    { type: 'string', min: 6, max: 16, message: '密码长度6-16个字符', trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        login (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    this.axios.post("http://localhost:80/login",this.loginData)
                    .then(resp => {
                        if(resp.data.status === 10002) {
                            this.$Message.error("用户不存在");
                        } else if(resp.data.status === 10003) {
                            this.$Message.error("密码错误");
                        } else {
                            this.$Message.success('登录成功！')
                            this.$router.push('/home')
                        }
                    })
                    .catch(err => {
                        this.$Message.error("请求出错");
                    });
                } else {
                    this.$Message.error('登录信息有误')
                }
            })
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
    .ivu-form-item-required .ivu-form-item-label:before {
        display: none;
    }
   
</style>