<template>
<Layout>
    <Content>
        <div class="page_content">
            <div style="text-align:center; font-size:16px;padding-top:15px">
                    <Row>
                    <Col span="8">
                        <Row>
                            <Col span="8">
                                <a @click="" style="color:gray">推荐</a>
                            </Col>
                            <Col span="8">
                                <a @click="" style="color:gray">关注</a>
                            </Col>
                            <Col span="8">
                                <a @click="" style="color:gray">热榜</a>
                            </Col>
                        </Row>
                    </Col>
                    <Col span="8"></Col>
                    <Col span="8" style="float:right; text-align:right; padding-right:40px">
                        <a @click="modal = true" style="color:gray">发表</a>
                        <Modal v-model="modal" title="发布文章" :loading="loading" @on-ok="OK('forumData')" :closable="false" :mask-closable="false">
                            <Form ref="forumData" :model="forumData" :label-width="40" class="coverCss">
                                <FormItem prop="title" label="标题">
                                        <Input type="text" v-model="forumData.title" placeholder="标题"></Input>
                                </FormItem>
                                <FormItem prop="content" label="内容">
                                    <Input v-model="forumData.content" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述..."></Input>
                                </FormItem>
                            </Form>
                            <Upload
                                multiple
                                :format="['jpg','jpeg','png']"
                                action="http://localhost:80/forumPicsUpload"
                                :data= "postData"
                                class="coverCss">
                                <Button icon="ios-cloud-upload-outline" style="width:100%">上传图片</Button>
                            </Upload>
                        </Modal>
                    </Col>
                </Row>
            </div>
            <Divider style="margin-top:15px"/>

            <forumCard  v-bind:item="article" v-for="(article,index) in forumList" :key="index"></forumCard>

        </div>
    </Content>
</Layout>



   
</template>

<script>
import forumCard from '@/components/forumCard' //引入pageHeader组件

export default {
    name: "forumPageContent",
    data(){
        return{
            modal:false,
            loading: true,
            forumData:{
                title:'',
                content:'',
                userId: this.$store.state.user.id
            },
            postData:{
                articleId: this.$store.state.latestArticleId + 1
            },
            forumList:''
        }
    },
    components:{
        'forumCard': forumCard,
    },
    mounted(){
        this.axios.get("http://localhost:80/latestArticleId")
        .then(resp => {
            this.$store.dispatch('getLatestArticleId', resp.data.data)
        })
        .catch(err => {
            this.$Message.error("请求出错");
        });

        this.axios.get("http://localhost:80/listAllArticle")
        .then(resp => {
            this.forumList = resp.data.data
            console.log(this.forumList)
        })
        .catch(err => {
            this.$Message.error("请求出错");
        });
    },
    methods:{
        OK (name) {
            setTimeout(() => {
                this.modal = false;
            }, 500);
            this.axios.post("http://localhost:80/insertArticle",this.forumData)
            .then(resp => {
                this.forumList = resp.data.data
                console.log(this.forumList)
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
        }
    }
}
</script>

<style>
   
</style>
