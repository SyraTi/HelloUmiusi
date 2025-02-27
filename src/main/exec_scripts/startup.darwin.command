#!/bin/bash
# 获取脚本所在的目录
SCRIPT_DIR=$(dirname "$0")

# 切换到脚本所在的目录
cd "$SCRIPT_DIR"
# 启动命令
java --add-opens java.desktop/sun.awt=ALL-UNNAMED \
          --add-opens java.desktop/sun.lwawt=ALL-UNNAMED \
          --add-opens java.desktop/sun.lwawt.macosx=ALL-UNNAMED \
          -jar ./hello-umiusi.jar