webpackJsonp([8],{AWYA:function(e,t){},jKLp:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=i("BO1k"),s=i.n(n),r=i("Gu7T"),a=i.n(r),l=i("o/zv"),o=i.n(l),c=(i("YaEn"),i("SQ6o")),u={props:{type:{default:"tab"}},data:function(){return{visible:!1,top:0,left:0,fixedTags:[],selectedTag:{},currentViews:this.$route.name}},computed:{visitedViews:function(){return this.$store.state.viewsBar.visitedViews}},watch:{$route:function(){this.currentViews=this.$route.name,this.addViewTags(),"tag"==this.type&&this.moveToCurrentTag()},visible:function(e){e?document.body.addEventListener("click",this.closeMenu):document.body.removeEventListener("click",this.closeMenu)}},mounted:function(){this.initTags(),this.addViewTags()},methods:{isActive:function(e){return e.path===this.$route.path},filterFixedViews:function(e){var t=this,i=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"/",n=[];return e.forEach(function(e){if(e.fixed){var s=o.a.resolve(i,e.path);n.push({fullPath:s,path:s,name:e.name,fixed:e.meta&&e.meta.fixed})}if(e.children){var r=t.filterFixedViews(e.children,e.path);r.length>=1&&(n=[].concat(a()(n),a()(r)))}}),n},initTags:function(){var e=this.fixedTags=this.filterFixedViews(c.a.getDynamicRouters()),t=!0,i=!1,n=void 0;try{for(var r,a=s()(e);!(t=(r=a.next()).done);t=!0){var l=r.value;l.name&&this.$store.dispatch("addVisitedView",l)}}catch(e){i=!0,n=e}finally{try{!t&&a.return&&a.return()}finally{if(i)throw n}}},addViewTags:function(){return this.$route.name&&this.$store.dispatch("addView",this.$route),!1},moveToCurrentTag:function(){var e=this,t=this.$refs.tag;this.$nextTick(function(){var i=!0,n=!1,r=void 0;try{for(var a,l=s()(t);!(i=(a=l.next()).done);i=!0){var o=a.value;if(o.$el.dataset.path===e.$route.path){e.moveToTarget(o),o.fullPath!==e.$route.fullPath&&e.$store.dispatch("updateVisitedView",e.$route);break}}}catch(e){n=!0,r=e}finally{try{!i&&l.return&&l.return()}finally{if(n)throw r}}})},refreshSelectedTag:function(e){var t=e.fullPath;if(t==this.$route.fullPath)return this.$router.replace("/"),void this.$router.replace(t);this.$router.replace(t)},closeTag:function(e){var t=this.visitedViews.filter(function(t){return t.path==e})[0];this.closeSelectedTag(t)},clickTag:function(e){this.$route.path!=e&&this.$router.push(e)},closeSelectedTag:function(e){var t=this;this.$store.dispatch("delView",e).then(function(i){var n=i.visitedViews;if(t.isActive(e)){var s=n.slice(-1)[0];s?t.$router.push(s.path):t.$router.push("/")}})},closeOthersTags:function(){var e=this;this.$router.push(this.selectedTag),this.$store.dispatch("delOthersViews",this.selectedTag).then(function(){e.moveToCurrentTag()})},closeAllTags:function(e){var t=this;this.$store.dispatch("delAllViews").then(function(i){var n=i.visitedViews;t.fixedTags.some(function(t){return t.path===e.path})||t.toLastView(n,e)})},toLastView:function(e,t){var i=e.slice(-1)[0];i?this.$router.push(i):"首页"===t.name?this.$router.replace({path:t.fullPath}):this.$router.push("/")},openMenu:function(e,t){var i=this.$el.getBoundingClientRect().left,n=this.$el.offsetWidth+i-105,s=t.clientX+5;this.left=s>n?n:s,this.top=t.clientY,this.visible=!0,this.selectedTag=e},closeMenu:function(){this.visible=!1},handleScroll:function(e){var t=-e.wheelDelta||40*-e.deltaY,i=this.$refs.scrollContainer.$refs.wrap;i.scrollLeft=i.scrollLeft+t/4},moveToTarget:function(e){var t=this.$refs.scrollContainer.$el.offsetWidth,i=this.$refs.scrollContainer.$refs.wrap,n=this.$refs.tag,s=null,r=null,a=null,l=null;n.length>0&&(s=n[0],r=n[n.length-1]);for(var o=0;o<n.length;o++)if(n[o]===e){0===o?l=n[o].length>1&&n[o+1]:o===n.length-1?a=n[o].length>1&&n[o-1]:(a=n[o-1],l=n[o+1]);break}if(s===e)i.scrollLeft=0;else if(r===e)i.scrollLeft=i.scrollWidth-t;else{var c=l.$el.offsetLeft+l.$el.offsetWidth+4,u=a.$el.offsetLeft-4;c>i.scrollLeft+t?i.scrollLeft=c-t:u<i.scrollLeft&&(i.scrollLeft=u)}},tabClick:function(e){var t=e.$el.dataset.path;this.$route.path!=t&&this.$router.push(t)},removeView:function(e){var t=this.visitedViews.filter(function(t){return t.name==e})[0];this.closeSelectedTag(t)}}},h={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",["tag"==e.type?i("div",{staticClass:"views-container"},[i("el-scrollbar",{ref:"scrollContainer",staticClass:"scroll-container",attrs:{vertical:!1},nativeOn:{wheel:function(t){return t.preventDefault(),e.handleScroll(t)}}},e._l(e.visitedViews,function(t){return i("el-tag",{key:t.path,ref:"tag",refInFor:!0,staticClass:"view-item",attrs:{type:e.isActive(t)?"":"info",closable:!t.fixed,size:"medium","data-path":t.path},on:{close:function(i){return e.closeTag(t.path)},click:function(i){return e.clickTag(t.path)}},nativeOn:{contextmenu:function(i){return i.preventDefault(),e.openMenu(t,i)}}},[e._v(e._s(t.name))])}),1),e._v(" "),i("ul",{directives:[{name:"show",rawName:"v-show",value:e.visible,expression:"visible"}],staticClass:"contextmenu",style:{left:e.left+"px",top:e.top+"px"}},[i("li",{on:{click:function(t){return e.refreshSelectedTag(e.selectedTag)}}},[e._v("刷新")]),e._v(" "),e.selectedTag.fixed?e._e():i("li",{on:{click:function(t){return e.closeSelectedTag(e.selectedTag)}}},[e._v("关闭")]),e._v(" "),i("li",{on:{click:e.closeOthersTags}},[e._v("关闭其他")]),e._v(" "),i("li",{on:{click:function(t){return e.closeAllTags(e.selectedTag)}}},[e._v("关闭所有")])])],1):e._e(),e._v(" "),"tab"==e.type?i("div",{staticClass:"tab-views"},[i("el-tabs",{attrs:{type:"card"},on:{"tab-click":e.tabClick,"tab-remove":e.removeView},model:{value:e.currentViews,callback:function(t){e.currentViews=t},expression:"currentViews"}},e._l(e.visitedViews,function(t){return i("el-tab-pane",{key:t.name,ref:"tag",refInFor:!0,attrs:{"data-path":t.path,label:t.name,closable:!t.fixed,name:t.name},nativeOn:{contextmenu:function(i){return i.preventDefault(),e.openMenu(t,i)}}})}),1)],1):e._e()])},staticRenderFns:[]};var f=i("VU/8")(u,h,!1,function(e){i("AWYA"),i("ys6I")},"data-v-61c18c56",null);t.default=f.exports},ys6I:function(e,t){}});