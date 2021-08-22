#MySQL
mysql作为关系型数据库，它的最大优势我觉得就是“开源”；在使用方面很便捷，查问题找资料都很好找；
作为开源项目，我们可以查看源码，知晓实现原理等等（难度很大）；

mysql数据库的的搜索引擎主要是两种：MyISAM(读多写少（报表系统）不支持事务) 、InnoDB（写为主(常规系统)，支持ACID事务操作）另外的搜索引擎可参考官方文档


##系统特性
1．MySQL使用 C和 C++编写，并使用了多种编译器进行测试，保证了源代码的可移植性。
2．支持 AIX、FreeBSD、HP-UX、Linux、Mac OS、NovellNetware、OpenBSD、OS/2 Wrap、Solaris、Windows等多种操作系统。
3．为多种编程语言提供了 API。这些编程语言包括 C、C++、Python、Java、Perl、PHP、Eiffel、Ruby,.NET和 Tcl 等。
4．支持多线程，充分利用 CPU 资源。
5．优化的 SQL查询算法，有效地提高查询速度
等等（摘自百度百科https://baike.baidu.com/item/mySQL/471251?fr=aladdin）