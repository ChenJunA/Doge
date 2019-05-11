<template>
    <Layout>
        <Content>
            <div class="page_content">
                <div style="text-align:center; font-size:16px;padding-top:15px">
                        <Row>
                        <Col span="8">
                            <Row>
                                <Col span="8">
                                    <a @click="listByType(3)" style="color:gray">推荐</a>
                                </Col>
                                <Col span="8">
                                    <a @click="listByType(1)" style="color:gray">流浪</a>
                                </Col>
                                <Col span="8">
                                    <a @click="listByType(2)" style="color:gray">送养</a>
                                </Col>
                            </Row>
                        </Col>
                        <Col span="8"></Col>
                        <Col span="8"></Col>
                    </Row>
                </div>
                <Divider style="margin-top:15px"/>

                <dogeCard  v-bind:item="doge" v-for="(doge,index) in dogeList" :key="index"></dogeCard>
            </div>
        </Content>
    </Layout>
</template>

<script>
import dogeCard from '@/components/dogeCard' //引入pageHeader组件

export default {
    name: "pageContent",
    data() {
        return {
            dogeList:""
        }
    },
    components:{
        'dogeCard': dogeCard,
    },
    mounted(){
        this.listByType(3);
    },
    methods: {
        listByType(typeId) {
            this.axios.get("http://localhost:80/listByType/" + typeId)
            .then(resp => {
                console.log(resp.data.data)
                this.dogeList = resp.data.data;
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
        }
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
