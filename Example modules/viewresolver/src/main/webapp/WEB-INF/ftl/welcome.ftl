<!DOCTYPE html>
<html>
<head>
    <title>Custom FTL Page</title>
</head>
<body>
<h1>welcome to FTL page</h1>

<h2>Forward : Query Param</h2>
<h3>Parameter 1 : ${queryParam1}</h3>
<h3>Parameter 2 : ${queryParam2}</h3>

<#--
<h2>Redirect : Query Param</h2>
<h3>Parameter 1 : ${qParam1}</h3>
<h3>Parameter 2 : ${qParam2}</h3>
-->
 <#--<h3>${error}</h3>-->

<h3>model object : ${model.queryParam1}</h3>
<h3>model object : ${model.queryParam2}</h3>
<h3>${CustomJavaClass.get()}</h3>

</body>
</html>