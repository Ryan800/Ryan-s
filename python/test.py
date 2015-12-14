classmates = ['Michael', 'Bob', 'Tracy']

print('classmates = ', classmates)
print('len(classmates) = ', len(classmates))
print('classmates[0] = ', classmates[0])
print('classmates[-1] = ', classmates[-1])

classmates.pop()
print('classmates = ', classmates)

age = 3
if age >= 18:
	print('adult')
elif age >= 6:
	print('teenager')
else:
	print('kid')

#s = input('birth:')
#birth = int(s)
#if birth < 2000:
#	print('00前')
#else:
#	print('00后')

names = ['Michael', 'Bob', 'Tracy']
for name in names:
	print(name)

sum = 0
for x in [1,2,3,4,5,6,7,8,9,10]:
	sum = sum + x
print(sum)

sum = 0
for x in range(101):
	sum = sum + x
print(sum)