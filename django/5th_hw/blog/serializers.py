from rest_framework.serializers import ModelSerializer
from .models import Post, Comment

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post # Post 모델을 직렬화
        fields = '__all__' # 모든 필드를 직렬화 (어떤 필드를 포함하여 직렬화할지)

class CommentModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'