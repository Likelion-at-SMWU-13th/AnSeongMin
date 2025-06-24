from django.urls import path, include
from django.contrib import admin
from rest_framework import routers

from .views import PostModelViewSet, PostListView, PostRetrieveView

app_name="posts"

router_post = routers.DefaultRouter()
router_post.register('', PostModelViewSet)

urlpatterns = [
    path('', include(router_post.urls)),
    path('', PostListView.as_view()), # 꼭 as_view()와 같이 cbv 방식으로 불러와야 한다 
    path('<int:pk>', PostRetrieveView.as_view()),
    path('admin/', admin.site.urls)
]