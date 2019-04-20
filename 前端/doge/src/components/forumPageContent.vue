<template>
<Layout>
    <Content>
        <div class="page_content">
            <div style="text-align:center; font-size:16px;padding-top:15px">
                    <Row>
                    <Col span="8">
                        <Row>
                            <Col span="8">推荐</Col>
                            <Col span="8">关注</Col>
                            <Col span="8">热榜</Col>
                        </Row>
                    </Col>
                    <Col span="8"></Col>
                    <Col span="8"></Col>
                </Row>
            </div>
            <Divider style="margin-top:15px"/>

            <forumCard></forumCard>
            <Divider />

            <forumCard></forumCard>
            <Divider />

            <forumCard></forumCard>
            <Divider />

            <forumCard></forumCard>
            <Divider />
        </div>
    </Content>
</Layout>



   
</template>

<script>
import forumCard from '@/components/forumCard' //引入pageHeader组件

export default {
    name: "forumPageContent",
    components:{
        'forumCard': forumCard,
    }
}
</script>

<style>
   
</style>
