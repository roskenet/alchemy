all: first.o
	ld first.o -o first

clean:
	rm *.o first

first.o: first.s
	as first.s -o first.o

run: all
	./first 
