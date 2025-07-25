
## 错误
### 请求
```bash
curl -L -X POST -H "Content-type: application/json" \
    http://localhost:8080/imagegen 
    -d '{"prompt": "画一幅孙悟空牵手哆啦A梦"}'
```

### 错误信息
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Error>
  <Code>MethodNotAllowed</Code>
  <Message>The specified method is not allowed against this resource.</Message>
  <RequestId>68833E4FFCBC723136EB8D86</RequestId>
  <HostId>aigc-files.bigmodel.cn</HostId>
  <Method>POST</Method>
  <ResourceType>Object</ResourceType>
  <EC>0017-00000001</EC>
  <RecommendDoc>https://api.aliyun.com/troubleshoot?q=0017-00000001</RecommendDoc>
</Error>
```

### 参考阿里云OSS解释, [0017-00000001](https://api.aliyun.com/troubleshoot?q=0017-00000001)

原因及解决方法：
- 原因: Controller中POST请求结束后重定向到阿里云的OSS的图片地址，这是一个GET请求
- 解决：curl不指定-X 选项，使用-L，让它自己跟随请求类型自动选择
```bash
curl -L -H "Content-type: application/json" \
    http://localhost:8080/imagegen 
    -d '{"prompt": "画一幅孙悟空牵手哆啦A梦"}'
```