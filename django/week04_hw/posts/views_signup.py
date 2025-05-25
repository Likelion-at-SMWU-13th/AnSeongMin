from rest_framework.response import Response
from rest_framework.decorators import api_view


# 회원가입 (Create -> POST)

# 회원정보 조회 (Read -> GET)
@api_view(['GET'])
def get_user(request):
    num1 = request.GET.get('num1', 0)
    num2 = request.GET.get('num2', 0)
    op = request.GET.get('op')


# 회원정보 수정 (Update -> PUT/PATCH)


# 회원 탈퇴 (Delete -> DELETE)