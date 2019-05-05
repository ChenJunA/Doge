<template>
<div>
    <a style="color:gray">
    <div class="material_card"  @click="material()">
        <div class="material_card_left">
            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
        </div>

        <div class="material_card_right">
            <div>
                <div style="font-size:16px; font-weight:bold">
                    {{item.materialName}}
                </div>
                <Divider />
                <div>
                    {{item.materialDescribe}}
                </div>
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
            material(){
                // this.axios.get("http://localhost:80/materialDownload",{
                //     params:{
                //         materialId: this.item.id
                //     }
                // })
                // .then(resp => {
                //     this.materialList = resp.data.data
                // })
                // .catch(err => {
                //     this.$Message.error("请求出错");
                // });
                window.location.href="http://localhost:80/materialDownload?materialId=" + this.item.id
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
.material_card .ivu-divider-horizontal{
    height: 1px;
    width: 100%;
    min-width: 100%;
    margin: 24px 0;
    clear: both;
}
</style>