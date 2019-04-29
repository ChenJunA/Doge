<template>
    <div>
        <router-view />
        <pageHeader></pageHeader>
        <pageContent></pageContent>
    </div>
</template>


<script>
import pageHeader from '@/components/pageHeader' //引入pageHeader组件
import pageContent from '@/components/pageContent' //引入pageContent组件

export default {
    name: "home",
    data() {
        return {
            avatarUrl:''
        }
    },
    components:{
        'pageHeader': pageHeader,
        'pageContent': pageContent
    },
    mounted(){
        
    },
    methods:{
        
    }
}
</script>

<style>

</style>

