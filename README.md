## 写在前面
 - 本系统为我的javaEE课程结课实验。写本系统之前，我已经有了一点用SSM框架写项目的经验但，一直都是在自己写一些小demo，大的项目没写。因此对于本次实验，我是以一种实战的态度去开发的，目标是达到能上线运行的。在写项目时，也发现了自己的不足，最大的一点就是前端页面的样式编写能力，可以说是硬伤。本来想着去自己使用bootstarp或者element-Ui去写，发现写出的页面不忍直视，一点都不美观。因此只能找一些开源样式进行修改。在写本项目项目之前，以往写的的项目并没有使用vue，而是使用jq进行dom操作，工作量巨大，在写本项目时，一并学习并应用了vue，发现真的是太方便了，进行数据渲染轻而易举，当然部分页面也有用jq编写的，比如管理员注册，是复用之前写的代码。
 - 使用spring boot完整开发也是第一次，之前的项目是使用传统的SSM框架，编写大量xml代码，编写运行环境就很麻烦，SSM转spring boot，可以说毫无压力，因为基础知识也就是spring那一套。数据库使用Mybatis，没有使hibernate。两者优劣势我不进行讨论，唯一重要的是，互联网企业都是使用Mybatis。Redis也是第一次使用，Nosql的使用，缓存的合理利用是及其复杂的，springboot虽然简化了缓存的操作，但是实际的应用，环境的搭建也是及其麻烦的。

## 感谢
感谢开源的框架！！

## 应用的技术
 - 本系统后端采用[spring boot](https://spring.io/projects/spring-boot)搭建及开发，spring boot包含spring，spring
   mvc框架，使用[mybatis](http://www.mybatis.org/mybatis-3/zh/index.html)做持久层框架。
 - 数据库使用[mysql](https://www.mysql.com/cn/)与[redis](https://redis.io/)(缓存，没有正式实现)。
 - 前端使用[Bootstarp](https://getbootstrap.com/)，[JQuery](https://jquery.com/)，[Vue](https://cn.vuejs.org/index.html)及其第三方库，使用axios框架获取后端数据，页面样式使用Github上的开源样式。
 - 搭建本系统用到的思想有：前后端分离，微服务架构，restful api架构。
 - 使用软件VS code（前端编写），IDEA（后端编写）。
 - 在线服务器为阿里云服务器。
 - 在线演示链接:[http://www.musuixin.top:8080/onlineLearning/](http://www.musuixin.top:8080/onlineLearning/)
 

## 使用说明

 - [ ] **学生与教师不提供对外注册接口，管理员可以注册，需要邀请码，想要注册的联系我Q：1804125652**
 - [ ] **提供一个学生ID：1059 密码：123456**
 - [ ] **提供一个教师ID：100018 密码：654321**
## 界面截图
![1.PNG](https://github.com/musuixin/Online-Learning/blob/master/%E6%88%AA%E5%9B%BE/1.PNG)


