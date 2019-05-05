<template>
<Layout>
    <Content>
        <div class="page_content" v-if="this.article">
            <div class="forum_title" style="color:black; margin-left:30px">
                <h1 style="font-size:26px;padding-top:10px" >{{article.title}}</h1>
            </div>

            <div class="forum_content" style="font-size:16px; margin-left:30px">
                <span>{{article.content}}</span>
                <br>
                <br>
            </div>

            <div class="forum_pics" style="text-align:center" v-for="(pic,index) in articlePics" :key="index">
                <img :src="pic" style="width:70%; height:240px;"/>
                <br/>
            </div>

            <br>
            <div class="forum_btn">
                <Row style="text-align:center; margin:auto;">
                    <Col span="4">
                        <Button type="primary" size="large">关注问题</Button>
                    </Col>
                    <Col span="4">
                        <Button type="primary" ghost icon="md-create" size="large">写回答</Button>
                    </Col>
                    <Col span="4">
                        <Button icon="md-person-add" size="large">邀请回答</Button>
                    </Col>
                    <Col span="4" style="line-height:36px; font-size:16px">
                        <Icon type="ios-text" size="20"/>&nbsp;&nbsp;{{article.replyNum}}条评论
                    </Col>
                    <Col span="3" style="line-height:36px; font-size:16px">
                        <Icon type="ios-share-alt" size="20" />&nbsp;&nbsp;分享
                    </Col>
                    <Col span="3" style="line-height:36px; font-size:16px">
                        <Icon type="md-flag" size="20" />&nbsp;&nbsp;举报
                    </Col>
                    <Col span="2" style="line-height:36px; font-size:16px;">
                        <Icon type="ios-more" size="20" />
                    </Col>
                </Row>
                
            </div>
            
            <div style="width:100%; height:10px; background:#f5f7f9;margin-top:10px;margin-bottom:10px">
            </div>

            <div class="forum_reply">
                <replyCard v-bind:item="reply" v-for="(reply, index) in forumReplyList" :key="index"></replyCard>
            </div>

            <div class="forum_reply_input" style="height:120px;margin-bottom:100px">
                <div style="text-align:center; margin-bottom:10px">
                    <Form ref="replyData" :model="replyData" :label-width="40" class="coverCss">
                        <FormItem prop="content">
                                <Input style="width:95%" v-model="replyData.content" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..." />
                        </FormItem>
                    </Form>
                </div>
                <div style="float:right; margin-right:25px">
                    <Button style="width:100px" type="primary" @click="insertReply()">发表</Button>
                </div>
            </div>
        </div>
    </Content>
</Layout>



   
</template>

<script>
import replyCard from '@/components/replyCard' //引入pageHeader组件
    export default {
        data(){
            return{
                article: undefined,
                articlePics: undefined,
                forumReplyList: undefined,
                replyData:{
                    content:'',
                    userId: this.$store.state.user.id,
                    articleId: this.$store.state.articleId,
                    parentId: 0,
                    replyId: 0,
                }
            }
        },
        components:{
            'replyCard': replyCard
        },
        methods:{
            insertReply(){
                this.axios.post("http://localhost:80/insertReply", this.replyData)
                .then(resp => {
                    this.forumReplyList = resp.data.data
                    this.article.replyNum += 1
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            }
        },
        mounted(){
            this.axios.get("http://localhost:80/getArticleById/" + this.$store.state.articleId)
            .then(resp => {
                this.article = resp.data.data
                this.articlePics = resp.data.data.pictures
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });

            this.axios.get("http://localhost:80/listAllReply",{
                params:{
                    articleId:this.$store.state.articleId
                }
            })
            .then(resp => {
                this.forumReplyList = resp.data.data
                console.log(this.forumReplyList)
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
        }
    }
</script>

<style>
   
</style>
