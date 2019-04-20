<template>
   <div class="forum_card"  @click="forum()">
        <div class="forum_card_left">
            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
        </div>

        <div class="forum_card_right">
            <div>
                <div style="font-size:16px; font-weight:bold">
                    帖子标题
                </div>
                <Divider />
                <div>
                    帖子内容
                </div>
            </div>
        </div>
    </div>
</template>


<script>

export default {
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
</style>