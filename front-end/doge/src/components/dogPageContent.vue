<template>
<Layout>
    <Content>
        <div class="page_content">
            <div class="carouselDiv">
                <Carousel autoplay loop :height="400" :radius-dot="true">
                    <CarouselItem v-for="(pic,key) in this.pictures" :key="key">
                        <div class="demo-carousel">
                            <img :src="pic" style="width:100%; height:400px">
                        </div>
                    </CarouselItem>
                </Carousel>
            </div>

            <div class="dogInfoDiv" style="margin-top:30px; margin-left:70px; margin-bottom:24px; font-size:14px; text-align:left; width: 75%; float:left;" v-if="this.dog">
                <Row>
                    <Col span="8"><span style="font-weight:bold">姓名：</span>{{this.dog.dogName}}</Col>
                    <Col span="8"><span style="font-weight:bold">年龄：</span>{{this.dog.age}}</Col>
                    <Col span="8"><span style="font-weight:bold">性别：</span>{{this.dog.sex}}</Col>
                </Row>
                <br>
                <Row>
                    <Col span="8"><span style="font-weight:bold">地址：</span>{{this.dog.address}}</Col>
                    <Col span="8"><span style="font-weight:bold">疫苗：</span>{{this.dog.vaccine}}</Col>
                    <Col span="8"><span style="font-weight:bold">类别：</span>{{this.dog.type}}</Col>
                </Row>
                <br>
                <Row>
                    <Col span="20">{{this.dog.dogDescribe}}</Col>
                </Row>
            </div>

            <div class="dogBtnDiv" style="width:15%; float:right;">
                <Row style="margin-top:25px">
                    <Col span="8" style="text-align:center" v-if="this.dog && this.dog.foster !== this.$store.state.user.id">
                        <Button style="width:100px" type="info" v-if="this.isCollect" disabled>已收藏</Button>
                        <Button style="width:100px" type="info" v-else @click="toCollect(dog.id)">收藏动物</Button>
                    </Col>
                    <Col span="8" style="text-align:center" v-if="this.dog && this.dog.foster === this.$store.state.user.id">
                        <Button style="width:100px" type="info" @click="updateDoge()">修改信息</Button>
                        <Modal v-model="dogModal" title="修改动物信息" :loading="loading" @on-ok="updateDogeOK(dog.id)" :closable="false" :mask-closable="false">
                                <Form ref="updateDogData" :model="updateDogData" :label-width="40" :rules="dogValidate" class="coverCss">
                                    <FormItem prop="dogName" label="姓名">
                                        <Input type="text" v-model="updateDogData.dogName" placeholder="动物名" >
                                        </Input>
                                    </FormItem>
                                    <FormItem prop="age" label="年龄">
                                        <Input type="text" v-model="updateDogData.age" placeholder="年龄">
                                        </Input>
                                    </FormItem>
                                    <FormItem prop="sex" label="性别">
                                        <Select v-model="updateDogData.sex">
                                            <Option value="男">男</Option>
                                            <Option value="女">女</Option>
                                        </Select>
                                    </FormItem>
                                    <FormItem prop="address" label="地址">
                                        <Input type="text" v-model="updateDogData.address" placeholder="地址">
                                        </Input>
                                    </FormItem>
                                    <FormItem prop="vaccine" label="疫苗">
                                        <Select v-model="updateDogData.vaccine">
                                            <Option value="1">已注射</Option>
                                            <Option value="0">未注射</Option>
                                        </Select>
                                    </FormItem>
                                    <FormItem prop="type" label="类别">
                                        <Select v-model="updateDogData.type">
                                            <Option value="1">流浪狗</Option>
                                            <Option value="2">宠物狗</Option>
                                        </Select>
                                    </FormItem>
                                    <FormItem prop="dogDescribe" label="描述">
                                        <Input v-model="updateDogData.dogDescribe" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="描述..."></Input>
                                    </FormItem>
                                </Form>
                            </Modal>
                    </Col>
                </Row>
                <Row style="margin-top:25px">
                    <Col span="8" style="text-align:center" v-if="this.dog && this.dog.foster !== this.$store.state.user.id">
                        <Button style="width:100px" type="info" v-if="this.dog && this.dog.adopt === null"  @click="toAdopt(dog.id, dog.foster)">发起领养</Button>
                        <Button style="width:100px" type="info" disabled v-if="this.dog && this.dog.adopt !== null">发起领养</Button>
                        <Modal
                            v-model="modal"
                            title="联系他/她"
                            footer-hide
                            v-if="this.fosterUser"
                            width="400px">
                            <div style="height:100px  ">
                                <div style="float:left; width:120px">
                                    <Avatar shape="square" :src="this.fosterUser.avatar" style="width:100px; height:100px"/>
                                </div>
                                <div style="float:left; font-size:14px">
                                    <Row>用户名：{{fosterUser.username}}</Row>
                                    <Row>电话号码：{{fosterUser.phoneNumber}}</Row>
                                    <Row>邮箱：{{fosterUser.email}}</Row>
                                    <Row>地址：{{fosterUser.address}}</Row>
                                    <Row>{{fosterUser.biography}}</Row>
                                </div>
                            </div>
                        </Modal>
                    </Col>
                    <Col span="8" style="text-align:center" v-if="this.dog && this.dog.foster === this.$store.state.user.id">
                        <Button style="width:100px" type="info" v-if="this.dog && this.dog.state === 3" disabled>已领养</Button>
                        <Button style="width:100px" type="info" v-if="this.dog && this.dog.state === 1" disabled>确认领养</Button>
                        <Button style="width:100px" type="info" @click="confirmAdopt(dog.id)"  v-if="this.dog && this.dog.state === 2">确认领养</Button>
                    </Col>
                </Row>
            </div>
            <Divider />

            <div class="stepsDiv" style="text-align:center;">
                <Steps v-if="this.dog && this.dog.state" :current="this.dog.state - 1">
                    <Step title="待领养" content=""></Step>
                    <Step title="领养中" content=""></Step>
                    <Step title="已领养" content=""></Step>
                </Steps>
            </div>
            <Divider />
            
            <div class="dogCommentListDiv" style=" margin-left:20px; font-size:15px">
                <Row>
                    <Col span="24" style="font-size:20px;">评论列表</Col>
                </Row>
                <br/>
                <div v-for="dogeComment in dogCommentList">
                    <Row >
                        <Col span="12" style="font-weight:bold">
                            {{dogeComment.username}}
                        </Col>
                        <Col span="12" style="text-align:right;padding-right:20px">
                            {{dogeComment.gmtCreate}}
                        </Col>
                    </Row>
                    <Row>
                        <Col span="24">
                            {{dogeComment.content}}
                        </Col>
                    </Row>
                    <Divider style="margin-top:10px"/>
                </div>
            </div>
            <Divider />

            <div class="dogCommentDiv" style="margin-bottom:100px; height:200px">
                <div style="width:95%; margin:auto">
                    <Form ref="dogComment" :model="dogComment" class="coverCss">
                        <FormItem prop="content">
                            <Input type="text" v-model="dogComment.content" placeholder="评论内容">
                            </Input>
                        </FormItem>
                    </Form>
                </div>
                <div>
                    <Button type="info" style="float:right;width:100px;margin-right:25px" @click="insertDogComment()">评论</Button>
                </div>
            </div>
        </div>
    </Content>
