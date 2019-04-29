<template>
    <Layout>
        <Content>
            <div class="user_content">
                <div class="Card">
                    <div class="UserCoverEditor">
                        <div class="userCover">
                            <img class="userCover-image" src="../assets/avatar.png"/>
                        </div>
                    </div>
                     
                    <div class="updateUser_information">
                        <div class="user_information_left">
                            <div>
                                <Avatar shape="square" src="https://i.loli.net/2017/08/21/599a521472424.jpg" style="width:160px; height:160px"/>
                            </div>
                        </div>

                        <Form ref="updateData" :model="updateData">
                            <div class="user_information_right">
                                <div style="margin-top:100px">
                                    <h1 style="padding-bottom: 15px;">用户名</h1>
                                    <FormItem prop="username">
                                        <Input class="informationInput" v-model="updateData.username" size="large" :placeholder="user.username" />
                                    </FormItem>
                                </div>
                                <Divider />
                                <div>
                                    <h1 style="padding-bottom: 15px;">性别</h1>
                                    <FormItem prop="sex">
                                        <Input v-model="updateData.sex" size="large" :placeholder="user.sex" />
                                    </FormItem>
                                </div>
                                <Divider />
                                <div>
                                    <h1 style="padding-bottom: 15px;">电话号码</h1>
                                    <FormItem prop="phoneNumber">
                                        <Input v-model="updateData.phoneNumber" size="large" :placeholder="user.phoneNumber" />
                                    </FormItem>
                                </div>
                                <Divider />
                                <div>
                                    <h1 style="padding-bottom: 15px;">一句话介绍</h1>
                                    <FormItem prop="biography">
                                        <Input v-model="updateData.biography" size="large" :placeholder="user.biography" />
                                    </FormItem>
                                </div>
                                <Divider />
                                <div>
                                    <h1 style="padding-bottom: 15px;">地址</h1>
                                    <FormItem prop="address">
                                        <Input v-model="updateData.address" size="large" :placeholder="user.address" />
                                    </FormItem>
                                </div>
                                <Divider />
                                <div>
                                    <Button type="primary" @click="updateUser()">保存</Button>
                                </div>
                            </div>
                        </Form>
                    </div>
                </div>
               
            </div>
        </Content>
    </Layout>
</template>

<script>
import dogeCard from '@/components/dogeCard' //引入dogeCard组件
    export default {
        name: "userPageContent",
        data () {
            return {
                updateData: {
                    id: this.$store.state.user.id,
                    username: this.$store.state.user.username,
                    sex: this.$store.state.user.sex,
                    biography:  this.$store.state.user.biography,
                    address: this.$store.state.user.address,
                    phoneNumber:this.$store.state.user.phoneNumber
                },
            }
        },
        computed: {
            user () {
                return this.$store.state.user
            }
        },
        components:{
            'dogeCard': dogeCard,
        },
        methods: {
            updateUser(){
                this.axios.put("http://localhost:80/updateUser",this.updateData)
                .then(resp => {
                    if(resp.data.status === 200){
                        this.$Message.success("修改成功！");
                        this.$store.dispatch('login', resp.data.data)
                        this.$router.push('/userPage')
                    }
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            }
        }
    }
</script>

<style>
    .user_content {
        margin: auto;
        margin-top: 10px;
        width: 70%;
    }
   
    .userCover{
        border-top-right-radius: 1px;
        border-top-left-radius: 1px;
    }
    .userCover-image{
        width:100%; 
        height: 240px;
        object-fit: cover;
    }
    .Card {
        background: #fff;
        overflow: hidden;
        border-radius: 2px;
        box-sizing: border-box;
    }
    .UserCoverEditor {
        position: relative;
    }

    .updateUser_information {
        height: 650px;
    }
    .user_information_left {
        width: 20%;
        text-align: center;
        margin-top: -25px;
        float: left;
    }
    .user_information_right {
        width: 70%;
        float: right;
        margin-right: 50px
    }
</style>