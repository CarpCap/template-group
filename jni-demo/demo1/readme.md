# JNI

编译 .c
```
javac -encoding UTF-8 -h . HelloJNI.java
```


## win 

编译 .dll
```
gcc -m64 -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o hello.dll HelloJNI.c
```


## linux 
or  编译 .so
```
g++ -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -fPIC -shared -o hello.so HelloJNI.c
```


## 运行

```
java  HelloJNI
```
