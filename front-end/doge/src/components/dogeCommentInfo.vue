<template>
<div v-if="dogeCommentListData">
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
        <Page :total="dogeCommentListData.length" show-sizer style="float:right"  @on-change="changePage"/>
    </template>
</div>
</template>


<script>

export default {
   data(){
       return{
           columns1: [
               {
                    title: '动物ID',
                    key: 'dogId'
                },
                {
                    title: '发表人',
                    key: 'username'
                },
                {
                    title: '发表时间',
                    key: 'gmtCreate'
                },
                {
                    title: '内容',
                    key: 'content'
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
            dogeCommentListData: undefined,
            showList: undefined,
            myStart:0,
            myEnd:10,
            pageIndex:1
       }
   },
   mounted(){
        this.axios.get("http://localhost:80/listAllDogComment")
        .then(resp => {
            this.dogeCommentListData = resp.data.data;
            if (this.dogeCommentListData.length < 10) {
                this.showList = this.dogeCommentListData
            } else {
                this.showList = this.dogeCommentListData.slice(0,10)
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
            this.showList = this.dogeCommentListData.slice(this.myStart,this.myEnd)
        },
        toDelete(index){
            var dataIndex = index + (this.pageIndex - 1) * 10
            var dogCommentId = this.dogeCommentListData[dataIndex].id
            var isDelete = this.dogeCommentListData[dataIndex].delete
            if(isDelete){
                this.$Message.info("已被删除")
            }else{
                this.axios.delete("http://localhost:80/deleteDogComment/" + dogCommentId)
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
            var dogCommentId = this.dogeCommentListData[dataIndex].id
            var isDelete = this.dogeCommentListData[dataIndex].delete
            if(isDelete){
                this.axios.delete("http://localhost:80/reCoverDogComment/" + dogCommentId)
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
            this.axios.get("http://localhost:80/listAllDogComment")
            .then(resp => {
                this.dogeCommentListData = resp.data.data;
                if (this.dogeCommentListData.length < 10) {
                    this.showList = this.dogeCommentListData
                } else {
                    this.showList = this.dogeCommentListData.slice(this.myStart,this.myEnd)
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