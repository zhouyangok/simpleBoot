###秒杀系统简介
 - 1 . 该系统为springboot+springSecurity+mybatis+redis+rabbitmq实现的简易秒杀系统,主要包含用户登录，权限管理和用户秒杀下单管理优化。
 - 2 . 用户登录后将用户信息存入redis中，key为jwt生成的用户token，用于后续操作时从redis中取出用户信息。
 - 3 . 用户日志采用springaop实现，主要针对用户登录和增删改操作的记录，实际项目中，用户登录日志和操作日志应该分开。
 - 4 . mybatis数据交互全部采用注解方式实现，实际使用可以注解和xml同时使用，增加系统的灵活性。