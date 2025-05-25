from rest_framework.response import Response
from rest_framework.decorators import api_view
from rest_framework import status # status를 숫자뿐만 아니라 문자(DRF 상수)로도 적을 수 있게 해준다 -> 가독성 굿
from .serializers import UserModelSerializer


# 회원가입 (Create -> POST)
@api_view(['POST'])
def create_user(request):
    serializer = UserModelSerializer(data=request.data) # 요청한 데이터 받기
    if serializer.is_valid(): # 유효성 검사
        serializer.save() # 저장 
        return Response(serializer.data, status=status.HTTP_201_CREATED)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


# 회원정보 조회 (Read -> GET)
@api_view(['GET'])
def get_user(request):
    num1 = request.GET.get('num1', 0)
    num2 = request.GET.get('num2', 0)
    op = request.GET.get('op')


# 회원정보 수정 (Update -> PUT/PATCH)


# 회원 탈퇴 (Delete -> DELETE)