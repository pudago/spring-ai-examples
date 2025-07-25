# Apache Doris快速入门

## 什么是Doris
Apache Doris是一个现代化的MPP分析型数据库产品。仅需亚秒级响应时间即可获得查询结果，有效地支持实时数据分析。Apache Doris的分布式架构非常简洁，易于运维，并且可以支持10PB以上的超大数据集。
Apache Doris可以满足多种数据分析需求，例如固定历史报表，实时数据分析，交互式数据分析和探索式数据分析等。令您的数据分析工作更加简单高效！

## 特性
- 现代化MPP架构
- 秒级查询返回延时
- 支持标准SQL语言，兼容MySQL协议
- 向量化查询
- 高效的聚合表技术
- 新型预聚合技术Rollup
- 高性能、高可用、高可靠
- 极简运维，弹性伸缩

## 使用 Docker 开发镜像编译
```bash
# 拉取镜像
docker pull apache/incubator-doris:build-env-for-0.15.0

# 查看是否拉取成功
docker images

# 下载源码
cd /opt
mkdir doris
cd doris
wget https://downloads.apache.org/incubator/doris/0.15.0-incubating/apache-doris-0.15.0-incubating-src.tar.gz
tar -xzvf apache-doris-0.15.0-incubating-src.tar.gz
mv apache-doris-0.15.0-incubating-src doris-0.15.0

# 运行run命令，进入Docker镜像
docker run --name apache-doris-0.15.0 -it -v /data/mvnrepo:/root/.m2 -v /opt/doris/doris-0.15.0:/opt/doris apache/incubator-doris:build-env-for-0.15.0

```