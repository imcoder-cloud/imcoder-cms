webpackJsonp([20],{ZP2C:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=n("XLwt"),r=n.n(i),a=n("bSGg"),o={data:function(){return{}},mounted:function(){var t=this;this.initChart();var e=this,n=setInterval(function(){t.initChart(),"/index"!=e.$route.path&&clearInterval(n)},5e3)},methods:{initChart:function(){var t=document.getElementById("pie_chart");if(!t)return!1;var e=r.a.init(t);a.a.terminalCount().then(function(t){var n=t.data,i=[];n.map(function(t){i.push(t.name)});var r={title:{text:"设备类型占比",left:"left"},tooltip:{trigger:"item",formatter:"{a} <br/>{b} : {c} ({d}%)"},legend:{orient:"vertical",left:"right",data:i},series:[{name:"访问来源",type:"pie",radius:"55%",center:["50%","60%"],data:n,emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]};e.setOption(r),window.addEventListener("resize",function(){e.resize()})})}}},s={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticStyle:{height:"400px"},attrs:{id:"pie_chart"}})},staticRenderFns:[]};var u=n("VU/8")(o,s,!1,function(t){n("n7bq")},null,null);e.default=u.exports},n7bq:function(t,e){}});