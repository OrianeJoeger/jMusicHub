#!/bin/bash

javac \
    -sourcepath src/                        \
    -cp bin/ src/musichub/main/Main.java    \
    -d bin/

javadoc \
    -sourcepath src/                                        \
    -cp src/musichub/main       src/musichub/main/*         \
    -cp src/musichub/util       src/musichub/util/*         \
    -cp src/musichub/business   src/musichub/business/*     \
    -d doc/