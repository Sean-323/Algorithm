import sys
from collections import deque
input = sys.stdin.readline

def find_parents(N, tree):
    # 부모 노드를 기록할 배열 초기화
    parent = [0] * (N + 1)
    queue = deque([1])  # 루트 노드인 1부터 탐색 시작
    parent[1] = -1  # 루트 노드는 부모가 없음을 나타냄
    
    # BFS를 통해 각 노드의 부모를 찾음
    while queue:
        current = queue.popleft()
        for neighbor in tree[current]:
            if parent[neighbor] == 0:  # 아직 부모가 설정되지 않은 경우
                parent[neighbor] = current
                queue.append(neighbor)
    
    # 부모 노드 출력
    for i in range(2, N + 1):
        print(parent[i])

if __name__ == "__main__":
    N = int(input())
    tree = {i: [] for i in range(1, N + 1)}  # 각 노드의 연결 리스트 생성
    
    # 트리 간선 정보 입력
    for _ in range(N - 1):
        n1, n2 = map(int, input().split())
        tree[n1].append(n2)
        tree[n2].append(n1)
    
    find_parents(N, tree)