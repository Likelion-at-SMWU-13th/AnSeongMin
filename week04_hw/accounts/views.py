from django.shortcuts import render, redirect
from .forms import SignupForm

def signup(request):
    if request.method == "POST":
        form = SignupForm(request.POST)
        if form.is_valid(): # 폼이 유효하면 회원가입 성공
            form.save()     # 정보 저장하고(?)
            return redirect("login") # login 페이지로 이동
    else:
        form = SignupForm()

    return render(request, "signup.html", {"form":form})