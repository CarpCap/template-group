package main

import (
	"github.com/gin-gonic/gin"
	"html/template"
	"net/http"
)

//http://127.0.0.1:8080/index
func main() {
	router := gin.Default()
	router.SetFuncMap(template.FuncMap{
		"safe": func(str string) template.HTML {
			return template.HTML(str)
		},
	})
	router.LoadHTMLFiles("safe_demo/index.tmpl")

	router.GET("/index", func(c *gin.Context) {
		c.HTML(http.StatusOK, "index.tmpl", "<a href='https://github.com/carpcap'>嘎嘎嘎</a>")
	})

	router.Run(":8080")
}
