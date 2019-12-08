### 리눅스(4)

- 사용자 관리와 파일 속성
  - 사용자 이름 :암호:사용자ID:사용자가 소속된 그룹 ID:전체 이름:홈 디렉터리:기본 셀
  - 그룹 이름:비밀번호:그룹 ID:그룹에 속한 사용자 이름

- 사용자 생성

```
useradd 사용자 이름 
useradd -u 1111 newuser : newuser 사용자를 생성하면서 사용자 ID를 1111로 지정
useradd -g mygroup newuser : newuser 사용자를 생성하면서 mygroup 그룹에 newuser 사용자를 포함시킴(mygroup를 먼저 만들어 놓아야 함)
useradd -d /newhome newuser :newuser 사용자를 생성하면서 홈 디렉터리를 /newhome으로 지정
useradd -s /bin/csh newuser : newuser 사용자를 생성하면서 기본 셀을 /bin/csh로 지정
```

> 사용자 등록 확인은 tail /etc/passwd로 확인  , 암호화 확인은 tail /etc/shadow

- 비밀번호 생성

```
passwd 사용자 이름
```

> 사용자 추가를 하고 반드시 비밀번호를 등록해줘야 완전히 등록된다.

- 사용자 속성을 변경 

```
usermod 옵션

예) usermod -g root newuser : newuser 사용자의 그룹을 root 그룹으로 변경
```

- 사용자를 삭제한다.

```
userdel 유저이름 (디렉토리는 남아 있음) , userdel -r 유저이름 (디렉토리 까지 삭제 (복구 X))
```

-  사용자의 암호를 주기적으로 변경하도록 설정한다. 

```
change -1 newuser : 사용자에 설정된 사항을 확인
change -m 2 newuser : newuser 사용자에  설정한 암호를 사용해야 하는 최소 일자(즉, 변경 후 최소 2일은 사용해야 함 )
change -M 30 newuser : newuser 사용자에 설정한 암호를 사용할 수 있는 최대 일자(즉,변경 후 최대 30일까지 사용할 수 있음)
change -E 2019/12/12 newuser : newuser 사용자에 설정한 암호가 만료되는 날짜 (즉,2019/12/12까지만 사용할 수 있음)
change -W 10 newuser : newuser 사용자에 설정한 암호가 만료되기 전에 경고하는 기간, 지정하지 않았을 경우 기본 값은 7일 (즉, 암호가 만료되기 10일 전부터 경고 메시지가 나감)

```

- 그룹을 생성한다.

```
groupadd 그룹이름
groupadd -g 2222 newgroup (newgroup 그룹을 생성하면서 그룹 ID를 2222로 지정)
```

> skel 파일은 생성 될  때 자동으로 계정에 복사된다. 즉 어떤 디렉토리를 생성할 때 자동적으로 생성되는 기능 들로 만약 어떤한 조건을 주고 싶을 때는 skel에 있는 .bashrc들어가서 설정 
>
> 예) alias al='clear' , 적용은 . . bashrc (단 하기 전에 alias를 검색해서 없는 키로만!!!)
>
> -> 디렉토리 생성시 마다 al을 누르면 clear 된다.

 

- 그룹의 속성을 변경한다.

```
groupmod -n newgroup mygroup : newgroup 그룹의 이름을 mygroup으로 변경
```

- 그룹을 삭제한다.

```
groupdel newgroup : newgroup 그룹을 삭제(단, 해당 그룹을 주요 그룹으로 지정한 사용자가 없어야 한다.)
```

- 그룹의 암호를 설정하거나 그룹 관리를 수행한다.

```
gpasswd newgroup : newgroup 그룹의 암호를 지정
gpasswd -A newuser newgroup : newuser 사용자를 newgroup 그룹의 관리자로 지정
gpasswd -a user1 newgroup : user1을 newgroup 그룹의 사용자로 추가
gpasswd -d newuser newgroup :user1을 newgroup 그룹의 사용자에서 제거 
```

#### 파일과 디렉터리의 소유와 허가권

```
- rw-r--r-- 1 root root 0 12월 1 20:54 sample.txt


 - : 파일 유형
 rw-r--r-- : 파일 허가권
 1 : 링크수
 root : 파일 소유자 이름
 root : 파일 소유 그룹 이름
 0 : 파일 크기
 12월 1 20:54 : 마지막 변경 날짜/시간
 sample.txt : 파일 이름 
```

- 파일 유형

```
b : 블록 디바이스 , c : 문자 디바이스 , l : 링크 

 b - 하드디스크, 플로피 디스크, CD/DVD 등의 저장 장치
 
 c - 마우스, 키보드, 프린터  
 
 l - Windows의 바로 가기 아이콘
```



- 파일 허가권

| 소유자               | 그룹           | 그 외 사용자  |
| :------------------- | -------------- | ------------- |
| r        w         - | r   -        - | r    -      - |
| 6                    | 4              | 4             |

r : 읽기권한 (4)   , w : 쓰기권한(2) , - : 권한 없음 (0) , x : 접근 권한(1)

> window는 *.exe는 실행 파일 *.txt는 텍스트 파일 등 확장명으로 해당 파일의 종류를 판단하지만, 리눅스는 확장자에 별 의미를 두지 않는다. 그래서 해당 파일이 어떤 파일인지를 알려면 'file' 명령어를 사용해야 한다.

 

- 파일의 허가원을 변경하는 명령어로는 'chmod'가 있다.

```
chmod 777 sample.txt를 실행하면 sample.txt파일은 모슨 사용자가 읽고 쓰고 실행할 수 있는 파일이 되는것이다. 
```

> 파일의 허가권이 설정되어 있어도, 파일이 실제로 실행 가능한 코드가 아니라면 실행시 오류가 발생한다. 
>
> (window 에서 jpg 파일을 exe로 변경할 수는 있지만 exe로 실행이 되지는 않는다.)

- 파일 소유권
  - 파일을 소유한 사용자와 그룹을 의미한다.

```
chown 새로운사용자이름 파일이름  (chown centos sample.txt 는 sample.txt 파일의 소유자를 centos 사용자로 바꾸라는 의미)

chown centos.centos sample.txt은 파일의 그룹도 centos 그룹으로 바꾸라는 의미다.

chgrp 그룹변경 , chowm 그룹이름.group sample.txt() 은 그룹만 centos로 변경하라는 의미다.
```

> ls -ㅣ 실행하면 소유자와 그룹이 바뀌어 있다.



