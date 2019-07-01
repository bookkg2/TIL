## Git 

  GIt은 프로그램 등의 소스 코드 관리를 위한 분산 버전 관리 시스템이다. 빠른 수행 속도에 중점을 두고 있는 것이 특징이다. 최초에는 리누스 토르발스가 리눅스 커널 개발에 이용하려고 개발하였으며, 현재는 다른곳에서도 널리 사용되고 있다. 깃의 작업 폴더는 모두, 전체 기록과 각 기록을 추적할 수 있는 정보를 포함하고 있으며, 완전한 형태의 저장소이다(로컬에 커밋이 된다). 네트워크에 접근하거나 중앙 서버에 의존하지 않는다.

>  *분산 버전 관리 시스템 : 분산 버전 관리 시스템을 쉽게 말하면, 여러명의 개발자(분산)가 특정 프로젝트를 자신의 컴퓨터로 협업하여 개발하면서 버전을 관리할 수 있는 시스템이다. 

참고 자료 > <https://www.slideshare.net/seungyongyun56/git-git-54855907>

#### Git의 장점

**-Branch and Merge**

git은 여러가지의 Branch를 생성해서 합병과 삭제를 통해 여러가지를 시도해 볼수 있고, 합병과 삭제등이 가능하여 Branch의 독립성을 제공합니다.  예를 들어, 모험적인 기능을 프로그램으로 구현 하려고 할때 그 프로그램을 Branch에 계속 커밋을 해두면 그것이 완전히 독립적이라 사용이 불가능한다고 생각되면, 그 Branch를 삭제하면 되고 사용이 가능하다고 생각되면 Master와 합병을 하여 사용 할 수 있습니다.

**-Distributed**

전체 개발 이력을 각 개발자의 로컬로 복사본을 제공하고 변경된 이력을 다시 하나의 저장소로 복사한다.



​     이러한 변경은 추가개발지점을 가져와, 로컬개발 지점과 동일하게 병합(merge)할 수 있다. 저장소는 웹서버 구성없이도 Git protocol 및 HTTP로 쉽고 효율적으로 접근할 수 있습니다.



**-Small and Fast**

​     Git은 지속적으로 어딘가의 서버와 통신을 하는 중앙 집중식 시스템이 아니라 자신의 로컬에서 작업을 하기 때문에 속도면에서 아주 우수합니다.



**-Staging Area**

​     Git에는 Staging area가 존재하는데 working directory 즉 현재 작업디렉토리에서 자신이 올리려고하는 것 예를들어 파일을 add를 하게되면 Staging Area라는 공간으로 이동을 하게 되는데. 이 공간은 저장소로 commit하기전에 파일을 점검할수 있는 공간 입니다. 여기서 자신이 commit하려고하는 파일과 최신 버전의 파일을 비교하여 어느부분이 수정되었는가를 점검한후에 Repository로 commit을 할 수 있습니다. 



출처: <https://hackersstudy.tistory.com/49> [공대인들이 직접쓰는 컴퓨터공부방]  





#### 다운로드 경로

- Git CLI(Command Line Interface, 명령 줄 인터페이스)를 설치하는 과정이다. 자신 컴퓨터에 맞는 Git을 설치하면 된다. 여기서 CLI란, Windows 운영체제에서의 CMD, Mac OS나 Linux 운영체제에서의 Terminal 등에서 명령어를 통해 제공되는 여러가지 기능을 담은 소프트웨어라고 생각하면 된다. GUI(Graphic User Interface, 그래픽 사용자 인터페이스)를 사용할 수 있지만, 이는 CLI에 비해 제한된 기능만을 제공하므로, 우리는 앞으로 CLI를 이용하여 진행하는 것이 좋다.

> <https://git-scm.com/downloads>







#### 주요 용어

- Git 저장소 만들기 
  - 기존 프로젝트를 Git 저장소로 만드는 방법 -`.git`이라는 하위 디렉토리를 만든다. `.git` 디렉토리에는 저장소에 필요한 뼈대 파일(Skeleton)이 들어 있다

```
$ git init
```

​     

- Git 저장소에 파일을 추가하고 커밋 -> USER Email -> USER 이름 -> 그다음 push

```
$ git add *.c
$ git add README
$ git commit -m 'initial project version'
$ git config --global user.email "you@example.com"
$ git config --global user.name "Your Name"
$ git push -u origin master
```

- Git 현재 상태 확인 

```
$ git status
```



- 기존 저장소를  Clone 하기 
  - 다른 프로젝트에 참여하거나(Contribute) Git 저장소를 복사하고 싶을 때 `git clone` 명령을 사용한다. 이미 Subversion 같은 VCS에 익숙한 사용자에게는 `checkout`이 아니라 `clone`이라는 점이 도드라져 보일 것이다. Git이 Subversion과 다른 가장 큰 차이점은 서버에 있는 모든 데이터를 복사한다는 것이다. `git clone`을 실행하면 프로젝트 히스토리를 전부 받아온다. 실제로 서버의 디스크가 망가져도 클라이언트 저장소 중에서 아무거나 하나 가져다가 복구하면 된다 (GUI를 통해 CLONE해 올 수 도 있다.)

```
$ git clone [url]
```

```
$ git clone git://github.com/schacon/grit.git
```

​     * 이 명령은 "grit"이라는 디렉토리를 만들고 그 안에 `.git` 디렉토리를 만든다. 