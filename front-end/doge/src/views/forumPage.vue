<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <forumPageContent></forumPageContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import forumPageContent from '@/components/forumPageContent' //引入pageContent组件

export default {
    name: "home",
    components:{
        'pageHeader': pageHeader,
        'forumPageContent': forumPageContent
    }
}
</script>

<style>

</style>

