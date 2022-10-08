* 使用步骤：
  * pom.xml 中配置 mybatis-generator-maven-plugin 插件
  * 配置 generatorConfig.xml 配置文件
  * 点击 maven mybatis-generator-maven-plugin 插件自动生成数据访问层
* 使用mybatis逆向工程创建数据访问层
  * generatorConfig.xml 即为逆向工程插件的配置文件
    * 配置数据库的参数
    * 配置生成实体类，mapper接口，mapper映射文件的位置
    * 库中需要自动生成的表，以及生成的对应实体类的类名
  * 使用注意：非第一次生成的java文件会被覆盖，非第一次生成的映射文件会被追加
  * 实体包中Example文件是查询使用的参数类
