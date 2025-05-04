from django.shortcuts import render
from django.http import HttpResponse


def introduce_view(request):
    print(f'request.method:{request.method}') # 로그에 찍는코드
    if request.method == 'GET':
        print(f'request.GET: {request.GET}')
    elif request.method == 'POST':
        print(f'request.POST: {request.POST}')
    return render(request, 'introduce.html')