# -- Dockerfile --
# 这个文件负责构建包含你的程序的 Docker 容器

# 使用 Java 12
FROM openjdk:12-alpine

WORKDIR /app/
# 向容器内复制文件
COPY ./* /app/
# 编译程序
RUN javac -d ./output ./src/Compiler.java
# 将当前目录设为 /app/output
WORKDIR /app/output