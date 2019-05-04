<template>
<div style="margin-bottom:24px">
    <div class="forum_card"  @click="forum()">
        <div class="forum_card_left">
            <img :src="item.picture" style="width:120px; height:120px; margin:auto">
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
        <Divider />
    </div>
</div>
</template>


<script>

export default {
    props:["item"],
    methods:{
            forum(){
                this.$router.push('/forumInfoPage')
            }
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
.forum_card .ivu-divider-horizontal{
    height: 1px;
    width: 100%;
    min-width: 100%;
    margin: 24px 0;
    clear: both;
}
</style>