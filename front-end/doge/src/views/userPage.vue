<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <userPageContent></userPageContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import userPageContent from '@/components/userPageContent' //引入pageHeader组件

export default {
    name: "userPage",
    components:{
        'pageHeader': pageHeader,
        'userPageContent': userPageContent
    }
}
</script>

<style>

</style>