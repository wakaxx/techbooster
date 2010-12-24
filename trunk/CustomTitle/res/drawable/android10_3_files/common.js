// designCnt
function designCnt(scID, targetURI){
var id1 = scID + '_' + s.hier3;
var id2 = id1 + ' ' + targetURI;
s.prop14 = id2;
s.tl(this,'e',id1);
s_objectid = id1;
}


// AnswerBox
function answerBUT(){
jq("#answerBox div").css({"background-color" : "#FFF", "color" : "#444"});
jq("#answerBox div span").css({"color" : "red"});
jq("#answerBox img").css({"visibility" : "visible"});
}
function answerBUToff(){
jq("#answerBox div").css({"background-color" : "#999","color" : "#999"});
jq("#answerBox div span").css({"color" : "#999"});
jq("#answerBox img").css({"visibility" : "hidden"});
}
function expBUT(){
jq("#expBox div").css({"background-color" : "#FFF", "color" : "#444"});
jq("#expBox div span").css({"color" : "red"});
jq("#expBox img").css({"visibility" : "visible"});
}
function expBUToff(){
jq("#expBox div").css({"background-color" : "#999","color" : "#999"});
jq("#expBox div span").css({"color" : "#999"});
jq("#expBox img").css({"visibility" : "hidden"});
}


function kankyo_instruction(json){
	var doc = document;
	var dom = doc.domain;
	var ImgLink = '<IMG SRC="http://ima' + 'ge.itmed' + 'ia.c' + 'o.jp';
	var data0 = json['data'];
	if(json['name'] == '環境メディア枠'){
		var code = [];
		code.push('<div id="kankyo" class="rcBox txtTtl"><h2><a href="http://kankyomedia.jp/" onc' + 'lick="desi' + "gnCnt('atit_rcKankyo_obi'" + ' , this.href);">環境メディア</a></h2><div>');
		for(var i = 0; i < data0.length; i++){
			var data1 = data0[i];
			if(data1['title'] == undefined) continue;
			if(data1['icon'] != ''){
				code.push('<p><span class="iconbg"><a href="' + data1['link'] + '" class="icon" onc' + 'lick="desi' + "gnCnt('atit_rcKankyo_ico' , this.href);" + '">' + ImgLink + data1['icon'] + '" alt="' + data1['title'] + '"></a></span>');
				code.push('<strong><a href="' + data1['link'] + '" onc' + 'lick="desi' + "gnCnt('atit_rcKankyo_ttl" + [i] + "' , this.href);"+ '">' + data1['title'] + '</a></strong><br>');
				code.push(data1['abstract'] + '<br clear="all"/></span></p>');
			}
		}
		code.push('<ul class="linkset">');
		for(var i = 0; i < data0.length; i++){
			var data1 = data0[i];
			if(data1['title'] == undefined) continue;
			if(data1['icon'] == ''){
				code.push('<li><a href="' + data1['link'] + '" onc' + 'lick="desi' + "gnCnt('atit_rcKankyo_ttl" + [i] + "', this.href);" + '">' + data1['title'] + '</a></li>');
			}
		}
		code.push('</ul></div></div>');
		doc.write(code.join(''));
	}
}


// ↓EETIMES枠追加ここから↓

