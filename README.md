SOAP webservice (od kódu k WSDL)

Projekt bol vytvorený v NetBeans IDE 8.1, Java JDK version 1.8.0_121

DB: MySQL 
Pre vytvorenie databázy je potrebné spustiť skript db.sql , ktorý vytvorí schému, tabuľky, vloží do nich dáta a taktiež vytvorí používateľa na prístup k tejto databáze.

Server: Spúšťa sa pomocou triedy Server.java v priečinku AttendanceSOAP/src/main/java/m/attendancesoap/
Testovacia trieda (JUnit testy) pre server AJSWebService.java sa nachádza v priečinku  AttendanceSOAP/src/test/java/m/attendancesoap

Klient: Vygenerovaný klient sa nachádza v priečinku AttendanceSOAP/src/main/java/m/attendancesoapclient/
Testovacia trieda (JUnit testy) pre klienta AJSWebService.java sa nachádza v priečinku  AttendanceSOAP/src/test/java/m/attendancesoapclient
