


















var JESONG_MESSAGE_TEXT;
var jesong;
window.sendJesongError = function(type, error){
	var img = document.createElement("img");
	img.src= "http://m.easyliao.com/i?cmd=loadError&c=3201&j=32502&type="+type+"&error="+(error ? window.encodeURIComponent(error) : "")+"&url="+window.encodeURIComponent(window.location.href);
	img.style="border:0px;width:0px;height:0px;";
	document.body.appendChild(img);
};
window.jesongErrorTimeout = window.setTimeout(function(){
	window.sendJesongError(2);
}, 5000);
(function(){
	function isMobile(){
		if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){ 
			return true;
		}else{
			return false;
		}
	}
	if(jesong || (false && false != isMobile())){
		return;
	}
JESONG_MESSAGE_TEXT = {"inviteText":"","extCode":"","msgOfDisConnected":"感谢您的咨询， 再见！","welcomeMsgOfConnected":"<p>系统可以：在线直播、在线录播 授课、在线考试、互动答疑、直播公开课 、社区讨论等多项功能</p>","inviteTitle":"","replyMsgAtConnected":"","welcomeMsgOfConnectedMin":"<p>系统可以：在线直播、在线录播 授课、在线考试、互动答疑、直播公开课 、社区讨论等多项功能</p>","msgOfTrans":"您的对话将被转移给我的同事， 感谢您的咨询！"};
jesong={	
	lazy : false,
	version : '20190927',
	language : 'sc',
	visitorReady : false,
	forceReady : false,
	newChat : false,
	jsType : 0,
	callerOpinion : "0",
	env:{
		aiReady : -1,
		isPhone : false,
		scheme : "http",
		schemePort : "80",
		server:{
			monitor:'http://m.easyliao.com/',
			chat:'http://live.easyliao.com/live/',
			file:'http://scripts.easyliao.com/prd/',
			guide : 'http://live.easyliao.com/api/robot'
		},
		compId:3201,
		confId:32502,
		vId:'',
		uId:'',
		pId:0,
		sid:0,
		promotionId:0,
		mId:'',
		lang:'',
		min:1,
		pos:'1'
	},
	config:{
		firstToRebot:0,
		phoneChatPop:0,
		monitor:true,
		panel:true,
		frameChatStyle:14,
		forceChatLogo:""
	},
	monitor:{},	panel:{},win:{},icon:{},text:{}, freecall:{}, probe:{}, phone:{},
	_isBindHost:function(){
		var bindHosts = "";
		if(bindHosts != ""){
			var _hosts = bindHosts.split(",");
			var domain = window.location.host;
			var bindHostFlag = false;
			for(var i=0; i < _hosts.length; i++){
				if(domain == _hosts[i]){
					bindHostFlag = true;
					break;
				}
			}
			return bindHostFlag;
		}else{
			return true;
		}
	},
	_genId : function(){
		var random4 = function(){
			return parseInt(Math.random()*9000+1000, 10);
		}
		var cId = "3201";
		while(cId.length < 12){
			cId = "0"+cId;
		}
		var id = ""+new Date().getTime();
		id = id.substring(3);
		id += random4();
		id += random4();
		return "01"+cId+id;
	},
	_createLayout : function(id, className){
		if(!this.lazy){
			document.write('<div id="'+id+'" class="'+className+'"></div>');
		}else{
			var _div = document.createElement("div");
			_div.id = id;
			_div.className = className;
			document.body.appendChild(_div);
		}
	},
	_loadJS : function(src){
		if(!this.lazy){
			//async="async"
			document.write('<scr'+'ipt type="text/javascript" defer src="'+src+'"></scr'+'ipt>');
		}else{
		    var script = document.createElement( "script" ); 
			script.type = "text/javascript"; 
			script.charset = "utf-8";
			script.src = src; 
			document.getElementsByTagName("script")[0].parentNode.appendChild(script); 
		}
	},
	_loadCSS : function(url){ 
		if(!this.lazy){
			document.write('<link rel="stylesheet" type="text/css" href="'+url+'"></link>');
		}else{
			var link = document.createElement( "link" ); 
			link.type = "text/css"; 
			link.rel = "stylesheet"; 
			link.href = url; 
			document.getElementsByTagName( "head" )[0].appendChild( link ); 
		}
	},
	init:function(){
		if(this._isBindHost()){
			jesong.env.vId = this._genId();
			this._createLayout("jesong_panel", "");
			if(jesong.jsType == 1 && jesong.env.isPhone){
				this._createLayout("jesong_chat_layout", "jesong_phone_layout jesong_phone_layout_sc_1");
			}else{
				this._createLayout("jesong_chat_layout", "jesong_chat_layout_pc jesong_chat_layout_pc_sc");
			}
			document.getElementById("jesong_chat_layout").style.display = "none";
			this._createLayout("jesong_chat_min", "jesong_chat_min_sc");
			this._createLayout("jesong_pop_msg", (jesong.jsType == 1 && jesong.env.isPhone) ? "jesong_pop_msg_phone" : "");
			if("https:" == document.location.protocol){
				this.env.server.monitor = this.env.server.monitor.replace("http:", "https:");
				this.env.server.chat = this.env.server.chat.replace("http:", "https:");
				this.env.server.file = this.env.server.file.replace("http:", "https:");
				this.env.schemePort = "443";
				this.env.scheme = "https";
				
			}
			this._loadCSS(this.env.server.file + "css/webcall.css?ver=20190927");
			this._loadJS(this.env.server.file + "static/2019/js/webcall.js?ver=20190927");
			this._loadCSS(this.env.server.file + "static/2019/css/force.css?ver=20190927");
		}
	},
	words:{
		welcome:JESONG_MESSAGE_TEXT.welcomeMsgOfConnected,
		welcomeMin:JESONG_MESSAGE_TEXT.welcomeMsgOfConnectedMin,
		greeting:JESONG_MESSAGE_TEXT.replyMsgAtConnected,
		disconnect:JESONG_MESSAGE_TEXT.msgOfDisConnected
	}
};



jesong.monitor.config={
	index:11,
	type:0,
	title:JESONG_MESSAGE_TEXT.inviteTitle,
	text:JESONG_MESSAGE_TEXT.inviteText,
	pos:'3',
	auto:-1,
	showInviteAgain:-1,
	autoInviteTimes:-1,
	group:'4480',
	start:'09:00',
	end:'18:00',
	mask:false,
	mainBg:'url() no-repeat',
	mainHeight:'0',
	mainWidth:'0',
	acceptStyle:'position:absolute;background:url() no-repeat;height:0px;width:0px;top:0px;left:0px;',
	refuseStyle:'position:absolute;background:url() no-repeat;height:0px;width:0px;top:0px;left:0px;',
	textStyle:'position:absolute;height:0px;width:0px;top:0px;left:0px;'
	
};


jesong.panel.config={
	category:'icon',	
	position:0,
	vertical:120,
	horizon:5,
	panelWhenInvite:'1'
};





jesong.icon.config={
	mode:1,
	target:'4480',
	online:'http://live.jswebcall.com/images/floaticon/online-2.png',
	offline:'http://live.jswebcall.com/images/floaticon/offline-2.png',
	width:0,
	height:0,
	status:1,
	closeWidth : 16,
	closeHeight : 16,
	closeTop : 54,
	closeLeft : 181
};






jesong.freecall.config = {
	groupId : -1,
	show : false,
	panelPos : 0,
	
	panelBg : "",
	panelWidth : 0,
	panelHeight : 0,
	
	panelTop : -1,
	panelLeft : -1,
	panelRight : -1,
	panelBottom : -1,
	
	textWidth : 0,
	textHeight : 0,
	textLeft : 0,
	textTop : 0,
	
	closeWidth : 0,
	closeHeight : 0,
	closeLeft : 0,
	closeTop : 0,
	
	callWidth : 0,
	callHeight : 0,
	callLeft : 0,
	callTop : 0

};


jesong.probe = {
	texts:"", 
	groupIds:""
};

jesong.autochat={
	keyWord : null,
	sendkeyWord : 0,
	searchMode : 0,
	bgcolor:'#3097ef',
	width:420,
	height:500,
	use:1,
	start:'00:00',
	end:'23:59',
	times:-1,
	delay : 6,
	hideMonitor : false,
	show:false,
	welcome:JESONG_MESSAGE_TEXT.welcomeMsgOfConnected,
	waitSendMsg:'',
	connect : '1',
	closeBtn : '1',
	minBtn : '1',
	mask : '0',
	userHead : 'http://scripts.easyliao.com/prd//images/chat/201805/head-user.png',
	visitorHead : 'http://scripts.easyliao.com/prd//images/chat/201805/head-visitor.png',
	topImage : '',
	topImageMin : '',
	phoneHeight : 80,
	tel : '',
	pageTitle : '',
	pcMinLogo : '',
	autoPopMWinTime : -1,
	autoPopMWinPeroid : -1,
	softLogoLicense : false,
	softLogo : "",
	tools:{
		emoticons : '1',
		opinion : '1',
		screen : '1',
		file : '1',
		quiet : '1'
	},
	popMsg : {
		head : '',
		title : '您有新的客户消息，请注意查看！',
		bgColor : '#2273F8',
		color : '#ffffff',
		opacity : '80'
	}
};
jesong.ocpc = {
	platform:'-1',
	condition:'1',
	configId:'0'
};
jesong.init();

})();

		

