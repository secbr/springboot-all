<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生列表</title>
</head>
<body>
<table border="1">
    <tr>
        <td>学生编号</td>
        <td>学生名称</td>
    </tr>
    <#list students as student>
        <tr>
            <td>${student.idNo}</td>
            <td>${student.name}</td>
        </tr>
    </#list>
</table>
</body>
</html>