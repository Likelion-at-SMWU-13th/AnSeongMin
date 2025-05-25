from rest_framework.response import Response
from rest_framework.decorators import api_view
from rest_framework import status # status를 숫자뿐만 아니라 문자(DRF 상수)로도 적을 수 있게 해준다 -> 가독성 굿
from .serializers import UserModelSerializer
from django.contrib.auth import get_user_model
User = get_user_model()


# 회원가입 (Create -> POST)
@api_view(['POST'])
def create_user(request):
    serializer = UserModelSerializer(data=request.data) # 요청한 데이터 받기
    if serializer.is_valid(): # 유효성 검사 
        serializer.save() # DB에 객체 생성, 저장 
        return Response(serializer.data, status=status.HTTP_201_CREATED) # 저장된 결과를 json 응답으로 반환 
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST) # 오류가 났다면, 어떤 필드에서 오류가 났는지 JSON으로 반환


# 회원정보 조회 (Read -> GET)
@api_view(['GET'])
def get_user(request, pk):
    try:
        user = User.objects.get(pk=pk) # User 모델에서 기본키 pk(변수)가 pk(파라미터로 들어온 실제 값)인 사용자를 가져오려고 시도
    except User.DoesNotExist: # 없으면 예외처리
        return Response(status=status.HTTP_404_NOT_FOUND)

    serializer = UserModelSerializer(user) # 찾은 user 객체를 UserModelSerializer를 통해 직렬화
    return Response(serializer.data, status=status.HTTP_200_OK) # 최종적으로 변환된 json 데이터를 200 코드와 함께 반환
    

# 회원정보 수정 (Update -> PUT/PATCH)
@api_view(['PUT'])
def update_user(request, pk):
    try:
        user = User.objects.get(pk=pk)
    except User.DoesNotExist:
        return Response(status=status.HTTP_404_NOT_FOUND)
    
    serializer = UserModelSerializer(instance=user, data=request.data, partial=True)

    if serializer.is_valid(): 
        serializer.save()
        return Response(serializer.data, status=status.HTTP_200_OK)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


# 회원 탈퇴 (Delete -> DELETE)
@api_view(['DELETE'])
def delete_user(request, pk):
    try:
        user = User.objects.get(pk=pk)
    except User.DoesNotExist:
        return Response(status=status.HTTP_404_NOT_FOUND)

    user.delete() 
    return Response(status=status.HTTP_204_NO_CONTENT) # 204: 반환 response가 없지만 요청 성공 



