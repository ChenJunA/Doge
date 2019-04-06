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
                     
                    <div class="doge_card">
                        <div class="doge_card_left">
                            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
                        </div>

                        <div class="doge_card_right">
                            <div>
                                <div>
                                    title
                                </div>
                                <Divider />
                                <div>
                                    descripe
                                </div>
                            </div>
                        </div>
                    </div>
                    <Divider />

                    <div class="doge_card">
                        <div class="doge_card_left">
                            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
                        </div>

                        <div class="doge_card_right">
                            <div>
                                <div>
                                    title
                                </div>
                                <Divider />
                                <div>
                                    descripe
                                </div>
                            </div>
                        </div>
                    </div>
                    <Divider />

                    <div class="doge_card">
                        <div class="doge_card_left">
                            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
                        </div>

                        <div class="doge_card_right">
                            <div>
                                <div>
                                    title
                                </div>
                                <Divider />
                                <div>
                                    descripe
                                </div>
                            </div>
                        </div>
                    </div>
                    <Divider />

                    <div class="doge_card">
                        <div class="doge_card_left">
                            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
                        </div>

                        <div class="doge_card_right">
                            <div>
                                <div>
                                    title
                                </div>
                                <Divider />
                                <div>
                                    descripe
                                </div>
                            </div>
                        </div>
                    </div>
                    <Divider />

                    <div class="doge_card">
                        <div class="doge_card_left">
                            <img src="@/assets/avatar.png" style="width:120px; height:120px; margin:auto">
                        </div>

                        <div class="doge_card_right">
                            <div>
                                <div>
                                    title
                                </div>
                                <Divider />
                                <div>
                                    descripe
                                </div>
                            </div>
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
