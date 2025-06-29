from django.urls import path, include
from django.contrib import admin
from rest_framework import routers

from .views import PostModelViewSet, CommentModelViewSet

app_name="blog"

router_post = routers.DefaultRouter()
router_post.register('posts', PostModelViewSet)
router_post.register('comments', CommentModelViewSet)

urlpatterns = [
    path('', include(router_post.urls)),
]