</Layout>
</template>

<script>
    export default {
        data () {
            return {
                dog: undefined,
                pictures: undefined,
                isCollect: undefined,
                modal: false,
                fosterUser:undefined,
                dogModal:undefined,
                updateDogData:{
                    dogName:'',
                    age:'',
                    sex:'',
                    address:'',
                    vaccine:'',
                    type:'',
                    dogDescribe:'',
                    id:'',
                },
                dogComment:{
                    userId:this.$store.state.user.id,
                    dogId:this.$store.state.dogId,
                    content:'',
                },
                dogCommentList:undefined,
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
        computed: {
            
        },
        mounted() {
            this.axios.get("http://localhost:80/getDogById/" + this.$store.state.dogId)
            .then(resp => {
                this.dog = resp.data.data
                this.pictures = resp.data.data.pictures
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });

            this.axios.get("http://localhost:80/isCollect",{
                params:{
                    userId: this.$store.state.user.id,
                    dogId: this.$store.state.dogId
                }
            })
            .then(resp => {
                if (resp.data.data.length !== 0){
                    this.isCollect = true;
                } else {
                    this.isCollect = false;
                }
                console.log(resp.data.data)
                console.log(this.isCollect)
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });

            this.axios.get("http://localhost:80/listDogComment",{
                params:{
                    dogId: this.$store.state.dogId
                }
            })
            .then(resp => {
                this.dogCommentList = resp.data.data
            })
            .catch(err => {
                this.$Message.error("请求出错");
            });

        },
        methods: {
            toAdopt(dogId,foster){
                this.modal = true;
                this.getFosterUser(foster);
                this.axios.put("http://localhost:80/toAdopt",{
                    dogId: dogId,
                    adoptId: this.$store.state.user.id
                })
                .then(resp => {
                    this.dog = resp.data.data
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            toCollect(dogId){
                this.axios.post("http://localhost:80/toCollect",{
                    dogId: dogId,
                    userId: this.$store.state.user.id
                })
                .then(resp => {
                    this.$Message.success("收藏成功");
                    this.iscollect()
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            iscollect(){
                this.axios.get("http://localhost:80/isCollect",{
                params:{
                    userId: this.$store.state.user.id,
                    dogId: this.$store.state.dogId
                }
                })
                .then(resp => {
                    if (resp.data.data.length !== 0){
                        this.isCollect = true;
                    } else {
                        this.isCollect = false;
                    }
                    console.log(resp.data.data)
                    console.log(this.isCollect)
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            confirmAdopt(dogId){
                this.axios.put("http://localhost:80/confirmAdopt",{
                    dogId:dogId
                })
                .then(resp => {
                    this.dog = resp.data.data
                    this.$Message.success("确认领养成功");
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            getFosterUser(foster){
                this.axios.get("http://localhost:80/getUserById",{
                    params:{
                        userId:foster
                    }
                })
                .then(resp => {
                    this.fosterUser = resp.data.data
                    console.log(this.fosterUser)
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            updateDoge(){
                this.dogModal = true
                this.updateDoge = this.dog;
                console.log("hahah")
                console.log(this.updateDoge);
            },
            updateDogeOK(id){
                this.updateDogData.id = id;
                this.axios.put("http://localhost:80/updateDog". this.updateDogData)
                .then(resp => {
                    this.dog = resp.data.data
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            insertDogComment(){
                this.axios.post("http://localhost:80/insertDogComment", this.dogComment)
                .then(resp => {
                    this.listDogComment();
                    this.$Message.success("评论成功");
                })
                .catch(err => {
                    this.$Message.error("请求出错");
                });
            },
            listDogComment(){
                this.axios.get("http://localhost:80/listDogComment",{
                params:{
                    dogId: this.$store.state.dogId
                }
                })
                .then(resp => {
                    this.dogCommentList = resp.data.data
                    console.log(this.dogCommentList)
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
