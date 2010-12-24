var _nc_wp_atit_rc_clicked = function (url) {
	new Image().src = 'http://connect.newzia.jp/channels/126/clicked'
		+ '?url=' + encodeURIComponent(url)
		+ '&page_url=' + encodeURIComponent(document.URL)
		+ '&ref=' + encodeURIComponent(document.referrer)
		+ '&' + Math.random();
}
;
var _nc_wp_atit_rc_callback = function (response) {
	(function (contents_length) {
	new Image().src = 'http://connect.newzia.jp/channels/126/viewed'
		+ '?url=' + encodeURIComponent(document.URL)
		+ '&ref=' + encodeURIComponent(document.referrer)
		+ '&contents_length=' + contents_length
		+ '&' + Math.random();
}
)(response.length);
	var newziaConnect = document.getElementById('newzia_connect_wp_atit_rc_');
var getMedianamecc = function() {
	if (document.URL.match('/fwin2k/')) {
		medianame = 'tt_atit_wp_windows';
	} else if (document.URL.match('/fdotnet/')) {
		medianame = 'tt_atit_wp_dotnet';
	} else if (document.URL.match('/fsys/')) {
		medianame = 'tt_atit_wp_system';
	} else if (document.URL.match('/fserver/')) {
		medianame = 'tt_atit_wp_serverstorage';
	} else if (document.URL.match('/fwcr/design/')) {
		medianame = 'tt_atit_wp_d89';
	} else if (document.URL.match('/fwcr/')) {
		medianame = 'tt_atit_wp_richclient';
	} else if (document.URL.match('/fcoding/')) {
		medianame = 'tt_atit_wp_codingedge';
	} else if (document.URL.match('/fjava/')) {
		medianame = 'tt_atit_wp_java';
	} else if (document.URL.match('/fdb/')) {
		medianame = 'tt_atit_wp_database';
	} else if (document.URL.match('/fxml/')) {
		medianame = 'tt_atit_wp_xml';
	} else if (document.URL.match('/flinux/')) {
		medianame = 'tt_atit_wp_linux';
	} else if (document.URL.match('/fnetwork/')) {
		medianame = 'tt_atit_wp_ipnetwork';
	} else if (document.URL.match('/fsecurity/')) {
		medianame = 'tt_atit_wp_security';
	} else if (document.URL.match('/frfid/')) {
		medianame = 'tt_atit_wp_rfid';
	} else if (document.URL.match('/fkaiketsu/')) {
		medianame = 'tt_atit_wp_fkaiketsu';
	} else if (document.URL.match('/im/cits/')) {
		medianame = 'tt_im_wp_cits';
	} else if (document.URL.match('/im/cop/')) {
		medianame = 'tt_im_wp_cop';
	} else if (document.URL.match('/im/carc/')) {
		medianame = 'tt_im_wp_carc';
	} else if (document.URL.match('/im/cpm/')) {
		medianame = 'tt_im_wp_cpm';
	} else if (document.URL.match('/im/cbp/')) {
		medianame = 'tt_im_wp_cbp';
	} else if (document.URL.match('/im/cap/')) {
		medianame = 'tt_im_wp_cap';
	} else if (document.URL.match('/im/ces/')) {
		medianame = 'tt_im_wp_webmarketing';
	} else if (document.URL.match('/fembedded/')) {
		medianame = 'tt_monoist_wp_fembedded';
	} else if (document.URL.match('/fpro/')) {
		medianame = 'tt_monoist_wp_fpro';
	} else if (document.URL.match('/enterprise/')) {
		medianame = 'tt_ent_wp';
	} else {
		medianame = 'tt_atit_wp_newzia';
	}
	return medianame;
}

var cctemp = '';
cctemp += "<div id=\"newzia_connect_wp_atit_rc\" class=\"btmlist\"><h3>ホワイトペーパー<small>（<a href=\"http://techtarget.itmedia.co.jp/tt/membership/\">TechTargetジャパン</a>）</small></h3><ul>";

for (i = 0; i < response.length; i++) {
	cctemp += "<li><a onclick=\"var s=s_gi('itmediacojpglobal'); s.eVar21='" + getMedianamecc() + "'; s.tl(this,'o','" + getMedianamecc() +"');\" href=\"" + response[i].url + "\" onmousedown=\"_nc_wp_atit_rc_clicked(this.href)\">" + response[i].title + "</a></li>";
}

cctemp += "</ul></div>";
newziaConnect.innerHTML = cctemp;

	newziaConnect.innerHTML += '<div style="text-align:right;font-size:10px;color:#666;">powered by <a href="http://connect.newzia.jp/" target="_blank">newziaコネクト</a></div><br clear="all">';
};
(function () {
	var getMetaContentByName = function (name) {
		if (document.getElementsByName(name).length > 0) {
			return document.getElementsByName(name)[0].getAttribute('content');
		}
		return '';
	};
	var bindReady = function (callback) {
    var isReady = false;
    function ready(){
        if(isReady)return;
        isReady = true;
        callback();
    }
    bindReady = function(){};
    var userAgent = navigator.userAgent.toLowerCase();
    var browser = {
        safari: /webkit/.test( userAgent ),
        opera: /opera/.test( userAgent ),
        msie: /msie/.test( userAgent ) && !/opera/.test( userAgent )
    };
    // Mozilla, Opera (see further below for it) and webkit nightlies currently support this event
    if ( document.addEventListener && !browser.opera)
        // Use the handy event callback
        document.addEventListener( "DOMContentLoaded", ready, false );

    // If IE is used and is not in a frame
    // Continually check to see if the document is ready
    if ( browser.msie && window == top ) (function(){
        if (isReady) return;
        try {
            // If IE is used, use the trick by Diego Perini
            // http://javascript.nwbox.com/IEContentLoaded/
            document.documentElement.doScroll("left");
        } catch( error ) {
            setTimeout( arguments.callee, 0 );
            return;
        }
        // and execute a waiting function
        ready();
    })();

    if ( browser.opera )
        document.addEventListener( "DOMContentLoaded", function () {
            if (isReady) return;
            for (var i = 0; i < document.styleSheets.length; i++)
                if (document.styleSheets[i].disabled) {
                    setTimeout( arguments.callee, 0 );
                    return;
                }
            // and execute a waiting function
            ready();
        }, false);

    if ( browser.safari ) {
        var numStyles;
        function countNumStyles(){
            var d = document;
            var stylesLength = d.getElementsByTagName('style').length;
            var links = d.getElementsByTagName('link');
            for(var i = 0; i++; i < links.length){
                if(links[i].rel == 'stylesheet'){
                    stylesLength++;
                }
            }
            return stylesLength;
        }
        (function(){
            if (isReady) return;
            if ( document.readyState != "loaded" && document.readyState != "complete" ) {
                setTimeout( arguments.callee, 0 );
                return;
            }
            if ( numStyles === undefined )
                numStyles = countNumStyles();
            if ( document.styleSheets.length != numStyles ) {
                setTimeout( arguments.callee, 0 );
                return;
            }
            // and execute a waiting function
            ready();
        })();
    }
    var oldOnload = window.onload;
    window.onload=function(){
        if(oldOnload)oldOnload();
        ready();
    };
};

	var callNewziaConnect = function () {
		var md5 = new function() {
	var blockLen = 64;
	var state = [ 0x67452301 , 0xefcdab89 , 0x98badcfe , 0x10325476 ];
	var sttLen = state.length;
	
	this.hex = function(_data)
	{
		return toHex( getMD(_data) );
	}

	this.dec = function(_data)
	{
		return getMD(_data);
	}
	
	this.bin = function(_data)
	{
		return pack( getMD(_data) );
	}
	
	var getMD = function(_data)
	{
		var datz = [];
		if (isAry(_data)) datz = _data;
		else if (isStr(_data)) datz = unpack(_data);
		else "unknown type";
		datz = paddingData(datz);
		return round(datz);
	}
    
    var isAry = function(_ary)
	{
		return _ary && _ary.constructor === [].constructor;
	}
	var isStr = function(_str)
	{
		return typeof(_str) == typeof("string");
	}
    
	var round = function(_blk)
	{
		var stt = [];
		var tmpS= [];
		var i, j, tmp, x = [];
		for (j=0; j<sttLen; j++) stt[j] = state[j];
		
		for (i=0; i<_blk.length; i+=blockLen)
		{
			for (j=0; j<sttLen; j++) tmpS[j] = stt[j];
			x = toLittleEndian32( _blk.slice(i, i+ blockLen) );

	        for (j=0; j<64; j++)
	        {
	            if (j<16) 
	                tmp = (stt[1] & stt[2]) | (~stt[1] & stt[3]);
	            else if (j<32)
	                tmp = (stt[1] & stt[3]) | (stt[2] & ~stt[3]);
	            else if (j<48)
	                tmp = stt[1] ^ stt[2] ^ stt[3];
	            else
	                tmp = stt[2] ^ (stt[1] | ~stt[3]);

	       		tmp +=  x[ K[j] ] + T[j] + stt[0];
	            stt[0] = stt[1] + ( (tmp << S[j]) | (tmp >>> (32-S[j])) );
	            stt = [ stt[3], stt[0], stt[1], stt[2] ];
	        }		
			for (j=0; j<sttLen; j++) stt[j] += tmpS[j];
		}

		return fromLittleEndian32(stt);
	}

	var paddingData = function(_datz)
	{
		var datLen = _datz.length;
		var n = datLen;
		_datz[n++] = 0x80;
		while (n% blockLen != 56) _datz[n++] = 0;
		datLen *= 8;
		return _datz.concat(
			fromLittleEndian32([datLen]),
			0, 0, 0, 0
		);
	}

	var toHex = function(_decz)
	{
		var i, hex = "";

		for (i=0; i<_decz.length; i++)
			hex += (_decz[i]>0xf?"":"0")+ _decz[i].toString(16);
		return hex;
	}
	
	var fromLittleEndian32 = function(_blk)
	{
		var tmp = [];
		for (n=i=0; i<_blk.length; i++)
		{
			tmp[n++] = _blk[i] & 0xff;
			tmp[n++] = (_blk[i] >>>  8) & 0xff;
			tmp[n++] = (_blk[i] >>> 16) & 0xff;
			tmp[n++] = (_blk[i] >>> 24) & 0xff;
		}
		return tmp;
	}
	
	var toLittleEndian32 = function(_blk)
	{
		var tmp = [];
		var i, n;
		for (n=i=0; i<_blk.length; i+=4, n++)
			tmp[n] = (_blk[i+ 3]<<24) | (_blk[i+ 2]<<16) | (_blk[i+ 1]<<8) | _blk[i];
		return tmp;
	}
	
	var unpack = function(_dat)
	{
		var i, n, c, tmp = [];

	    for (n=i=0; i<_dat.length; i++) 
	    {
	    	c = _dat.charCodeAt(i);
			if (c <= 0xff) tmp[n++] = c;
			else {
				tmp[n++] = c >>> 8;
				tmp[n++] = c &  0xff;
			}	
	    }
	    return tmp;
	}

	var pack = function(_ary)
    {
        var i, tmp = "";
        for (i in _ary) tmp += String.fromCharCode(_ary[i]);
        return tmp;
    }

    var K = [
        0 ,  1 ,  2 ,  3 ,  4 ,  5 ,  6 ,  7 ,    8 ,  9 , 10 , 11 , 12 , 13 , 14 , 15 , 
        1 ,  6 , 11 ,  0 ,  5 , 10 , 15 ,  4 ,    9 , 14 ,  3 ,  8 , 13 ,  2 ,  7 , 12 , 
        5 ,  8 , 11 , 14 ,  1 ,  4 ,  7 , 10 ,   13 ,  0 ,  3 ,  6 ,  9 , 12 , 15 ,  2 , 
        0 ,  7 , 14 ,  5 , 12 ,  3 , 10 ,  1 ,    8 , 15 ,  6 , 13 ,  4 , 11 ,  2 ,  9  
    ];

    var S = [
        7 , 12 , 17 , 22 ,  7 , 12 , 17 , 22 ,    7 , 12 , 17 , 22 ,  7 , 12 , 17 , 22 , 
        5 ,  9 , 14 , 20 ,  5 ,  9 , 14 , 20 ,    5 ,  9 , 14 , 20 ,  5 ,  9 , 14 , 20 , 
        4 , 11 , 16 , 23 ,  4 , 11 , 16 , 23 ,    4 , 11 , 16 , 23 ,  4 , 11 , 16 , 23 , 
        6 , 10 , 15 , 21 ,  6 , 10 , 15 , 21 ,    6 , 10 , 15 , 21 ,  6 , 10 , 15 , 21  
    ];

    var T = [
        0xd76aa478 , 0xe8c7b756 , 0x242070db , 0xc1bdceee ,   0xf57c0faf , 0x4787c62a , 0xa8304613 , 0xfd469501 , 
        0x698098d8 , 0x8b44f7af , 0xffff5bb1 , 0x895cd7be ,   0x6b901122 , 0xfd987193 , 0xa679438e , 0x49b40821 , 
        0xf61e2562 , 0xc040b340 , 0x265e5a51 , 0xe9b6c7aa ,   0xd62f105d ,  0x2441453 , 0xd8a1e681 , 0xe7d3fbc8 , 
        0x21e1cde6 , 0xc33707d6 , 0xf4d50d87 , 0x455a14ed ,   0xa9e3e905 , 0xfcefa3f8 , 0x676f02d9 , 0x8d2a4c8a , 
        0xfffa3942 , 0x8771f681 , 0x6d9d6122 , 0xfde5380c ,   0xa4beea44 , 0x4bdecfa9 , 0xf6bb4b60 , 0xbebfbc70 , 
        0x289b7ec6 , 0xeaa127fa , 0xd4ef3085 ,  0x4881d05 ,   0xd9d4d039 , 0xe6db99e5 , 0x1fa27cf8 , 0xc4ac5665 , 
        0xf4292244 , 0x432aff97 , 0xab9423a7 , 0xfc93a039 ,   0x655b59c3 , 0x8f0ccc92 , 0xffeff47d , 0x85845dd1 , 
        0x6fa87e4f , 0xfe2ce6e0 , 0xa3014314 , 0x4e0811a1 ,   0xf7537e82 , 0xbd3af235 , 0x2ad7d2bb , 0xeb86d391 
    ];

}
;


		var script = document.body.appendChild(document.createElement('script'));
		script.charset = 'utf-8';
		script.type = 'text/javascript';
		script.src = 'http://connect.newzia.jp/channels/126/' + md5.hex(document.URL) + '/contents.json?'
			 + 'url=' + encodeURIComponent(document.URL)
			 + '&ref=' + encodeURIComponent(document.referrer)
			 ;
	};

	if (!document.getElementById('newzia_connect_wp_atit_rc_')) {
		document.write('<div id="newzia_connect_wp_atit_rc_"></div>');
		bindReady(callNewziaConnect);
	} else {
		callNewziaConnect();
	}
}
)();
