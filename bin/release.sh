#!/bin/bash

# 获取当前版本号
current_version=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

# 移除 SNAPSHOT 后缀
new_version=$(echo $current_version | sed 's/-SNAPSHOT$//')

# 递增版本号（此处简单加 1，你可以根据实际需求调整递增方式）
IFS='.' read -r -a version_parts <<< "$new_version"
patch_version=${version_parts[2]}
new_patch_version=$((patch_version + 1))

new_version="${version_parts[0]}.${version_parts[1]}.$new_patch_version"


# 更新 pom.xml 中的版本号
mvn versions:set -DnewVersion=$new_version

# 提交版本更新
git add .
git commit -am "Update version to $new_version"
git push

# 创建 Git 标签
git tag v$new_version
git push origin v$new_version

