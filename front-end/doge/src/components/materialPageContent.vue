<template>
<Layout>
    <Content>
        <div class="page_content">
            <materialCard></materialCard>
            <Divider />

            <materialCard></materialCard>
            <Divider />

            <materialCard></materialCard>
            <Divider />

            <materialCard></materialCard>
            <Divider />
        </div>
    </Content>
</Layout>



   
</template>

<script>
import materialCard from '@/components/materialCard' //引入pageHeader组件

export default {
    name: "materialPageContent",
    components:{
        'materialCard': materialCard,
    }
}
</script>

<style>
   
</style>
