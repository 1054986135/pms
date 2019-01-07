<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link href="../res/lecheng/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="../res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="../res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="../res/css/style.css" />
<!-- 引入核心标签库 -->
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>tfast-list</title>
</head>
<body>

<div class="box-positon">
	<div class="rpos">当前位置: 频道管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onClick="javascript:window.location.href='toadd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="list.do" method="post" style="padding-top:5px;">
栏目名称: <input type="text" name="cname" value="${QUERY.cname}"/>

	<input type="submit" class="query" value="查询"/>
</form>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onClick="checkBox('ids',this.checked)"/></th>
			<th>id</th>
			<th>栏目名称</th>
			<th>上级栏目</th>
			<th>等级</th>
			<th>是否叶子</th>
			<th>可操作项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
<form action="deletes.do" method="post">	
<c:forEach items="${LIST}" var="channel" >
		<tr bgcolor="#ffffff" onMouseOut="this.bgColor='#ffffff'" onMouseOver="this.bgColor='#eeeeee'">
			<td><input type="checkbox"  value="${channel.id}"  name="ids"/></td>
			<td align="center">${channel.id} </td>
			<td align="center">${channel.cname}</td>
			<td align="center">${channel.levTxt}</td>
			<td align="center">${channel.pidtxt}</td>
			<td align="center">${channel.isleafTxt}</td>

			
			<td align="center">
			<a class="pn-opt" href="get.do?id=${channel.id}">修改</a> | <a class="pn-opt"   onClick="if(!confirm('是否删除数据?')){return false;}" href="delete.do?id=${channel.id}">删除</a>
			</td>
		</tr>
</c:forEach>		

	</tbody>
</table>
<div style="margin-top:15px;">
	<input class="del-button" type="submit" value="删除" />
</div>
</form>
	<div style="float:right"><a href="list.do?cname=${QUERY.cname}">第一页</a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do?page=${(PAGE-1)<=0?1:(PAGE-1)}&cname=${QUERY.cname}">上一页</a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do?page=${PAGE+1>PAGECONT?PAGECONT:PAGE+1}&cname=${QUERY.cname}">下一页</a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do?page=${PAGECONT}&cname=${QUERY.cname}">最后页</a>&nbsp;&nbsp;&nbsp;&nbsp;当前第${PAGE}页 /共${PAGECONT}页</div>
</div>
</body>
</html>