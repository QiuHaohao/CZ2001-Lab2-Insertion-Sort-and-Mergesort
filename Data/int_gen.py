from random import randint,choice
import sys


for size in range(1000,10000,1000):
	array = [randint(0,2147483648) for x in range(size)]
	array.sort()
	with open(str(size)+".txt","w") as f:
		for x in range(size):
			f.write(str(array[-x-1])+"\n")
			


