# GitHub Runner Setup Script

This directory contains resources for setting up the application on a self-hosted GitHub runner.

## Setup Steps

### 1. Install Java 17+

**Windows (with Chocolatey):**
```powershell
choco install openjdk17
```

**Windows (with Winget):**
```powershell
winget install Oracle.JDK.17
```

**macOS (with Homebrew):**
```bash
brew install openjdk@17
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt-get install openjdk-17-jdk
```

### 2. Verify Java Installation

```bash
java -version
```

Should output Java 17 or higher.

### 3. Configure GitHub Runner

1. Go to your repository on GitHub
2. Settings → Actions → Runners → New self-hosted runner
3. Follow the instructions to:
   - Download the runner
   - Extract it to a location (e.g., `~/github-runner`)
   - Configure it with your GitHub token
   - Start the runner service

**On Windows:**
```powershell
# Download and extract runner
# Then configure
.\config.cmd --url https://github.com/YOUR_ORG/YOUR_REPO --token YOUR_TOKEN

# Start the runner
.\run.cmd
```

**On macOS/Linux:**
```bash
# Download and extract runner
# Then configure
./config.sh --url https://github.com/YOUR_ORG/YOUR_REPO --token YOUR_TOKEN

# Start the runner
./run.sh
```

### 4. Runner as a Service (Optional but Recommended)

**Windows:**
```powershell
.\config.cmd --url https://github.com/YOUR_ORG/YOUR_REPO --token YOUR_TOKEN --svc
.\svc.cmd install
.\svc.cmd start
```

**macOS/Linux:**
```bash
./config.sh --url https://github.com/YOUR_ORG/YOUR_REPO --token YOUR_TOKEN --svc
sudo ./svc.sh install
sudo ./svc.sh start
```

## Environment Variables (Optional)

You can set environment variables on the runner to customize deployment:

**Windows PowerShell:**
```powershell
[Environment]::SetEnvironmentVariable("SERVER_PORT", "3100", "Machine")
```

**Linux/macOS (in ~/.bashrc or ~/.zshrc):**
```bash
export SERVER_PORT=3100
```

These will be available to the deployed application.

## Troubleshooting

### Runner doesn't show as online

- Check runner logs: `tail ~/.actions-runner/_diag/Runner_*.log`
- Verify network connectivity
- Check GitHub token is still valid

### Build fails on runner

- SSH into runner and manually run: `cd ~/repo-path && mvnw clean package`
- Check Java version: `java -version`
- Check disk space: `df -h`

### Application won't start on port 3100

- Check if port is already in use: 
  - Windows: `netstat -ano | findstr :3100`
  - Linux/macOS: `lsof -i :3100`
- Kill existing process and retry
- Check firewall settings
