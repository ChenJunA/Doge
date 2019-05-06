<template>
    <div>
        <router-view />
        <backgroundPage></backgroundPage>
    </div>
</template>


<script>
import backgroundPage from '@/components/backgroundPage' //引入pageContent组件

export default {
    name: "background",
    components:{
        'backgroundPage': backgroundPage
    }
}
</script>

<style>

</style>

