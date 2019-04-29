<template>
   <div class="material_card"  @click="material()">
        <div class="material_card_left">
            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
        </div>

        <div class="material_card_right">
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
        material(){
            this.$Message.success("下载资料");
        }
   }
}
</script>

<style>
.material_card {
    width: 90%;
    height:150px;
}
.material_card_left {
    width: 30%;
    float: left;
    text-align: center;
    margin-top: 25px;
}
.material_card_right {
    width: 70%;
    float: right;
    margin-top: 25px;
}
</style>