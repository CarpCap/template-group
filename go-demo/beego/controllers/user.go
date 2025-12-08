package controllers

import (
	"fmt"
	beego "github.com/beego/beego/v2/server/web"
	"time"
)

type UserDb struct {
	Id   int    `json:"id" orm:"column(id)"`
	Name string `json:"name"  orm:"column(name)"`
	Psw  string `json:"psw"  orm:"column(psw)"`
}

type UserController struct {
	beego.Controller
}

func (c *UserController) Get() {
	user := UserDb{1, "CarpCap", "123456"}
	c.Data["json"] = map[string]interface{}{
		"code": 0,
		"msg":  "",
		"data": user,
	}

	go test()
	c.ServeJSON() //对json进行序列化输出
	c.StopRun()   //终止执行逻辑

}

func test() {
	time.Sleep(20 * time.Second)

	//不一定会执行
	fmt.Println("----------------")
}
