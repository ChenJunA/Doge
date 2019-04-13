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
                        <div class="user_information_right">
                            <div style="margin-top:100px">
                                <h1 style="padding-bottom: 15px;">用户名</h1>
                                <Input class="informationInput" v-model="value1" size="large" placeholder="用户名" />
                            </div>
                            <Divider />
                            <div>
                                <h1 style="padding-bottom: 15px;">性别</h1>
                                <Input v-model="value1" size="large" placeholder="large size" />
                            </div>
                            <Divider />
                            <div>
                                <h1 style="padding-bottom: 15px;">一句话介绍</h1>
                                <Input v-model="value1" size="large" placeholder="large size" />
                            </div>
                            <Divider />
                            <div>
                                <h1 style="padding-bottom: 15px;">地址</h1>
                                <Input v-model="value1" size="large" placeholder="large size" />
                            </div>
                            <Divider />
                            <div>
                                <Button type="primary">保存</Button>
                            </div>
                        </div>
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
        components:{
            'dogeCard': dogeCard,
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