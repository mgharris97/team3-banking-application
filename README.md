# Team 3
- **Edgaras Daugevičius**
- **Karyna Yatsenko**
- **Matthew Harris**
- **Raivis Priede**
- 
# ACN Bootcamp - Spring Boot + Thymeleaf Hello World

A simple Spring Boot application with Thymeleaf templating engine, deployable via GitHub Actions to a self-hosted runner.

## Features

✅ Spring Boot 3.2.3 with Thymeleaf  
✅ Configurable port via environment variables (default: 3100)  
✅ Deployment information displayed in footer (branch, commit, timestamp)  
✅ GitHub Actions workflow for automated deployment  
✅ Self-hosted runner support  
✅ Modern responsive UI  

## Prerequisites

- **Java 17+** installed
- **Maven 3.8+** installed
- **Git** installed

### For GitHub Actions Deployment

- Self-hosted GitHub runner configured
- Runner must have Java 17+ and Maven 3.8+ installed

## Local Development

### Build the application

```bash
mvn clean package
```

### Run the application

```bash
java -jar target/acn-bootcamp-app-1.0.0.jar
```

The application will start on port 3100 by default.

### Custom Port

```bash
java -jar target/acn-bootcamp-app-1.0.0.jar --server.port=8080
```

Or via environment variable:

```bash
export SERVER_PORT=8080
java -jar target/acn-bootcamp-app-1.0.0.jar
```

### Development with hot reload

```bash
mvn spring-boot:run
```

## Environment Variables

The application supports the following environment variables:

| Variable | Description | Default |
|----------|-------------|---------|
| `SERVER_PORT` | Port the application listens on | `3100` |
| `DEPLOYMENT_BRANCH` | Git branch for deployment info | `unknown` |
| `DEPLOYMENT_COMMIT` | Git commit hash for deployment info | `unknown` |
| `DEPLOYMENT_TIMESTAMP` | Deployment timestamp for deployment info | `unknown` |

## Deployment

### GitHub Actions Workflow

The repository includes a GitHub Actions workflow (`.github/workflows/deploy.yml`) that:

1. Triggers on pushes to `main` or `develop` branches
2. Builds the application with Maven
3. Extracts deployment information (branch, commit, timestamp)
4. Deploys to a self-hosted runner
5. Starts the application with deployment info injected

### Setting up a Self-Hosted Runner

1. Go to your GitHub repository → Settings → Actions → Runners
2. Click "New self-hosted runner"
3. Follow the instructions to configure the runner on your machine
4. Ensure the runner has Java 17+ and Maven 3.8+ installed
5. Push to `main` or `develop` branch to trigger deployment

### Manual Deployment

To manually deploy on your self-hosted runner machine:

```bash
# Clone/pull the repository
git clone <repo-url>
cd acn-bootcamp-example-project

# Get deployment info
BRANCH=$(git rev-parse --abbrev-ref HEAD)
COMMIT=$(git rev-parse --short HEAD)
TIMESTAMP=$(date -u +'%Y-%m-%d %H:%M:%S UTC')

# Build
mvn clean package

# Stop existing app (if running)
kill $(lsof -ti:3100) || true

# Start with environment variables
DEPLOYMENT_BRANCH=$BRANCH \
DEPLOYMENT_COMMIT=$COMMIT \
DEPLOYMENT_TIMESTAMP=$TIMESTAMP \
java -jar target/acn-bootcamp-app-1.0.0.jar
```

## Project Structure

```
acn-bootcamp-example-project/
├── src/
│   └── main/
│       ├── java/com/example/acnbootcamp/
│       │   ├── Application.java              # Main Spring Boot application
│       │   ├── controller/
│       │   │   └── HelloController.java      # Request handler
│       │   └── model/
│       │       └── DeploymentInfo.java       # Deployment info model
│       └── resources/
│           ├── application.properties        # Application configuration
│           ├── templates/
│           │   └── index.html               # Thymeleaf template
│           └── static/css/
│               └── style.css                # Stylesheet
├── .github/workflows/
│   └── deploy.yml                           # GitHub Actions workflow
├── pom.xml                                  # Maven configuration
└── README.md                                # This file
```

## Accessing the Application

Once deployed, access the application at:

```
http://localhost:3100
```

The footer displays:
- **Branch**: The Git branch from which the deployment occurred
- **Commit**: The short commit hash
- **Timestamp**: The deployment timestamp in UTC

## Architecture

### Components

1. **Application.java**: Spring Boot entry point
2. **HelloController.java**: Handles HTTP requests and injects deployment info
3. **DeploymentInfo.java**: Model for deployment metadata
4. **index.html**: Thymeleaf template rendering the UI with footer
5. **style.css**: Responsive styling with gradient background

### Data Flow

```
Request → HelloController → DeploymentInfo Model → Thymeleaf Template → HTML Response
```

The deployment info is injected from environment variables at runtime:
- `DEPLOYMENT_BRANCH` → application.properties → Controller → Template
- `DEPLOYMENT_COMMIT` → application.properties → Controller → Template  
- `DEPLOYMENT_TIMESTAMP` → application.properties → Controller → Template

## Building from Scratch

The application uses Maven for dependency management:

- **spring-boot-starter-web**: Web framework
- **spring-boot-starter-thymeleaf**: Template engine
- **spring-boot-devtools**: Development tools
- **spring-boot-starter-test**: Testing framework

All dependencies are automatically downloaded during the first build.

## Troubleshooting

### Application won't start

1. Check if port 3100 is already in use: `lsof -i :3100`
2. Use a different port: `SERVER_PORT=8080 java -jar target/acn-bootcamp-app-1.0.0.jar`
3. Check logs for errors

### GitHub Actions deployment fails

1. Verify self-hosted runner is online and connected
2. Check runner logs: `tail ~/.actions-runner/_diag/Runner_*.log`
3. Ensure Java 17+ is installed on runner: `java -version`
4. Ensure Maven 3.8+ is installed on runner: `mvn -version`

### Deployment info shows "unknown"

Ensure environment variables are set when starting the application:

```bash
DEPLOYMENT_BRANCH=main \
DEPLOYMENT_COMMIT=abc1234 \
DEPLOYMENT_TIMESTAMP="2026-04-16 12:00:00 UTC" \
java -jar target/acn-bootcamp-app-1.0.0.jar
```

## License

MIT License
