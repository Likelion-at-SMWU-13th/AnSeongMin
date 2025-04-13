from django.db import models

# Create your models here.

# 댓글 Comments model
class Comments(models.Model):
    content = models.TextField(verbose_name='내용')
    created_at = models.DateTimeField(verbose_name='작성일')
    like_count = models.IntegerField(verbose_name='좋아요수')

