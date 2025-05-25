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
        fields = ['id', 'username', 'email'] 
        # 회원가입 기능에 필요한 최소 필드만 직렬화하고 반환할 수 있도록 함