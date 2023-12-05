<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pichill.post.entity.Post"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>



<html>
<head>
<title>�j�M�峹���G - listPost.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�峹�j�M���G - listPost.jsp</h3>
		 <h4><a href="post.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<tr>
		<th>�峹�s��</th>
		<th>�@��|���s��</th>
		<th>���~�|���s��</th>
		<th>���D</th>
		<th>����</th>
		<th>�峹����</th>
		<th>�o��ɶ�</th>
		<th>���g��</th>
	</tr>
<c:forEach var="post"   items = "${postlist }">
	<tr>
		<td>${post.postID}</td>
			<td>${post.gUserID}</td>
			<td>${post.oUserID}</td>
			<td>${post.postTitle}</td>
			<td>${post.postContent}</td>
			<td>${post.postType}</td> 
			<td>${post.postTime}</td>
			<td>${post.likeCnt}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>