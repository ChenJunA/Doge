<template>
<Layout>
    <Content>
        <div class="page_content">
            <div style="text-align:center; font-size:16px;padding-top:15px">
                <Row>
                    <Col span="8">
                        <Row>
                            <Col span="8">
                                <a @click="modal = true" style="color:gray">我要上传</a>
                                <Modal v-model="modal" title="文件信息" :loading="loading" @on-ok="OK('materialData')" :closable="false" :mask-closable="false">
                                    <Form ref="materialData" :model="materialData" :label-width="40" class="coverCss">
                                        <FormItem prop="materialDescribe" label="描述">
                                            <Input v-model="materialData.materialDescribe" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述..."></Input>
                                        </FormItem>
                                    </Form>
                                    <Upload
                                        action="http://localhost:80/materialUpload"
                                        :data= "postData"
                                        class="coverCss">
                                        <Button icon="ios-cloud-upload-outline" style="width:100%">上传资料</Button>
                                    </Upload>
                            </Modal>
                            </Col>
                        </Row>
                    </Col>
                    <Col span="8"></Col>
                    <Col span="8"></Col>
                </Row>
            </div>
            <Divider style="margin-top:15px"/>
            <div>
                <materialCard v-bind:item="material" v-for="(material,index) in materialList" :key="index"></materialCard>
            </div>
        </div>
    </Content>
</Layout>



   
</template>

<script>
import materialCard from '@/components/materialCard' //引入pageHeader组件

export default {
    name: "materialPageContent",
    data(){
        return{
            postData:{
                userId: this.$store.state.user.id
            },
            modal: false,
            loading: true,
            materialData:{
                materialDescribe:'',
            },
            materialList:''
        }
    },
    components:{
        'materialCard': materialCard,
    },
    methods:{
        OK (name) {
            setTimeout(() => {
                this.modal = false;
            }, 500);
            this.axios.put("http://localhost:80/materialDescribeUpload",this.materialData)
            .then(resp => {
                this.materialList = resp.data.data
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
        }
    },
    mounted(){
        this.axios.get("http://localhost:80/listAllMaterial")
            .then(resp => {
                this.materialList = resp.data.data
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
    }
}
</script>

<style>
   
</style>
