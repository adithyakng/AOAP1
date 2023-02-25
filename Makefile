default:
	python3 generateInput.py
	javac Task1.java
	javac Task2.java
	javac Task3.java
	javac Task4.java
run1:
	java Task1
run2:
	java Task2
run3:
	java Task3
run4:
	java Task4
experiment:
	javac CompareTasks.java
	java CompareTasks

clean:
	rm -rf input_1000.txt
	rm -rf input_10000.txt
	rm -rf input_25000.txt
	rm -rf input_50000.txt
	rm -rf input_99999.txt