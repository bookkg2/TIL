# Django Authentication

## I. django.contrib.auth

- auth.User 클래스를 관리하는 유저 총괄 관리 앱
- `from django.conf import settings`
  - settings.AUTH_USER_MODEL
    - 기본 auth.User 를 관리하는 상수
    - 바꾸면 터진다??

## II. auth.User

- 유저를 확장할 수 있는 방법은?

  - models.py

  ```
  # models.py
  
  from django.db import models
  from django.contrib.auth.models import AbstractUser
  
  # Create your models here.
  
  class User(AbstractUser):
      address = models.CharField(max_length=200)
  ```

  - settings.py

  ```
  # settings.py
  
  ...
  
  AUTH_USER_MODEL = 'accounts.User'
  
  ...
  ```

  - forms.py

  ```
  # forms.py
  
  from django.contrib.auth.forms import UserCreationForm, AuthenticationForm
  from django import forms
  from .models import User
  
  class CustomUserCreationForm(UserCreationForm):
      address = forms.CharField(min_length=3)
  
      class Meta(UserCreationForm.Meta):
          model = User
          fields = UserCreationForm.Meta.fields + ('address', )
  
  class CustomAuthenticationForm(AuthenticationForm):
      class Meta(AuthenticationForm):
          model = User
  ```

## III. Login Required

- boards.views.py

```
# boards.views.py

@login_required
def new_article(request):
    if request.method == 'POST':
        form = ArticleForm(request.POST)

        if form.is_valid():
            article = form.save()

            return redirect('boards:article_detail', article.id)
    else:
        form = ArticleForm()

    context = {
        'form' : form
    }

    return render(request, 'boards/article_form.html', context)
```

- accounts.views.py

```
# accounts.views.py

def login(request):
    if request.user.is_authenticated:
        return redirect('boards:article_list')

    if request.method == 'POST':
        form = CustomAuthenticationForm(request, request.POST)

        if form.is_valid():
            user = form.get_user()
            auth_login(request, user)

            return redirect(request.GET.get('next') or 'boards:article_list')
    else:
        form = CustomAuthenticationForm()

    context = {
        'form' : form
    }

    return render(request, 'accounts/login.html', context)
```