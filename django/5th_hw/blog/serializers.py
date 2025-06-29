from rest_framework.serializers import ModelSerializer
from .models import Post, Comment

class CommentModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'

class PostModelSerializer(ModelSerializer): # 글 전체보기 (상세보기)
    comments = CommentModelSerializer(many=True, read_only=True, source='comment_set')

    class Meta:
        model = Post # Post 모델을 직렬화
        fields = '__all__' # 모든 필드를 직렬화 (어떤 필드를 포함하여 직렬화할지)

class PostListSerializer(ModelSerializer): # 글 목록보기 
    class Meta:
        model = Post
        fields = ['id', 'content', 'created_at'] # 최소한 댓글은 안보이도록 함.