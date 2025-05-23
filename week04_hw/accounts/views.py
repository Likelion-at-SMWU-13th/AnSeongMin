from django.shortcuts import render, redirect
from .forms import SignupForm
from django.contrib.auth import authenticate, login as auth_login, logout as auth_logout

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

def main(request):
    return render(request, "main.html")

def logout(request):
    if request.user.is_authenticated: # 사용자가 로그인 상태면
        auth_logout(request) # 로그아웃 수행
        return redirect("login") # login 페이지로 이동
    
    # 로그인 상태가 아니라면(일부러 주소창에 /main 입력해서 메인페이지로 가는경우) 로그아웃 요청을 받으면 로그인되도록 함
    else: 
        return redirect("login")
    
def mypage(request):
    if request.user.is_authenticated:   
        return render(request, "mypage.html")
    else:
        return redirect("login")
    

def edit(request): # 정보수정 버튼 누르면 일단 메인가도록 함
    return render(request, "main.html")