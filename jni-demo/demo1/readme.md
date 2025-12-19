# JNI

编译 .c
```
javac -encoding UTF-8 -h . HelloJNI.java
```


编译 .dll
```
gcc -m64 -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o hello.dll HelloJNI.c
```



运行
```
java -Djava.library.path=. HelloJNI
```
