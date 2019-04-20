<template>
<Layout>
    <Content>
        <div class="page_content">
            <div class="carouselDiv">
                <Carousel autoplay v-model="value2" loop :height="400" :radius-dot="true">
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/1.jpg">
                        </div>
                    </CarouselItem>
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/2.jpg">
                        </div>
                    </CarouselItem>
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/3.jpg">
                        </div>
                    </CarouselItem>
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/4.jpg">
                        </div>
                    </CarouselItem>
                </Carousel>
            </div>

            <div class="dogInfoDiv" style="margin-top:30px; font-size:14px;">
                <Row>
                    <Col span="8">姓名：哎一古</Col>
                    <Col span="8">年龄：21</Col>
                    <Col span="8">性别：男</Col>
                </Row>
                <br>
                <Row>
                    <Col span="8">地址：四川省绵阳市三台县</Col>
                    <Col span="8">疫苗：已接种</Col>
                    <Col span="8">类别：人类</Col>
                </Row>
                <br>
                <Row>
                    <Col span="20">哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈</Col>
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
                <Steps :current="1">
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
                    <Input v-model="value" placeholder="Enter something..." />
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
        
    }
</script>

<style>
   
</style>
