from django.urls import path, include
from django.contrib import admin
from rest_framework import routers

from .views import PostModelViewSet
from .views_signup import create_user, get_user, update_user

app_name = "posts"

router_post = routers.DefaultRouter()
router_post.register('', PostModelViewSet)

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', create_user),
    path('<int:pk>/', get_user),
    path('<int:pk>/update/', update_user), 
]