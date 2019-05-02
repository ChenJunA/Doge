<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <forumInfoPageContent></forumInfoPageContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import forumInfoPageContent from '@/components/forumInfoPageContent' //引入pageContent组件

export default {
    name: "forumInfoPage",
    components:{
        'pageHeader': pageHeader,
        'forumInfoPageContent': forumInfoPageContent
    }
}
</script>

<style>

</style>

