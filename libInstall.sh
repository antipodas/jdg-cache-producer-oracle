#!/bin/sh
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2.0 -Dpackaging=jar -Dfile=./lib/ojdbc7.jar -DgeneratePom=true

echo
echo " NOW ADD THIS TO YOUR PROJECT POM FILE"
echo
echo "    <dependency>"
echo "        <groupId>com.oracle</groupId>"
echo "        <artifactId>ojdbc7</artifactId>"
echo "        <version>12.1.0.2.0</version>"
echo "    </dependency>"
echo
