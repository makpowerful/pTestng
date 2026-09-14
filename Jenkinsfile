pipeline {
    agent any

    tools {
        // This must match the name of the Maven installation configured in your Jenkins Global Tool Configuration
        maven 'Maven_3.9.4' 
    }

    stages {
        stage('Clean & Compile') {
            steps {
                echo 'Cleaning old build targets and compiling source code...'
                bat 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                echo 'Launching TestNG automation suite via Maven...'
                // 'bat' is used for Windows command prompt lines
                bat 'mvn test -DsuiteXmlFile=testng.xml' 
            }
        }
    }

    post {
        always {
            echo 'Archiving execution test reports...'
            // Safeguards your Extent Report inside the Jenkins build artifacts
            archiveArtifacts artifacts: 'target/ExtentReport.html', allowEmptyArchive: true
        }
        
        success {
            echo 'Automation build completed flawlessly!'
        }

        failure {
            echo 'Test failures or compilation issues detected. Please review logs.'
        }
    }
}
