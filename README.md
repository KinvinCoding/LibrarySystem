# LibrarySystem  
## 1．项目描述  
图书馆管理系统作为一个线上的图书管理平台，可分别为普通用户、图书管理员和系统管理员提供与图书馆内图书相关操作的服务。  
## 2. 用户需求  
### 2.1 功能需求  
分模块阐述系统功能细节  
1．系统功能描述  
（1）普通用户功能  
登录图书馆管理系统。  
登录成功后，可以进行书籍查询。  
对查询到的书籍可以进行借阅操作。  
对已经借阅的书籍可以进行还书操作。  
可以对喜欢的书籍进行预约申请。  
可以查看已经预约的书籍的信息。  
可以退出系统登录  
（2）图书管理员功能  
登录图书馆管理系统。  
可以管理普通用户的借书申请。  
可以管理普通用户的还书操作。  
可以管理普通用户的预约书籍申请。  
（3）系统管理员功能  
用户管理：删除/添加用户。  
书籍管理：查询、添加、删除书籍以及修改书籍信息。  

### 2.2 用例模型  
概述  
根据图书馆管理系统的用户特点，主要参与者包括：普通用户、图书管理员及管理员。根据系统功能的描述，可以分离出的主要用例包括：登录，查询书籍，借阅书籍，归还书籍，预约申请，管理借阅，管理还书，管理预约，添加/删除书籍，修改书籍信息，用户管理，退出登录等。  
#### 2.2.1 用例图  
要求与功能需求一致  
![img_01](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%871.png)
#### 2.2.2用例模型说明  
详细阐述每个参与者和用例的细节  
普通用户可以登录、查询书籍，借阅书籍，归还书籍，预约申请，退出登录等。  
图书管理员可以登录、查询书籍，从事针对普通用户的书籍管理等业务。  
系统管理员可以登录，从事书籍管理、用户管理等业务。  
## 3. 数据库设计  
### 3.1 概念结构设计  
E-R图及其说明  
![img_02](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%872.png)
### 3.2 逻辑结构设计  
关系模式  
admins(id, uname, code, password)  
users(id, uname, code, password)  
sysadmin(id, uname, code, password)  
books(id,bname,sid,number,author,birth,edition)  
backs(id,brid,status)  
borrows(id,uid,bid,startTime,endTime,status)  
reserves(id,uid,bkid,startTime,endTime,status)  
sorts(id,sname)  
## 4. 类设计  
### 4.1 主要系统类、功能及分类  
要求给出基于MVC模式的划分  
#### 4.1.1模型层类  
永久层主要包括AdminMapper，BooksMapper，SysAdminMapper等接口及映射文件。  
业务层主要包括AdminService(Impl)，BooksService(Impl)，SysAdminService(Impl)等接口（实现类）。  
#### 4.1.2控制层类  
主要包括AdminController，PageController，SysAdminController，UsersController等类。这些类的职责是接受View层的请求，与模型层交互完成业务功能后，再将处理结果反馈给View层。  
#### 4.1.3视图类（JSP页）  
主要包括index.jsp，login.jsp，show.jsp，showBackBook.jsp，showReserveBook.jsp，add.jsp，addUser.jsp，showUser.jsp，update.jsp，updateUser.jsp，等。  
### 4.2 类图   
![img_03](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%873.png)
## 5. 业务流程顺序图  
提供用例模型中每个用例的顺序图  
#### 5.1.1登陆用例  
（包括普通用户、图书管理员、系统管理员的登陆用例，下图给出的是图书管理员登陆的用例，其他两个的类似。）  
![img_04](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%874.png)
#### 5.1.2查询书籍用例  
（包括普通用户、图书管理员、系统管理员的查询书籍用例，下图给出的是普通用户查询书籍的用例，其他两个的类似。）  
![img_05](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%875.png)
#### 5.1.3退出登陆用例  
（包括普通用户、图书管理员、系统管理员的退出登陆用例，下图给出的是图书管理员退出登陆的用例，其他两个的类似。)  
![img_06](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%876.png)
#### 5.1.4管理书籍用例  
（管理书籍包括对书籍的修改、增加和删除操作）  
![img_07](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%877.png)
#### 5.1.5管理用户用例  
（管理用户包括对用户的添加、修改和删除）  
![img_08](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%878.png)
#### 5.1.6管理借阅用例  
（管理借阅的操作包括“通过”和“不通过”)  
![img_09](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%879.png)
#### 5.1.7管理还书用例  
（管理还书的操作为“通过”）  
![img_10](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8710.png)
#### 5.1.8管理预定用例  
![img_11](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8711.png)
#### 5.1.9 用户借书用例  
![img_12](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8712.png)
#### 5.1.10 用户还书用例  
![img_13](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8713.png)
#### 5.1.11 用户预定用例  
![img_14](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8714.png)
## 6. 系统各模块运行界面截图  
### 6.1普通用户端功能  
#### 6.11. 登陆  
![img_15](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8715.png)
#### 6.1.2 书籍查询  
![img_16](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8716.png)
#### 6.1.3 书籍借阅  
![img_17](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8717.png)
![img_18](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8718.png)
#### 6.1.4 归还书籍  
![img_19](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8719.png)
#### 6.1.5 预定书籍  
![img_20](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8720.png)
#### 6.1.6 退出登陆  
![img_21](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8721.png)
### 6.2 图书管理员端功能  
#### 6.2.1 登陆  
![img_22](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8722.png)
#### 6.2.2 借书处理  
![img_23](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8723.png)
#### 6.2.3 还书处理  
![img_24](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8724.png)
#### 6.2.4 预定处理  
![img_25](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8725.png)
#### 6.2.5 退出登陆  
![img_26](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8726.png)
### 6.3 系统管理员端功能  
#### 6.3.1 登陆  
![img_27](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8727.png)
#### 6.3.2 书籍管理  
![img_28](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8728.png)
#### 6.3.2.1 添加书籍  
![img_29](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8729.png)
#### 6.3.2.2 修改书籍信息  
![img_30](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8730.png)
#### 6.3.2.3 删除书籍  
![img_31](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8731.png)
#### 6.3.3 用户管理
![img_32](https://github.com/KinvinCoding/LibrarySystem/blob/master/%E5%9B%BE%E7%89%8732.png)
