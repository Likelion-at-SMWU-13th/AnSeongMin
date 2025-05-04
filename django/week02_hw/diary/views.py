from django.shortcuts import render 
from django.views.generic import ListView
from .models import Post

class diary_view(ListView):
    model = Post
    template_name = 'diary.html'


