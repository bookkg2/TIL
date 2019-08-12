## HADOOP

- NAMENODE - 요청이 들어가면 파일에 속한 모든 블록이 어느 데이터노드에 있는지 파악하고  있고 파일시스템의 네임스페이스를 관리한다.
- SECONDARY NAMENODE - NAMENODE가 문제가 생겼다 다시 RECOVERY 되면 바로 백업을 해줄 수 있는 준비 상태 (하둡1.2.1에서)
- DATANODE - 실질적으로 데이터가 담기는 곳

> 하나의 NAMENODE는 여러개의 DATANODE를 가지고 있다. 
>
> 1. 저장되는 파일은 특정 사이즈의 블록으로 나눠져 분산된 서버에 저장됨
> 2. 하나의 블록은 3개로 복제되며, 각각 다른 HDFS의 노드에 분산 저장됨
> 3. HDFS에는 마스터 역할을 하는 네임노드 서버 한 대와, 슬레이브 역할을 하는 



##### 복제 하는법(SSH) 

1. 일단 4개의 server를 세팅해 놓는다. (hostname, ipaddress  등)
2.  각각의 서버에 SSH 활성화  (private key 와 public key) 

```
ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa
```

> cd .ssh 들어가서 ls로 두개의 키를 확인 

```
cat id_dsa .pub >> authorized_keys     -> public key를 authorized로 변경
```

​	3. 하나의 서버에서 다른 서버로 자유롭게 들어갈 수 있도록 세팅

```
scp authorized_keys root@hadoop2:~/.ssh/authorized_keys  ->즉 authorized_key 를 복제해서 다른서버(hadoop2)로 세팅
```

>  이렇게 되면 다른 서버에도 authorized_keys 가 설정이 된다. 

> server1 즉 hadoop1 에서는 자신의 public 키를 복제해서 다른 서버로 뿌려줬으니 접근을 할 때는 비밀번호를 물어보지 않고 접근가능하게 되었다. (ssh root@hadoop2 ls ~/.ssh 로 확인 해볼것 )



​    4. /etc/hadoop1.2.1/conf 에 vi masters에 secondarynamenode(hadoop2) 을 설정

​		/etc/hadoop1.2.1/conf에 vi slaves에 나머지 datanode 설정 (hadoop2, hadoop3,               		hadoop4)

    ##### 완전 분산 모드 설치

정리 할것 !!!