<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/style.css" rel="stylesheet">
    <title>Hello</title>
</head>
<body>
Hello
<#if grade == "A">
    ${student.name}
<#else>
    NoBody
</#if>

<br/>
date日期格式：${date?date}

<br/>
datetime日期格式：${date?datetime}

<br/>
time日期格式：${date?time}

<br/>
自定义日期格式：${date?string("yyyy-MM-dd HH:mm:ss")}

<br/>
Null值处理(显示为空)：${empty!}

<br/>
Null值处理(显示为默认值)：${empty!"I am Empty"}

<br/>
<#if empty??>
    不为空时输出结果。
<#else>
    Null值判断结果："I am Empty"
</#if>

<br/>

<#--定义宏-->
<#macro hello someone>
    <p style="color:red">Hello ${someone}</p>
</#macro>

<@hello someone="Tom">11</@hello>

</body>
</html>