# Quick Start Guide

Get the application running in 5 minutes.

## Prerequisites

- Java 17+ ([Download](https://adoptopenjdk.net/))
- Git

## Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR_ORG/acn-bootcamp-example-project.git
cd acn-bootcamp-example-project
```

## Step 2: Build the Application

Using Maven Wrapper (no Maven installation required):

**Windows:**
```bash
mvnw.cmd clean package
```

**macOS/Linux:**
```bash
./mvnw clean package
```

Or with installed Maven:
```bash
mvn clean package
```

## Step 3: Run the Application

```bash
java -jar target/acn-bootcamp-app-1.0.0.jar
```

You should see:
```
Started Application in X.XXX seconds (process running for X.XXX)
```

## Step 4: Open in Browser

Open [http://localhost:3100](http://localhost:3100)

You should see:
- ✅ Welcome header
- ✅ Main content
- ✅ Footer with deployment info (currently showing "unknown")

## Customizing the Port

```bash
SERVER_PORT=8080 java -jar target/acn-bootcamp-app-1.0.0.jar
```

Then access: [http://localhost:8080](http://localhost:8080)

## With Deployment Info

```bash
set DEPLOYMENT_BRANCH=main
set DEPLOYMENT_COMMIT=abc1234
set DEPLOYMENT_TIMESTAMP=2026-04-16 12:00:00 UTC
java -jar target/acn-bootcamp-app-1.0.0.jar
```

Or on macOS/Linux:
```bash
DEPLOYMENT_BRANCH=main \
DEPLOYMENT_COMMIT=abc1234 \
DEPLOYMENT_TIMESTAMP="2026-04-16 12:00:00 UTC" \
java -jar target/acn-bootcamp-app-1.0.0.jar
```

## Stop the Application

Press `Ctrl+C` in the terminal

## Next Steps

- See [BUILD.md](BUILD.md) for detailed build instructions
- See [README.md](../README.md) for full documentation
- See [docs/RUNNER_SETUP.md](../docs/RUNNER_SETUP.md) for GitHub Runner setup
