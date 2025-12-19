package main

import (
	"fmt"
	"sync"
	"time"
)

var mu1, mu2 sync.Mutex

func main() {
	go func() {
		mu1.Lock()
		mu2.Lock()
		fmt.Println("go1结束")
	}()

	go func() {
		mu2.Lock()
		mu1.Lock()
		fmt.Println("go2结束")
	}()

	go func() {
		for {
			time.Sleep(1 * time.Second)
			fmt.Println("永远运行")
		} // 第三个 goroutine 永远运行
	}()

	select {}
}
