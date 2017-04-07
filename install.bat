cd biwan-parent
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-support 
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-config
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-model
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-dao
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-service
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-business
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-biz
call mvn clean install -Dmaven.test.skip=true -e

cd ../biwan-facade
call mvn clean install -Dmaven.test.skip=true -e

echo "mvn打包代码完毕 ..........."

pause