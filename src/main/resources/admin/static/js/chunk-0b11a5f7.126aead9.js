(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0b11a5f7","chunk-2d0dd9a4"],{1485:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e.canBeLeafMenu(e.menu)?[n("menu-link",{attrs:{type:e.leafMenu.type,path:e.resolvePath(e.leafMenu)}},[n("el-menu-item",{attrs:{index:e.resolvePath(e.leafMenu)}},[n("i",{class:e.leafMenu.icon}),n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s("zh-CN"==e.lang?e.leafMenu.name:e.leafMenu.enName))])])],1)]:n("el-submenu",{attrs:{index:e.resolvePath(e.menu)}},[n("template",{slot:"title"},[n("i",{class:e.menu.icon}),n("span",[e._v(e._s("zh-CN"==e.lang?e.menu.name:e.menu.enName))])]),e._l(e.menu.children,(function(t){return n("menu-item",{key:t.id,attrs:{menu:t,"base-path":e.resolvePath(e.menu)}})}))],2)],2)},u=[],r=n("0eaa"),l=n("6266"),s=n.n(l),i=n("ae8c"),c=n("81a6"),o={name:"MenuItem",components:{MenuLink:c["default"]},computed:Object(r["a"])(Object(r["a"])({},Object(i["b"])(["settings"])),{},{lang:function(){return this.settings.lang}}),props:{menu:{required:!0},basePath:{type:String,default:""}},data:function(){return{leafMenu:{}}},methods:{canBeLeafMenu:function(e){return e.children&&0!==e.children.length?1===e.children.length&&(this.leafMenu=e.children[0],!0):(this.leafMenu=e,!0)},resolvePath:function(e){switch(e.type){case"external":return e.path;case"click":return e.path+"@click";default:var t=s.a.resolve(this.basePath,e.path);return t}}}},h=o,f=n("4023"),p=Object(f["a"])(h,a,u,!1,null,null,null);t["default"]=p.exports},"81a6":function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n(e.none,e._b({tag:"component"},"component",e.tagetConvert(e.type,e.path),!1),[e._t("default")],2)},u=[],r={props:{type:{required:!0},path:{required:!0}},methods:{tagetConvert:function(e,t){switch(e){case"external":return{is:"a",href:t,target:"_blank"};case"click":return{is:"a",href:"javascript:void(0);"};default:return{is:"router-link",to:t}}},none:function(){return null}}},l=r,s=n("4023"),i=Object(s["a"])(l,a,u,!1,null,null,null);t["default"]=i.exports}}]);