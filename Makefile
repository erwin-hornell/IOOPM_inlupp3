all:
	javac -d classes -sourcepath src src/org/ioopm/calculator/Calculator.java

test:
	java -cp classes org.ioopm.calctests.CalculatorTests

run:
	java -cp classes org.ioopm.calculator.Calculator

clean:
	rm -rf classes