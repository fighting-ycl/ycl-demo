#! /bin/bash
cd `dirname $0`
CDIR=`pwd`
git pull
version=`date +%Y%m%d%H%M%S`
sudo mvn clean install -Dmaven.test.skip=true
echo "Image Building..."
sudo docker build -t registry.cn-beijing.aliyuncs.com/personal/ycl/spring-boot-demo:latest .
sudo docker push registry.cn-beijing.aliyuncs.com/personal/ycl/spring-boot-demo:latest