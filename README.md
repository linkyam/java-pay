## Pay API SDK for Java

## 代码目录介绍
* main
  * java
    * com.api
      * api
      * config
      * constants
      * dto
      * enums
      * exception
      * strategy
      * utils
        * MerchantApplication.java
        > srping boot starter
  * resources
      * application.properties
    > API 配置信息，包括商户号、商户密钥、API地址等
    > e.g. API configuration information, including Merchant Number, Merchant Key, API Address, etc.
    
* test
  * java
    * com.api
      * api
        * CommonApiTest
        > 通用API(查询订单、查询余额)案例测试类
        > e.g. CommonApiTest is common API(Query Order、Query Balance) Demo test class
        * [Currency]ApiTest
        > 例如: BRLApiTest 代表巴西API案例测试类
        > e.g. BRLApiTest is Brazil API Demo test class
