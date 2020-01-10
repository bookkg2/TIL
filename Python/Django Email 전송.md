## Django Email 전송

- 메일은 [`EMAIL_HOST`](https://django-doc-test-kor.readthedocs.io/en/old_master/ref/settings.html#std:setting-EMAIL_HOST) 및 [`EMAIL_PORT`](https://django-doc-test-kor.readthedocs.io/en/old_master/ref/settings.html#std:setting-EMAIL_PORT) 설정에 지정된 SMTP 호스트 및 포트를 사용하여 전송됩니다 . [`EMAIL_HOST_USER`](https://django-doc-test-kor.readthedocs.io/en/old_master/ref/settings.html#std:setting-EMAIL_HOST_USER) 및 [`EMAIL_HOST_PASSWORD`](https://django-doc-test-kor.readthedocs.io/en/old_master/ref/settings.html#std:setting-EMAIL_HOST_PASSWORD) 설정은 설정하면 SMTP 서버에 인증하는 데 사용되며, [`EMAIL_USE_TLS는`](https://django-doc-test-kor.readthedocs.io/en/old_master/ref/settings.html#std:setting-EMAIL_USE_TLS) 보안 연결 사용 여부를 제어 설정.

- ## send_mass_mail () 

  - `send_mass_mail` ( *datatuple* , *fail_silently = False* , *auth_user = None* , *auth_password = None* , *connection = None* ) 

    

  `django.core.mail.send_mass_mail ()` : 대량 전자 메일 처리

  `datatuple` 은 각 요소가 다음 형식 인 튜플입니다.

  ```
  ( subject ,  message ,  from_email ,  recipient_list )
  ```

  `fail_silently` ,` auth_user` 및` auth_password` 는[` send_mail ()`](https://django-doc-test-kor.readthedocs.io/en/old_master/topics/email.html#django.core.mail.send_mail) 과 동일한 기능을 갖습니다.

  별도의 데이터 `튜플` 요소마다 별도의 전자 메일 메시지가 생성됩니다. 마찬가지로 [`send_mail ()`](https://django-doc-test-kor.readthedocs.io/en/old_master/topics/email.html#django.core.mail.send_mail) , 같은받는 사람 `recipient_list는` 필드 : 모든 이메일 메시지 ' ""에 다른 주소를 볼 수 있습니다.

  예를 들어 다음 코드는 서로 다른 두 명의 수신자에게 두 개의 서로 다른 메시지를 보냅니다. 그러나 메일 서버에 대한 연결은 하나만 열립니다.

  ```
  message1  =  ( '제목' ,  '여기에 메시지가 있습니다' ,  'from@example.com' ,  [ 'first@example.com' ,  'other@example.com' ]) 
  message2  =  ( '다른 주제' ,  ' 여기에 또 다른 메시지가 있습니다. ' ,  'from@example.com ' ,  [ 'second@test.com ' ]) 
  send_mass_mail (( message1 ,  message2 ),  fail_silently = False )
  ```

  

  ### send_mass_mail () vs. send_mail () 

  주요 차이점 [`send_mass_mail ()`](https://django-doc-test-kor.readthedocs.io/en/old_master/topics/email.html#django.core.mail.send_mass_mail) 및 [`send_mail ()는`](https://django-doc-test-kor.readthedocs.io/en/old_master/topics/email.html#django.core.mail.send_mail) 즉 [`send_mail ()가`](https://django-doc-test-kor.readthedocs.io/en/old_master/topics/email.html#django.core.mail.send_mail) 있지만, 메일 서버가 실행되는 각 시간에 연결을 열고 [`send_mass_mail ()는`](https://django-doc-test-kor.readthedocs.io/en/old_master/topics/email.html#django.core.mail.send_mass_mail) 그것의 모든 메시지에 대해 하나의 연결을 사용한다. 이것은 [`send_mass_mail ()을`](https://django-doc-test-kor.readthedocs.io/en/old_master/topics/email.html#django.core.mail.send_mass_mail) 약간 더 효율적으로 만듭니다.

- 장고에서 이메일 인증

  - 1) Post/users/signup : 회원가입 후 인증 메일 전송

  - 2) GET / users/activate : 인증 메일 클릭시 전송

    urls.py

    ```
    
    ```

    