# GIT / Github

# 1일차

## I. GIT 설치

최신버전 업데이트

## II. VS CODE 설치

<https://code.visualstudio.com/#alt-downloads>

system Installer

## III. 코드 관리 도구로서의 GIT

README.md 하나씩 만들기

```
mkdir codes
cd codes

mkdir git_basic
cd git_basic

code .

git init
.git 이라는 폴더가 생김 


git log --oneline
```

SCM (Source Code Management)

- source 코드들을 관리하기 위해 태어난 친구.
- = VCS(Version Control System)

GIT이 변화를 빠르게 감지할 수 있는 이유

HASH를 사용. 2^160

Commit ID 가 HASH 값인데 변경전이랑 후의 ID값을 비교해서 다르면 변화가 있다고 판단.

이 아이디에 meta Data 등등 다들어가 있는거임.

commit message 는 동사 + 목적어 (현재형 능동태로 ㄱㄱ)

과거상태 보기 (잠깐만 보러간거임 수정 왠만하면 ㄴㄴ)

```
git log --oneline
e4e97fb (HEAD -> master) finish basic command
4bdca36 first commit

git checkout 4bdca36 
```

돌아오기

```
git checkout master
```

수정한 부분이 맘에들지 않을때 취소

```
git restore README.md
```

이 경우 가장 최근에 커밋 했던 부분으로 이동하게 됨

## IV. 원격 저장소로서의 GIT (git/github)

1. REPOSITORY 생성.

2. 원격 저장소에 관련한 모든 커맨드는

   ```
   git remote
   ```

   remote를 추가할 때

   ```
   git remote add [name] [address]
   
   관례상 name: origin이라고 지음
   git remote add root https://github.com/jkim0715/basic_git.git
   
   git remote
   root
   ```

   주소까지 확인 할 때

   ```
   git remote -v
   root    https://github.com/jkim0715/basic_git.git (fetch)
   root    https://github.com/jkim0715/basic_git.git (push)
   ```

3. 저장소 만든거에 파일 올릴 때

   ```
   git push [원격저장소의 이름] [브랜치의 이름]
   ```

4. 원격 저장소의 코드를 가져올 때

   1. 맨 처음 가져올때

      ```
      git clone [원격 저장소의 주소]
      
      git clone [원격 저장소의 주소] [프로젝트 이름]
      ```

      인자를 추가하면 clone한 폴더이름 설정 가능

      clone을 하게되면 remote 정보도 같이 가져오기 때문에 remote 설정이 되어있음 (default: origin)

   2. 두번째 부터

      ```
      git pull origin master
      ```

      단 pull 하기전에 working tree는 clean 해야 함.

      restore를 적절히 이용할 것.

## SUBLIME TEXT

<https://www.sublimetext.com/>

## V. 협업 도구

1. push & pull

2. forking & pull request

   (github flow )

   1. fork
   2. clone
   3. edit
   4. push
   5. pull request
   6. 팀장이 merge request

3. branching

협업의 원칙

1. 팀장의 권한이 강하디.