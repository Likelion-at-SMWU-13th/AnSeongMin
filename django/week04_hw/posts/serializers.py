from rest_framework.serializers import ModelSerializer
from .models import Post
from django.contrib.auth.models import User 

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__' # 모든 필드를 직렬화


class UserSerializer(serializers.ModelSerializer):
    password = serializers.CharField(write_only=True)

    class Meta:
        model = User
        fields = ['id', 'username', 'email', 'password']

    def create(self, validated_data):
        return User.objects.create_user(**validated_data)