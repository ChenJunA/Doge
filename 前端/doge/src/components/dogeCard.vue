<template>
   <div class="doge_card">
        <div class="doge_card_left">
            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
        </div>

        <div class="doge_card_right">
            <div>
                <div>
                    title
                </div>
                <Divider />
                <div>
                    descripe
                </div>
            </div>
        </div>
    </div>
</template>


<script>

export default {
   
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