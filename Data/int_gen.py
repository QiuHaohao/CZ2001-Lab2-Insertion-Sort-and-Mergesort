from random import randint,choice
import sys


for size in range(1000,10000,1000):
	with open(str(size)+".txt","w") as f:
		for x in range(size):
			f.write(str(randint(0,2147483648))+"\n")


