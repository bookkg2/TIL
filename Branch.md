### Branch

즉, 파일을 여러개로 나눈다.

- Git을 처음 만들면  HEAD 라는 파일이 만들어 진다. 

```bash
git init
```

- 그 안에는 ref/heads/master 파일이 생성된다.
- commit 을 하면  ref/heads/master 에 가장 최신 파일  OBJECT(ID) 가 생성된다.

```bash
git log (최신 commit 확인 가능)
```

- 이전꺼는 parent에 담긴다. 

- branch 생성

```bash
git branch [브랜치 이름]

```

- ref/heads/[브랜치 이름]라는 파일이 생성되고 그 파일은 master branch와 똑같이 최신 파일을 가리킨다.

- 브랜치 확인

```bash
git branch
```

- 브랜치 삭제

```bash
rm .git/refs/heads/[브랜치 이름]
```

- vim .git/refs/heads/[브랜치 이름] 치고 log의 commit ID를 치면 다시 생성된다.

- 브랜치로 스위치- head의 위치가 master -> 브랜치로 이동

```bash
git checkout [브랜치 이름]
```

