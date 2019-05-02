<template>
<Layout>
    <Content>
        <div class="page_content">
            <div class="carouselDiv">
                <Carousel autoplay loop :height="400" :radius-dot="true">
                    <CarouselItem v-for="(pic,key) in this.pictures" :key="key">
                        <div class="demo-carousel">
                            <img :src="pic" style="width:100%; height:400px">
                        </div>
                    </CarouselItem>
                </Carousel>
            </div>

            <div class="dogInfoDiv" style="margin-top:30px; font-size:14px;" v-if="this.dog">
                <Row>
                    <Col span="8">姓名：{{this.dog.dogName}}</Col>
                    <Col span="8">年龄：{{this.dog.age}}</Col>
                    <Col span="8">性别：{{this.dog.sex}}</Col>
                </Row>
                <br>
                <Row>
                    <Col span="8">地址：{{this.dog.address}}</Col>
                    <Col span="8">疫苗：{{this.dog.vaccine}}</Col>
                    <Col span="8">类别：{{this.dog.type}}</Col>
                </Row>
                <br>
                <Row>
                    <Col span="20">{{this.dog.dogDescribe}}</Col>
                    <Col span="4">
                        <Button type="info">收藏动物</Button><br/>
                        <Button type="info">发起领养</Button><br/>
                        <Button type="info">确认领养</Button>
                    </Col>
                </Row>
            </div>
            <Divider />

            <div class="dogBtnDiv">
                <Row>
                    <Col span="8" style="text-align:center">
                        <Button type="info">收藏</Button>
                    </Col>
                    <Col span="8" style="text-align:center">
                        <Button type="info">发起领养</Button>
                    </Col>
                    <Col span="8" style="text-align:center">
                        <Button type="info">确认领养</Button>
                    </Col>
                </Row>
            </div>
            <Divider />

            <div class="stepsDiv">
                <Steps v-if="this.dog && this.dog.state" :current="this.dog.state - 1">
                    <Step title="待领养" content="这里是该步骤的描述信息"></Step>
                    <Step title="领养中" content="这里是该步骤的描述信息"></Step>
                    <Step title="已领养" content="这里是该步骤的描述信息"></Step>
                </Steps>
            </div>
            <Divider />
            
            <div class="dogCommentListDiv">
                <Row>
                    <Col span="24" style="font-size:20px">评论列表</Col>
                </Row>
                <Divider />
                <Row>
                    <Col span="12">
                        评论ID
                    </Col>
                    <Col span="12" >
                        评论时间
                    </Col>
                </Row>
                <Row>
                    <Col span="24">
                        评论内容
                    </Col>
                </Row>
            </div>
            <Divider />

            <div class="dogCommentDiv">
                <div>
                    <Input placeholder="Enter something..." />
                </div>
                <div>
                    <Button type="info" style="float:right">评论</Button>
                </div>
            </div>
        </div>
    </Content>
</Layout>



   
</template>

<script>
    export default {
        data () {
            return {
                dog: undefined,
                pictures: undefined
            }
        },
        computed: {
            
        },
        mounted() {
            this.axios.get("http://localhost:80/getDogById/" + this.$store.state.dogId)
            .then(resp => {
                this.dog = resp.data.data
                this.pictures = resp.data.data.pictures
                console.log(this.dog)
                console.log(this.pictures)
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
        },
        methods: {
            
        }
    }
</script>

<style>
   
</style>
