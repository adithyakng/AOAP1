
import random


maxValue = 1000
# f = open("input1.txt", "w")

inputList = []

for i in range(0,500000):
    a = random.randint(0,499999)
    b = random.randint(a+1,500000)
    inputList.append([a,b])

sortedInputList = sorted(inputList)

f = open("input_500000.txt","w")
for i in range(len(sortedInputList)):
    f.write(str(sortedInputList[i][0])+" "+str(sortedInputList[i][1])+"\n")

f.close()