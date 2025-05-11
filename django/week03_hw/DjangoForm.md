# Django Form 관련 공식 홈페이지 내용 정리하기

# HTML forms
- `<form>...</form>` 사이에 적는 코드
- 사용자는 텍스트 입력, 옵션 선택, 객체 조작 등을 할 수 있음
- 그리고 그 정보를 서버에 다시 보낸다
<hr>
- 폼은 다음 두 가지 정보를 구체화해야 한다
    - where : 사용자의 입력값에 대응하는 정보가 리턴되는 URL (어디에 렌더링하는지를 말하는 듯)
    - how : 데이터가 리턴되는 HTTP 메서드의 방식 (POST인지 GET인지 등등..)

# GET and POST
- 폼을 다룰 때 사용되는 HTTP 메서드는 GET이랑 POST밖에 없다.
- 두 메서드는 보통 다른 경우에 사용된다.
    - POST: 시스템의 상태를 바꾸기 위해 사용될 때 (데이터베이스에 변화를 주고 싶을 때 등등) 사용. 
    - GET: 시스템의 상태에 영향을 미치지 않을 때에만 사용 가능. 패스워드 다룰 때도 보안문제로 사용 불가능. 
    - 장고의 CSRF protection은 POST에만 적용 가능하다
    - GET은 web search form 등에 적합하다. 북마크, 공유, 재제출 등이 용이해서!

# Django's role in forms
- 렌더링을 준비하기 위해 데이터를 준비하고 재구성
- 데이터에 맞는 HTML 폼 생성
- 사용자로부터 폼과 데이터를 제출받고, 받은 데이터를 처리

# Forms in Django
- 장고에서는 Form 클래스를 사용하여 사용자 입력을 처리할 수 있다.

## 1. Form 클래스 
```python
from django import forms

class ContactForm(forms.Form):
    subject = forms.CharField(max_length=100)
    message = forms.CharField(widget=forms.Textarea)
    sender = forms.EmailField()
    cc_myself = forms.BooleanField(required=False)
```
위와 같이 폼에 들어갈 필드를 직접 정의할 수 있다. 
## 2. views.py 작성
```python
from django.http import HttpResponseRedirect
from django.shortcuts import render

from .forms import NameForm

def get_name(request):
    # post 요청이면 
    if request.method == "POST":
        # 폼 인스턴스를 생성하고
        form = NameForm(request.POST)
        # 유효성을 검사하고
        if form.is_valid():
            # 이곳에 데이터 처리하기, 필요하면 form.cleaned_data 형태 사용하기
            # url을 리다이렉트한다. 
            return HttpResponseRedirect("/thanks/")

    # get 등의 다른 요청이면 빈 폼을 생성한다
    else:
        form = NameForm()

    return render(request, "name.html", {"form": form})
```
## 3. templates로 폼 렌더링
```python
<form action="/your-name/" method="post">
    {% csrf_token %}
    {{ form.as_p }}
    <input type="submit" value="Submit">
</form>
```
{% csrf_token %}라는 보안 토큰을 사용한다.
{{ form.as_p }}를 통해 폼 태그를 p태그로 감싸 출력한다.
