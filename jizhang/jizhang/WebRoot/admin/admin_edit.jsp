<%@include file="/common/sub_header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<link href="<%=path%>/css/list.css" rel="stylesheet" type="text/css" />

	</head>
	<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">

		<br />


		<form id="form1" name="form1" method="post" action="?act=save">
			 <input type="hidden" name="messageInfo" id="messageInfo" value="${messageInfo}" />
			 <input type="hidden" name="admin.id" value="${admin.id}" />	
			<table cellpadding='3' cellspacing='1' border='0' class='tableBorder'
				align=center>
				<tr>
					<th class='tableHeaderText' colspan=2 height=25>
						管理员管理
					</th>
					<tr>
						<td width="15%" height=23 class='forumRow'>
							姓名：
						</td>
						<td class='forumRow'>
							<input id="name" name="admin.name" value="${admin.name}" type='text'  ' size='70'>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td class='forumRowHighLight' height=23>
							密码
						</td>
						<td class='forumRowHighLight'>
							<input id="pass"	value="${admin.pass}" 
													name="admin.pass"  type='text'   size='70'>
							&nbsp;
						</td>
					</tr>
					 

					<tr>
						<td height="50" colspan=2 class='forumRow'>
							<div align="center">
								<input type="button" name="Submit" value="保存" class="button"	
						onclick="save();" />	
	
					<input type="button" name="Submit2" value="返回" class="button"	
						onclick="window.history.go(-1);" />
							</div>
						</td>
					</tr>
			</table>
		</form>
	</body>
</html>
<script>

function save() {
	if ($("#name").val() == "") {
		$.messager.alert('警告', '姓名不能为空！', 'warning');
		return;
	}
	if ($("#pass").val() == "") {
		$.messager.alert('警告', '密码不能为空！', 'warning');
		return;
	}
	document.forms[0].action = "<%=path%>/admin!editAdmin.action";
	document.forms[0].submit();

}

$(document).ready(function() {
	var $messageInfo = $("#messageInfo").val();
	if ($messageInfo != null && $messageInfo != "") {
		$.messager.show( {
			title : '提示',
			msg : $messageInfo,
			timeout : 2000,
			showType : 'slide'
		});
		$("#messageInfo").val("");
	}
});
</script>
