<template>
    <div class="layout">
        <Layout>
            <Header id="page_header">
                <Row>
                    <Col span="4" style="text-align:right; font-size:30px; color:#2b85e4"><router-link :to="{name: 'home'}">Doge</router-link></Col>
                    <Col span="4" style="text-align:right">
                        <Row>
                            <Col span="8">
                                <router-link :to="{name: 'home'}" style="color:gray">首页</router-link>
                            </Col>
                            <Col span="8">
                                <router-link :to="{name: 'home'}" style="color:gray">论坛</router-link>
                            </Col>
                            <Col span="8">
                                <router-link :to="{name: 'home'}" style="color:gray">资料</router-link>
                            </Col>
                        </Row>
                    </Col>
                    <Col span="8" style="text-align:center;">
                        <Input v-model="value4" icon="ios-search" placeholder="Enter something..." style="width: 90%" />
                    </Col>
                    <Col span="2">
                            <Button type="primary" style="width: 50%">发布</Button>
                    </Col>
                    <Col span="4" style="text-align:left;">
                        <Col span="8">
                            <Icon type="ios-notifications"  size="25"/>
                        </Col>
                        <Col span="8">
                            <Icon type="ios-chatbubbles" size="25"/>
                        </Col>
                        <Col span="8">
                            <Poptip>
                                <Avatar shape="square" src="https://i.loli.net/2017/08/21/599a521472424.jpg"></Avatar>
                                <div class="api" slot="content">
                                    <div class="poptip_icon">
                                        <Icon type="ios-contact" />&nbsp;<a @click="toUserPage()" style="color:gray">主页</a>
                                    </div>
                                    <Divider style="margin-top:10px"/>
                                    <div class="poptip_icon">
                                        <Icon type="ios-settings" />&nbsp;<a style="color:gray">设置</a>
                                    </div>
                                    <Divider style="margin-top:10px"/>
                                    <div class="poptip_icon">
                                       <Icon type="ios-power" />&nbsp;<a @click="quit()" style="color:gray">退出</a>
                                    </div>
                                </div>
                            </Poptip>
                        </Col>
                    </Col>
                </Row>
            </Header>
            
            
        </Layout>
    </div>
</template>

<script>
    export default {
        methods: {
            quit(){
                this.$router.push('/');
            },
            toUserPage(){
                this.$router.push('/userPage');
            }
        }
    }
</script>

<style>
    #page_header {
        background: white;
        font-size: 16px;
    }
    .poptip_icon {
        text-align: center;
        font-size: 16px;
    }
</style>
