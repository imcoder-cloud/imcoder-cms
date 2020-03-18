webpackJsonp([11],{bktE:function(o,t){},fcUy:function(o,t){},vAOe:function(o,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=e("BO1k"),l=e.n(r),n={name:"colorPicker",props:{value:{type:String,required:!0},defaultColor:{type:String,default:"#000000"},disabled:{type:Boolean,default:!1}},data:function(){return{openStatus:!1,hoveColor:null,tColor:["#ffffff","#000000","#eeece1","#1e497b","#4e81bb","#e2534d","#9aba60","#8165a0","#47acc5","#f9974c"],colorConfig:[["#7f7f7f","#f2f2f2"],["#0d0d0d","#808080"],["#1c1a10","#ddd8c3"],["#0e243d","#c6d9f0"],["#233f5e","#dae5f0"],["#632623","#f2dbdb"],["#4d602c","#eaf1de"],["#3f3150","#e6e0ec"],["#1e5867","#d9eef3"],["#99490f","#fee9da"]],bColor:["#c21401","#ff1e02","#ffc12a","#ffff3a","#90cf5b","#00af57","#00afee","#0071be","#00215f","#72349d"],html5Color:this.value}},computed:{showPanelColor:function(){return this.hoveColor?this.hoveColor:this.showColor},showColor:function(){return this.value?this.value:this.defaultColor},colorPanel:function(){var o=[],t=!0,e=!1,r=void 0;try{for(var n,a=l()(this.colorConfig);!(t=(n=a.next()).done);t=!0){var u=n.value;o.push(this.gradient(u[1],u[0],5))}}catch(o){e=!0,r=o}finally{try{!t&&a.return&&a.return()}finally{if(e)throw r}}return o}},methods:{triggerHtml5Color:function(){this.$refs.html5Color.click()},updataValue:function(o){this.$emit("input",o),this.$emit("change",o),this.openStatus=!1},handleDefaultColor:function(){this.updataValue(this.defaultColor)},parseColor:function(o){if(4!==o.length)return o;o="#"+o[1]+o[1]+o[2]+o[2]+o[3]+o[3]},rgbToHex:function(o,t,e){var r=(o<<16|t<<8|e).toString(16);return"#"+new Array(Math.abs(r.length-7)).join("0")+r},hexToRgb:function(o){o=this.parseColor(o);for(var t=[],e=1;e<7;e+=2)t.push(parseInt("0x"+o.slice(e,e+2)));return t},gradient:function(o,t,e){for(var r=this.hexToRgb(o),l=this.hexToRgb(t),n=(l[0]-r[0])/e,a=(l[1]-r[1])/e,u=(l[2]-r[2])/e,i=[],c=0;c<e;c++)i.push(this.rgbToHex(parseInt(n*c+r[0]),parseInt(a*c+r[1]),parseInt(u*c+r[2])));return i}},mounted:function(){var o=this;document.onclick=function(){o.openStatus=!1}}},a={render:function(){var o=this,t=o.$createElement,e=o._self._c||t;return e("div",{ref:"colorPicker",staticClass:"colorPicker",on:{click:function(o){o.stopPropagation()}}},[e("div",{staticClass:"colorBtn",class:{disabled:o.disabled},style:"background-color: "+o.showColor,on:{click:function(t){o.openStatus=!o.disabled}}}),o._v(" "),e("input",{directives:[{name:"model",rawName:"v-model",value:o.html5Color,expression:"html5Color"}],ref:"html5Color",attrs:{type:"color"},domProps:{value:o.html5Color},on:{change:function(t){return o.updataValue(o.html5Color)},input:function(t){t.target.composing||(o.html5Color=t.target.value)}}}),o._v(" "),e("div",{staticClass:"box",class:{open:o.openStatus}},[e("div",{staticClass:"hd"},[e("div",{staticClass:"colorView",style:"background-color: "+o.showPanelColor}),o._v(" "),e("div",{staticClass:"defaultColor",on:{click:o.handleDefaultColor,mouseover:function(t){o.hoveColor=o.defaultColor},mouseout:function(t){o.hoveColor=null}}},[o._v("默认颜色")])]),o._v(" "),e("div",{staticClass:"bd"},[e("h3",[o._v("主题颜色")]),o._v(" "),e("ul",{staticClass:"tColor"},o._l(o.tColor,function(t,r){return e("li",{key:r,style:{backgroundColor:t},on:{mouseover:function(e){o.hoveColor=t},mouseout:function(t){o.hoveColor=null},click:function(e){return o.updataValue(t)}}})}),0),o._v(" "),e("ul",{staticClass:"bColor"},o._l(o.colorPanel,function(t,r){return e("li",{key:r},[e("ul",o._l(t,function(t,r){return e("li",{key:r,style:{backgroundColor:t},on:{mouseover:function(e){o.hoveColor=t},mouseout:function(t){o.hoveColor=null},click:function(e){return o.updataValue(t)}}})}),0)])}),0),o._v(" "),e("h3",[o._v("标准颜色")]),o._v(" "),e("ul",{staticClass:"tColor"},o._l(o.bColor,function(t,r){return e("li",{key:r,style:{backgroundColor:t},on:{mouseover:function(e){o.hoveColor=t},mouseout:function(t){o.hoveColor=null},click:function(e){return o.updataValue(t)}}})}),0),o._v(" "),e("h3",{staticClass:"more-color",on:{click:o.triggerHtml5Color}},[o._v("更多颜色...")])])])])},staticRenderFns:[]};var u={components:{ColorPicker:e("VU/8")(n,a,!1,function(o){e("bktE")},"data-v-501a46b6",null).exports},data:function(){return{color:"#409EFF"}}},i={render:function(){var o=this,t=o.$createElement,e=o._self._c||t;return e("div",[e("color-picker",{model:{value:o.color,callback:function(t){o.color=t},expression:"color"}}),o._v(" "),e("div",[o._v(o._s(o.color))])],1)},staticRenderFns:[]};var c=e("VU/8")(u,i,!1,function(o){e("fcUy")},null,null);t.default=c.exports}});