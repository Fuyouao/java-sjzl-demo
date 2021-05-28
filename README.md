# java-sjzl-demo
> java-sjzl-demo 是一个用来深度学习并实战 spring boot 的项目。

# 开发环境
- JDK 1.8 +
- Maven 3.3 +
- IntelliJ IDEA (注意：务必使用 IDEA 开发，同时保证安装 lombok 插件)
- Mysql 5.7 + (尽量保证使用 5.7 版本以上，因为 5.7 版本加了一些新特性，同时不向下兼容。本 demo 里会尽量避免这种不兼容的地方，但还是建议尽量保证 5.7 版本以上)

# 运行方式
- 1、git clone https://github.com/277769738/java-sjzl-demo.git
- 2、使用 IDEA 打开 clone 下来的项目
- 3、在 IDEA 中 Maven Projects 的面板导入项目根目录下 的 pom.xml 文件
- 4、找到各个 Module 的 Application 类就可以运行各个 demo 了
- 5、注意：每个 demo 均有详细的 README 配套，记得先看看哦~
- 6、注意：运行各个 demo 之前，有些是需要事先初始化数据库数据的，亲们别忘记了哦~

# 各 Module 介绍
| Module 名称 | Module 介绍 |
| --- | --- |
|springboot-send-mail|基于springBoot实现邮件发送功能|
|springboot-websocket|SpringBoot整合WebSocket，实现即时通讯功能|

# 感谢
