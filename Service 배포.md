# Service 배포

## I. Heroku CLI

- AWS 의 EC2 와는 다르게 한번 배포하면 풀세팅이 되어있다.
- 그리고 간단하당
- [www.heroku.com](http://www.heroku.com/)
- 일단 가입하기
- 일단 다운받기
- 주의사항
  - 서버를 돌릴 때, 에러가 뜨지 않아야 한다.
  - 404 에러가 발생하지 않을 때에만 배포 가능할 걸!!
  - git repo 안에 있으면 안됨 > 따로 복사해서 빼줘야 한다!!

## II. 배포 순서

- 프로젝트 파일 따로 복사

- `pip freeze > requirements.txt`

  - `Django 3` 버전이면 기도메타를 이루는 수 밖에 없다...
  - 또한 requirements.txt 와 manage.py 에 있는 버전이 다르면 안된다

- settings.py 에서

  - ```
    SECRET_KEY
    ```

     

    숨기기

    - 지금은 그냥 올리겠지만, 나중에 지워줘야 한다.

  - `DEBUG` False 로 바꾸기

  - `ALLOWED_HOSTS = ['127.0.0.1', '']`

  - 맨 밑에

     

    ```
    STATIC_ROOT = os.path.join(BASE_DIR, 'static')
    ```

    - 현재까지는 BASE_DIR 에 static 폴더가 있으면 안된다.

- `.gitignore`

  - `venv` 꼭 추가하기
  - `db.sqlite3` 꼭 추가하기

- `git init`

  - `git add .`

  - ```
    git commit -m "ready to deploy"
    ```

    - 마지막 커밋 기준으로 배포가 된다.
    - 다시 커밋하면 배포를 다시 해줘야 한다.

- `pip install django_heroku`

  - 만약 설치에서 오류가 난다면?
  - `brew install postgresql`

- `settings.py` 에서

  - `import django_heroku`
  - `django_heroku.settings(locals())`

- BASE_DIR 에서 `touch Procfile`

  - `pip install gunicorn`
  - `web: gunicorn [프로젝트 이름].wsgi --log-file -` (마스터 앱 이름 바꾸기해서 이름을 복사해 오자!!)

- `wsgi (Web Server Gateway Interface)`

- `touch runtime.txt`

  - 파이썬 버전을 확인해서

  - `python -V`

  - `python 3.7.3`

  - ```
    runtime.txt
    ```

     

    에서

    - `python [해당버전]`

  - `pip freeze > requirements.txt` 다시 한 번 마지막으로 실행

  - 서버가 알아서 두 파일을 읽고 필요한 패키지들을 깔아줄 거다!!

- `heroku`

- `heroku login`

- 엔터

- 헤로쿠 로그인 창이 익스플로러라면?

  - 기본 브라우저를 크롬으로 바꿔주자!
  - 그럼 로그인 하고 브라우저를 꺼주자

- `로그인 정보가 콘솔에 뜨면 성공적으로 로그인 된거다!`

- `heroku create [앱 name]` (앱 name 은 url 에도 영향을 준다! > 안 쓰면 랜덤 url)

- 나온 링크 클릭

- `git remote -v`

  - `heroku` 가 등록되어 있을 것이다

- 이후 conf 세팅

  - 헤로쿠 홈에서도 확인할 수 있긴 하다.
  - 헤로쿠 홈 > 로그인 > 대쉬보드 > 해당 서버 > Settings > Config Var > 필요한 세팅 값 입력
  - 혹은 `heroku config:set DEBUG=False`

- 다시 푸쉬해보기

  - `git add .`
  - `git commit -m "Last Commit"`
  - `git push heroku master`

- DB migrate 해주기

  - `heroku run python manage.py migrate`
  - 혹은 헤로쿠 대쉬보드 > run console > `python manage.py migrate`

## III. DB load in Heroku

- ```
  board/fixtures
  ```

  - 이 안에 json 파일을 넣어놓으면 쉽게 DB 에 자동으로 load 할 수 있다.

- `python manage.py dumpdata > board/fixtures/data.json`

- `f1 > beautify file` 하면 이쁘게 볼 수 있다.

- ```
  python manage.py loaddata data.json
  ```

  - 이 명령을 쓰면 데이터를 로드 할 수 있는 것이다!!

- 이 명령을 data.json 을 푸쉬하고 나서 다시 한 번 해보자

  - `git add .`
  - `git commit -m "data.json commit"`
  - `git push heroku master`

- 대쉬보드 > run console

  - `python manage.py loaddata data.json`
  - 이러면 데이터가 DB 에 들어간닷ㅎㅎ

## IV. DB remove in Heroku

- 대쉬보드 > Resource > Settings > Reset Data
- 데이터를 싹 없애 버릴 수 있다