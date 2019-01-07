<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script>
	function getDate() {
		//获取当前时间
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var weekFormat = new Array("日", "一", "二", "三", "四", "五", "六");
		var week = date.getDay();
		var hour = date.getHours();
		if(hour<10){
			hour="0"+hour;
		}
		var minute = date.getMinutes();
		if(minute<10){
			minute="0"+minute;
		}
		var second = date.getSeconds();
		if(second<10){
			second="0"+second;
		}
		var time = year + '-' + month + '-' + day + ' ' + hour + ':' + minute
				+ ':' + second + '  星期' + weekFormat[week];

		//获取div
		var div1 = document.getElementById("showThisTime");
		//将时间写入div
		div1.innerHTML = "当前时间：" + time;
	}
	//使用定时器每秒向div写入当前时间
	setInterval("getDate()", 1000);
</script>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
</head>
<body leftmargin="0" topmargin="0">
<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"><img src="images/logo.gif" width="262" height="64"></td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt"><b>欢迎${CUSER.realname}</b>
      <span id="showThisTime"></span>感谢登录使用！</td>
        <td width="22%"><a href="login.jsp" target="parent"><img src="images/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

