default:
	python3 generateInput.py
run1:
	javac Task1.java
	java Task1
run2:
	javac Task2.java
	java Task2
run3:
	javac Task3.java
	java Task3
run4:
	javac Task4.java
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