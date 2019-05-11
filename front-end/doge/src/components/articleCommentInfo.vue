<template>
<div v-if="articleCommentData">
    <Table border :columns="columns1" :data="showList">
        <template slot-scope="{ row }" slot="name">
            <strong>{{ row.name }}</strong>
        </template>
        <template slot-scope="{ row, index }" slot="action">
            <Button type="error" size="small" style="margin-right: 5px" @click="toDelete(index)">删除</Button>
            <Button type="primary" size="small" @click="reCover(index)">恢复</Button>
        </template>
    </Table>
    <template>
        <Page :total="articleCommentData.length" show-sizer style="float:right"  @on-change="changePage"/>
    </template>
</div>
</template>


<script>

export default {
   data(){
       return{
           columns1: [
               {
                   title:'ID',
                   key:'id'
               },
               {
                    title: '文章ID',
                    key: 'articleId'
                },
                {
                    title: '发表人',
                    key: 'username'
                },
                {
                    title: '回复内容',
                    key: 'content'
                },
                {
                    title: '发表时间',
                    key: 'gmtCreate'
                },
                {
                    title:'是否删除',
                    key: 'delete'
                },
                {
                    title: '操作',
                    slot: 'action'
                },
            ],
            articleCommentData: undefined,
            showList: undefined,
            myStart:0,
            myEnd:10,
            pageIndex:1
       }
   },
   mounted(){
        this.axios.get("http://localhost:80/listAllArticleReply")
        .then(resp => {
            this.articleCommentData = resp.data.data
            if (this.articleCommentData.length < 10) {
                this.showList = this.articleCommentData
            } else {
                this.showList = this.articleCommentData.slice(0,10)
            }
        })
        .catch(err => {
            this.$Message.error("请求出错");
        });
   },
   methods:{
       changePage(index){
            this.pageIndex = index
            this.myStart = (index - 1) * 10
            this.myEnd = index * 10
            this.showList = this.articleCommentData.slice(this.myStart,this.myEnd)
        },
        toDelete(index){
            var dataIndex = index + (this.pageIndex - 1) * 10
            var replyId = this.articleCommentData[dataIndex].id
            var isDelete = this.articleCommentData[dataIndex].delete
            if(isDelete){
                this.$Message.info("已被删除")
            }else{
                this.axios.delete("http://localhost:80/deleteArticleReply/" + replyId)
                .then(resp => {
                    this.listAll();
                    this.$Message.success("操作成功");
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            }
        },
        reCover(index){
            var dataIndex = index + (this.pageIndex - 1) * 10
            var replyId = this.articleCommentData[dataIndex].id
            var isDelete = this.articleCommentData[dataIndex].delete
            if(isDelete){
                this.axios.delete("http://localhost:80/reCoverArticleReply/" + replyId)
                .then(resp => {
                    this.listAll();
                    this.$Message.success("操作成功");
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            }else{
                this.$Message.info("未被删除")
            }
        },
        listAll(){
            this.axios.get("http://localhost:80/listAllArticleReply")
            .then(resp => {
                this.articleCommentData = resp.data.data;
                if (this.articleCommentData.length < 10) {
                    this.showList = this.articleCommentData
                } else {
                    this.showList = this.articleCommentData.slice(this.myStart,this.myEnd)
                }
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