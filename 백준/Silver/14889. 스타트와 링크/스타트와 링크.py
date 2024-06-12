from itertools import combinations

n = int(input())
scoreboard = [list(map(int, input().split())) for _ in range(n)]
team_with_0s = list(combinations(range(1, n), n // 2 - 1)) # 0번 사람 + (n // 2 - 1)명 으로 팀을 구성할 거에요
m = float('inf') # 무한대. 최솟값을 찾을 때 초깃값으로 사용하면 편해요.
for team1 in team_with_0s:
	team1 = [0] + list(team1)
	team2 = list(set(range(n)) - set(team1)) # 2번째 팀은 1번째 팀에 속하지 않는 사람들로 구성할게요.
	score1 = 0
	score2 = 0
	for i in range(n // 2):
		for j in range(n // 2):
			score1 += scoreboard[team1[i]][team1[j]] # team1[i]번 사람과 team1[j]번 사람이 만났을 때의 점수를 더해요.
			score2 += scoreboard[team2[i]][team2[j]] # 위와 마찬가지로 team2의 점수도 구해줍니다.
	m = min(m, abs(score1 - score2)) # 절댓값 함수 abs를 이용하면 두 값의 차이를 구할 수 있습니다.
print(m)