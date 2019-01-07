<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="../res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="res/css/style.css" />
<title>user-add</title>
<!-- 添加表单验证 -->
<script type="text/javascript">	
	//栏目验证：必须两个字以上
	var CHKREALNAME="^[\u4e00-\u9fa5]{2,}$";
	//验证栏目
	function chkCman(){
		//获取栏目
		var cname1=$("#cname").val();
		//定义匹配栏目的则表达式
		var reg=new RegExp(CHKREALNAME);
		if(reg.test(cname1)){//表示匹配成功
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
	</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 频道管理 - 添加</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="add.do" method="post" onsubmit="return chkCman()">
		<table cellspacing="1" cellpadding="2" width="100%" border="0" class="pn-ftable">
			<tbody>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired"></span>
						<span class="pn-frequired">${MSG}</span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						栏目名称:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="cname" id="cname" maxlength="100"/>
					<span id="resultCName"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						上一级:</td><td width="80%" class="pn-fcontent">
						<select name="pid">
							<c:forEach items="${tcbs}" var="tcb">
							    <c:if test="${tcb.isleaf!=1 }">
									<option value="${tcb.id}" name="id">${tcb.cname}</option>
								</c:if>
							</c:forEach>							
					</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						等级:</td><td width="80%" class="pn-fcontent">
						<input type="radio" name="lev" value="1" checked="checked"/>第一等级
						<input type="radio" name="lev" value="0"/>第二等级
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否叶子:</td><td width="80%" class="pn-fcontent">
						<input type="radio" name="isleaf" value="1" checked="checked"/>是叶子
						<input type="radio" name="isleaf" value="0"/>不是叶子
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