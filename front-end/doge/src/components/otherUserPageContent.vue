<template>
    <Layout>
        <Content>
            <div class="user_content">
                <div class="Card">
                    <div class="UserCoverEditor">
                        <div class="userCover">
                            <img class="userCover-image" :src="user.picture"/>
                        </div>
                    </div>
                     
                    <div class="user_information">
                        <div class="user_information_left">
                            <div>
                                <Avatar shape="square" :src="user.avatar" style="width:160px; height:160px"/>
                            </div>
                        </div>
                        <div class="user_information_right">
                            <div style="width: 400px; float:left">
                                <div>
                                    <span style="font-weight:bold; font-size:24px">{{user.username}}</span>
                                </div>
                                <Divider style="margin:10px 0"/>
                                <div>
                                    <span style="font-size:16px">电话号码：{{user.phoneNumber}}</span></br>
                                    <span style="font-size:16px">地址：{{user.address}}</span></br>
                                    <span style="font-size:16px">个人简介：{{user.biography}}</span></br>
                                </div>
                            </div>
                            <div style="float: right; margin-right:50px; text-align:center; margin-top:20px">
                                <div style="margin-bottom:50px;font-size:14px">
                                   <div style="float:left">
                                       <div>关注了</div>
                                       <div>{{user.followingNumber}}</div>
                                   </div>
                                   <Divider type="vertical" />
                                   <div style="float:right">
                                       <div>关注者</div>
                                       <div>{{user.followersNumber}}</div>
                                   </div>
                                </div>
                                
                                <div style="text-align:center">
                                    <Button type="primary" ghost style="width:100px" @click="toFollow()" v-if="isFollowed === false">关注</Button>
                                    <Button type="primary" ghost style="width:100px" @click="toFollow()" v-else disabled>关注</Button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
               
            </div>

            <div class="page_content">
                    <div style="text-align:center; font-size:16px;padding-top:15px">
                         <Row>
                            <Col span="12">
                                <Row>
                                    <Col span="6">
                                        <a @click="myPulish(user.id)" style="color:gray">TA的发布</a>
                                    </Col>
                                    <Col span="6">
                                        <a @click="myAdopt(user.id)" style="color:gray">TA的领养</a>
                                    </Col>
                                    <Col span="6">
                                        <a @click="myCollection(user.id)" style="color:gray">TA的收藏</a>
                                    </Col>
                                    <Col span="6">
                                        <a @click="myArticles(user.id)" style="color:gray">TA的帖子</a>
                                    </Col>
                                </Row>
                            </Col>
                            <Col span="6"></Col>
                            <Col span="6"></Col>
                        </Row>
                    </div>
                     <Divider style="margin-top:15px"/>
                     
                    <dogeCard v-if="dogeList" v-bind:item="doge" v-for="(doge,index) in dogeList" :key="index"></dogeCard>
                    <forumCard v-if="forumList"  v-bind:item="article" v-for="(article,index) in forumList" :key="index"></forumCard>
                </div>
        </Content>
    </Layout>
</template>

<script>
import dogeCard from '@/components/dogeCard' //引入dogeCard组件
import forumCard from '@/components/forumCard' //引入dogeCard组件
    export default {
        name: "userPageContent",
        data() {
            return {
                user: '',
                dogeList:"",
                forumList:'',
                isFollowed:true
            }
        },
        computed: {
        },
        components:{
            'dogeCard': dogeCard,
            'forumCard': forumCard
        },
        methods: {
            myPulish(fosterId){
                this.axios.get("http://localhost:80/listDogsByFosterId",{
                    params:{
                        fosterId: fosterId
                    }
                })
                .then(resp => {
                    this.dogeList = resp.data.data
                    this.forumList = null
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            myAdopt(adoptId){
                this.axios.get("http://localhost:80/listDogsByAdoptId",{
                    params:{
                        adoptId: adoptId
                    }
                })
                .then(resp => {
                    this.dogeList = resp.data.data
                    this.forumList = null
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            myCollection(collectionId){
                this.axios.get("http://localhost:80/listDogsByCollectionId",{
                    params:{
                        collectionId: collectionId
                    }
                })
                .then(resp => {
                    this.dogeList = resp.data.data
                    this.forumList = null
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            myArticles(userId){
                this.axios.get("http://localhost:80/listArticleByUserId",{
                    params:{
                        userId: userId
                    }
                })
                .then(resp => {
                    this.dogeList = null
                    this.forumList = resp.data.data
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            toFollow(){
                this.isFollowed = true;
                this.axios.post("http://localhost:80/toFollow",{
                    userId: this.$store.state.user.id,
                    followerId:this.$store.state.otherUserId
                })
                .then(resp => {
                    this.user = resp.data.data
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            }
        },
        mounted: function () {
            this.axios.get("http://localhost:80/getUserById",{
                params:{
                    userId: this.$store.state.otherUserId
                }
            })
            .then(resp => {
                this.user = resp.data.data
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });

            this.axios.get("http://localhost:80/isFollowed",{
                params:{
                    userId: this.$store.state.user.id,
                    followerId:this.$store.state.otherUserId
                }
            })
            .then(resp => {
                if(resp.data.data.length === 0){
                    this.isFollowed = false;
                }
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });

            this.myPulish(this.$store.state.otherUserId)
        }
    }
</script>

<style>
    
</style>
