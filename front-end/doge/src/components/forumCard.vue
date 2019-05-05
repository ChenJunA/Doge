<template>
<div>
    <a style="color:gray">
    <div class="forum_card"  @click="forum()">
        <div class="forum_card_left">
            <img :src="item.pictures[0]" style="width:120px; height:120px; margin:auto">
        </div>

        <div class="forum_card_right">
            <div>
                <div style="font-size:16px; font-weight:bold">
                    {{item.title}}
                </div>
                <Divider />
                <div>
                    {{item.content}}
                </div>
            </div>
        </div>

        <div>
            <div style="float:left; margin-top:20px">
                {{item.username}}
                <Divider type="vertical" />
                {{item.gmtCreate}}
            </div>
            <div style="float:right; margin-top:20px">
                <Icon type="md-eye" />&nbsp;&nbsp;{{item.viewNum}}
                &nbsp;&nbsp;&nbsp;&nbsp;
                <Icon type="ios-text" />&nbsp;&nbsp;{{item.replyNum}}
            </div>
                
        </div>
    </div>
    <Divider />
    </a>
</div>
</template>


<script>

export default {
    props:["item"],
    methods:{
            forum(){
                this.axios.put("http://localhost:80/addViewNum", {
                    articleId: this.item.id
                })
                .then(resp => {
                   this.$store.dispatch('getArticleById', this.item.id);
                    this.$router.push('/forumInfoPage')
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            }
    },
    mounted(){
    }
}
</script>

<style>
.forum_card {
    width: 90%;
    height:150px;
}
.forum_card_left {
    width: 30%;
    float: left;
    text-align: center;
    margin-top: 25px;
}
.forum_card_right {
    width: 70%;
    float: right;
    margin-top: 25px;
}
</style>