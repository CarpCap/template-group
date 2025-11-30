import base64

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

# 运行示例
decode("Y3h4")