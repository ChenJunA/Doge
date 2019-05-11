<template>
<div v-if="userListData">
    <Table border :columns="columns1" :data="showList">
        <template slot-scope="{ row }" slot="name">
            <strong>{{ row.name }}</strong>
        </template>
        <template slot-scope="{ row, index }" slot="action">
            <Button type="error" size="small" style="margin-right: 5px" @click="ban(index)">封禁</Button>
            <Button type="primary" size="small" @click="unban(index)">解封</Button>
        </template>
    </Table> 
    <template>
        <Page :total="userListData.length" show-sizer style="float:right"  @on-change="changePage"/>
    </template>
</div>
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
            userListData: undefined,
            showList: undefined,
            myStart:0,
            myEnd:10,
            pageIndex:1
       }
   },
   mounted(){
        this.axios.get("http://localhost:80/listAllUser")
        .then(resp => {
            this.userListData = resp.data.data
            if (this.userListData.length < 10) {
                this.showList = this.userListData
            } else {
                this.showList = this.userListData.slice(0,10)
            }
        })
        .catch(err => {
            this.$Message.error("请求出错");
        });
   },
   methods:{
        ban(index){
            var dataIndex = index + (this.pageIndex - 1) * 10     
            var userId = this.userListData[dataIndex].id
            var ban = this.userListData[dataIndex].isBan

            if (ban) {
                this.$Message.info("该用户已被封禁")
            } else {
                this.axios.put("http://localhost:80/ban/" + userId)
                .then(resp => {
                    this.listAll()
                    this.$Message.success("操作成功");
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            }
        },
        unban(index){
                var dataIndex = index + (this.pageIndex - 1) * 10
                var userId = this.userListData[dataIndex].id
                var ban = this.userListData[dataIndex].isBan
                if (ban) {
                    this.axios.put("http://localhost:80/unBan/" + userId)
                    .then(resp => {
                        this.listAll()
                        this.$Message.success("操作成功");
                    })
                    .catch(err => {
                        this.$Message.error("请求出错");
                    });
                } else {
                    this.$Message.info("该用户未被封禁")
                }
        },
        changePage(index){
            this.pageIndex = index
            this.myStart = (index - 1) * 10
            this.myEnd = index * 10
            this.showList = this.userListData.slice(this.myStart,this.myEnd)
        },
        listAll(){
            this.axios.get("http://localhost:80/listAllUser")
            .then(resp => {
                this.userListData = resp.data.data
                if (this.userListData.length < 10) {
                    this.showList = this.userListData
                } else {
                    this.showList = this.userListData.slice(myStart,myEnd)
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