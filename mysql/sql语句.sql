-- 查询表中的所有数据
SELECT * FROM emp;

--  向emp表中添加数据
INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(1,'tom','m','2017-12-16',8888,'2017-12-18','good');

INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(1,'jerry','m','2017-12-16',8888,'2017-12-18','good');

-- 将所有员工薪水修改为5000
UPDATE emp SET salary =5000;
-- 将tom的工资修改为3000
UPDATE emp SET salary =3000 WHERE NAME ='tom';
-- 将姓名为’jerry’的员工薪水修改为4000元,性别改为fe。
UPDATE emp SET salary=4000,gender='female' WHERE NAME='jerry';

-- 删除表中名称为zhangsan的记录
DELETE FROM emp WHERE NAME = 'zhangsan';
-- 删除表中所有记录，数据还可以召回。
DELETE FROM emp;
-- 使用truncate 删除表，并创建一个新表。速度比delete还快。
SELECT * FROM emp;

-- 查询列
SELECT gender,NAME FROM emp;

-- 创建一个stu表
CREATE TABLE stu(
	sid CHAR(6),
	snmae VARCHAR(50),
	age INT,
	gender VARCHAR(50)
);
-- 添加信息
CREATE TABLE stu (
	sid	CHAR(6),
	sname		VARCHAR(50),
	age		INT,
	gender	VARCHAR(50)
);

INSERT INTO stu VALUES('S_1001', 'liuYi', 35, 'male');
INSERT INTO stu VALUES('S_1002', 'chenEr', 15, 'female');
INSERT INTO stu VALUES('S_1003', 'zhangSan', 95, 'male');
INSERT INTO stu VALUES('S_1004', 'liSi', 65, 'female');
INSERT INTO stu VALUES('S_1005', 'wangWu', 55, 'male');
INSERT INTO stu VALUES('S_1006', 'zhaoLiu', 75, 'female');
INSERT INTO stu VALUES('S_1007', 'sunQi', 25, 'male');
INSERT INTO stu VALUES('S_1008', 'zhouBa', 45, 'female');
INSERT INTO stu VALUES('S_1009', 'wuJiu', 85, 'male');
INSERT INTO stu VALUES('S_1010', 'zhengShi', 5, 'female');
INSERT INTO stu VALUES('S_1011', 'xxx', NULL, NULL);

SELECT * FROM stu;
--  DQL练习
-- 查询所有列
SELECT * FROM stu;

-- 1.2　查询指定列
SELECT sid,sname,age FROM stu;

-- 条件查询
-- 2.2　查询性别为女，并且年龄大于等于50的记录
SELECT *FROM stu WHERE gender='female' AND age>=50;

-- 2.3　查询学号为S_1001，或者姓名为liSi的记录
SELECT *FROM stu WHERE sid='S_1001' OR sname='liSi'

-- 2.4　查询学号为S_1001，S_1002，S_1003的记录
SELECT *FROM stu WHERE sid='S_1001'OR sid='S_1002'OR  sid='S_1003';
SELECT * FROM stu WHERE sid IN('S_1001','S_1002','S_1003');

-- 2.5　查询学号不是S_1001，S_1002，S_1003的记录
SELECT * FROM stu WHERE sid NOT IN('S_1001','S_1002','S_1003');

-- 2.6　查询年龄为null的记录
SELECT * FROM stu WHERE age IS NULL;
SELECT * FROM stu WHERE age IS NOT NULL;

-- 2.7　查询年龄在20到40之间的学生记录
SELECT * FROM stu WHERE age BETWEEN 20 AND 40;
SELECT * FROM stu WHERE age>=20 AND age<=40;

-- 2.8　查询性别非男的学生记录
SELECT * FROM stu WHERE gender='female';
SELECT * FROM stu WHERE gender!='male';
SELECT * FROM stu WHERE gender<>'male';

-- 2.9　查询姓名不为null的学生记录
SELECT *FROM stu WHERE	sname IS NOT NULL;

-- 模糊查询
-- 3.1　查询姓名由5个字母构成的学生记录
SELECT *FROM stu WHERE sname LIKE '_____';

-- 3.2　查询姓名由5个字母构成，并且第5个字母为“i”的学生记录
SELECT * FROM stu WHERE sname LIKE '____i';	

-- 3.3　查询姓名以“z”开头的学生记录
SELECT * FROM stu WHERE sname LIKE 'z%';

-- 3.4　查询姓名中第2个字母为“i”的学生记录
SELECT * FROM stu WHERE sname LIKE '_i%';

-- 3.5　查询姓名中包含“a”字母的学生记录
SELECT *FROM stu WHERE sname LIKE '%a%';

