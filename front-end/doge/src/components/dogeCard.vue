<template>
    <div>
        <a style="color:gray">
        <div class="doge_card"  @click="dog()">
            <div class="doge_card_left">
                <img :src="item.picture" style="width:120px; height:120px; margin:auto">
            </div>

            <div class="doge_card_right">
                <div>
                    <div style="font-size:16px; font-weight:bold">
                        {{item.dogName}}
                    </div>
                    <Divider />
                    <div>
                        {{item.dogDescribe}}
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
        dog(){
            this.$store.dispatch('getDogById', this.item.id);
            this.$router.push('/dogPage')
        }
    },
    mounted(){
    }
}
</script>

<style>
.doge_card {
    width: 90%;
    height:150px;
}
.doge_card_left {
    width: 30%;
    float: left;
    text-align: center;
    margin-top: 25px;
}
.doge_card_right {
    width: 70%;
    float: right;
    margin-top: 25px;
}
</style>