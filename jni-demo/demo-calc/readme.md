
# JNI

编译 .c
```
javac -encoding UTF-8 -h . Calc.java 
```


编译 .dll
```
gcc  -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o  Calc.dll Calc.cpp
```



运行
```
java -Djava.library.path=. Calc
```
