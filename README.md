# QQ农场游戏开发



## 1、静态页面开发

![](G:/Typora temp/微信图片_20200628175421.png)



## 2、编写游戏的核心代码

游戏的核心就是**土地变化的状态**：暂时先手动控制状态

![img](G:/Typora temp/F{ETC(7A}J)CVE7EYDVR4.png)



## 3、游戏的状态控制

```
function changePic(id){
		document.getElementById(id).src='imged.png';
		grow(id);
}

//timer表示一块地的生长时间
var timer=20;

function grow(id){
			timer--;
			console.log("timer:"+timer);
            if(timer==10){
            	document.getElementById(id).src='imgd.png';	
            }
            if(timer==0){
            	document.getElementById(id).src='img/flower.gif';
            	return;
            }
            setTimeout("grow("+id+")",1000);
}
```



## 4、设计每一块土地的状态

![](G:/Typora temp/MASVLOKIDFWSQUC~`7X7YEO.png)

```
var allLand=new Array(20);
	for(var i=0;i<allLand.length;i++){
		allLand[i]=new Array(3);
		allLand[i][0]=1; //土地的当前状态
		allLand[i][1]=0; //表示这块土地的生长周期，从发芽到成熟
	}
```

