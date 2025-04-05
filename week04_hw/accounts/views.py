from django.shortcuts import render, redirect
from .forms import SignupForm
from django.contrib.auth import authenticate, login as auth_login

def signup(request):
    if request.method == "POST":
        form = SignupForm(request.POST)
        if form.is_valid(): # 폼이 유효하면 회원가입 성공
            form.save()     # 정보 저장하고(?)
            return redirect("login") # login 페이지로 이동
    else:
        form = SignupForm()

    return render(request, "signup.html", {"form":form})

def login(request):
    if request.method == "POST": # POST 요청 받는경우 -> 로그인 로직 수행
        username = request.POST.get("username") # get() 메소드 -> 사용자로부터 입력받은 username 가져오기
        password = request.POST.get("password")

        # authentcate() 메소드 -> 사용자 인증 후 -> 사용자 객체 or None 반환
        user = authenticate(request, username=username, password=password) # 사용자 인증
        if user is not None: # 사용자 객체가 있으면
            auth_login(request, user) # 로그인 실행
            return redirect("main") # main 페이지로 이동
        
    # 인증에 실패하는 경우(None 반환된 경우) or GET 요청 받는경우
    return render(request, "login.html") # 로그인 페이지 렌더링하기