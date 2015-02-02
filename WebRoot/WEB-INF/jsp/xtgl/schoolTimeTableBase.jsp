<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<script type="text/javascript">
		var basePath = '<%=basePath%>';
		var path='${pageContext.request.contextPath}';
		
		jQuery(document).ready(function(){
			
			jQuery('.left .item').draggable({
				revert:true,
				proxy:'clone'
			});
			
			jQuery('.right td.drop').droppable({
				onDragEnter:function(){
					jQuery(this).addClass('over');
				},
				onDragLeave:function(){
					jQuery(this).removeClass('over');
				},
				onDrop:function(e,source){
					jQuery(this).removeClass('over');
					if (jQuery(source).hasClass('assigned')){
						jQuery(this).append(source);
					} else {
						var c = jQuery(source).clone().addClass('assigned');
						jQuery(this).empty().append(c);
						c.draggable({
							revert:true
						});
					}
				}
			});
		});
		
	</script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/schooltimetable.css">
	
  </head>
  
  <body>
  <div id="layoutDivId">
	   <div class="left">
	   		<table>
				<tr>
					<td><div class="item">语文</div></td>
				</tr>
				<tr>
					<td><div class="item">英语</div></td>
				</tr>
				<tr>
					<td><div class="item">数学</div></td>
				</tr>
				<tr>
					<td><div class="item">物理</div></td>
				</tr>
				<tr>
					<td><div class="item">化学</div></td>
				</tr>
				<tr>
					<td><div class="item">生物</div></td>
				</tr>
				<tr>
					<td><div class="item">地理</div></td>
				</tr>
				<tr>
					<td><div class="item">历史</div></td>
				</tr>
				<tr>
					<td><div class="item">音乐</div></td>
				</tr>
				<tr>
					<td><div class="item">美术</div></td>
				</tr>
				<tr>
					<td><div class="item">体育</div></td>
				</tr>
			</table>
	   </div>
	   
	   <div class="right">
			<table>
				<tr>
					<td class="blank"></td>
					<td class="title">星期日</td>
					<td class="title">星期一</td>
					<td class="title">星期二</td>
					<td class="title">星期三</td>
					<td class="title">星期四</td>
					<td class="title">星期五</td>
					<td class="title">星期六</td>
				</tr>
				<tr>
					<td class="time">08:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<!-- other cells -->
			</table>
		</div>
    </div>
  </body>
</html>
