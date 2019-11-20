## URL namespace

- 각각의 url에 별명을 지어줘서 html 파일에서 사용하는 링크를 추가적으로 바꾸지 않고, `url.py` 에서만 수정하면 html 파일에서도 링크 수정이 반영되게끔 함\

  - NAME에다가 준다

  ```python
  urlpatterns = [
      # CRUD 
      # C -> new, create
      # R -> index, show
      # U -> edit, update
      # D -> Delete
      path('', views.index, name="index"),
      path('<int:id>/', views.show , name="show"),
      path('new/', views.new,name="new"),
      path('create/', views.create,name="create"),
      path('<int:id>/edit/', views.edit, name="edit"),
      path('<int:id>/update/', views.update, name ="update"),
      path('<int:id>/delete/', views.delete, name="delete"),
  ]
  ```

  - html

  ```html
  <td><a href="{% url 'show' article.id %}">{{article.title}}</a></td>
  
  <a href="{% url 'new' %}" class="btn btn-info">새글쓰기</a>
  ```

  - Render

  ```html
  return redirect('show', article.id)
  ```

- RESTful api

  | 역할   | Method       | End-point              | Views(Function) |
  | ------ | ------------ | ---------------------- | --------------- |
  | Create | GET          | /articles/new          | new             |
  | Create | POST         | /articles/new          | create          |
  | Read   | GET          | /articles/<id>/        | show            |
  | Read   | GET          | /articles/             | index           |
  | Update | GET          | /articles/<id>/edit/   | edit            |
  | Update | POST         | /articles/<id>/        | update          |
  | Delete | POST(DELETE) | /articles/<id>/delete/ | delete          |

  - GET : 조회 , POST : DB에 반영

- date 넣고 찍기

  - models.py

  ```python
  from django.db import models
  
  # Create your models here.
  
  class Article(models.Model):
      title = models.CharField(max_length=16)
      contents = models.TextField()
      creator = models.CharField(max_length=8)
      created_at = models.DateTimeField(auto_now_add = True, null=True)
      updated_at = models.DateTimeField(auto_now= True, null=True)
  ```

  - html

  ```html
  <td>{{article.created_at}}</td>
  ```

  - format 변경 (String frormat)

    - models.py

      ```python
      from django.db import models
      
      # Create your models here.
      
      class Article(models.Model):
          title = models.CharField(max_length=16)
          contents = models.TextField()
          creator = models.CharField(max_length=8)
          created_at = models.DateTimeField(auto_now_add = True, null=True)
          updated_at = models.DateTimeField(auto_now= True, null=True)
      
          def datetime_to_string(self):
              return self.created_at.strftime('%Y %m %d')
      ```

      

    - index.html

      ```html
      <td>{{article.datetime_to_string}}</td>
      ```

- 관리자 권한 만들기

  - shell

    - python manage.py createsuperuser 입력해서 생성
    - url/admin 검색
    - admin.py에 등록해서 관리 파일 지정

    ```python
    from django.contrib import admin
    from .models import Article
    
    # Register your models here.
    
    admin.site.register(Article)
    ```

    - models.py ( str은 파일 출력 형식 지정)

    ```
     #폴더 보기위한 형식 지정
        def __str__(self):
            return f'[{self.title}]-created by {self.creator}'
    ```

    

