<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <materialPageContent></materialPageContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import materialPageContent from '@/components/materialPageContent' //引入pageContent组件

export default {
    name: "materialPage",
    components:{
        'pageHeader': pageHeader,
        'materialPageContent': materialPageContent
    }
}
</script>

<style>

</style>

