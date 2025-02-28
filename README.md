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
mvn clean package
```