
import random


n = [1000,10000,25000,50000,100000]
for i in range(len(n)):
    inputList = []
    m = random.randint(1,100000)
    for j in range(0,m):
        a = random.randint(1,100000)
        b = random.randint(a,100000)
        inputList.append([a,b])

    sortedInputList = sorted(inputList)

    f = open("input_"+str(n[i])+".txt","w")
    f.write(str(n[i])+" "+str(m)+"\n")
    for i in range(len(sortedInputList)):
        f.write(str(sortedInputList[i][0])+" "+str(sortedInputList[i][1])+"\n")
    f.close()