webpackJsonp([22],{"9leZ":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=a("vLgD"),i="/api/admin/label",s={findAll:function(e){return Object(l.a)({url:""+i,params:e,method:"get"})},page:function(e){return Object(l.a)({url:i+"/page",params:e,method:"get"})},get:function(e){return Object(l.a)({url:i+"/"+e,method:"get"})},update:function(e){return Object(l.a)({url:i+"/update",data:e,method:"put"})},create:function(e){return Object(l.a)({url:i+"/save",data:e,method:"post"})},delete:function(e){return Object(l.a)({url:i+"/"+e,method:"delete"})}},r=s,n={components:{},data:function(){return{fileList:[],editParams:{type:"input"},tableLoading:!1,labels:[]}},created:function(){this.getLabels()},methods:{getLabels:function(){var e=this;this.tableLoading=!0,r.findAll().then(function(t){e.labels=t.data,e.tableLoading=!1})},typeChange:function(e){},addLabel:function(){var e=this;this.editParams.id?r.update(this.editParams).then(function(t){e.$message.success("保存成功"),e.getLabels()}):r.create(this.editParams).then(function(t){e.$message.success("保存成功"),e.getLabels()})},edit:function(e){var t=this;(this.editParams=e,"file"==e.type||"image"==e.type)&&e.value.split(",").map(function(e){t.fileList.push({name:e.split("@@")[1],url:e})})},del:function(e){var t=this;r.delete(e.id).then(function(e){t.$message.success("删除成功"),t.getLabels()})},resetForm:function(){},onSuccess:function(e,t,a){t.url=e.data.url,this.editParams.value=a.map(function(e){return e.url}).join(",")},handleRemove:function(e,t){this.editParams.value=t.map(function(e){return e.url}).join(",")}}},o={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"mb20",attrs:{xl:6,lg:6,md:10,sm:24,xs:24}},[a("el-card",[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("标签编辑")])]),e._v(" "),a("el-form",{attrs:{model:e.editParams,"label-position":"right","label-width":"60px"}},[a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{attrs:{autocomplete:"off",placeholder:"名称：建议2-4字以内"},model:{value:e.editParams.name,callback:function(t){e.$set(e.editParams,"name",t)},expression:"editParams.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"字段"}},[a("el-input",{attrs:{autocomplete:"off",placeholder:"以字母开头，下划线分隔，例：price"},model:{value:e.editParams.field,callback:function(t){e.$set(e.editParams,"field",t)},expression:"editParams.field"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"类型"}},[a("el-select",{attrs:{placeholder:"请选类型"},on:{change:e.typeChange},model:{value:e.editParams.type,callback:function(t){e.$set(e.editParams,"type",t)},expression:"editParams.type"}},[a("el-option",{attrs:{label:"单行文本",value:"input"}}),e._v(" "),a("el-option",{attrs:{label:"多行文本",value:"textarea"}}),e._v(" "),a("el-option",{attrs:{label:"日期选择",value:"date"}}),e._v(" "),a("el-option",{attrs:{label:"图片上传",value:"image"}}),e._v(" "),a("el-option",{attrs:{label:"附件上传",value:"file"}})],1)],1),e._v(" "),a("el-form-item",{attrs:{label:"字段值"}},["input"==e.editParams.type?a("el-input",{attrs:{placeholder:e.editParams.name},model:{value:e.editParams.value,callback:function(t){e.$set(e.editParams,"value",t)},expression:"editParams.value"}}):"textarea"==e.editParams.type?a("el-input",{attrs:{type:"textarea",placeholder:e.editParams.name},model:{value:e.editParams.value,callback:function(t){e.$set(e.editParams,"value",t)},expression:"editParams.value"}}):"date"==e.editParams.type?a("el-date-picker",{attrs:{type:"date","value-format":"yyyy-MM-dd",placeholder:e.editParams.name},model:{value:e.editParams.value,callback:function(t){e.$set(e.editParams,"value",t)},expression:"editParams.value"}}):"image"==e.editParams.type?a("el-upload",{attrs:{action:"/api/admin/upload/image","on-remove":e.handleRemove,"on-success":e.onSuccess,"file-list":e.fileList,multiple:"","list-type":"picture"}},[a("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")]),e._v(" "),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传jpg/png文件，且不超过500kb")])],1):"file"==e.editParams.type?a("el-upload",{attrs:{action:"/api/admin/upload/file","on-remove":e.handleRemove,"on-success":e.onSuccess,"file-list":e.fileList,multiple:""}},[a("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")]),e._v(" "),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("不超过500kb")])],1):e._e()],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.addLabel}},[e._v("保存")]),e._v(" "),a("el-button",[e._v("取消")])],1)],1)],1)],1),e._v(" "),a("el-col",{staticClass:"mb20",attrs:{xl:18,lg:18,md:14,sm:24,xs:24}},[a("el-card",[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("所有标签")])]),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{"margin-bottom":"20px"},attrs:{data:e.labels,"element-loading-background":"rgba(0, 0, 0, 0.3)","element-loading-text":"数据正在加载中","element-loading-spinner":"el-icon-loading"}},[a("el-table-column",{attrs:{prop:"id",label:"ID",width:"60"}}),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"名称"}}),e._v(" "),a("el-table-column",{attrs:{prop:"field",label:"字段"}}),e._v(" "),a("el-table-column",{attrs:{prop:"value",label:"值","show-overflow-tooltip":""}}),e._v(" "),a("el-table-column",{attrs:{prop:"type",label:"类型"}}),e._v(" "),a("el-table-column",{attrs:{prop:"createTime",label:"创建时间"}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.edit(t.row)}}},[e._v("修改")]),e._v(" "),a("el-popconfirm",{staticStyle:{"margin-left":"10px"},attrs:{title:"确定删除本条数据吗？删除后不可恢复。",cancelButtonType:"default"},on:{onConfirm:function(a){return e.del(t.row)}}},[a("el-button",{attrs:{slot:"reference",type:"text"},slot:"reference"},[e._v("删除")])],1)]}}])})],1)],1)],1)],1)],1)},staticRenderFns:[]};var u=a("VU/8")(n,o,!1,function(e){a("DrGQ")},"data-v-3f932603",null);t.default=u.exports},DrGQ:function(e,t){}});