<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <otherUserPageContent></otherUserPageContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import otherUserPageContent from '@/components/otherUserPageContent' //引入pageHeader组件

export default {
    name: "otherUserPage",
    components:{
        'pageHeader': pageHeader,
        'otherUserPageContent': otherUserPageContent
    }
}
</script>

<style>

</style>