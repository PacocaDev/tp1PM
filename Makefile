all:
	javac -sourcepath src -d bin src/br/ufmg/dcc/pm/parking/Parking.java

clean:
	rm -rf bin/*

run:
	java -classpath bin br.ufmg.dcc.pm.parking.Parking
