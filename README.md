# Hello Umiusi!
UmiusiCraft安装器

## 运行
### MacOS
```bash
MAVEN_OPTS="--add-opens java.desktop/sun.awt=ALL-UNNAMED --add-opens java.desktop/sun.lwawt=ALL-UNNAMED --add-opens java.desktop/sun.lwawt.macosx=ALL-UNNAMED" mvn exec:java
```
### Windows
```bash
mvn exec:java
```



## 构建
```bash
# 构建当前平台
mvn clean package
# 构建指定平台
mvn clean package -P darwin-aarch64
mvn clean package -P win-amd64
```
## 发布
```bash
# 该脚本会自动增加maven的patch版本号并打tag，push后会触发workflow进行github的release
./bin/release.sh
```

## 注意事项
```src/main/public/config.json```是配置文件，里面存放了客户端repo的地址，可以修改。该文件会原样打包至.hello-umiusi文件夹下，所以打包后也可以修改。