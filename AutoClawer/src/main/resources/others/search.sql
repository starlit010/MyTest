SELECT @a:=@a+1 as num,english.*  FROM english,(select @a:=0) as b where lvl = 1 order by chinese ,id;


select @a:=@a+1 as num,english.* from english,(select @a:=0) as b where english.property like 'vt%' or english.property like 'vi%' order by property,id asc;