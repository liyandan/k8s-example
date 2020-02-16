# k8s-example

通过 spring-boot + k8s 实现微服务.

## 环境说明

* mac-10.15.3
* spring-boot-2.1.12.RELEASE
* jdk_1.8.0_191
* docker-desktop-for-mac-2.2.0.0
* docker-19.03.5
* kubernetes-1.15.5
* ingress-nginx-0.28.0

## 部署

所有部署文件在目录 `k8s` 里面. 两个环境, `test` 和 `prod`. 以下命令以 `prod` 环境说明. 

1. `% kubectl apply -f k8s/prod/namespace.yaml`
1. `% kubectl apply -f k8s/prod`

## 验证

1. 配置 hosts. `% sudo vim /etc/hosts`

    ```bash
    127.0.0.1       api.example.com
    ```

1. GET `http://api.example.com/consumer/1`, 返回如下内容即可. 

    ```json
    {
        "code": 200,
        "msg": "请求成功",
        "data": {
            "id": 1,
            "providerName": "provider"
        }
    }
    ```
