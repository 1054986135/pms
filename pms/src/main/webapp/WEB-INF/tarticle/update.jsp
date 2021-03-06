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
<!-- 引入JQuery -->
<script type="text/javascript" language="javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<script type="text/javascript" language="javascript" src="../js/DatePicker/WdatePicker.js"></script>
<!-- 添加表单验证 -->
<script type="text/javascript">	
	//作者验证：必须两个字以上
	var CHKREALNAME="^[\u4e00-\u9fa5]{2,}$";
	//非空验证
	var CHKNULL="^[\s\S]*.*[^\s][\s\S]*$";

	</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 文章管理 - 修改</div>
	<form class="ropt">
		<input type="submit" onclick="this.form.action='list.do';" value="返回列表" class="return-button"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box" style="float:right">
	<form id="jvForm" action="update.do?id=${TARTICLE.id}" method="post" onsubmit="return chkAll()">
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
						<input type="text" class="required" name="title" id="title" maxlength="100" value="${TARTICLE.title}"/>
					<span id="resultTitle"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						内容:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="content" id="content" maxlength="100" value="${TARTICLE.content}"/>
					<span id="resultContent"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						作者:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="required" name="author" id="author" maxlength="100" value="${TARTICLE.author}"/>
					<span id="resultAuthor"></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						<span class="pn-frequired">*</span>
						添加日期:</td><td width="80%" class="pn-fcontent">
						<input type="text" class="Wdate" name="crtime" maxlength="100" onclick="WdatePicker()" value="${TARTICLE.crtimeTxt}"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						所属栏目:</td><td width="80%" class="pn-fcontent">
						<select name="channel">
							<c:forEach items="${tcbs}" var="tcb">
								
								<c:if test="${TARTICLE.channel==tcb.id}">
									<option value="${tcb.id}" selected="selected">${tcb.cname}</option>
								</c:if>
								<c:if test="${TARTICLE.channel!=tcb.id}">
									<option value="${tcb.id}">${tcb.cname}</option>
								</c:if>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否推荐:</td><td width="80%" class="pn-fcontent">
						<c:if test="${TARTICLE.isremod==1}">
						<input type="radio" class="required" name="isremod" maxlength="80" value="1" checked="checked"/>是
						<input type="radio" class="required" name="isremod" maxlength="80" value="2"/>否
						</c:if>
						<c:if test="${TARTICLE.isremod!=1}">
						<input type="radio" class="required" name="isremod" maxlength="80" value="1"/>是
						<input type="radio" class="required" name="isremod" maxlength="80" value="2" checked="checked"/>否
						</c:if>
					</td>
				</tr>
				<tr>
					<td width="20%" class="pn-flabel pn-flabel-h">
						是否热点:</td><td width="80%" class="pn-fcontent">
						<c:if test="${TARTICLE.ishot==1}">
						<input type="radio" class="required" name="ishot" maxlength="80" value="1" checked="checked"/>是
						<input type="radio" class="required" name="ishot" maxlength="80" value="2"/>否
						</c:if>
						<c:if test="${TARTICLE.ishot!=1}">
						<input type="radio" class="required" name="ishot" maxlength="80" value="1"/>是
						<input type="radio" class="required" name="ishot" maxlength="80" value="2" checked="checked"/>否
						</c:if>
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