arr = []
students = {}

for _ in range(3):
    num, year, name = map(str,input().strip().split())
    num = int(num)
    arr.append(int(year))
    students[num] = name
arr.sort()

output = ''.join(str(i % 100) for i in arr)

sorted_students = dict(sorted(students.items(), reverse=True))
result_name = ''.join(sorted_students[i][0] for i in sorted_students)

print(output)
print(result_name)