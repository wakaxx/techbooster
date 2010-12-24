document.write('<!-- THIS HTML MADE BY ADX -->\n');

var flashClick0 = "http://ad-apac.doubleclick.net/6k%3Bh%3Dv8/3a65/3/0/%2a/c%3B231815326%3B0-0%3B0%3B55831837%3B4307-300/250%3B39058969/39076726/1%3B%3B%7Esscs%3D%3fhttp://www.ibm.com/businesscenter/jp/offeringpromo/opcp.html";
var flashURL = "http://s0.2mdn.net/1875135/IBM_ES_Systemx_Simple1_H250xW300_50K_30s_atmarkit_101104.swf?clickTAG=" + escape(flashClick0);
var gifADURL   = "http://ad-apac.doubleclick.net/ad/N2830.279597.BS0001891100000010/B4874243;sz=300x250;ord=1";
var gifCLKURL  = "http://ad-apac.doubleclick.net/6k%3Bh%3Dv8/3a65/3/0/%2a/c%3B231815326%3B0-0%3B0%3B55831837%3B4307-300/250%3B39058969/39076726/1%3B%3B%7Esscs%3D%3fhttp://ad-apac.doubleclick.net/jump/N2830.279597.BS0001891100000010/B4874243;sz=300x250;ord=1";
var B_win = 0;
var B_mac = 0;
var B_plugin = 0;
var B_IE6 = 0;
var B_IE5 = 0;
var B_IE4 = 0;
var B_NN6 = 0;
function isTarget() {
	if( B_plugin >= 6 ) {
	    if( B_IE6 || B_IE5 ) {
	        if( B_win || B_mac ) {
	            return true;
	        }
	    } else
	    if( B_NN6 ) {
	        if( B_win || B_mac ) {
	            return true;
    	    }
	    }
	}
	return false;
}
if( -1 == navigator.userAgent.indexOf("Opera") ) {
	if( document.getElementById ) {
		if( navigator.appName=="Netscape" ) {
			B_NN6 = 1;
		} else if( navigator.appVersion.indexOf( 'MSIE 6', 0 ) != -1 ) {
			B_IE6 = 1;
		} else {
			B_IE5 = 1;
		}
	} else {
		if( document.all ){
			B_IE4 = 1;
		}
	}
}
ver = navigator.appVersion;
for( i=0; i<ver.length; i++ ) {
	str = ver.substring(i, i+3);
	if ( str == "Win"){
		B_win = 1;
	}
}
if( -1 != navigator.appVersion.indexOf("Macintosh") ) {
	B_mac = 1;
}
if (navigator.mimeTypes && navigator.mimeTypes["application/x-shockwave-flash"] && navigator.mimeTypes["application/x-shockwave-flash"].enabledPlugin) {
	if (navigator.plugins && navigator.plugins["Shockwave Flash"]) {
		for( i=0; i<navigator.plugins.length; i++ ) {
			if( B_plugin < 4 && navigator.plugins[i].description.indexOf( 'Shockwave Flash 4', 0 ) != -1 ) {
				B_plugin = 4;
			} else
			if( B_plugin < 5 && navigator.plugins[i].description.indexOf( 'Shockwave Flash 5', 0 ) != -1 ) {
				B_plugin = 5;
			} else
			if( B_plugin < 6 && navigator.plugins[i].description.indexOf( 'Shockwave Flash 6', 0 ) != -1 ) {
				B_plugin = 6;
			} else
			if( B_plugin < 7 && navigator.plugins[i].description.indexOf( 'Shockwave Flash 7', 0 ) != -1 ) {
				B_plugin = 7;
			} else
			if( B_plugin < 8 && navigator.plugins[i].description.indexOf( 'Shockwave Flash 8', 0 ) != -1 ) {
				B_plugin = 8;
			} else
			if( B_plugin < 9 && navigator.plugins[i].description.indexOf( 'Shockwave Flash 9', 0 ) != -1 ) {
				B_plugin = 9;
			} else
			if( B_plugin < 10 && navigator.plugins[i].description.indexOf( 'Shockwave Flash 10', 0 ) != -1 ) {
				B_plugin = 10;
			}
		}
	}
} else if (navigator.userAgent && navigator.userAgent.indexOf("MSIE")>=0 && (B_win == 1)) {
	document.write('<SCRIPT LANGUAGE=VBScript\>' + '\n');
	document.write('on error resume next' + '\n');
	document.write('For v = 2 to 10' + '\n');
	document.write('If Not(IsObject(CreateObject(\"ShockwaveFlash.ShockwaveFlash.\" & v))) Then' + '\n');
	document.write('Else' + '\n');
	document.write('B_plugin = v' + '\n');
	document.write('End If' + '\n');
	document.write('Next' + '\n');
	document.write('<\/SCRIPT\>');
}

if( isTarget() ) {
	document.write('<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://active.macromedia.com/flash2/cabs/swflash.cab#version=6,0,0,0" WIDTH=300 HEIGHT=250 ID=movie>');
	document.write('<param name="movie" value="' + flashURL + '">');
	document.write('<param name="menu" value="false">');
	document.write('<param name="quality" value="high">');
	document.write('<param name="allowScriptAccess" value="always">');
	document.write('<embed src="' + flashURL + '" quality="high" menu="false" allowScriptAccess="always" pluginspage="http://www.macromedia.com/jp/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="300" height="250"></embed>');
	document.write('</OBJECT>');
} else {
	document.write('<A HREF="' + gifCLKURL + '" TARGET="_top">');
	document.write('<IMG SRC="' + gifADURL + '" WIDTH="300" HEIGHT="250" BORDER="0"></A>');
}
// -->

document.write('\n<NOSCRIPT>\n<A HREF=\"http://ad-apac.doubleclick.net/6k%3Bh%3Dv8/3a65/3/0/%2a/c%3B231815326%3B0-0%3B0%3B55831837%3B4307-300/250%3B39058969/39076726/1%3B%3B%7Esscs%3D%3fhttp://ad-apac.doubleclick.net/jump/N2830.279597.BS0001891100000010/B4874243;sz=300x250;ord=1\" TARGET=\"_top\">\n<IMG SRC=\"http://ad-apac.doubleclick.net/ad/N2830.279597.BS0001891100000010/B4874243;sz=300x250;ord=1\" WIDTH=\"300\" HEIGHT=\"250\" BORDER=\"0\"></A>\n</NOSCRIPT>');
