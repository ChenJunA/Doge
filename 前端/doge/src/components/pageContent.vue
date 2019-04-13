<template>
    <Layout>
        <Content>
                <div class="page_content">
                    <div style="text-align:center; font-size:16px;padding-top:15px">
                         <Row>
                            <Col span="8">
                                <Row>
                                    <Col span="8">推荐</Col>
                                    <Col span="8">流浪</Col>
                                    <Col span="8">送养</Col>
                                </Row>
                            </Col>
                            <Col span="8"></Col>
                            <Col span="8"></Col>
                        </Row>
                    </div>
                     <Divider style="margin-top:15px"/>
                     
                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
                    <Divider />

                    <dogeCard></dogeCard>
                </div>
            </Content>
    </Layout>
</template>

<script>
import dogeCard from '@/components/dogeCard' //引入pageHeader组件

    export default {
        name: "pageContent",
        components:{
            'dogeCard': dogeCard,
        }
    }
</script>

<style>
     .page_content {
        margin: auto;
        margin-top: 10px;
        width: 70%;
        background-color:white;
    }
    .doge_card {
        width: 90%;
        height:150px;
    }
    .doge_card_left {
        width: 30%;
        float: left;
        text-align: center;
        margin-top: 25px;
    }
    .doge_card_right {
        width: 70%;
        float: right;
        margin-top: 25px;
    }
</style>
