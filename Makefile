compile:
	@echo "Compiling source files"
	@javac -sourcepath ./src/ -d ./out/ ./src/AvajLauncher/*.java
	@echo "Source files compiled"
run:
	@java -classpath ./out AvajLauncher

clean:
	@rm -rf ./out/*