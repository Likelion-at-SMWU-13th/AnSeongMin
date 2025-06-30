from .models import Post, Comment
from rest_framework.viewsets import ModelViewSet 
from .serializers import PostModelSerializer, PostListSerializer, CommentModelSerializer

class PostModelViewSet(ModelViewSet): 
    queryset = Post.objects.all()
    
    def get_serializer_class(self):
        if self.action == 'list': # 글 목록 조회일 경우 글 목록만 보여주기
            return PostListSerializer
        return PostModelSerializer # 아니면 글 상세조회, 작성, 수정, 삭제 



class CommentModelViewSet(ModelViewSet):
    queryset = Comment.objects.all()
    serializer_class = CommentModelSerializer
    # 이전 과제와는 다르게, 이후에 함수를 따로 정의하지 않아도 된다~!!
