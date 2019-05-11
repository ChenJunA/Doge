<template>
<div v-if="dogeListData">
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
        <Page :total="dogeListData.length" style="float:right" @on-change="changePage"/>
    </template>
</div>
</template>


<script>

export default {
   data(){
       return{
           columns1: [
                {
                    title: '姓名',
                    key: 'dogName'
                },
                {
                    title: '性别',
                    key: 'sex'
                },
                {
                    title: '年龄',
                    key: 'age'
                },
                {
                    title: '发布人ID',
                    key: 'foster'
                },
                {
                    title: '领养人ID',
                    key: 'adopt'
                },
                {
                    title: '地址',
                    key: 'address'
                },
                {
                    title: '疫苗',
                    key: 'isVaccine'
                },
                {
                    title:'是否删除',
                    key: 'isDelete'
                },
                {
                    title: '操作',
                    slot: 'action'
                },
            ],
            dogeListData: undefined,
            showList: undefined,
            myStart:0,
            myEnd:10,
            pageIndex:1

       }
   },
   mounted(){
        this.axios.get("http://localhost:80/listAll")
        .then(resp => {
            this.dogeListData = resp.data.data;
            if (this.dogeListData.length < 10) {
                this.showList = this.dogeListData
            } else {
                this.showList = this.dogeListData.slice(0,10)
                console.log(this.showList)
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
            this.showList = this.dogeListData.slice(this.myStart,this.myEnd)
        },
        toDelete(index){
            var dataIndex = index + (this.pageIndex - 1) * 10
            var dogId = this.dogeListData[dataIndex].id
            var isDelete = this.dogeListData[dataIndex].isDelete
            if(isDelete){
                this.$Message.info("已被删除")
            }else{
                this.axios.delete("http://localhost:80/deleteDog/" + dogId)
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
            var dogId = this.dogeListData[dataIndex].id
            var isDelete = this.dogeListData[dataIndex].isDelete
            if(isDelete){
                this.axios.delete("http://localhost:80/reCover/" + dogId)
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
            this.axios.get("http://localhost:80/listAll")
            .then(resp => {
                this.dogeListData = resp.data.data;
                if (this.dogeListData.length < 10) {
                    this.showList = this.dogeListData
                } else {
                    this.showList = this.dogeListData.slice(this.myStart,this.myEnd)
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