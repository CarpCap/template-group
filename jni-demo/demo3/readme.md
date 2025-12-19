
# JNI

编译 .c
```
javac -encoding UTF-8 -h . JniDemo3.java 
```


编译 .dll
```
gcc  -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o  jniDemo3.dll JniDemo3.cpp
```



运行
```
java -Djava.library.path=. HelloJNI
```
