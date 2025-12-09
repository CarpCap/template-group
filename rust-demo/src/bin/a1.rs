
// const常量定义
const _MAX_POINTS: u32 = 100_000;

fn main(){
       // let mut x = 5;   mut 表示可变的意思 可以解决这个问题
    let mut x = 5;
    println!("The value of x is: {}", x);

    //具体的错误原因是 cannot assign twice to immutable variable x（无法对不可变的变量进行重复赋值），因为我们想为不可变的 x 变量再次赋值。
    x = 6;
    println!("The value of x is: {}", x);


}