# Build Instructions

This project uses Maven for building. You have two options:

## Option 1: Using Maven Wrapper (Recommended)

Maven Wrapper automatically downloads and uses the correct version of Maven.

### On Windows:
```bash
mvnw.cmd clean package
```

### On macOS/Linux:
```bash
./mvnw clean package
```

Then run the application:
```bash
java -jar target/acn-bootcamp-app-1.0.0.jar
```

## Option 2: Using Installed Maven

First, ensure Maven 3.8+ is installed on your system:

```bash
mvn -version
```

If not installed:

### Windows (with Chocolatey):
```bash
choco install maven
```

### Windows (with Winget):
```bash
winget install Maven.Maven
```

### macOS (with Homebrew):
```bash
brew install maven
```

### Linux (Ubuntu/Debian):
```bash
sudo apt-get install maven
```

Then build:
```bash
mvn clean package
```

## Available Build Commands

- `mvnw clean package` - Clean and build the project
- `mvnw spring-boot:run` - Run the application directly
- `mvnw clean install` - Build and install to local repository
- `mvnw test` - Run tests

## CI/CD Deployment

The GitHub Actions workflow (`.github/workflows/deploy.yml`) automatically:
1. Uses the Maven Wrapper to build
2. Extracts deployment info
3. Deploys to self-hosted runner
4. Starts the application with deployment details

No manual Maven installation is required on the runner when using the Maven Wrapper.
