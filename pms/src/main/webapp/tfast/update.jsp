<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="res/common/js/jquery.js" type="text/javascript"></script>
<script src="res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="res/common/js/lecheng.js" type="text/javascript"></script>
<script src="res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="res/css/style.css" />
<!-- 引入JQuery -->
<script type="text/javascript" language="javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<script type="text/javascript" language="javascript" src="js/DatePicker/WdatePicker.js"></script>
<title>user-add</title>
<!-- 添加表单验证 -->
<script type="text/javascript">	
	//公告人验证：必须两个字以上
	var CHKREALNAME="^[\u4e00-\u9fa5]{2,}$";
	//非空验证
	var CHKNULL="^[\s\S]*.*[^\s][\s\S]*$";
	//验证标题非空
	function chkNull(){
		//获取标题
		var nulls=$("#nulls").val();
		//定义匹配标题的则表达式
		var reg=new RegExp(CHKNULL);
		if(reg.test(nulls)){//表示匹配成功
			$("#resultNull").html("√");
			$("#resultNull").css("color","green");
			return true;
		}else{
			$("#resultNull").html("不能为空");
			$("#resultNull").css("color","red");
			//返回
			return false;
		}
	}
	//验证内容非空
	function chkNulls(){
		//获取内容
		var nulls=$("#nullss").val();
		//定义匹配内容的则表达式
		var reg=new RegExp(CHKNULL);
		if(reg.test(nulls)){//表示匹配成功
			$("#resultNulls").html("√");
			$("#resultNulls").css("color","green");
			return true;
		}else{
			$("#resultNulls").html("不能为空");
			$("#resultNulls").css("color","red");
			//返回
			return false;
		}
	}
	//验证公告人
	function chkCman(){
		//获取公告人
		var cname=$("#cman").val();
		//定义匹配公告人的则表达式
		var reg=new RegExp(CHKREALNAME);
		if(reg.test(cname)){//表示匹配成功
			$("#resultCName").html("√");
			$("#resultCName").css("color","green");
			return true;
		}else{
			$("#resultCName").html("必须两个字以上");
			$("#resultCName").css("color","red");
			//返回
			return false;
		}
	}
	//验证所有
	function chkAll(){
		return chkNull()&&chkNulls()&&chkCman();
	}
	</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 快报管理 - 修改</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='tfastlist.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="updatetfast.do?id=${tFast.id }" method="post" onsubmit="return chkAll()">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired"></span>
						<span class="pn-frequired">${msg}</span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						标题:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="title" id="nulls" maxlength="100" value="${tFast.title }"/>
					<span id="resultNull"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						内容:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="content" id="nullss" maxlength="100" value="${tFast.content }"/>
					<span id="resultNulls"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						公告时间:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="Wdate" name="ctime" onclick="WdatePicker()" maxlength="80" value="${tFast.ctime }"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						公告人:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="cman" id="cman" maxlength="100" value="${tFast.cman }"/>
					<span id="resultCName"></span>
					</td>
				</tr>
			</tbody>
			<tbody>
				<tr>
					<td class="pn-fbutton" colspan="2">
						<input type="submit" class="submit" value="提交"/> &nbsp; <input type="reset" class="reset" value="重置"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>