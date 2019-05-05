<template>
    <div>
        <div class="reply_card">
            <div class="reply_card_top">
                <div style="float:left">
                    <a @click="toOtherUserPage()">
                    <img :src="item.avatar" style="width:40px; height:40px;">
                    </a>
                </div>
                <div style="margin-left:50px; font-weight:bold; font-size:14px; color:black">
                    {{item.username}}
                </div>
                <div style="margin-left:50px; font-size:13px">
                    {{item.biography}}
                </div>
            </div>
            <div class="reply_card_bottom">
                <div style="font-size:16px; font-weight:bold;height:70px">
                    {{item.content}}
                </div>

                <div class="reply_card_right_btn" style="margin-right:24px">
                    <Row style="text-align:center; margin:auto">
                        <Col span="17">&nbsp;</Col>
                        <Col span="2" style="line-height:36px; font-size:12px">
                            <Icon type="ios-text" size="16"/>&nbsp;&nbsp;{{item.replyNum}}条评论
                        </Col>
                        <Col span="2" style="line-height:36px; font-size:12px">
                            <Icon type="ios-share-alt" size="16" />&nbsp;&nbsp;分享
                        </Col>
                        <Col span="2" style="line-height:36px; font-size:12px">
                            <Icon type="md-flag" size="16" />&nbsp;&nbsp;举报
                        </Col>
                        <Col span="1" style="line-height:36px; font-size:12px">
                            <Icon type="ios-more" size="16" />
                        </Col>
                    </Row>
                </div>
            </div>
        </div>
        <Divider />
    </div>
</template>


<script>

export default {
    props:["item"],
    methods:{
        toOtherUserPage(){
            this.$store.dispatch('getOtherUserId', this.item.userId);
            this.$router.push('/otherUserPage')
        }
    },
    mounted(){
    }
}
</script>

<style>
.reply_card {
    height:150px;
    margin-left: 30px;
}
.reply_card_top {
    height: 50px;
}
.reply_card_bottom {
    height: 100px;
}
</style>