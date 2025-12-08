import base64
import sys


def encode(str):
    # 需要先将字符串转换为字节
    encoded_bytes = base64.b64encode(str.encode('utf-8'))
    encoded_string = encoded_bytes.decode('utf-8')
    print(f"Base64编码: {encoded_string}")
    return encoded_string  # 建议返回编码结果

def decode(str):
    decoded_bytes = base64.b64decode(str)
    decoded_string = decoded_bytes.decode('utf-8')
    print(f"Base64解码: {decoded_string}")
    return decoded_string  # 建议返回解码结果


if __name__ == "__main__":
    # 没有参数时提示
    if len(sys.argv) < 2:
        print("用法：python base64_utils.py <字符串> [encode|decode]")
        sys.exit(1)

    text = sys.argv[1]                  # 第1个参数：要处理的文本
    action = "decode"                   # 默认操作
    if len(sys.argv) >= 3:
        action = sys.argv[2]            # 第2个参数可指定 encode/decode

    if action == "encode":
        encode(text)
    else:
        decode(text)