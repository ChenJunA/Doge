<template>
    <Table border :columns="columns1" :data="data1">
        <template slot-scope="{ row }" slot="name">
            <strong>{{ row.name }}</strong>
        </template>
        <template slot-scope="{ row, index }" slot="action">
            <Button type="primary" size="small" style="margin-right: 5px" @click="ban(index)">封禁</Button>
            <Button type="error" size="small" @click="unban(index)">解封</Button>
        </template>
    </Table>
</template>


<script>

export default {
   data(){
       return{
           columns1: [
                {
                    title: '用户名',
                    key: 'username'
                },
                {
                    title: '性别',
                    key: 'sex'
                },

                {
                    title: '简介',
                    key: 'biography'
                },
                {
                    title: '邮箱',
                    key: 'email'
                },
                {
                    title: '电话号码',
                    key: 'phoneNumber'
                },
                {
                    title: '地址',
                    key: 'address'
                },
                {
                    title: '粉丝数',
                    key: 'followersNumber'
                },
                {
                    title:'封禁',
                    key: 'isBan'
                },
                {
                    title: '操作',
                    slot: 'action'
                },
            ],
            data1: undefined
       }
   },
   mounted(){
        this.axios.get("http://localhost:80/listAllUser")
        .then(resp => {
            console.log(resp.data.data)
            this.data1 = resp.data.data;
        })
        .catch(err => {
            this.$Message.error("请求出错");
        });
   },
   methods:{
       ban(index){
           var userId = this.data1[index].id
           this.axios.put("http://localhost:80/ban/" + userId)
            .then(resp => {
                this.data1 = resp.data.data;
                this.$Message.success("操作成功");
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
       },
       unban(index){
           var userId = this.data1[index].id
           alert(userId)
       }
   }
}
</script>

<style>

</style>