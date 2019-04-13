<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <updateUserContent></updateUserContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import updateUserContent from '@/components/updateUserContent' //引入updateUserContent组件

export default {
    name: "updateUser",
    components:{
        'pageHeader': pageHeader,
        'updateUserContent': updateUserContent
    }
}
</script>

<style>

</style>