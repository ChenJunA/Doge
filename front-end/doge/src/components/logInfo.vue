<template>
<div v-if="logListData">
    <Table border :columns="columns1" :data="showList">
        <template slot-scope="{ row }" slot="name">
            <strong>{{ row.name }}</strong>
        </template>
    </Table>
    <template>
        <Page :total="logListData.length" style="float:right" @on-change="changePage"/>
    </template>
</div>
</template>


<script>

export default {
   data(){
       return{
           columns1: [
                {
                    title: '浏览器',
                    key: 'browser'
                },
                {
                    title: '访问时间',
                    key: 'gmtCreate'
                },
                {
                    title: 'IP',
                    key: 'ip'
                },
                {
                    title: '访问路径',
                    key: 'url'
                }
            ],
            logListData: undefined,
            showList: undefined
       }
   },
   mounted(){
        this.axios.get("http://localhost:80/listAllLog")
        .then(resp => {
            this.logListData = resp.data.data;
            if (this.logListData.length < 10) {
                this.showList = this.logListData
            } else {
                this.showList = this.logListData.slice(0,10)
            }
        })
        .catch(err => {
            this.$Message.error("请求出错");
        });
   },
   methods:{
       changePage(index){
            var start = (index - 1) * 10
            var end = index * 10
            this.showList = this.logListData.slice(start,end)
        }
   }
}
</script>

<style>

</style>