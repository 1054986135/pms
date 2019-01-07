<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="../res/lecheng/css/admin.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/theme.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/jquery.validate.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/jquery.ui.css" rel="stylesheet"
	type="text/css" />

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="res/css/style.css" />
<!-- 引入JQuery -->
<script type="text/javascript" language="javascript"
	src="js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<script type="text/javascript" language="javascript"
	src="../js/DatePicker/WdatePicker.js"></script>
<title>user-add</title>
<!-- 添加表单验证 -->
<script type="text/javascript">
  $(function(){
		//初始化二级部门，用第一个部门的id
		//发ajax的post请求
		$.post(
			//url
			"getDep2.do",
			//参数   第一个部门的id
			{pid:1},
			//回调方法
			function(result){
				//循环数组
				$(result).each(
					function(){									//value='6'
						$("#dep2").append("<option value='"+this.id+"'>"+this.dname+"</option>")
					}		
				
				)
			},
			//返回值类型
			"json"
		);
		
		
		//在第一个部门的改变事件中
		$("#dep1").change(
				//匿名方法
				function(){
					//清空第二个下拉框
					$("#dep2").empty();
					//发ajax的post请求
					$.post(
						//url
						"getDep2.do",
						//参数
						{pid:this.value},
						//回调方法
						function(result){
							//循环数组
							$(result).each(
								function(){									//value='6'
									$("#dep2").append("<option value='"+this.id+"'>"+this.dname+"</option>")
								}		
							
							)
						},
						//返回值类型
						"json"
					);
				}	
		
		);
	  
  });
	//用户名验证：用户名必须包含数字和字母，且必须是6-16位之间，且结束前不能全是数字
	var CHKLOGINNAME = "^(?![0-9]+$)[a-zA-Z0-9]{6,16}$";
	//密码验证：必须包含数字和字母，且必须是6-16位之间，且结束前不能全是数字也不能全是字母
	var CHKPASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{6,16}$";
	//真实姓名验证：必须两个字以上
	var CHKREALNAME = "^[\u4e00-\u9fa5]{2,}$";
	//日期验证：   yyyy-MM-dd
	var CHKDATE = "^[0-9]{4}-(0?[1-9]|1?[0-2])-(0?[1-9]|[1-2][0-9]|3?[0-1])$";
	//邮箱验证：xxxxx@xxx.com,可以包含_下划线，          企业邮箱：   qweqweq@huawei.com.cn
	var CHKEMAIL = "^[a-zA-Z0-9_]+@[a-z0-9]{2,5}(\\.[a-z]{2,3}){1,2}$";

	/* 文件上传 */
	function upload() {
		/* ajax提交 */

		var args = {
			//路径
			url : "../commupload.do",
			//数据返回类型
			dataType : "String",
			//提交方式
			type : "post",
			//成功回调函数
			success : function(result) {
				//设置图片的属性 src
				$("#img").attr("src", "../upload/" + result);
				$("#pic").val(result);
			}
		};
		//ajax表单提交
		$("#jvForm").ajaxSubmit(args);
	}
	
</script>
</head>
<body>
	<div class="box-positon">
		<div class="rpos">当前位置: 用户管理 - 添加</div>
		<form class="ropt">
			<input type="submit" onclick="this.form.action='list.do';"
				value="返回列表" class="return-button" />
		</form>
		<div class="clear"></div>
	</div>
	<div id="fm" class="body-box" style="float: right">
		<form id="jvForm" action="add.do" method="post"
			enctype="multipart/form-data">
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired"></span> <span class="pn-frequired">${msg}</span>
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 用户名:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="loginname" id="loginname" maxlength="100" />
							<span id="resultName"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 密码:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="password" id="password" maxlength="100" />
						</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 确认密码:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="repwd" id="repwd" maxlength="100" /> <span
							id="resultRepwd"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h"><span
							class="pn-frequired">*</span> 真实姓名:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="realname" id="realname" maxlength="100" />
							<span id="resultRName"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">性别:</td>
						<td width="80%" class="pn-fcontent"><input type="radio"
							name="sex" value="男" checked="checked" />男 <input type="radio"
							name="sex" value="女" />女</td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">出生日期:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="Wdate" name="birthday" onclick="WdatePicker()"
							maxlength="80" /> <span id="resultBirthday"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">部门:</td>
						<td width="80%" class="pn-fcontent">
						<select id="dep1" name="dep1">
								<c:forEach items="${DLIST1}" var="d1">
									<option value="${d1.id}">${d1.dname}</option>
								</c:forEach>
						</select> 
						<select id="dep2" name="dept.id"></select></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">邮箱:</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="email" id="email" maxlength="80" /> <span
							id="resultEmail"></span></td>
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">头像：</td>
						<td width="80%" class="pn-fcontent"><input type="file"
							name="file" onchange="upload()" /> <img id="img" width="80px"
							height="80px" /> <input type="hidden" id="pic" name="pic" /></td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td class="pn-fbutton" colspan="2"><input type="submit"
							class="submit" value="提交" /> &nbsp; <input type="reset"
							class="reset" value="重置" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>