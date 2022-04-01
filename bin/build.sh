#!/bin/sh

ENV=$1
if [ ! -n "$ENV" ] ;then
    echo "Must specify an environment: [test, prod]!"
    exit
fi
echo "Environment：$ENV"

cd ../ && mvn clean install -P$ENV -Dmaven.test.skip=true

cd dc-secure-client/target

mkdir dc-secure-client-build

cp dc-secure-client.jar dc-secure-client-build/

cp ../../bin/deploy.sh dc-secure-client-build/

mkdir dc-secure-client-build/awslogs

cp ../../bin/awscli.conf dc-secure-client-build/awslogs/

sed -e "s/{env}/$1/g" -e "s/{project_name}/dc-secure-client/g" ../../bin/awslogs.conf > dc-secure-client-build/awslogs/awslogs.conf

tar zcvf root.tar.gz dc-secure-client-build

cd ../../

echo "package dc-secure done!"
