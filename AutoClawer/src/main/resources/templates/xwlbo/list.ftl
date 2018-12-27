<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <style>
        .div-inline{display:inline;float:left;margin:10px;padding:2px;}
    </style>

</head>
<body>
    <div>
        <#list xwlbos as xwlbo>
            <div class="display:block;">
               <div class="div-inline">${xwlbo.date}</div>
               <div class="div-inline"><#if xwlbo.url??><a href="${xwlbo.url}">${xwlbo.url}</a><#else><button type="button" onclick="clawer('${xwlbo.date}','${xwlbo.path}',this)">抓取</button></#if></div>
               <div style="clear:both"/>
            </div>
        </#list>
        <div><a href="?page=${page + 1}">next</a><a href="?page=${page - 1}">prev</a></div>
    </div>
</body>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    function clawer(dateStr,realPath,obj){
        if(dateStr != null && realPath != null){
            var url="/xwlbo/clawer?date="+dateStr+"&path="+realPath;
            $.get(url,function(){
                $(obj).parent().html("<a href='http://localhost/xwlbo/"+dateStr+"'>http://localhost/xwlbo/"+dateStr+"</a>");
            })
        }
    }
</script>

</html>