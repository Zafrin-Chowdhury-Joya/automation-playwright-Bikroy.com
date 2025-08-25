# Sharp Archive Project Automation

## 🚀 Project Overview
Sharp Archive is a comprehensive digital archiving solution designed to collect, organize, and preserve various types of social media accounts for future reference, legal compliance, research, and digital asset management. The project aims to support individuals, organizations, and researchers in securely storing and accessing historical content from platforms like Facebook, Instagram, X (formerly Twitter), LinkedIn, YouTube, and more.

By enabling automated and manual data capture, Sharp Archive ensures that public posts, multimedia content, user interactions, and account metadata are safely stored in a structured, searchable, and exportable format. The system supports advanced filtering, timeline views, and user permission levels, ensuring both usability and security.

## 📋 Project Structure
```
playwright-testng-maven-updated/
├── .gitignore
├── pom.xml
├── testng.xml
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/automation/
│   │   │       ├── base/
│   │   │       ├── components/
│   │   │       ├── listeners/
│   │   │       ├── pages/
│   │   │       ├── reports/
│   │   │       └── utils/
│   │   └── resources/
│   │       ├── config.properties
│   │       └── testdata.json
│   │
│   └── test/
│       └── java/
│           └── com/automation/tests/
│
├── reports/
│   └── playwright/
│       ├── html/
│       ├── videos/
│       └── trace.zip
│
└── target/
    ├── classes/
    ├── test-classes/
    └── surefire-reports/
```


### Common Troubleshooting
- Ensure you're in the project root directory
- Check script permissions
- Verify Java and Maven are installed
- Review console output for any errors

### Example Workflow
```bash
# Clone the repository
git clone https://github.com/hudacse6/sa-qa-automation.git

# Navigate to project directory
cd sa-qa-automation.git

```

## 🛠 Prerequisites

### Common Requirements
- Java Development Kit (JDK) 22.0.2 or higher
- Maven 3.9.9 or higher
- Git (optional)

### 🖥 Operating System Specific Setup

#### Windows
1. Install Prerequisites:
   - Download and install [JDK 22](https://www.oracle.com/java/technologies/downloads/)
   - Download and install [Maven](https://maven.apache.org/download.cgi)
   - Add Java and Maven to system PATH

2. Setup and Run:
```Powersell
# Clone the repository
git clone https://github.com/hudacse6/sa-qa-automation.git

# Navigate to project directory
cd sa-qa-automation.git

```

#### macOS
1. Install Prerequisites:
   ```bash
   # Install Homebrew (if not installed)
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

   # Install Java and Maven
   brew install openjdk@22 maven
   ```

2. Setup and Run:
```bash
# Clone the repository
git clone https://github.com/hudacse6/sa-qa-automation.git

# Navigate to project directory
cd sa-qa-automation.git

```

#### Kali Linux
1. Install Prerequisites:
   ```bash
   # Update package list
   sudo apt update

   # Install Java and Maven
   sudo apt install openjdk-22-jdk maven

   # Install additional dependencies
   sudo apt install git
   ```

2. Setup and Run:
```bash
# Clone the repository
git clone https://github.com/hudacse6/sa-qa-automation.git

# Navigate to project directory
cd sa-qa-automation.git

```


## 📊 Reporting
- Playwright Reports: `reports/playwright/html/report.html`
- Extent Reports: `reports/extent-reports/`
- Video Recordings: `reports/playwright/videos/`
- Trace Files: `reports/playwright/trace.zip`

## 🧪 Test Scenarios
- Login Validation
- Product Page Navigation
- User Authentication Flows

## 🔧 Technology Stack
- Automation Tool: Playwright 1.41.2
- Testing Framework: TestNG 7.8.0
- Build Tool: Maven
- Reporting: ExtentReports 5.1.1

## 🤝 Contributing
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📜 License
[Specify your license here]

## 📞 Contact
[Your contact information]

## 🆘 Troubleshooting
- Ensure all prerequisites are installed
- Check Maven and Java versions
- Verify network connectivity
- Review error logs in `target/surefire-reports/`
