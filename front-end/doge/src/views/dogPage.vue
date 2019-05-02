<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <dogPageContent></dogPageContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import dogPageContent from '@/components/dogPageContent' //引入pageContent组件

export default {
    name: "home",
    components:{
        'pageHeader': pageHeader,
        'dogPageContent': dogPageContent
    }
}
</script>

<style>

</style>

