from random import randint,choice
import sys

for size in range(100000,1000001,100000):
	with open(str(size)+".txt","w") as f:
		for x in range(size):
			f.write(str(randint(0,2147483648))+"\n")


