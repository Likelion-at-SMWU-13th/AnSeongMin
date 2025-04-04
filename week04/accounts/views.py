from django.shortcuts import render, redirect
from .forms import SignupForm
from django.contrib.auth import authenticate, login as auth_login, logout as auth_logout

def signup(request):
    if request.method == "POST":
        form = SignupForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect("login")
    else:
        form = SignupForm()

    return render(request, "signup.html", {"form":form})

def login(request):
    if request.method == "POST":
        username = request.POST.get("username")
        password = request.POST.get("password")

        user = authenticate(request, username=username, password=password) # 사용자 인증
        if user is not None:
            auth_login(request, user)
            return redirect("main")
    
    return render(request, "login.html")

def main(request):
    return render(request, "main.html")

def logout(request):
    if request.user.is_authenticated:
        auth_logout(request)
        return redirect("login")
    # 여기에 else문으로 로그아웃되어 있는 경우 로그아웃 버튼을 눌렀을 때에 대한 기능을 처리해주지 않았기 때문에
    # 로그아웃된 상태에서 로그아웃 버튼 누르면 에러가 뜨는게 정상이다. 