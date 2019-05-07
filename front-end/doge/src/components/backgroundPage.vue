<template>
    <div class="layout">
        <Layout>
            <Header>
                <Menu mode="horizontal" theme="dark" active-name="1">
                    <div class="layout-logo">
                        <img :src="user.avatar" style="width:100px; height:30px">
                    </div>
                    <div class="layout-nav">
                        <MenuItem name="1">
                            <Icon type="ios-navigate"></Icon>
                            Item 1
                        </MenuItem>
                        <MenuItem name="2">
                            <Icon type="ios-keypad"></Icon>
                            Item 2
                        </MenuItem>
                        <MenuItem name="3">
                            <Icon type="ios-analytics"></Icon>
                            {{user.username}}
                        </MenuItem>
                        <MenuItem name="4">
                            <Icon type="ios-paper"></Icon>
                            退出
                        </MenuItem>
                    </div>
                </Menu>
            </Header>
            <Layout>
                <Sider hide-trigger :style="{background: '#fff'}">
                    <Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
                        <Submenu name="1">
                            <template slot="title">
                                <Icon type="ios-navigate"></Icon>
                                用户管理
                            </template>
                            <MenuItem name="1-1">
                                <span @click="userInfoManagement()">用户信息管理</span>
                            </MenuItem>
                        </Submenu>
                        <Submenu name="2">
                            <template slot="title">
                                <Icon type="ios-keypad"></Icon>
                                动物管理
                            </template>
                            <MenuItem name="2-1">动物信息管理</MenuItem>
                            <MenuItem name="2-2">动物评论管理</MenuItem>
                            <MenuItem name="2-3">领养记录管理</MenuItem>
                        </Submenu>
                        <Submenu name="3">
                            <template slot="title">
                                <Icon type="ios-analytics"></Icon>
                                论坛管理
                            </template>
                            <MenuItem name="3-1">文章管理</MenuItem>
                            <MenuItem name="3-2">评论管理</MenuItem>
                        </Submenu>
                        <Submenu name="4">
                            <template slot="title">
                                <Icon type="ios-analytics"></Icon>
                                系统管理
                            </template>
                            <MenuItem name="4-1">日志管理</MenuItem>
                        </Submenu>
                    </Menu>
                </Sider>
                <Layout :style="{padding: '0 24px 24px'}">
                    <Breadcrumb :style="{margin: '24px 0'}">
                        <BreadcrumbItem>Doge</BreadcrumbItem>
                        <BreadcrumbItem>后台管理</BreadcrumbItem>
                    </Breadcrumb>
                    <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
                        <!-- <keep-alive>
                            <router-view></router-view>
                        </keep-alive> -->
                        <userInfo></userInfo>
                    </Content>
                </Layout>
            </Layout>
        </Layout>
    </div>
</template>
<script>
import userInfo from '@/components/userInfo'
    export default {
        components:{
            'userInfo': userInfo,
        },
        computed: {
            user () {
                return this.$store.state.user
            }
        },
        methods:{
            // userInfoManagement(){
            //     this.$router.push({
            //         name: "userInfo"
            //     })
            // }
        },
        mounted(){
        }
    }
</script>
<style scoped>
.layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
}
.layout-logo{
    width: 100px;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    float: left;
    position: relative;
    top: 15px;
    left: 20px;
}
.layout-nav{
    width: 420px;
    margin: 0 auto;
    margin-right: 20px;
}
</style>
