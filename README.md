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
- 由于jcef资源包较大，所以并未上传到git。
- 因此，构建前请先直接运行代码，用以预载jcef相关资源。否则，用户第一次打开会巨慢，也有可能会因为网络原因无法下载jcef相关资源导致无法打开，所以建议先运行，能成功跑起来了之后再打包。
```bash
# 构建当前平台
mvn clean package
# 构建指定平台
mvn clean package -P mac-aarch64
mvn clean package -P win-amd64
```
构建完成后，执行startup脚本即可运行，将target目录下的 hellow-umiusi.jar 、 .hello-umiusi、 startup.windows.bat、README.md 打包即可发布


## 注意事项
```src/main/public/config.json```是配置文件，里面存放了客户端repo的地址，可以修改。该文件会原样打包至.hello-umiusi文件夹下，所以打包后也可以修改。