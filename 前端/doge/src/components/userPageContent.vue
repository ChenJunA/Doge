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
                     
                    <div class="user_information">
                        <div class="user_information_left">
                            <div>
                                <Avatar shape="square" src="https://i.loli.net/2017/08/21/599a521472424.jpg" style="width:160px; height:160px"/>
                            </div>
                        </div>
                        <div class="user_information_right">
                            <div style="width: 400px; float:left">
                                <div>
                                    <span style="font-weight:bold; font-size:24px">用户名</span>
                                </div>
                                <Divider style="margin:10px 0"/>
                                <div>
                                    <span style="font-size:16px">电话号码：123456789</span></br>
                                    <span style="font-size:16px">地址：123456789</span></br>
                                </div>
                            </div>
                            <div style="float: right; margin-right:50px; text-align:center; margin-top:20px">
                                <div style="margin-bottom:50px;font-size:14px">
                                   <div style="float:left">
                                       <div>关注了</div>
                                       <div>xxx</div>
                                   </div>
                                   <Divider type="vertical" />
                                   <div style="float:right">
                                       <div>关注者</div>
                                       <div>xxx</div>
                                   </div>
                                </div>
                                
                                <div style="text-align:center">
                                    <router-link :to="{name: 'updateUser'}">
                                        <Button :size="large" type="primary" ghost >编辑个人资料</Button>
                                    </router-link>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
               
            </div>

            <div class="page_content">
                    <div style="text-align:center; font-size:16px;padding-top:15px">
                         <Row>
                            <Col span="8">
                                <Row>
                                    <Col span="8">我的发布</Col>
                                    <Col span="8">我的帖子</Col>
                                    <Col span="8">我的领养</Col>
                                </Row>
                            </Col>
                            <Col span="8"></Col>
                            <Col span="8"></Col>
                        </Row>
                    </div>
                     <Divider style="margin-top:15px"/>
                     
                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
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

    .user_information {
        height: 160px;
    }
    .user_information_left {
        width: 20%;
        text-align: center;
        margin-top: -25px;
        float: left;
    }
    .user_information_right {
        width: 80%;
        float: right;
    }
</style>
