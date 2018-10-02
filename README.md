# PTClient

一个包括聚合搜索、账号信息登录统计的小工具。

主要功能包括：
- 账号登录、同步数据、历史记录、图表
- 聚合搜索功能
- 软件开启后，会在本地8888端口开启一个RSS服务。聚合搜索的结果中可以直接右键添加到本地的RSS服务，配合transmission-rss、flexget、utorrent等工具订阅可以直接推送到群晖或者家庭服务器等等。
- 本软件使用JavaFX开发所以提供全平台支持。
- 支持代理，对于那些只使用ipv6的站点提供代理功能。

![avatar](https://raw.githubusercontent.com/Imgaojp/PTClient/master/img/info.png)

![avatar](https://raw.githubusercontent.com/Imgaojp/PTClient/master/img/search.png)

待完善功能：
- 设置界面
- 每天定时更新功能
- 帮助文档加入
- 浏览器功能加入
- 讨论区
- 更多站点的支持
- 聚合RSS功能

由于我目前只有几个站，不可能所有的站都支持，如果需要添加新的站可以把首页、搜索页、控制页面等源码下载后发送给我。

为了实现动态增加新的站点的支持而不用每次添加新的站点都需要下载新的安装包，所以使用了类似于热更新的方式，软件每次启动都会从CDN上下载几个关键的类。这个CDN目前每个月有免费的10G流量，当然目前是肯定不会超支。

**如果这款软件对你有帮助请我喝杯咖啡吧，我会非常感谢的！**

<img src="https://raw.githubusercontent.com/Imgaojp/PTClient/master/img/wechatQR.png"  height="400" alt="图片描述文字"/>
<img src="https://raw.githubusercontent.com/Imgaojp/PTClient/master/img/alipayQR.jpg" height="400" alt="图片描述文字"/>

