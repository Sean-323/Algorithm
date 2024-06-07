n = int(input().strip())

for _ in range(n):
    m = int(input().strip())
    schools = {}
    for _ in range(m):
        name, num = input().strip().split()
        schools[name] = int(num)
    sorted_items = sorted(schools.items(), key=lambda item: item[1], reverse=True)
    print(sorted_items[0][0])