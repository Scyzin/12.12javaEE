CREATE	DATABASE mydb2;
USE mydb2;
SELECT DATABASE();
-- 创建主键的三种方式  主键约束
CREATE TABLE student(
	id INT PRIMARY KEY,
	NAME VARCHAR(50)
);

CREATE TABLE student(
	id INT,
	NAME VARCHAR(50),
	PRIMARY KEY(id)
);

CREATE TABLE student(
	id INT ,
	NAME VARCHAR(50)
);
-- constraint 添加个约束名称
ALTER TABLE student ADD CONSTRAINT pk stu -id PRIMARY KEY (id);

-- 唯一约束
CREATE TABLE student(
	id INT PRIMARY KEY,
	NAME VARCHAR(50) UNIQUE
);

-- 自动增长列	
-- 给主键添加自动增长的数值，列只能是整数类型 
-- 某一列被删除，自动增长的还会继续之前的。
CREATE TABLE student(
	Id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(50)
);

-- 域完整性  数据类型  非空约束 not null 默认值约束default
CREATE TABLE student(
	Id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(50) NOT NULL,
	sex VARCHAR(50) DEFAULT '男'
);
INSERT INTO student VALUES(15,'你好',DEFAULT);
INSERT INTO student VALUES(5,'不好','女');
INSERT INTO student(NAME) VALUES('你好');-- 自动增长列，所以id和默认值都可以不用添加。

-- 参照完整性
-- 外键约束：FOREIGN KEY ，前提又要主键

-- 学生表
CREATE TABLE student(
	stuid VARCHAR(10)PRIMARY KEY,
	stuname VARCHAR(50)
);
ALTER TABLE  student ADD sex VARCHAR(50) DEFAULT '男';

-- 分数表
CREATE TABLE score(
	stuid VARCHAR(10),
	score INT,
	courseid INT,
	-- constraint stu_score foreign key (stuid) REFERENCES student(stuid)
);

-- 或者在外面添加外部约束
ALTER TABLE score ADD CONSTRAINT stu_score FOREIGN KEY (stuid) REFERENCES student(stuid);

SELECT * FROM student;
INSERT INTO student VALUES('1001','张三峰',DEFAULT);
INSERT INTO student VALUES('1002','张无忌',DEFAULT);
INSERT INTO student VALUES('1003','王尼玛',DEFAULT);
INSERT INTO student VALUES('1004','王老五',DEFAULT);


INSERT INTO score VALUES('1001',98,1);
INSERT INTO score VALUES('1002',95,1);
INSERT INTO score VALUES('1002',67,2);
INSERT INTO score VALUES('1003',83,2);
INSERT INTO score VALUES('1003',57,3);
-- 有了参照完整性，在没有1008学号时，无法添加成绩。
INSERT INTO score VALUES('1008',57,3);

DROP TABLE student;
DROP TABLE score;

SELECT *FROM student;
SELECT * FROM score;

-- 一对多关系 上面给了(多对一)

-- 多对多关系	就是中间添加了一个表，表示表相互之间的关系
CREATE TABLE tea(
	tid INT PRIMARY KEY,
	sname VARCHAR(50)
);
CREATE TABLE stu2(
	sid INT PRIMARY KEY,
	sanme VARCHAR(50)
);

CREATE TABLE tea_stu2_rel(
	tid INT,
	sid INT
);
ALTER TABLE tea_stu2_rel ADD CONSTRAINT fk_tid FOREIGN KEY (tid) REFERENCES tea(tid);
ALTER TABLE tea_stu2_rel ADD CONSTRAINT fk_sid FOREIGN KEY (sid) REFERENCES stu2(sid);

-- 一对一关系  完全可以合并到一张表中
CREATE TABLE qq(
	qqid INT PRIMARY KEY,
	PASSWORD VARCHAR(50)
);

CREATE TABLE qqdetail(
	qqid INT PRIMARY KEY,
	NAME VARCHAR(50),
	address VARCHAR(200)
);
ALTER TABLE qqdetail ADD CONSTRAINT fk_qq_qqdetail FOREIGN KEY(qqid) REFERENCES qq(qqid);


--------------联合查询------------------
CREATE TABLE A(
	NAME VARCHAR(10),
	score INT
);

CREATE TABLE B(
	NAME VARCHAR(10),
	score INT
);

-- 批量插入
INSERT INTO A VALUES('a',10),('b',20),('c',30);aba
INSERT INTO B VALUES('a',10),('b',20),('d',40);

-- 合并结果集  去除重复记录
SELECT *FROM a 
UNION
SELECT * FROM b;

-- 不去除重复记录
SELECT *FROM a 
UNION ALL
SELECT *FROM b;

SELECT * FROM a,b ;-- 笛卡尔积灰有行*行条记录。

