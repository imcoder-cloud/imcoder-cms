webpackJsonp([16],{Ffj8:function(e,t){},"R/97":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=a("spLH"),r=a("bSGg"),n=a("6D10"),i=a("PJh5"),o=a.n(i),s={components:{Pagination:l.a},data:function(){return{visits:[],tableLoading:!1,queryParams:{pageNum:1,pageSize:10},daterange:[],total:0}},created:function(){var e=o()().locale("zh-cn").format("YYYY-MM-DD");this.daterange=[e,e],this.getVisits()},methods:{getVisits:function(){var e=this;this.queryParams.startDate=this.daterange[0],this.queryParams.endDate=this.daterange[1],this.tableLoading=!0,r.a.page(this.queryParams).then(function(t){e.tableLoading=!1,e.visits=t.data.records,e.total=t.data.total})},handleSizeChange:function(e){this.queryParams.pageSize=e,this.getVisits()},handleCurrentChange:function(e){this.queryParams.pageNum=e,this.getVisits()},timeAgo:function(e){return n.a.timeAgo(e)}}},u={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-row",{attrs:{gutter:20}},[a("el-col",{staticClass:"mb20"},[a("el-card",[a("div",{staticStyle:{"margin-top":"20px"}},[a("el-form",{attrs:{inline:!0}},[a("el-form-item",{attrs:{label:"IP"}},[a("el-input",{attrs:{placeholder:"IP"},model:{value:e.queryParams.ip,callback:function(t){e.$set(e.queryParams,"ip",t)},expression:"queryParams.ip"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"城市"}},[a("el-input",{attrs:{placeholder:"城市"},model:{value:e.queryParams.city,callback:function(t){e.$set(e.queryParams,"city",t)},expression:"queryParams.city"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"时间段"}},[a("el-date-picker",{attrs:{type:"daterange",clearable:!1,"value-format":"yyyy-MM-dd","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.daterange,callback:function(t){e.daterange=t},expression:"daterange"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.getVisits()}}},[e._v("查询")])],1)],1)],1),e._v(" "),a("div",{staticStyle:{padding:"20px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.tableLoading,expression:"tableLoading"}],staticStyle:{"margin-bottom":"20px"},attrs:{data:e.visits,"element-loading-background":"rgba(0, 0, 0, 0.3)","element-loading-text":"数据正在加载中","element-loading-spinner":"el-icon-loading"}},[a("el-table-column",{attrs:{label:"时间","show-overflow-tooltip":""},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(e.timeAgo(t.row.createTime)))]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"ip",label:"IP"}}),e._v(" "),a("el-table-column",{attrs:{prop:"province",label:"省"}}),e._v(" "),a("el-table-column",{attrs:{prop:"city",label:"城市"}}),e._v(" "),a("el-table-column",{attrs:{prop:"isp",label:"ISP"}}),e._v(" "),a("el-table-column",{attrs:{prop:"source",label:"来源"}}),e._v(" "),a("el-table-column",{attrs:{prop:"url",label:"URL","show-overflow-tooltip":""},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-link",{attrs:{underline:!1,href:t.row.url,target:"_blank",type:"primary"}},[e._v(e._s(t.row.url))])]}}])}),e._v(" "),a("el-table-column",{attrs:{prop:"browser",label:"浏览器"}}),e._v(" "),a("el-table-column",{attrs:{prop:"os",label:"系统"}}),e._v(" "),a("el-table-column",{attrs:{prop:"terminal",label:"终端"}}),e._v(" "),a("el-table-column",{attrs:{prop:"type",label:"类型"}})],1),e._v(" "),a("pagination",{attrs:{pageNum:e.queryParams.pageNum,pageSize:e.queryParams.pageSize,total:e.total},on:{sizeChange:e.handleSizeChange,currentChange:e.handleCurrentChange}})],1)])],1)],1)],1)},staticRenderFns:[]};var c=a("VU/8")(s,u,!1,function(e){a("Ffj8")},null,null);t.default=c.exports}});