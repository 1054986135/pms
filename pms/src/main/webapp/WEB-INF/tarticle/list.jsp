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
<title>文章列表</title>
</head>
<body>

<div class="box-positon">
	<div class="rpos">当前位置: 文章管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onClick="javascript:window.location.href='toadd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="list.do" method="post" style="padding-top:5px;">
标题: <input type="text" name="title" value="${QUERY.title}"/>
作者: <input type="text" name="author" value="${QUERY.author}"/>
	<input type="submit" class="query" value="查询"/>
</form>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onClick="checkBox('ids',this.checked)"/></th>
			<th>id</th>
			<th>标题</th>
			<th>内容</th>
			<th>作者</th>
			<th>添加日期</th>
			<th>所属栏目</th>
			<th>是否推荐</th>
			<th>是否热点</th>
			<th>可操作项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
<form action="deletes.do" method="post">	
<c:forEach items="${LIST}" var="tarticle" >
		<tr bgcolor="#ffffff" onMouseOut="this.bgColor='#ffffff'" onMouseOver="this.bgColor='#eeeeee'">
			<td><input type="checkbox"  value="${tarticle.id}"  name="ids"/></td>
			<td align="center">${tarticle.id}</td>
			<td align="center">${tarticle.title}</td>
			<td align="center">${tarticle.content}</td>
			<td align="center">${tarticle.author}</td>
			<td align="center">${tarticle.crtimeTxt}</td>
			<td align="center">${tarticle.cname}</td>
			<td align="center">${tarticle.isremodTxt}</td>
			<td align="center">${tarticle.ishotTxt}</td>
			
			<td align="center">
			<a class="pn-opt" href="get.do?id=${tarticle.id}">修改</a> | <a class="pn-opt"   onClick="if(!confirm('是否删除数据?')){return false;}" href="delete.do?id=${tarticle.id}">删除</a>
			</td>
		</tr>
</c:forEach>		

	</tbody>
</table>
<div style="margin-top:15px;">
	<input class="del-button" type="submit" value="删除" />
</div>
</form>
	<div style="float:right"><a href="list.do?title=${QUERY.title}&author=${QUERY.author}">第一页</a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do?page=${(PAGE-1)<=0?1:(PAGE-1)}&title=${QUERY.title}&author=${QUERY.author}">上一页</a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do?page=${PAGE+1>PAGECONT?PAGECONT:PAGE+1}&title=${QUERY.title}&author=${QUERY.author}">下一页</a>
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do?page=${PAGECONT}&title=${QUERY.title}&author=${QUERY.author}">最后页</a>&nbsp;&nbsp;&nbsp;&nbsp;当前第${PAGE}页 /共${PAGECONT}页</div>
</div>
</body>
</html>