webpackJsonp([7],{"4+SH":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=a("Go1s"),s=a("c5su"),n={data:function(){return{optionsArr:["total","sizes","prev","pager","next","jumper"],tableData:[],editParams:{},tagRules:r.a.tagRules,queryParams:{pageNum:1,pageSize:10},total:0}},created:function(){this.getTags()},computed:{editTypeChange:function(){return this.editType}},watch:{},methods:{getTags:function(){var e=this;""==this.queryParams.name&&(this.queryParams.name=null),s.a.page(this.queryParams).then(function(t){e.tableData=t.data.records,e.total=t.data.total})},handleSizeChange:function(e){this.queryParams.pageSize=e,this.getTags()},handleCurrentChange:function(e){this.queryParams.pageNum=e,this.getTags()},save:function(e){var t=this;if(!this.editParams.name)return this.$message.warning("请填写名称"),!1;this.editParams.id?s.a.update(this.editParams).then(function(e){t.$message.success("保存成功"),t.reset()}):s.a.create(this.editParams).then(function(e){t.reset(),t.$message.success("保存成功"),t.getTags()})},edit:function(e){this.editParams=e},del:function(e){var t=this;s.a.delete(e.id).then(function(e){t.$confirm("此操作将永久删除该数据, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.$message.success("已删除"),t.getTags()}).catch(function(){})})},reset:function(e){this.editParams={}}}},l={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"mb20",attrs:{xl:6,lg:6,md:10,sm:24,xs:24}},[a("el-card",[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("标签编辑")])]),e._v(" "),a("div",[a("el-form",{ref:"tagForm",staticClass:"vertical-form",attrs:{model:e.editParams,"label-position":"top",rules:e.tagRules,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{attrs:{prop:"name",placeholder:"名称"},model:{value:e.editParams.name,callback:function(t){e.$set(e.editParams,"name",t)},expression:"editParams.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"别名"}},[a("el-input",{attrs:{placeholder:"别名"},model:{value:e.editParams.alias,callback:function(t){e.$set(e.editParams,"alias",t)},expression:"editParams.alias"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"路径"}},[a("el-input",{attrs:{placeholder:"访问路径"},model:{value:e.editParams.path,callback:function(t){e.$set(e.editParams,"path",t)},expression:"editParams.path"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:function(t){return e.save()}}},[e._v("保存")]),e._v(" "),a("el-button",{attrs:{size:"medium"},on:{click:function(t){return e.reset()}}},[e._v("重置")])],1)],1)],1)])],1),e._v(" "),a("el-col",{staticClass:"mb20",attrs:{xl:18,lg:18,md:14,sm:24,xs:24}},[a("el-card",[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("标签列表")])]),e._v(" "),a("div",[a("el-form",{attrs:{inline:!0}},[a("el-form-item",{attrs:{label:"标签名称"}},[a("el-input",{attrs:{placeholder:"标签名称"},model:{value:e.queryParams.name,callback:function(t){e.$set(e.queryParams,"name",t)},expression:"queryParams.name"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.getTags()}}},[e._v("查询")])],1)],1)],1),e._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("el-table",{staticStyle:{"margin-bottom":"20px"},attrs:{data:e.tableData}},[a("el-table-column",{attrs:{prop:"id",label:"ID"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"标签名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"path",label:"访问路径"}}),e._v(" "),a("el-table-column",{attrs:{prop:"alias",label:"别名"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"创建时间"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.edit(t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.del(t.row)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("el-pagination",{attrs:{background:!1,"current-page":e.queryParams.pageNum,"page-sizes":[10,20,30,40,50],"page-size":e.queryParams.pageSize,layout:e.optionsArr.join(","),total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)])],1)],1)],1)},staticRenderFns:[]};var i=a("VU/8")(n,l,!1,function(e){a("g23a")},null,null);t.default=i.exports},Go1s:function(e,t,a){"use strict";t.a={loginRules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]},modelRules:{name:[{required:!0,message:"请输入模型名称",trigger:"blur"},{min:3,max:5,message:"长度在 3 到 5 个字符",trigger:"blur"}]}}},c5su:function(e,t,a){"use strict";var r=a("vLgD"),s="/api/admin/tag",n={findAll:function(e){return Object(r.a)({url:""+s,params:e,method:"get"})},page:function(e){return Object(r.a)({url:s+"/page",params:e,method:"get"})},get:function(e){return Object(r.a)({url:s+"/"+e,method:"get"})},update:function(e){return Object(r.a)({url:s+"/update",data:e,method:"put"})},create:function(e){return Object(r.a)({url:s+"/save",data:e,method:"post"})},delete:function(e){return Object(r.a)({url:s+"/"+e,method:"delete"})}};t.a=n},g23a:function(e,t){}});