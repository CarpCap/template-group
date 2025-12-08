package main

import (
	"fmt"
)

// 定义工资计算器接口
// 里面有计算工作这一行为
type SalaryCalculator interface {
	CalculateSalary() int
}

// 固定职工
type Permanent struct {
	empId    int
	basicpay int
	pf       int
}

// 合同员工
type Contract struct {
	empId    int
	basicpay int
}

// 固定职工的工资为基本工资与基本工资之和   Permanent 实现计算工资这一行为
func (p Permanent) CalculateSalary() int {
	return p.basicpay + p.pf
}

// 合同员工的工资仅为基本工资   Contract 实现计算工资这一行为
func (c Contract) CalculateSalary() int {
	return c.basicpay
}

/*
总费用通过迭代SalaryCalculator切片并求和来计算
每个员工的工资
*/
func totalExpense(s []SalaryCalculator) {
	expense := 0
	for _, v := range s {
		expense = expense + v.CalculateSalary()
	}
	fmt.Printf("Total Expense Per Month $%d", expense)
}

func main() {
	pemp1 := Permanent{1, 5000, 20}
	pemp2 := Permanent{2, 6000, 30}
	cemp1 := Contract{3, 3000}
	employees := []SalaryCalculator{pemp1, pemp2, cemp1}
	totalExpense(employees)

}
