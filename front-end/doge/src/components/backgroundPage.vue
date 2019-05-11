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
                            <Icon type="ios-keypad"></Icon>
                            <router-link :to="{name: 'home'}" style="color:#fff">首页</router-link>
                        </MenuItem>
                        <MenuItem name="2">
                            <Icon type="ios-contact" size="20" />
                            {{user.username}}
                        </MenuItem>
                        <MenuItem name="3">
                            <Icon type="md-exit" size="20" />
                            <a @click="quit()" style="color:#fff">退出</a>
                        </MenuItem>
                    </div>
                </Menu>
            </Header>
            <Layout style="height:690px">
                <Sider hide-trigger :style="{background: '#fff'}">
                    <Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
                        <Submenu name="1">
                            <template slot="title">
                                <Icon type="ios-navigate"></Icon>
                                用户管理
                            </template>
                            <MenuItem name="1-1">
                                <span @click="getUserListData()">用户信息管理</span>
                            </MenuItem>
                        </Submenu>
                        <Submenu name="2">
                            <template slot="title">
                                <Icon type="ios-keypad"></Icon>
                                动物管理
                            </template>
                            <MenuItem name="2-1">
                                <span @click="getDogeListData()">动物信息管理</span>
                            </MenuItem>
                            <MenuItem name="2-2">
                                <span @click="getDogeCommentListData()">动物评论管理</span>
                            </MenuItem>
                        </Submenu>
                        <Submenu name="3">
                            <template slot="title">
                                <Icon type="ios-analytics"></Icon>
                                论坛管理
                            </template>
                            <MenuItem name="3-1">
                                <span @click="getArticleListData()">文章管理</span>
                            </MenuItem>
                            <MenuItem name="3-2">
                                <span @click="getArticleCommentData()">评论管理</span>
                            </MenuItem>
                        </Submenu>
                        <Submenu name="4">
                            <template slot="title">
                                <Icon type="ios-analytics"></Icon>
                                系统管理
                            </template>
                            <MenuItem name="4-1">
                                <span @click="getLogListData()">日志管理</span>
                            </MenuItem>
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
                        <userInfo v-if="userListData"></userInfo>
                        <dogeInfo v-if="dogeListData"></dogeInfo>
                        <logInfo v-if="logListData"></logInfo>
                        <dogeCommentInfo v-if="dogeCommentListData"></dogeCommentInfo>
                        <articleInfo v-if="articleListData"></articleInfo>
                        <articleCommentInfo v-if="articleCommentData"></articleCommentInfo>
                    </Content>
                </Layout>
            </Layout>
        </Layout>
    </div>
</template>
<script>
import userInfo from '@/components/userInfo'
import dogeInfo from '@/components/dogeInfo'
import logInfo from '@/components/logInfo'
import dogeCommentInfo from '@/components/dogeCommentInfo'
import articleInfo from '@/components/articleInfo'
import articleCommentInfo from '@/components/articleCommentInfo'
    export default {
        data(){
            return{
                userListData: undefined,
                dogeListData: undefined,
                dogeCommentListData: undefined,
                adoptListData: undefined,
                articleListData: undefined,
                articleCommentData: undefined,
                logListData: undefined,
            }
        },
        components:{
            'userInfo': userInfo,
            'dogeInfo': dogeInfo,
            'logInfo': logInfo,
            'dogeCommentInfo': dogeCommentInfo,
            'articleInfo': articleInfo,
            'articleCommentInfo': articleCommentInfo
        },
        computed: {
            user () {
                return this.$store.state.user
            }
        },
        methods:{
            getUserListData(){
                this.axios.get("http://localhost:80/listAllUser")
                .then(resp => {
                    this.dogeListData = null
                    this.dogeCommentListData = null
                    this.adoptListData = null
                    this.articleListData = null
                    this.articleCommentData = null
                    this.logListData = null

                    this.userListData = resp.data.data;
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            getDogeListData(){
                this.axios.get("http://localhost:80/listAll")
                .then(resp => {
                    this.dogeCommentListData = null
                    this.adoptListData = null
                    this.articleListData = null
                    this.articleCommentData = null
                    this.logListData = null
                    this.userListData = null
                    
                    this.dogeListData = resp.data.data;
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            getLogListData(){
                this.axios.get("http://localhost:80/listAllLog")
                .then(resp => {
                    this.dogeListData = null
                    this.dogeCommentListData = null
                    this.adoptListData = null
                    this.articleListData = null
                    this.articleCommentData = null
                    this.userListData = null

                    this.logListData = resp.data.data
                    console.log(this.logListData)
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            getDogeCommentListData(){
                this.axios.get("http://localhost:80/listAllDogComment")
                .then(resp => {
                    this.dogeListData = null
                    this.articleCommentData = null
                    this.adoptListData = null
                    this.articleListData = null
                    this.userListData = null
                    this.logListData = null

                    this.dogeCommentListData = resp.data.data
                    console.log(this.dogeCommentListData)
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            getArticleListData(){
                this.axios.get("http://localhost:80/listAllArticle")
                .then(resp => {
                    this.dogeListData = null
                    this.articleCommentData = null
                    this.adoptListData = null
                    this.articleListData = resp.data.data
                    this.userListData = null
                    this.logListData = null
                    this.dogeCommentListData = null

                    console.log(resp.data.data)
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            getArticleCommentData(){
                this.axios.get("http://localhost:80/listAllArticleReply")
                .then(resp => {
                    this.dogeListData = null
                    this.articleCommentData = resp.data.data
                    this.adoptListData = null
                    this.articleListData = null
                    this.userListData = null
                    this.logListData = null
                    this.dogeCommentListData = null
                    console.log(resp.data.data)
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            quit(){
                this.axios.post("http://localhost:80/logout")
                this.$router.push('/');
            },
        },
        mounted(){
            this.axios.get("http://localhost:80/listAllUser")
            .then(resp => {
                this.dogeListData = null
                this.dogeCommentListData = null
                this.adoptListData = null
                this.articleListData = null
                this.articleCommentData = null
                this.logListData = null

                this.userListData = resp.data.data;
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
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
