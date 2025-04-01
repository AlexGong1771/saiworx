# Spring Boot-Projekt-Setup-Anleitung

## Voraussetzungen
Stellen Sie vor der Projekteinrichtung sicher, dass Folgendes installiert ist:
- **Java 21** (oder die für das Projekt erforderliche Version)
- **Maven** (Apache Maven 3.8.1 oder höher)
- **Git**
- **Postman/Swagger-UI**

## Repository klonen
Im Terminalfenster:
git clone https://github.com/AlexGong1771/saiworx.git
cd saiworx

## Anwendung ausführen

mvn spring-boot:run

## Swagger-API-Dokumentation
Sobald die Spring Boot-Anwendung läuft, können Sie auf die Swagger-UI mit API-Dokumentation unter folgender Adresse zugreifen:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Tests ausführen

mvn test

## Postman für API verwenden Testen
1. Öffnen Sie Postman.
2. Erstellen Sie eine neue Anfrage.
3. Verwenden Sie die Basis-URL: „http://localhost:8080/api/“.
4. Testen Sie Endpunkte (GET, POST, DELETE usw.) mit JSON-Nutzdaten.

**H2-Datenbanktabelle nicht gefunden:** Stellen Sie sicher, dass „spring.datasource.url=jdbc:h2:mem:gongdb“ in „application.properties“ festgelegt ist.