function eetimes_instruction(json){
	var doc = document;
	var dom = doc.domain;
	var ImgLink = '<IMG SRC="http://ima' + 'ge.itmed' + 'ia.c' + 'o.jp';
	var data0 = json['data'];
	if(json['name'] == 'EETIMES枠'){
		var code = [];
		code.push('<div id="kankyo" class="rcBox txtTtl"><h2><a href="http://eetimes.jp/" onc' + 'lick="desi' + "gnCnt('atit_EETimes_obi'" + ' , this.href);">EE Times Japan</a></h2><div>');
		for(var i = 0; i < data0.length; i++){
			var data1 = data0[i];
			if(data1['title'] == undefined) continue;
			if(data1['icon'] != ''){
				code.push('<p><span class="iconbg"><a href="' + data1['link'] + '" class="icon" onc' + 'lick="desi' + "gnCnt('atit_rcEETimes_ico' , this.href);" + '">' + ImgLink + data1['icon'] + '" alt="' + data1['title'] + '"></a></span>');
				code.push('<strong><a href="' + data1['link'] + '" onc' + 'lick="desi' + "gnCnt('atit_rcEETimes_ttl" + [i] + "' , this.href);"+ '">' + data1['title'] + '</a></strong><br>');
				code.push(data1['abstract'] + '<br clear="all"/></span></p>');
			}
		}
		code.push('<ul class="linkset">');
		for(var i = 0; i < data0.length; i++){
			var data1 = data0[i];
			if(data1['title'] == undefined) continue;
			if(data1['icon'] == ''){
				code.push('<li><a href="' + data1['link'] + '" onc' + 'lick="desi' + "gnCnt('atit_rcEETimes_ttl" + [i] + "', this.href);" + '">' + data1['title'] + '</a></li>');
			}
		}
		code.push('</ul></div></div>');
		doc.write(code.join(''));
	}
}

// ↑EETIMES枠追加ここまで↑

// ↓環境対策コーナーレポートピックアップ枠ここから↓

function envpickup_instruction(json){
	var doc = document;
	var dom = doc.domain;
	var ImgLink = '<IMG SRC="';
	var data0 = json['data'];
	if(json['name'] == '環境対策コーナーリポートピックアップ'){
		var code = [];
		code.push('<div id="kankyo" class="rcBox txtTtl"><h2><a href="http://kankyomedia.jp/report/" onc' + 'lick="desi' + "gnCnt('atit_rcenv_obi'" + ' , this.href);">環境メディアリポートピックアップ</a></h2><div>');
		for(var i = 0; i < data0.length; i++){
			var data1 = data0[i];
			if(data1['title'] == undefined) continue;
			if(data1['icon'] != ''){
				code.push('<p><span class="iconbg"><a href="' + data1['link'] + '" class="icon" onc' + 'lick="desi' + "gnCnt('atit_rcenv_ico' , this.href);" + '">' + ImgLink + data1['icon'] + '"></a></span>');
				code.push('<strong><a href="' + data1['link'] + '" onc' + 'lick="desi' + "gnCnt('atit_rcenv_ttl" + [i] + "' , this.href);"+ '">' + data1['title'] + '</a></strong><br>');
				code.push(data1['abstract'] + '<br clear="all"/></span></p>');
			}
		}
		code.push('<ul class="linkset">');
		for(var i = 0; i < data0.length; i++){
			var data1 = data0[i];
			if(data1['title'] == undefined) continue;
			if(data1['icon'] == ''){
				code.push('<li><a href="' + data1['link'] + '" onc' + 'lick="desi' + "gnCnt('atit_rcenv_ttl" + [i] + "', this.href);" + '">' + data1['title'] + '</a></li>');
			}
		}
		code.push('</ul></div></div>');
		doc.write(code.join(''));
	}
}

// ↑環境対策コーナーレポートピックアップ枠ここまで↑



