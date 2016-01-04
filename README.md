#根据代码规范和分层架构的代码生成工具

操作步骤：

- 修改配置文件； 在codegen-impl工程下的 resources/generator.xml文件，配置 basepackage 和 数据库连接信息；
- 运行GeneratorMain入口文件
- 待补充的操作见API说明<http://wiki.thinkjoy.cn/pages/viewpage.action?pageId=7798790>



注意:
1、用户管理均在ucenter统一维护，所以业务系统是不存在用户表的。如果业务需要可以自行扩展
2、由于不存在用户表，所以生成代码的时候没有生成view下有关的文件，所以请用户参照其他页面自行配置
3、在用户管理和角色管理有角色分配和资源分配两个功能，请再resource_action中配置actionAlias:resource_assign和role_assign
4、关于权限控制简单说明:
  1>.用户由于角色一一对应.即一个用户只有一个角色
  2>.角色与资源（resource）多对多的对应
  3>一个资源有多个操作。即resource与resource_action 一对多

  例如：A用户拥有角色AA.角色AA具有用户管理这个资源中的添加、修改、删除功能
       B用户拥有角色AB.角色AB具有用户管理这个资源中的添加、修改、删除、分配角色功能

  5、代码第一次生成以后，大家用gbdai账号登陆，密码联系管理员获取。此时gbdai还没有业务系统的任何权限。所以大家手动role、user_role
       、role_resource添加相关数据
  6、用户管理需要再zk中配置uwwUrl。节点为/configs/{product}/bizsystem}/common/uwwUrl.具体的值为：

        dev：http://uww-dev.thinkjoy.com.cn/v2/ucm
        pro：http://uww-pro.thinkjoy.com.cn/v2/ucm
        test：http://uww-test.thinkjoy.com.cn/v2/ucm
  7、初次需要基础表。建表语句见：http://wiki.thinkjoy.cn/pages/viewpage.action?pageId=17389476



