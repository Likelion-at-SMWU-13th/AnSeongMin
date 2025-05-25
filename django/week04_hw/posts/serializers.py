from rest_framework.serializers import ModelSerializer
from .models import Post
from django.contrib.auth.models import User 

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__' # 모든 필드를 직렬화


class UserModelSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = '__all__'