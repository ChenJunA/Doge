<template>
    <div class="layout">
        <Layout>
            <Header id="page_header">
                <Row>
                    <Col span="4" style="text-align:right; font-size:30px; color:#2b85e4"><router-link :to="{name: 'home'}">Doge</router-link></Col>
                    <Col span="4" style="text-align:right">
                        <Row>
                            <Col span="8">
                                <router-link :to="{name: 'home'}" style="color:gray">首页</router-link>
                            </Col>
                            <Col span="8">
                                <router-link :to="{name: 'forum'}" style="color:gray">论坛</router-link>
                            </Col>
                            <Col span="8">
                                <router-link :to="{name: 'material'}" style="color:gray">资料</router-link>
                            </Col>
                        </Row>
                    </Col>
                    <Col span="8" style="text-align:center;">
                        <Input icon="ios-search" placeholder="Enter something..." style="width: 90%" />
                    </Col>
                    <Col span="2">
                            <Button type="primary" style="width: 50%" @click="modal = true">发布</Button>
                            <Modal v-model="modal" title="动物信息" :loading="loading" @on-ok="OK('dogData')" :closable="false" :mask-closable="false">
                                <Form ref="dogData" :model="dogData" :label-width="40" :rules="dogValidate" class="coverCss">
                                    <FormItem prop="dogName" label="姓名">
                                        <Input type="text" v-model="dogData.dogName" placeholder="动物名">
                                        </Input>
                                    </FormItem>
                                    <FormItem prop="age" label="年龄">
                                        <Input type="text" v-model="dogData.age" placeholder="年龄">
                                        </Input>
                                    </FormItem>
                                    <FormItem prop="sex" label="性别">
                                        <Select v-model="dogData.sex">
                                            <Option value="男">男</Option>
                                            <Option value="女">女</Option>
                                        </Select>
                                    </FormItem>
                                    <FormItem prop="address" label="地址">
                                        <Input type="text" v-model="dogData.address" placeholder="地址">
                                        </Input>
                                    </FormItem>
                                    <FormItem prop="vaccine" label="疫苗">
                                        <Select v-model="dogData.vaccine">
                                            <Option value="1">已注射</Option>
                                            <Option value="0">未注射</Option>
                                        </Select>
                                    </FormItem>
                                    <FormItem prop="type" label="类别">
                                        <Select v-model="dogData.type">
                                            <Option value="1">流浪狗</Option>
                                            <Option value="2">宠物狗</Option>
                                        </Select>
                                    </FormItem>
                                    <FormItem prop="dogDescribe" label="描述">
                                        <Input v-model="dogData.dogDescribe" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述..."></Input>
                                    </FormItem>
                                </Form>
                                <Upload
                                    multiple
                                    :format="['jpg','jpeg','png']"
                                    action="http://localhost:80/dogPicsUpload"
                                    :data= "postData"
                                    class="coverCss">
                                    <Button icon="ios-cloud-upload-outline" style="width:100%">上传动物图片</Button>
                                </Upload>
                            </Modal>
                    </Col>
                    <Col span="4" style="text-align:left;">
                        <Col span="8">
                            <Icon type="ios-notifications"  size="25"/>
                        </Col>
                        <Col span="8">
                            <Icon type="ios-chatbubbles" size="25"/>
                        </Col>
                        <Col span="8">
                            <Poptip>
                                <a style="color:gray">
                                <Avatar shape="square" :src="user.avatar"></Avatar>
                                </a>
                                <div class="api" slot="content">
                                    <div class="poptip_icon">
                                        <Icon type="ios-contact" />&nbsp;<a @click="toUserPage()" style="color:gray">主页</a>
                                    </div>
                                    <Divider style="margin-top:10px"/>
                                    <div class="poptip_icon" v-if="user.id === 29">
                                        <Icon type="ios-settings" />&nbsp;<a @click="toBackground()" style="color:gray">设置</a>
                                    </div>
                                    <Divider style="margin-top:10px" v-if="user.id === 29"/>
                                    <div class="poptip_icon">
                                       <Icon type="ios-power" />&nbsp;<a @click="quit()" style="color:gray">退出</a>
                                    </div>
                                </div>
                            </Poptip>
                        </Col>
                    </Col>
                </Row>
            </Header>
        </Layout>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                postData:{
                    dogId: this.$store.state.latestDogId + 1
                },
                dogData: {
                    dogName:'',
                    age:'',
                    sex:'',
                    address:'',
                    vaccine:'',
                    type:'',
                    dogDescribe:'',
                    foster: this.$store.state.user.id
                },
                modal: false,
                loading: true,
                dogValidate: {
                    dogName: [
                        { required: true, message: '姓名不能为空', trigger: 'blur' }
                    ],
                    age: [
                        { required: true, message: '年龄不能为空', trigger: 'blur' },
                    ],
                    sex: [
                        { required: true, message: '性别不能为空', trigger: 'blur' },
                    ],
                    address: [
                        { required: true, message: '地址不能为空', trigger: 'blur' },
                    ],
                    vaccine: [
                        { required: true, message: '疫苗不能为空', trigger: 'blur' },
                    ],
                    type: [
                        { required: true, message: '类型不能为空', trigger: 'blur' },
                    ],
                    dogDescribe: [
                        { required: true, message: '描述不能为空', trigger: 'blur' },
                    ]
                }
            }
        },
        mounted(){
            this.axios.get("http://localhost:80/latestDogId")
            .then(resp => {
                console.log(resp.data.data)
                this.$store.dispatch('getLatestDogId', resp.data.data)
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });
        },
        computed: {
            user () {
                return this.$store.state.user
            }
        },
        methods: {
            quit(){
                this.axios.post("http://localhost:80/logout")
                this.$router.push('/');
            },
            toUserPage(){
                this.$router.push('/userPage');
            },
            toBackground(){
                this.$router.push('/background');
            },
            OK (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                         setTimeout(() => {
                            this.modal = false;
                        }, 500);

                        this.axios.post("http://localhost:80/dog",this.dogData)
                        .then(resp => {
                            // this.$Message.success("发布成功");
                        })
                        .catch(err => {
                            this.$Message.error("请求出错");
                        });
                    } else {
                        this.$Message.error('动物信息有误！')
                    }
                })
            }
        }
    }
</script>

<style>
    #page_header {
        background: white;
        font-size: 16px;
    }
    .poptip_icon {
        text-align: center;
        font-size: 16px;
    }
    .coverCss .ivu-form-item-required .ivu-form-item-label:before {
        content: '';
        display: inline-block;
        margin-right: 4px;
        line-height: 1;
        font-family: SimSun;
        font-size: 12px;
        color: #ed4014;
    }
    .coverCss .ivu-upload-select {
        display: inline-block;
        width: 100%;
    }
</style>
