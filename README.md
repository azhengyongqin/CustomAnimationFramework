# Android自定义曲线路径动画框架 #
### 最近在一个项目中需要一个像QQ打开个人爱好那样的动画效果如下图: ###
![](http://i.imgur.com/kgaMBas.gif)
### 可以看出每个小球都是以顺时针旋转出来的,说明像这样的曲线动画用Android中自带的平移动画是很难实现的。###
## 曲线动画怎么画???##
### 我们先来看看Android自带的绘制曲线的方式是怎样的: ###
### android自定义View中画图经常用到这几个什么什么To ###
## 1、moveTo ##
### moveTo 不会进行绘制，只用于移动移动画笔,也就是确定绘制的起始坐标点。结合以下方法进行使用。 ###
## 2、lineTo ##
### lineTo 用于进行直线绘制。 ###
```java
mPath.lineTo(300, 300);
canvas.drawPath(mPath, mPaint);
```
### 默认从坐标(0,0)开始绘制。如图： ###
![](http://i.imgur.com/gvmkxPt.png)
### 刚才我们不是说了moveTo是用来移动画笔的吗？ ###
```java
mPath.moveTo(100, 100);
mPath.lineTo(300, 300);
canvas.drawPath(mPath, mPaint);
```
### 把画笔移动(100,100)处开始绘制，效果如图： ###
![](http://i.imgur.com/lMHaFvD.png)
## 3、quadTo ##
### quadTo 用于绘制圆滑曲线，即贝塞尔曲线。 ###
![](http://i.imgur.com/r0ydKkx.png)
## 4、cubicTo ##
### cubicTo 同样是用来实现贝塞尔曲线的。mPath.cubicTo(x1, y1, x2, y2, x3, y3) (x1,y1) 为控制点，(x2,y2)为控制点，(x3,y3) 为结束点。那么，cubicTo 和 quadTo 有什么不一样呢？说白了，就是多了一个控制点而已。然后，我们想绘制和上一个一样的曲线，应该怎么写呢？ ###
```java
mPath.moveTo(100, 500);
mPath.cubicTo(100, 500, 300, 100, 600, 500);
```
### 看看效果： ###
![](http://i.imgur.com/bWTPsoZ.png)
### 一模一样！如果我们不加 moveTo 呢？###
### 则以(0,0)为起点，(100,500)和(300,100)为控制点绘制贝塞尔曲线： ###
![](http://i.imgur.com/azH7dUT.png)

## 受到上面的启发,我们也可以用同样的方法来实现一个曲线动画框架 ##
### 在写框架之前我们必须要先了解一样东西: ###
# 贝塞尔曲线: #
## 维基百科中这样说到: ##
### 在数学的数值分析领域中，贝塞尔曲线（英语：Bézier curve）是计算机图形学中相当重要的参数曲线。更高维度的广泛化贝塞尔曲线就称作贝塞尔曲面，其中贝塞尔三角是一种特殊的实例。 ###
### 贝塞尔曲线于1962年，由法国工程师皮埃尔·贝塞尔（Pierre Bézier）所广泛发表，他运用贝塞尔曲线来为汽车的主体进行设计。贝塞尔曲线最初由Paul de Casteljau于1959年运用de Casteljau算法开发，以稳定数值的方法求出贝塞尔曲线。 ###
## 1、线性贝塞尔曲线  ##
### 给定点P0、P1，线性贝塞尔曲线只是一条两点之间的直线。这条线由下式给出： ###
![](http://i.imgur.com/ECCWBQh.png)
![](http://i.imgur.com/pAQEgZ5.gif)
## 二次方贝塞尔曲线 ##
### 二次方贝塞尔曲线的路径由给定点P0、P1、P2的函数B（t）追踪： ###
![](http://i.imgur.com/00tb9DR.png)
![](http://i.imgur.com/2oaybnq.gif)

## 三次方贝塞尔曲线 ##
### P0、P1、P2、P3四个点在平面或在三维空间中定义了三次方贝塞尔曲线。曲线起始于P0走向P1，并从P2的方向来到P3。一般不会经过P1或P2；这两个点只是在那里提供方向资讯。P0和P1之间的间距，决定了曲线在转而趋进P2之前，走向P1方向的“长度有多长”。 ###
### 曲线的参数形式为： ###
![](http://i.imgur.com/iQb6U1P.png)
![](http://i.imgur.com/7QZZeFY.gif)
### 以上都是维基百科给出的定义,以及不同曲线的公式和效果图; 如果不清楚可以自己百度搜索或者维基百科搜索,么么哒! ###

## 那么在上代码之前先看看我们最后实现出来的效果图: ##
![](http://i.imgur.com/k4Dtv6C.gif)
## 项目整体结构: ##
![](http://i.imgur.com/YgRFcbR.png)

## 记录一下,方便以后使用,完事了额! 如果喜欢我的博客可以直接下面:##
[http://blog.csdn.net/qq_23179075](http://blog.csdn.net/qq_23179075)
# 印象丶亮仔 #
