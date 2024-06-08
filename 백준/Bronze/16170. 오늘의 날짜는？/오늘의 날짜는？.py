from datetime import datetime

now = datetime.now()
arr = str(now.date()).split('-')

print(arr[0])
print(arr[1])
print(arr[2])