-- 内连接查询，也是99查询法
-- 使用主外键关系做为条件来去除无用信息
SELECT * FROM student,score WHERE student.stuid = score.stuid;
SELECT * FROM student s,score c WHERE s.stuid = c.stuid AND score >90 ;
-- 只获取连接表中的某些数据
SELECT s.stuid,s.stuname,s.sex FROM student s,score c WHERE s.stuid = c.stuid;

-- 内连接查询，跟上面一样的结果 inner可以省略
SELECT * FROM student s INNER JOIN score c ON  s.stuid=c.stuid WHERE score >90;

-- 外链接查询,左连接
SELECT s.stuid,s.stuname,c.score FROM student s LEFT OUTER JOIN score c ON s.stuid=c.stuid;
-- 上面的左外连接 = 这个的右外连接。
SELECT s.stuid,s.stuname,c.score FROM score c RIGHT OUTER JOIN student s ON s.stuid=c.stuid;

SELECT s.stuid,s.stuname,c.score FROM score c LEFT OUTER JOIN student s ON s.stuid=c.stuid;

SELECT s.stuid,s.stuname,c.score FROM student s RIGHT OUTER JOIN score c ON s.stuid=c.stuid;

1
SELECT *FROM score

-- 先连接两个表，产生的虚拟表再和第三张表连接  n表连接查询，至少有n-1个条件
SELECT * FROM student s INNER JOIN score c ON  s.stuid=c.stuid 
JOIN course cc ON c.courseid=cc.courseid;

-- 自然连接
SELECT *FROM student NATURAL JOIN score;

SELECT *FROM emp;
-- 子查询，一个查询结果作为另一个查询条件。
-- 1.	工资高于JONES的员工。
分析：
查询条件：工资>JONES工资，其中JONES工资需要一条子查询。

第一步：查询JONES的工资
SELECT *FROM emp WHERE sal >(SELECT sal FROM emp WHERE ename ='JONES');

-- 2、查询与SCOTT同一个部门的员工。
SELECT * FROM emp WHERE deptno =(SELECT deptno FROM emp WHERE ename = 'SCOTT');

-- 3、工资高于30号部门所有人的员工信息
SELECT *FROM emp WHERE sal >(SELECT MAX(sal) FROM emp WHERE deptno =30);

-- 4、查询工作和工资与MARTIN（马丁）完全相同的员工信息

SELECT *FROM emp WHERE (job,sal)=(SELECT job,sal FROM emp WHERE ename='MARTIN');

-- 5. 有2个以上直接下属的员工信息	不理解
SELECT *FROM emp WHERE empno IN(
SELECT mgr FROM emp GROUP BY mgr HAVING COUNT(mgr)>=2);

-- 6.求7369员工编号、姓名、经理编号和经理姓名  自连接

SELECT e1.empno, e1.ename,e2.mgr,e2.ename 
FROM emp e1,emp e2 
WHERE e1.mgr =e2.empno AND e1.empno =7369;

-- 7.各个部门薪水最高的员工所有信息.
SELECT *FROM emp WHERE sal IN (
SELECT MAX(sal) FROM emp GROUP BY deptno);

SELECT * FROM emp e,(SELECT MAX(sal) maxsal,deptno FROM emp
GROUP BY deptno) a
WHERE e.deptno = a.deptno
AND e.sal =a.maxsal;

-- mysql函数
SELECT ADDTIME('15:51:00','1:1:1');
SELECT CURRENT_DATE();
SELECT CURRENT_TIME();-- 显示现在的时间
SELECT CURRENT_TIMESTAMP();-- 显示现在的日期和时间

SELECT NOW();	-- 当前时间
SELECT DATE(NOW()); -- 返回当前时间的日期部分
SELECT TIME(NOW());  -- 返回当前时间的时间部分
SELECT YEAR(NOW()); 

SELECT DATE_ADD(NOW(),INTERVAL 1 DAY);  -- 按某个规则去添加时间。
SELECT DATE_SUB(NOW(),INTERVAL 1 DAY); -- 按某个规则去减去时间

SELECT CHARSET('tom'); -- 字符集
SELECT CONCAT('aaa','bbb');

SELECT INSTR ('admin','a'); -- 返回字符串在前面字符串的位置.
SELECT UCASE('adad');-- 大写
SELECT LCASE (('ADS'); -- 小写

SELECT LEFT('admin' ,2);  -- 从左起2个字符
SELECT REPLACE('adada','ad','bc'); -- 在字符串中搜索替换
SELECT STRCMP('dada','bada'); -- 比较左右两边字符串大小
SELECT SUBSTRING('dada',a,)
SELECT LTRIM('  stirs ');  -- 去掉左边空格  rtrim去掉右边空格

SELECT ABS
SELECT BIN(10);-- 转成二进制
SELECT FLOOR(12.5); -- 向下取整
SELECT FORMAT(12.56,1); -- 保留几位小数
HEX 十六进制
LEAST 最小值
MOD 求余
RAND() 随机数  一个每次产生一样的随机数，
