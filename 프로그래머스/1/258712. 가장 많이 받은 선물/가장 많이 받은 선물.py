def solution(friends, gifts):
    n = len(friends)
    table = [[0] * n for _ in range(n)] # table[i][j] : i가 j에게 준 선물의 수
    gift_factor = [0] * n # gift_factor[i] : i가 준 선물의 수 - i가 받은 선물의 수

    # 각 친구의 이름을 인덱스로 변환해줄게요.
    index_map = {}
    for i in range(n):
        index_map[friends[i]] = i
    
    for gift in gifts:
        a, b = gift.split()
        idx_a = index_map[a]
        idx_b = index_map[b]
        table[idx_a][idx_b] += 1
        gift_factor[idx_a] += 1
        gift_factor[idx_b] -= 1
    
    next_gift = [0] * n
    for i in range(n):
        for j in range(i + 1, n):
            if table[i][j] > table[j][i]:
                next_gift[i] += 1
            elif table[i][j] < table[j][i]:
                next_gift[j] += 1
            else:
                if gift_factor[i] > gift_factor[j]:
                    next_gift[i] += 1
                elif gift_factor[i] < gift_factor[j]:
                    next_gift[j] += 1

    return max(next_gift)