SELECT * FROM emp;

-- 4.1
-- 删除重复记录 distinct 
SELECT DISTINCT comm FROM emp;.

-- 4.2　查看雇员的月薪与佣金之和	数据为Null时，相加结果会为null
-- 这时候就要用个过滤函数  ifnull(原列名，0)   
SELECT sal +IFNULL(comm,0)FROM emp;

-- 给列起别名
SELECT sal +IFNULL(comm,0) AS total FROM emp;
SELECT sname AS 姓名,gender AS 性别 FROM stu;

-- 排序查询
-- 5.1　查询所有学生记录，按年龄升序排序
SELECT * FROM stu ORDER BY age ASC;
SELECT * FROM stu ORDER BY age ;

-- 5.2　查询所有学生记录，按年龄降序排序
SELECT * FROM stu ORDER BY age DESC;

-- 5.3　查询所有雇员，按月薪降序排序，如果月薪相同时，按编号升序排序
-- 如果有列排序结果中有相同，则用多列排序，对第二列进行排序
SELECT * FROM emp ORDER BY sal DESC,empno ASC;

-- 6　聚合函数  sum avg max min count
-- 查询指定列不为null的记录函数
SELECT * FROM emp;
SELECT COUNT(*) FROM stu;

-- 查询emp表中有佣金的人数：
SELECT COUNT(comm) FROM emp;

-- 查询emp表中月薪大于2500的人数：
SELECT COUNT(sal) FROM emp WHERE sal>2500 ;

-- 统计月薪与佣金之和大于2500元的人数：
SELECT COUNT(*) FROM emp WHERE (sal +IFNULL(comm,0)) >2500;

-- 查询有佣金的人数，有领导的人数：
SELECT COUNT(comm),COUNT(mgr) FROM emp;

-- 查询有佣金的人数，以及有领导的人数：
SELECT COUNT(*) FROM emp WHERE comm IS NOT NULL AND  mgr IS NOT NULL;

-- 查询所有雇员月薪和：
SELECT SUM(sal) AS 月薪和 FROM emp;

-- 查询所有雇员月薪和，以及所有雇员佣金和：
SELECT SUM(sal),SUM(comm) FROM emp;

-- 查询所有雇员月薪+佣金和：
SELECT SUM(sal +IFNULL(comm,0)) AS 月薪和和佣金和 FROM emp;
SELECT SUM(sal)+SUM(comm) FROM emp;

-- 统计所有员工平均工资：
SELECT AVG(sal) FROM emp;

-- 查询最高工资和最低工资：
SELECT MAX(sal),MIN(sal) FROM emp;

-- where 和order by的影响	order by 放最后

SELECT COUNT(*) FROM stu WHERE gender='male' OR gender='female';

SELECT * FROM stu WHERE gender IS NOT NULL GROUP BY gender;


-- 查询各部门的人数
SELECT deptno,COUNT(*) FROM emp GROUP BY deptno;

-- 查询每个部门的部门编号和每个部门的工资和：
SELECT deptno,SUM(sal) FROM emp GROUP BY deptno;

-- 查询每个部门的部门编号以及每个部门的人数：
SELECT deptno,COUNT(*) FROM emp GROUP BY deptno;

-- 查询每个部门的部门编号以及每个部门工资大于1500的人数
SELECT * FROM emp WHERE sal>1500;
SELECT deptno,COUNT(*) FROM emp WHERE sal>1500 GROUP BY deptno ;

-- 查询工资总和大于9000的部门编号以及工资和：
SELECT deptno,SUM(sal) FROM emp  GROUP BY deptno  HAVING SUM(sal)>9000; 
--  正确使用顺序
SELECT deptno,SUM(sal) FROM emp GROUP BY deptno HAVING SUM(sal)>9000 ORDER BY SUM(sal);

-- 查询工资大于1500的,工资总和大于6000的部门编号以及工资和：
SELECT deptno,SUM(sal) FROM emp WHERE sal>1500 GROUP BY deptno HAVING SUM(sal)>6000 ORDER BY SUM(sal);


SELECT * FROM emp;
-- limit
SELECT * FROM emp LIMIT 3,3; -- 0是第一行，第一个参数：从第几行查询，第二个参数：查几行  

-- 8.1　查询5行记录，起始行从0开始
SELECT * FROM emp LIMIT 0,5;

-- java编程中用下列写
INT currentPage = 3;-- 当前页
INT pageSize = 3; -- 每页显示的条数
SELECT * FROM emp LIMIT （currentPage-1）*pageSize,pageSize;   




