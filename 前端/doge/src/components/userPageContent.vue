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
                            <div style="width: 400px">
                                <div style="whi">
                                    <span style="font-weight:bold; font-size:24px">用户名</span>
                                </div>
                                <Divider style="margin:10px 0"/>
                                <div>
                                    <span style="font-size:16px">电话号码：123456789</span></br>
                                    <span style="font-size:16px">地址：123456789</span></br>
                                </div>
                            </div>
                            <div style="float:right; padding:20px;">
                                <Button :size="large" type="primary" ghost >编辑资料</Button>
                            </div>
                        </div>
                    </div>
                </div>
               
            </div>
        </Content>
    </Layout>
</template>

<script>
    export default {
        
    }
</script>

<style>
     .user_content {
        margin: auto;
        margin-top: 10px;
        width: 70%;
        height: 1000px;
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
