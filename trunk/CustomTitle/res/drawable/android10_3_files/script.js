var url_atitrc = document.URL;
if (
	url_atitrc.match('atmarkit.co.jp/fdb/rensai/10_dwh/01/dwh01_1.html') || 
	url_atitrc.match('atmarkit.co.jp/fdb/rensai/10_dwh/01/dwh01_2.html') || 
	url_atitrc.match('core.atmarkit.co.jp/keyword/dwh.html')
) {
	document.write('<script language="JavaScript" type="text/javascript" src="http://www.atmarkit.co.jp/parts/include/atit/1011_newzia_DWH.js">');
	document.write('</script>');
}
