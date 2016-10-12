<?php 
$connect=mysql_connect("127.0.0.1","root","1234"); 
if(!$connect) echo "Mysql Connect Error!"; 
else echo "Mysql connect sucsessfull!!"; 
mysql_close(); 
?> 