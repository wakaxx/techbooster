function atmarkitbbs(json) {
	var a = json['lounges']; // JSONƒf[ƒ^Ši”[
	var currentScript = (function(e){ // ƒR[ƒ‹ƒoƒbƒNŠÖ”ÀsŒã©•ª©g‚ÌSCRIPTƒ^ƒOQÆ
		if(e.nodeName.toLowerCase() == 'script') return e;
		return arguments.callee(e.lastChild)
	})(document);
	if(currentScript.getAttribute('title')){ // ©•ª©g‚ÌSCRIPTƒ^ƒOTITLE‘®«æ“¾
		var jstitle = currentScript.getAttribute('title');
		if(jstitle.match(/^tmpl\=([A-Z])\,loop\=\d*$/)){
			jstitle = jstitle.split(',');
			var tmpl = jstitle[0].replace('tmpl=','');
			var loop = parseInt(jstitle[1].replace('loop=',''));
			if((a.length) < loop){
				loop = a.length;
			}
		}else if(jstitle.match(/^tmpl\=([A-Z])$/)){
			var tmpl = jstitle.replace('tmpl=','');
			var loop = a.length;
		}else if(jstitle.match(/^loop\=\d*$/)){
			var tmpl = 'default';
			var loop = parseInt(jstitle.replace('loop=',''));
			if((a.length) < loop){
				loop = a.length;
			}
		}else{
			var tmpl = 'default';
			var loop = a.length;
		}
	}else{ // TITLE‚ª‚È‚¢ê‡
		var tmpl = 'default';
		var loop = a.length;
	}
	if(json['name'] == ''){
	}else if(json['name'] == 'hoge'){
	}else{
		if(tmpl == 'A'){//CORE ‰ï‹cº
			var code = '';
			code += '<style type="text/css"><!--';
			code += '.bbs-box { ';
			code += 'border: 1px solid #CCC !important; ';
			code += 'border-top: 0px solid #CCC !important; ';
			code += 'padding-top: 0px;';
			code += 'padding-bottom: 0px; ';
			code += 'margin-top: 10px;';
			code += 'font-size: small;';
			code += 'width: auto;';
			code += '}';
			code += '.bbs-box div { ';
			code += 'border: 2px solid #DDD;';
			code += 'margin-bottom: 0px;';
			code += '}';
			code += '.bbs-box h2 {';
			code += 'margin: 0px; ';
			code += 'color: #444; ';
			code += 'font-size: small;';
			code += 'border-top: 4px solid #996 ; ';
			code += 'border-bottom: 1px solid #CCC ;';
			code += 'padding: 5px 2px 4px 7px;';
			code += '_padding: 5px 2px 0px 10px;';
			code += 'background:url("/parts/images/atit/t_bbs.jpg") repeat-x right bottom #FFF ;';
			code += 'height: 17px;';
			code += '_height: 22px; ';
			code += 'text-indent: -9999px ; ';
			code += '}';
			code += '.bbs-box h2 a {';
			code += 'color: #444 !important;';
			code += '}';
			code += '.bbs-box h2 .l {text-indent: -9999px;} ';
			code += '.bbs-box h2 .r {color: #996;padding-top: 7px;} ';
			code += '.bbs-box ul {list-style:none;padding:0px;margin:0px;font-size:12px;}';
			code += '.bbs-box a { ';
			code += 'display: block;';
			code += 'background: url("/parts/images/BBSicon.gif") no-repeat 3px 3px;';
			code += 'border-bottom: 1px solid #EEE; ';
			code += 'padding: 2px 2px 2px 22px; ';
			code += 'margin: 5px; ';
			code += 'word-wrap: break-word; ';
			code += '}';
			code += '.bbs-box br { display: none;}';
			code += '.bbs-box span.cal-bt { ';
			code += 'display: block;';
			code += 'background:url("/images/arrow_evcal.gif") no-repeat right 2px; ';
			code += 'text-align:right;';
			code += 'padding: 0px 5px 1px 0px;';
			code += 'margin: 0px 5px 0px 0px;';
			code += 'width: auto;';
			code += 'border:1px solid WHITE;';
			code += '}';
			code += '.bbs-box span.cal-bt a { ';
			code += 'padding: 0px 13px 0px 0px !important;';
			code += 'font-size:12px;';
			code += 'background-image: none;';
			code += 'border: none;';
			code += '}';
			code += '.bbs-box .arrow {';
			code += 'border: 1px solid #CCC;';
			code += 'padding: 0px 2px 0px 3px;';
			code += '_padding: 0px 3px 3px 5px; ';
			code += 'font-size: 12px; ';
			code += 'font-weight: bold; ';
			code += 'background-color:#F30; ';
			code += 'color: #FFF; ';
			code += '}';
			code += '.bbs-box .btn-bbs {';
			code += 'border: 0px solid red;height:55px;padding-left:10px;';
			code += '}';
			code += '.bbs-box .btn-bbs ul { width:auto;padding-left:15px !important;}';
			code += '.bbs-box .btn-bbs li {';
			code += 'width:130px;float:left;background:none;background:url(/parts/images/bbs_btn.gif) no-repeat;margin: 3px 3px 3px 3px;text-indent:-9999px;';
			code += '}';
			code += '.bbs-box .btn-bbs a { background-color:#FFF;filter:alpha(opacity=30);-moz-opacity:0.30;opacity:0.30;border:0px;display:block;width:130px;height:20px;padding:0px;margin:0px;}';
			code += '.bbs-box .btn-bbs a:hover { background-color:#FFF;filter:alpha(opacity=00);-moz-opacity:0.00;opacity:0.00;border:0px;}';
			code += '.bbs-box .btn-bbs li#BtnIm { background-position: 0px -50px;}';
			code += '.bbs-box .btn-bbs li#BtnMono { background-position: 0px -100px;}';
			code += '.bbs-box .btn-bbs li#BtnJbn { background-position: 0px -150px;}';
			code += '//--></style>';
			var docUrl = document.URL ;
			var dt = [];
			for(var i = 0; i < a.length; i++){
				for(var j in a[i]){
					for(var k = 0; k < a[i][j].length; k++){
						b = a[i][j][k];
						dt.push([b['post_updated_at'],b['post_url'],b['post_subject']]);
					}
				}
			}
			dt.sort();
			dt.reverse();
			code += '<div class="bbs-box"><h2>‰ï‹cº</h2><div><ul>';
			for(var i = 0; i < 10; i++){
				if(dt[i][1].length < 25){
					code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2] + '</a></li>';
				}else{
					code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2].substr(0,24) + '¥¥¥</a></li>';
				}
			}
			if (docUrl.match('atmarkit.co.jp\/news\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/news/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fwin2k\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fwin/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fdotnet\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fdotnet/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fsys\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fsys/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fserver\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fserver/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fwcr\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fwcr/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fcoding\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fcoding/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fjava\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fjava/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fdb\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fdb/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fxml\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fxml/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/flinux\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/flinux/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fnetwork\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fnetwork/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fsecurity\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fsecurity/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/frfid\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/frfid/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fkaisetsu\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fkaisetsu/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}
			code += '</ul></div></div>';
		}else if(tmpl == 'B'){//îƒ}ƒl ‰ï‹cº
			var code = '';
			code += '<div id="bbs" class="bbs-box"><h2><img src="/im/top/ttl_bbs.gif" alt="—ITî•ñƒ}ƒlƒWƒƒ“ƒg‰ï‹cº" title="—ITî•ñƒ}ƒlƒWƒƒ“ƒg‰ï‹cº" width="300" height="22"></h2><div><ul>';
			for(var i = 0; i < json['lounges'][1]['\uff20IT\u60c5\u5831\u30de\u30cd\u30b8\u30e1\u30f3\u30c8\u4f1a\u8b70\u5ba4'].length; i++){
				var b = json['lounges'][1]['\uff20IT\u60c5\u5831\u30de\u30cd\u30b8\u30e1\u30f3\u30c8\u4f1a\u8b70\u5ba4'][i];
				if(b['post_subject'].length < 25){
					code += '<li><a href="' + b['post_url'] + '">' + b['post_subject'] + '</a></li>';
				}else{
					code += '<li><a href="' + b['post_url'] + '">' + b['post_subject'].substr(0,24) + '¥¥¥</a></li>';
				}
			}

			
			code += '</ul><p class="more"><img src="/top/arrow_white.gif" width="13" height="13" align="texttop"><a href="http://ap.atmarkit.co.jp/bbs/im/">‰ï‹cºƒgƒbƒv‚Ö</a></p>';
			code += '</div></div><br clear="all">';
		}else if(tmpl == 'C'){//©•ªŒ¤ ‰ï‹cº
			var code = '';
			code += '<div class="bbs-box"><h2>©•ªŒ¤‰ï‹cº</h2><div><ul>';
			for(var i = 0; i < json['lounges'][2]['\uff20IT\u81ea\u5206\u6226\u7565\u7814\u7a76\u6240\u4f1a\u8b70\u5ba4'].length; i++){
				var b = json['lounges'][2]['\uff20IT\u81ea\u5206\u6226\u7565\u7814\u7a76\u6240\u4f1a\u8b70\u5ba4'][i];
				if(b['post_subject'].length < 25){
					code += '<li><a href="' + b['post_url'] + '">' + b['post_subject'] + '</a></li>';
				}else{
					code += '<li><a href="' + b['post_url'] + '">' + b['post_subject'].substr(0,24) + '¥¥¥</a></li>';
				}
			}
			code += '<span class="cal-bt"><a href="#">‰ï‹cº‚Ö</a></span>';
			code += '</ul></div></div><br clear="all">';
		}else if(tmpl == 'D'){//MONOist ‰ï‹cº
			var code = '';
			var docUrl = document.URL;
			//alert(docUrl);
			if (docUrl.match('atmarkit.co.jp\/fembedded\/')) {
				code += '<div class="l-box" id="mtg"><h2>‘g‚İ‚İŠJ”­‰ï‹cº</h2><div><ul>';
			}else if (docUrl.match('atmarkit.co.jp\/fmecha\/')) {
				code += '<div class="l-box" id="mtg"><h2>ƒƒJİŒv‰ï‹cº</h2><div><ul>';
			}else if (docUrl.match('atmarkit.co.jp\/feledev\/')) {
				code += '<div class="l-box" id="mtg"><h2>“dq‹@Ší‰ï‹cº</h2><div><ul>';
			}else if (docUrl.match('atmarkit.co.jp\/fpro\/')) {
				code += '<div class="l-box" id="mtg"><h2>¶YŠÇ—‰ï‹cº</h2><div><ul>';
			}else if (docUrl.match('atmarkit.co.jp\/news\/')) {
				code += '<div class="l-box" id="mtg"><h2>News‰ï‹cº</h2><div><ul>';
			}else {
				code += '<div class="l-box" id="mtg"><h2>—IT MONOist‰ï‹cº</h2><div><ul>';
			}
			for(var i = 0; i < json['lounges'][3]['\uff20IT MONOist\u4f1a\u8b70\u5ba4'].length; i++){
				var b = json['lounges'][3]['\uff20IT MONOist\u4f1a\u8b70\u5ba4'][i];
				if(b['post_subject'].length < 16){
					code += '<li><a href="' + b['post_url'] + '" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">' + b['post_subject'] + '</a></li>';
				}else{
					code += '<li><a href="' + b['post_url'] + '" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">' + b['post_subject'].substr(0,15) + '¥¥¥</a></li>';
				}
			}
			if (docUrl.match('atmarkit.co.jp\/fembedded\/')) {
				code += '</ul><div class="i-link" align="right" style="border:0px;"><a href="http://ap.atmarkit.co.jp/bbs/monoist/fembedded/" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">‰ï‹cº‚Ö</a></div>';
			}else if (docUrl.match('atmarkit.co.jp\/fmecha\/')) {
				code += '</ul><div class="i-link" align="right" style="border:0px;"><a href="http://ap.atmarkit.co.jp/bbs/monoist/fmecha/" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">‰ï‹cº‚Ö</a></div>';
			}else if (docUrl.match('atmarkit.co.jp\/feledev\/')) {
				code += '</ul><div class="i-link" align="right" style="border:0px;"><a href="http://ap.atmarkit.co.jp/bbs/monoist/feledev/" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">‰ï‹cº‚Ö</a></div>';
			}else if (docUrl.match('atmarkit.co.jp\/fpro\/')) {
				code += '</ul><div class="i-link" align="right" style="border:0px;"><a href="http://ap.atmarkit.co.jp/bbs/monoist/fpro/" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">‰ï‹cº‚Ö</a></div>';
			}else if (docUrl.match('atmarkit.co.jp\/news\/')) {
				code += '</ul><div class="i-link" align="right" style="border:0px;"><a href="http://ap.atmarkit.co.jp/bbs/monoist/news/" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">‰ï‹cº‚Ö</a></div>';
			}else {
				code += '</ul><div class="i-link" align="right" style="border:0px;"><a href="http://ap.atmarkit.co.jp/bbs/monoist/" oncl' + 'ick="desig' + "nCnt('mono_bbs', this.href)" + '">‰ï‹cº‚Ö</a></div>';
			}
			code += '</div></div>';
		}else if(tmpl == 'E'){//‘‡TOP
			var code = '';
			code += '<style type="text/css"><!--';
			code += '.bbs-box { ';
			code += 'border: 1px solid #CCC !important; ';
			code += 'border-top: 0px solid #CCC !important; ';
			code += 'padding-top: 0px;';
			code += 'padding-bottom: 0px; ';
			code += 'margin-top: 10px;';
			code += 'font-size: small;';
			code += 'width: auto;';
			code += '}';
			code += '.bbs-box div { ';
			code += 'border: 2px solid #DDD;';
			code += 'margin-bottom: 0px;';
			code += '}';
			code += '.bbs-box h2 {';
			code += 'margin: 0px; ';
			code += 'color: #444; ';
			code += 'font-size: small;';
			code += 'border-top: 4px solid #996 ; ';
			code += 'border-bottom: 1px solid #CCC ;';
			code += 'padding: 5px 2px 4px 7px;';
			code += '_padding: 5px 2px 0px 10px;';
			code += 'background:url("/parts/images/atit/t_bbs.jpg") repeat-x right bottom #FFF ;';
			code += 'height: 17px;';
			code += '_height: 22px; ';
			code += 'text-indent: -9999px ; ';
			code += '}';
			code += '.bbs-box h2 a {';
			code += 'color: #444 !important;';
			code += '}';
			code += '.bbs-box h2 .l {text-indent: -9999px;} ';
			code += '.bbs-box h2 .r {color: #996;padding-top: 7px;} ';
			code += '.bbs-box ul {list-style:none;padding:0px;margin:0px;font-size:12px;}';
			code += '.bbs-box a { ';
			code += 'display: block;';
			code += 'background: url("/parts/images/BBSicon.gif") no-repeat 3px 3px;';
			code += 'border-bottom: 1px solid #EEE; ';
			code += 'padding: 2px 2px 2px 22px; ';
			code += 'margin: 5px; ';
			code += 'word-wrap: break-word; ';
			code += '}';
			code += '.bbs-box br { display: none;}';
			code += '.bbs-box span.cal-bt { ';
			code += 'display: block;';
			code += 'background:url("/images/arrow_evcal.gif") no-repeat right 2px; ';
			code += 'text-align:right;';
			code += 'padding: 0px 5px 1px 0px;';
			code += 'margin: 0px 5px 0px 0px;';
			code += 'width: auto;';
			code += 'border:1px solid WHITE;';
			code += '}';
			code += '.bbs-box span.cal-bt a { ';
			code += 'padding: 0px 13px 0px 0px !important;';
			code += 'font-size:12px;';
			code += 'background-image: none;';
			code += 'border: none;';
			code += '}';
			code += '.bbs-box .arrow {';
			code += 'border: 1px solid #CCC;';
			code += 'padding: 0px 2px 0px 3px;';
			code += '_padding: 0px 3px 3px 5px; ';
			code += 'font-size: 12px; ';
			code += 'font-weight: bold; ';
			code += 'background-color:#F30; ';
			code += 'color: #FFF; ';
			code += '}';
			code += '.bbs-box .btn-bbs {';
			code += 'border: 0px solid red;height:55px;padding-left:10px;';
			code += '}';
			code += '.bbs-box .btn-bbs ul { width:auto;padding-left:15px !important;}';
			code += '.bbs-box .btn-bbs li {';
			code += 'width:130px;float:left;background:none;background:url(/parts/images/bbs_btn.gif) no-repeat;margin: 3px 3px 3px 3px;text-indent:-9999px;';
			code += '}';
			code += '.bbs-box .btn-bbs a { background-color:#FFF;filter:alpha(opacity=30);-moz-opacity:0.30;opacity:0.30;border:0px;display:block;width:130px;height:20px;padding:0px;margin:0px;}';
			code += '.bbs-box .btn-bbs a:hover { background-color:#FFF;filter:alpha(opacity=00);-moz-opacity:0.00;opacity:0.00;border:0px;}';
			code += '.bbs-box .btn-bbs li#BtnIm { background-position: 0px -50px;}';
			code += '.bbs-box .btn-bbs li#BtnMono { background-position: 0px -100px;}';
			code += '.bbs-box .btn-bbs li#BtnJbn { background-position: 0px -150px;}';
			code += '//--></style>';
			var docUrl = document.URL ;
			var dt = [];
			for(var i = 0; i < a.length; i++){
				for(var j in a[i]){
					for(var k = 0; k < a[i][j].length; k++){
						b = a[i][j][k];
						dt.push([b['post_updated_at'],b['post_url'],b['post_subject']]);
					}
				}
			}
			dt.sort();
			dt.reverse();
			code += '<div class="bbs-box"><h2>‰ï‹cº</h2><div><ul>';
			for(var i = 0; i < 10; i++){
				if(dt[i][1].length < 25){
					code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2] + '</a></li>';
				}else{
					code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2].substr(0,24) + '¥¥¥</a></li>';
				}
			}
			code += '</ul><ul class="btn-bbs"><li id="BtnCore"><a href="http://ap.atmarkit.co.jp/bbs/core/" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">—ITCORE‰ï‹cº‚Ö</a></li>';
			code += '<li id="BtnIm"><a href="http://ap.atmarkit.co.jp/bbs/im/" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">î•ñƒ}ƒlƒWƒƒ“ƒg‰ï‹cº‚Ö</a></li>';
			code += '<li id="BtnMono"><a href="http://ap.atmarkit.co.jp/bbs/monoist/" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">MONOist‰ï‹cº‚Ö</a></li>';
			code += '<li id="BtnJbn"><a href="http://ap.atmarkit.co.jp/bbs/jibun/" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">©•ªí—ªŒ¤‹†Š‰ï‹cº‚Ö</a></li>';
			code += '</div></div><p style="text-align:right;font-size:12px;background:url(/images/arrow_evcal.gif)no-repeat right 1px;margin: 3px 0px 0px 0px;padding:2px 22px 2px 0px;"><a href="http://www.atmarkit.co.jp/bbs/phpBB/" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">‹Œ‰ï‹cº‚Ö</a></p>';
		}else if(tmpl == 'F'){//CORE
			var code = '';
			var docUrl = document.URL ;
			var dt = [];
			for(var i = 0; i < a.length; i++){
				for(var j in a[i]){
					for(var k = 0; k < a[i][j].length; k++){
						b = a[i][j][k];
						dt.push([b['post_updated_at'],b['post_url'],b['post_subject']]);
					}
				}
			}
			dt.sort();
			dt.reverse();
			code += '<div id="bbs"><h2><a href="http://ap.atmarkit.co.jp/bbs/core/">—IT‰ï‹cº</a></h2><div class="list-box">';
			for(var i = 0; i < 10; i++){
				if(dt[i][1].length < 22){
					code += '<img src="/images/global/bbs/icon.gif" border="0"><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">' + dt[i][2] + '</a><br>';
				}else{
					code += '<img src="/images/global/bbs/icon.gif" border="0"><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">' + dt[i][2].substr(0,21) + '¥¥¥</a><br>';
				}
			}
			code += '<div class="category-box"><p><span class="arrow-r">&raquo; </span><a href="http://ap.atmarkit.co.jp/bbs/core/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">—IT‰ï‹cºƒgƒbƒv‚Ö</a></p></div></div></div>';
		}else if(tmpl == 'G'){//CORE
			var code = '';
			code += '<style type="text/css"><!--';
			code += '.bbs-box { ';
			code += 'border: 1px solid #CCC !important; ';
			code += 'border-top: 0px solid #CCC !important; ';
			code += 'padding-top: 0px;';
			code += 'padding-bottom: 0px; ';
			code += 'margin-top: 10px;';
			code += 'font-size: small;';
			code += 'width: auto;';
			code += '}';
			code += '.bbs-box div { ';
			code += 'border: 2px solid #DDD;';
			code += 'margin-bottom: 0px;';
			code += '}';
			code += '.bbs-box h2 {';
			code += 'margin: 0px; ';
			code += 'color: #444; ';
			code += 'font-size: small;';
			code += 'border-top: 4px solid #996 ; ';
			code += 'border-bottom: 1px solid #CCC ;';
			code += 'padding: 5px 2px 4px 7px;';
			code += '_padding: 5px 2px 0px 10px;';
			code += 'background:url("/parts/images/atit/t_bbs.jpg") repeat-x right bottom #FFF ;';
			code += 'height: 17px;';
			code += '_height: 22px; ';
			code += 'text-indent: -9999px ; ';
			code += '}';
			code += '.bbs-box h2 a {';
			code += 'color: #444 !important;';
			code += '}';
			code += '.bbs-box h2 .l {text-indent: -9999px;} ';
			code += '.bbs-box h2 .r {color: #996;padding-top: 7px;} ';
			code += '.bbs-box ul {list-style:none;padding:0px;margin:0px;font-size:12px;}';
			code += '.bbs-box a { ';
			code += 'display: block;';
			code += 'background: url("/parts/images/BBSicon.gif") no-repeat 3px 3px;';
			code += 'border-bottom: 1px solid #EEE; ';
			code += 'padding: 2px 2px 2px 22px; ';
			code += 'margin: 5px; ';
			code += 'word-wrap: break-word; ';
			code += '}';
			code += '.bbs-box br { display: none;}';
			code += '.bbs-box span.cal-bt { ';
			code += 'display: block;';
			code += 'background:url("/images/arrow_evcal.gif") no-repeat right 2px; ';
			code += 'text-align:right;';
			code += 'padding: 0px 5px 1px 0px;';
			code += 'margin: 0px 5px 0px 0px;';
			code += 'width: auto;';
			code += 'border:1px solid WHITE;';
			code += '}';
			code += '.bbs-box span.cal-bt a { ';
			code += 'padding: 0px 13px 0px 0px !important;';
			code += 'font-size:12px;';
			code += 'background-image: none;';
			code += 'border: none;';
			code += '}';
			code += '.bbs-box .arrow {';
			code += 'border: 1px solid #CCC;';
			code += 'padding: 0px 2px 0px 3px;';
			code += '_padding: 0px 3px 3px 5px; ';
			code += 'font-size: 12px; ';
			code += 'font-weight: bold; ';
			code += 'background-color:#F30; ';
			code += 'color: #FFF; ';
			code += '}';
			code += '.bbs-box .btn-bbs {';
			code += 'border: 0px solid red;height:55px;padding-left:10px;';
			code += '}';
			code += '.bbs-box .btn-bbs ul { width:auto;padding-left:15px !important;}';
			code += '.bbs-box .btn-bbs li {';
			code += 'width:130px;float:left;background:none;background:url(/parts/images/bbs_btn.gif) no-repeat;margin: 3px 3px 3px 3px;text-indent:-9999px;';
			code += '}';
			code += '.bbs-box .btn-bbs a { background-color:#FFF;filter:alpha(opacity=30);-moz-opacity:0.30;opacity:0.30;border:0px;display:block;width:130px;height:20px;padding:0px;margin:0px;}';
			code += '.bbs-box .btn-bbs a:hover { background-color:#FFF;filter:alpha(opacity=00);-moz-opacity:0.00;opacity:0.00;border:0px;}';
			code += '.bbs-box .btn-bbs li#BtnIm { background-position: 0px -50px;}';
			code += '.bbs-box .btn-bbs li#BtnMono { background-position: 0px -100px;}';
			code += '.bbs-box .btn-bbs li#BtnJbn { background-position: 0px -150px;}';
			code += '//--></style>';
			var docUrl = document.URL ;
			var dt = [];
			for(var i = 0; i < a.length; i++){
				for(var j in a[i]){
					for(var k = 0; k < a[i][j].length; k++){
						b = a[i][j][k];
						dt.push([b['post_updated_at'],b['post_url'],b['post_subject']]);
					}
				}
			}
			dt.sort();
			dt.reverse();
			code += '<div class="bbs-box"><h2>‰ï‹cº</h2><div><ul>';
			for(var i = 0; i < 10; i++){
				if(dt[i][1].length < 25){
					code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2] + '</a></li>';
				}else{
					code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2].substr(0,24) + '¥¥¥</a></li>';
				}
			}
			if (docUrl.match('atmarkit.co.jp\/news\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/news/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fwin2k\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fwin/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fdotnet\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fdotnet/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fsys\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fsys/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fserver\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fserver/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fwcr\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fwcr/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fcoding\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fcoding/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fjava\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fjava/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fdb\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fdb/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fxml\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fxml/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/flinux\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/flinux/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fnetwork\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fnetwork/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fsecurity\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fsecurity/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/frfid\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/frfid/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fkaiketsu\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fkaiketsu/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}
			code += '</ul></div></div>';
		}else if(tmpl == 'H'){//CORE
			var code = '';
			code += '<style type="text/css"><!--';
			code += '.bbs-box { ';
			code += 'border: 1px solid #CCC !important; ';
			code += 'border-top: 0px solid #CCC !important; ';
			code += 'padding-top: 0px;';
			code += 'padding-bottom: 0px; ';
			code += 'margin-top: 10px;';
			code += 'font-size: small;';
			code += 'width: auto;';
			code += '}';
			code += '.bbs-box div { ';
			code += 'border: 2px solid #DDD;';
			code += 'margin-bottom: 0px;';
			code += '}';
			code += '.bbs-box h2 {';
			code += 'margin: 0px; ';
			code += 'color: #444; ';
			code += 'font-size: small;';
			code += 'border-top: 4px solid #996 ; ';
			code += 'border-bottom: 1px solid #CCC ;';
			code += 'padding: 5px 2px 4px 7px;';
			code += '_padding: 5px 2px 0px 10px;';
			code += 'background:url("/parts/images/atit/t_bbs.jpg") repeat-x right bottom #FFF ;';
			code += 'height: 17px;';
			code += '_height: 22px; ';
			code += 'text-indent: -9999px ; ';
			code += '}';
			code += '.bbs-box h2 a {';
			code += 'color: #444 !important;';
			code += '}';
			code += '.bbs-box h2 .l {text-indent: -9999px;} ';
			code += '.bbs-box h2 .r {color: #996;padding-top: 7px;} ';
			code += '.bbs-box ul {list-style:none;padding:0px;margin:0px;font-size:12px;}';
			code += '.bbs-box a { ';
			code += 'display: block;';
			code += 'background: url("/parts/images/BBSicon.gif") no-repeat 3px 3px;';
			code += 'border-bottom: 1px solid #EEE; ';
			code += 'padding: 2px 2px 2px 22px; ';
			code += 'margin: 5px; ';
			code += 'word-wrap: break-word; ';
			code += '}';
			code += '.bbs-box br { display: none;}';
			code += '.bbs-box span.cal-bt { ';
			code += 'display: block;';
			code += 'background:url("/images/arrow_evcal.gif") no-repeat right 2px; ';
			code += 'text-align:right;';
			code += 'padding: 0px 5px 1px 0px;';
			code += 'margin: 0px 5px 0px 0px;';
			code += 'width: auto;';
			code += 'border:1px solid WHITE;';
			code += '}';
			code += '.bbs-box span.cal-bt a { ';
			code += 'padding: 0px 13px 0px 0px !important;';
			code += 'font-size:12px;';
			code += 'background-image: none;';
			code += 'border: none;';
			code += '}';
			code += '.bbs-box .arrow {';
			code += 'border: 1px solid #CCC;';
			code += 'padding: 0px 2px 0px 3px;';
			code += '_padding: 0px 3px 3px 5px; ';
			code += 'font-size: 12px; ';
			code += 'font-weight: bold; ';
			code += 'background-color:#F30; ';
			code += 'color: #FFF; ';
			code += '}';
			code += '.bbs-box .btn-bbs {';
			code += 'border: 0px solid red;height:55px;padding-left:10px;';
			code += '}';
			code += '.bbs-box .btn-bbs ul { width:auto;padding-left:15px !important;}';
			code += '.bbs-box .btn-bbs li {';
			code += 'width:130px;float:left;background:none;background:url(/parts/images/bbs_btn.gif) no-repeat;margin: 3px 3px 3px 3px;text-indent:-9999px;';
			code += '}';
			code += '.bbs-box .btn-bbs a { background-color:#FFF;filter:alpha(opacity=30);-moz-opacity:0.30;opacity:0.30;border:0px;display:block;width:130px;height:20px;padding:0px;margin:0px;}';
			code += '.bbs-box .btn-bbs a:hover { background-color:#FFF;filter:alpha(opacity=00);-moz-opacity:0.00;opacity:0.00;border:0px;}';
			code += '.bbs-box .btn-bbs li#BtnIm { background-position: 0px -50px;}';
			code += '.bbs-box .btn-bbs li#BtnMono { background-position: 0px -100px;}';
			code += '.bbs-box .btn-bbs li#BtnJbn { background-position: 0px -150px;}';
			code += '//--></style>';
			var docUrl = document.URL ;
			var dt = [];
			for(var i = 0; i < a.length; i++){
				for(var j in a[i]){
					for(var k = 0; k < a[i][j].length; k++){
						b = a[i][j][k];
						dt.push([b['post_updated_at'],b['post_url'],b['post_subject']]);
					}
				}
			}
			dt.sort();
			dt.reverse();
			code += '<div class="bbs-box"><h2>‰ï‹cº</h2><div><ul>';
			for(var i = 0; i < dt.length; i++){
				if(i == 0 || i < 10){
					if(dt[i][2].length < 25){
						code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2] + '</a></li>';
					}else{
						code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2].substr(0,24) + '¥¥¥</a></li>';
					}
				}
			}
			if (docUrl.match('atmarkit.co.jp\/news\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/news/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fwin2k\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fwin/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fdotnet\/')) {
				if(docUrl.match('vblab')){
					code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/vblab/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
				}else if(docUrl.match('chushin')){
					code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/vblab/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
				}else{
					code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fdotnet/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
				}
			}else if (docUrl.match('atmarkit.co.jp\/fsys\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fsys/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fserver\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fserver/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fwcr\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fwcr/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fcoding\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fcoding/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fjava\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fjava/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fdb\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fdb/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fxml\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fxml/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/flinux\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/flinux/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fnetwork\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fnetwork/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fsecurity\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fsecurity/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/frfid\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/frfid/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else if (docUrl.match('atmarkit.co.jp\/fkaiketsu\/')) {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/fkaiketsu/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}else {
				code += '<span class="cal-bt"><a href="http://ap.atmarkit.co.jp/bbs/core/" oncl' + 'ick="desig' + "nCnt('core_bbs', this.href)" + '">‰ï‹cº‚Ö</a></span>';
			}
			code += '</ul></div></div>';
		}else if(tmpl == 'Z'){//CORE
			var code = '';
			var docUrl = document.URL ;
			var dt = [];
			for(var i = 0; i < a.length; i++){
				for(var j in a[i]){
					for(var k = 0; k < a[i][j].length; k++){
						b = a[i][j][k];
						dt.push([b['post_updated_at'],b['post_url'],b['post_subject']]);
					}
				}
			}
			dt.sort();
			dt.reverse();
			for(var i = 0; i < dt.length; i++){
				if(i > 10){
				code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2] + '</a></li>';
				}else{
				}
			
			}
		}else if(tmpl == 'Y'){//Windows7
			var code = '';
			var docUrl = document.URL ;
			var dt = [];
			for(var i = 0; i < a.length; i++){
				for(var j in a[i]){
					for(var k = 0; k < a[i][j].length; k++){
						b = a[i][j][k];
						dt.push([b['post_updated_at'],b['post_url'],b['post_subject']]);
					}
				}
			}
			dt.sort();
			dt.reverse();
			code += '<div class="bbs">';
			for(var i = 0; i < 1; i++){
				if (dt[i][1].match('fwincl')){
				code += '<h2><span class="l">Windows7‰ï‹cº</span><small class="r">' + dt[i][0].slice(5,-9).replace('-','/').replace('T',' ') + '</small></h2><div class="cBox">';
				}else{
				code += '<h2><span class="l">Windows Server Insider‰ï‹cº</span><small class="r">' + dt[i][0].slice(5,-9).replace('-','/').replace('T',' ') + '</small></h2><div class="cBox">';
				}
			}

			code += '<ul>';
			for(var i = 0; i < dt.length; i++){
				if(i > 20 ){
				}else{
					code += '<li><a href="' + dt[i][1] + '" oncl' + 'ick="desig' + "nCnt('top_bbs', this.href)" + '">' + dt[i][2] + '</a><small>i' + dt[i][0].slice(5,-9).replace('-','/').replace('T',' ') + 'j</small></li>';
				}
			}
			code += '</ul></div></div>';
		}
	}
	document.write(code);
}