function ttwpdata(json){
	var a = json['data']; // JSONデータ格納
	var currentScript = (function(e){ // コールバック関数実行後自分自身のSCRIPTタグ参照
		if(e.nodeName.toLowerCase() == 'script') return e;
		return arguments.callee(e.lastChild)
	})(document);
	if(currentScript.getAttribute('title')){ // 自分自身のSCRIPTタグTITLE属性取得
		var jstitle = currentScript.getAttribute('title');
		if(jstitle.match(/^tmpl\=([A-Z])\,loop\=\d*$/)){
			jstitle = jstitle.split(',');
			var tmpl = jstitle[0].replace('tmpl=','');
			var loop = parseInt(jstitle[1].replace('loop=',''));
			if((a.length - 1) < loop){
				loop = a.length - 1;
			}
		}else if(jstitle.match(/^tmpl\=([A-Z])$/)){
			var tmpl = jstitle.replace('tmpl=','');
			var loop = a.length - 1;
		}else if(jstitle.match(/^loop\=\d*$/)){
			var tmpl = 'default';
			var loop = parseInt(jstitle.replace('loop=',''));
			if((a.length - 1) < loop){
				loop = a.length - 1;
			}
		}else{
			var tmpl = 'default';
			var loop = a.length - 1;
		}
	}else{ // TITLEがない場合
		var tmpl = 'default';
		var loop = a.length - 1;
	}
	if(json['name'] == ''){document.write('No Template');
	}else if(json['name'] == 'TTWP新着'){ // .json name での分岐
		if(tmpl == 'default'){ // script title での分岐
		}else if(tmpl == 'F'){//test3 normal
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "designCnt('tt_normal_" + [i] + " ', document.URL)" + '">' + b['title'].replace(/\[.+\]/,'') + '</a><small>（' + b['date'] + '）</small></div>';
			}
		}else{
			code += 'No Template';
		}
	}else if(json['name'] == '新着TTWP'){ // .json name での分岐
		if(tmpl == 'default'){ // script title での分岐
		}else if(tmpl == 'A'){ // WinForum
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_windows'; s.tl(this,'e','tt_atit_wp_windows'); s_objectid='tt_atit_wp_windows';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'B'){ // DotNET
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_dotnet'; s.tl(this,'e','tt_atit_wp_dotnet'); s_objectid='tt_atit_wp_dotnet';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'C'){ // System
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_system'; s.tl(this,'e','tt_atit_wp_system'); s_objectid='tt_atit_wp_system';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'D'){ // Server＆Storage
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_serverstorage'; s.tl(this,'e','tt_atit_wp_serverstorage'); s_objectid='tt_atit_wp_serverstorage';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'E'){ // WCR
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_richclient'; s.tl(this,'e','tt_atit_wp_richclient'); s_objectid='tt_atit_wp_richclient';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'F'){ // JAVA
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_java'; s.tl(this,'e','tt_atit_wp_java'); s_objectid='tt_atit_wp_java';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'G'){ // Database
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_database'; s.tl(this,'e','tt_atit_wp_database'); s_objectid='tt_atit_wp_database';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'H'){ // XML
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_xml'; s.tl(this,'e','tt_atit_wp_xml'); s_objectid='tt_atit_wp_xml';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'I'){ // Linux
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_linux'; s.tl(this,'e','tt_atit_wp_linux'); s_objectid='tt_atit_wp_linux';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'J'){ // IP Network
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_ipnetwork'; s.tl(this,'e','tt_atit_wp_ipnetwork'); s_objectid='tt_atit_wp_ipnetwork';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'K'){ // Security
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_security'; s.tl(this,'e','tt_atit_wp_security'); s_objectid='tt_atit_wp_security';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'L'){ // RFID
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_atit_wp_rfid'; s.tl(this,'e','tt_atit_wp_rfid'); s_objectid='tt_atit_wp_rfid';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'M'){ // ITS
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_im_wp_cits'; s.tl(this,'e','tt_im_wp_cits'); s_objectid='tt_im_wp_cits';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'N'){ // COP
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_im_wp_cop'; s.tl(this,'e','tt_im_wp_cop'); s_objectid='tt_im_wp_cop';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'O'){ // アーキテクチャ
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_im_wp_carc'; s.tl(this,'e','tt_im_wp_carc'); s_objectid='tt_im_wp_carc';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'P'){ // プロジェクト管理
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_im_wp_cpm'; s.tl(this,'e','tt_im_wp_cpm'); s_objectid='tt_im_wp_cpm';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'Q'){ // 仕事の改善
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_im_wp_cbp'; s.tl(this,'e','tt_im_wp_cbp'); s_objectid='tt_im_wp_cbp';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'R'){ // 業務アプリ
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_im_wp_cap'; s.tl(this,'e','tt_im_wp_cap'); s_objectid='tt_im_wp_cap';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'S'){ // 組み込み開発
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_monoist_wp_fembedded'; s.tl(this,'e','tt_monoist_wp_fembedded'); s_objectid='tt_monoist_wp_fembedded';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else if(tmpl == 'T'){ // 生産管理
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "var s=s_gi('itmediacojpglobal');s.eVar21='tt_monoist_wp_fpro'; s.tl(this,'e','tt_monoist_wp_fpro'); s_objectid='tt_monoist_wp_fpro';" + '">' + b['title'].replace(/\[.+\]/,'') + '</a></div>';
			}
		}else{
			code += 'No Template';
		}
	}else if(json['name'] == 'TTWP新着'){ // .json name での分岐
		if(tmpl == 'default'){ // script title での分岐
		}else if(tmpl == 'F'){//test3 normal
			var code = '';
			for(var i = 0; i < 3; i++){
				var b = a[i];
				code += '<div><a href="' + b['link'] + '" onC' + 'lick="' + "designCnt('tt_normal_" + [i] + " ', document.URL)" + '">' + b['title'].replace(/\[.+\]/,'') + '</a><small>（' + b['date'] + '）</small></div>';
			}
		}else{
			code += 'No Template';
		}
	}else if(json['name'] == 'RC-TTWP新着'){ // .json name での分岐
		if(tmpl == 'default'){ // script title での分岐
		}else if(tmpl == 'A'){ // WinForum
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fserver'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'B'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fwin2k'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'C'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fsecurity'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'D'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fdotnet'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'E'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fsys'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'F'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fwcr'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'G'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'design'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'H'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fcoding'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'I'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fjava'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'J'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fdb'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'K'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fxml'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'L'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'flinux'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'M'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'fnetwork'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'N'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'frfid'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'O'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'cits'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'P'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'cop'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'Q'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'carc'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'R'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'cpm'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'S'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'cbp'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'T'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'cap'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else if(tmpl == 'U'){
			var code = '';
			code += '<div id="rc-ttwp"><h4><img width="300" alt="TechTargetジャパン" title="TechTargetジャパン" src="/parts/images/rc_ttl_ttwp.gif"></h4><ul>';
			for(var i = 0; i < loop; i++){
				var b = a[i];
				if(b['forum'] == 'ces'){
					code += '<li><a href="' + b['link1'] + '" onC' + 'lick="' + b['onclick1'] + '">' + b['title1_1'];
					if(b['title1_2'] != ''){code += '<br>' + b['title1_2'];}
					if(b['title1_3'] != ''){code += '<br>' + b['title1_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link2'] + '" onC' + 'lick="' + b['onclick2'] + '">' + b['title2_1'];
					if(b['title2_2'] != ''){code += '<br>' + b['title2_2'];}
					if(b['title2_3'] != ''){code += '<br>' + b['title2_3'];}
					code += '</a></li>';
					code += '<li><a href="' + b['link3'] + '" onC' + 'lick="' + b['onclick3'] + '">' + b['title3_1'];
					if(b['title3_2'] != ''){code += '<br>' + b['title3_2'];}
					if(b['title3_3'] != ''){code += '<br>' + b['title3_3'];}
					code += '</a></li>';
				}
			}
			code += '</ul><div class="b-rtxt"><a onclick="' + "var s=s_gi('itmediacojpglobal'); s.eVar21='tt_atit_rc_4'; s.tl(this,'e','tt_atit_rc_4'); s_objectid='tt_atit_rc_4';" + ';" href="http://wp.techtarget.itmedia.co.jp/">システム担当者のIT製品選びをサポートします</a></div></div>';
		}else{
			code += 'No Template';
		}
	}else{document.write('No Template');}
	document.write(code);
}
