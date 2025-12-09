package main

import (
	"fmt"
	"time"
)

func main() {

	//携程
	go assistant()

	//main 线程运行
	time.Sleep(time.Second * 6) //开会

	fmt.Println("工作完成了")
}

// 安排助手看邮件
func assistant() {
	time.Sleep(time.Second * 2)
	fmt.Println("助手 工作完成了")
}
