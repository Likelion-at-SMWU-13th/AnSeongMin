from django.shortcuts import render
from django.http import HttpResponse


def introduce_view(request):
    data = {
        'name':'안성민',
        'generation':'13기',
        'part':'백엔드',
        'favorite_food':'마라샹궈',
    }
    return render(request, 'introduce.html', data)