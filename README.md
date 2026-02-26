[![CI](https://github.com/ChrisClsg/recap-basics/actions/workflows/maven.yml/badge.svg)](https://github.com/ChrisClsg/recap-basics/actions/workflows/maven.yml)

# Recap project java basics course
This project implements a basic password validation based on a policy for valid passwords (see below).

## Password validation policy
The password must:
- have at least 8 characters
- have at least one digit (0–9)
- include both uppercase and lowercase letters
- not be on a list of common/weak passwords

## Build / Run / Tests

### Build & test (local)
```bash
mvn clean verify
```

### Package (JAR)
```bash
mvn package
```

Artifact output:
- `target/*.jar`

### Run
```bash
java -jar target/<artifact-name>.jar
```