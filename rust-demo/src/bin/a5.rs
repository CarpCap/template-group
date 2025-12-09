fn main() {
    // 字符串类型
    let spaces = "   ";
    // usize数值类型
    let _spaces = spaces.len();


    // 使用mut 会报错  Rust 对类型的要求很严格，不允许将整数类型 usize 赋值给字符串类型
    // let mut spaces = "   ";
    // spaces = spaces.len();
}
