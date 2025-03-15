# Bazarbozorg Project

A Spring Boot web application that uses TypeList Generator for code generation during the pre-compile phase.

## Features

- RESTful API endpoints with OpenAPI/Swagger documentation
- GraphQL support for flexible data querying
- TypeList Generator integration for enum class generation from Excel files
- MongoDB and JPA/Hibernate support
- Structured logging with Logback and Logstash encoder

## Getting Started

### Prerequisites

- Java 17 or higher
- Gradle 8.10+
- Git
- TypeList Generator (published to local Maven repository)
- MongoDB (optional, depending on your configuration)

### Setup and Build

1. Clone the repository:

```bash
git clone https://github.com/bazarbozorg/your-repo-name.git
cd your-repo-name
```

2. Make sure TypeList Generator is published to your local Maven repository:

```bash
# From the TypeList Generator project
./gradlew publishToMavenLocal
```

3. Build the application:

```bash
./gradlew clean build
```

4. Run the application:

```bash
./gradlew bootRun
```

## API Documentation

The application includes Swagger/OpenAPI for API documentation:

- Swagger UI: http://localhost:8081/swagger-ui.html
- OpenAPI JSON: http://localhost:8081/api-docs
- OpenAPI YAML: http://localhost:8081/api-docs.yaml

## GraphQL Support

GraphQL is available at:

- GraphQL endpoint: http://localhost:8081/graphql
- GraphiQL UI (if enabled): http://localhost:8081/graphiql

## Type Lists

The TypeList Generator uses Excel sheets (XLSX files) as input. These sheets should contain structured type definitions
with columns like:

- code - The enum constant name
- publicId - Unique identifier (typically UUID)
- retired - Boolean flag indicating if the type is obsolete

Place Excel files in `domain-types-xlsx/` directory and they will be automatically converted to TypeList enums during
the compilation process.

## Project Structure

```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bazarbozorg/
│   │   │           ├── config/          # Configuration classes
│   │   │           ├── controller/      # REST controllers
│   │   │           ├── entity/          # JPA/MongoDB entities
│   │   │           ├── model/           # Data models
│   │   │           ├── repository/      # Data repositories
│   │   │           └── service/         # Business logic
│   │   └── resources/
│   │       ├── domain-types-xlsx/       # Place Excel files here
│   │       ├── application.yml          # Application configuration
│   │       └── logback-spring.xml       # Logging configuration
│   └── test/
│       └── java/
│           └── com/
│               └── bazarbozorg/         # Test classes
├── build/
│   └── generated-sources/
│       └── typelists/                   # Generated TypeList classes
└── ...
```

## Deployment

### Building WAR files

For embedded container deployment:

```bash
./gradlew bootWar
```

For external servlet container deployment:

```bash
./gradlew war
```

## Common Git Commands

### Basic Git Workflow

```bash
# Check status
git status

# Update your local repository
git pull

# Stage all changes
git add .

# Commit with message
git commit -m "Implemented feature X"

# Push to remote repository
git push
```

### Branch Management

```bash
# Create a new branch
git checkout -b feature/new-feature

# Switch to an existing branch
git checkout develop

# List all branches
git branch -a
```

## Common Gradle Commands

### Build & Compile

```bash
# Build the project
./gradlew build

# Clean build
./gradlew clean build

# Compile only (will trigger TypeList generation)
./gradlew compileJava
```

### TypeList Generator Tasks

```bash
# Generate TypeList classes
./gradlew generateTypeLists

# Execute TypeList generator directly
./gradlew executeTypeListGenerator
```

### Application Specific

```bash
# Run the application
./gradlew bootRun

# Run with specific profile
./gradlew bootRun --args='--spring.profiles.active=dev'
```

## IntelliJ IDEA Tips

- Refresh Gradle project after making changes to build.gradle
- Mark build/generated-sources/typelists as a Generated Sources Root
- Use Build > Rebuild Project to trigger the TypeList generation

## Troubleshooting

### MongoDB Connection Issues

If you encounter MongoDB connection problems:

1. Verify MongoDB is running on localhost:27017
2. Check your MongoDB credentials if authentication is enabled
3. Review the application.yml MongoDB configuration
4. Look for MongoDB-related errors in the application logs

### TypeList Generator Issues

If you encounter problems with the TypeList generator:

1. Ensure the TypeList Generator project is properly published to your local Maven repository
2. Check that your Excel files are in the correct format
3. Verify file paths in your application.yml configuration

### OpenAPI/Swagger Not Working

If Swagger UI is not accessible:

1. Verify the application is running correctly
2. Check that the port is correct (8081 by default)
3. Ensure the paths in springdoc configuration match your access URLs