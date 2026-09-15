pipeline {
    agent any

    tools {
        maven 'Maven' 
    }

    // 1. Defines the dropdown parameter for the browser selection
    parameters {
        choice(
            name: 'BROWSER', 
            choices: ['Chrome', 'Firefox', 'Edge'], 
            description: 'Select the browser for test execution'
        )
        booleanParam(
            name: 'HEADLESS', 
            defaultValue: true, 
            description: 'Check this box to run the browser in Headless Mode'
        )
    }

    // 2. Polls Git repository every 5 minutes for changes. 
    // If changes are found, it triggers the build automatically.
    triggers {
        pollSCM('*/5 * * * *')
    }

    environment {
        // Captures how the build was started (e.g., 'SCMTrigger' if triggered by a Git change)
        CAUSE = "${currentBuild.getBuildCauses()[0]._class}"
    }

    stages {
        stage('Clean & Compile') {
            steps {
                echo 'Cleaning old build targets and compiling source code...'
                bat 'mvn clean compile'
            }
        }

        // This stage runs ONLY during normal manual executions
 		stage('Run Automation Tests') {
            when {
                expression { !CAUSE.contains('SCMTrigger') }
            }
            steps {
                echo "Launching regular TestNG suite on browser: ${params.BROWSER} (Headless: ${params.HEADLESS})..."
                // Pass the headless parameter choice down to Maven
                bat "mvn test -DsuiteXmlFile=testng.xml -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS}" 
            }
        }

        // 3. This stage runs ONLY if Jenkins detected a Git change (SCM Trigger)
        stage('Run Smoke Tests') {
            when {
                expression { CAUSE.contains('SCMTrigger') }
            }
            steps {
				echo "Git change detected! Launching Smoke Test suite on browser: ${params.BROWSER} (Headless: ${params.HEADLESS})..."
                // SCM automatic triggers will respect whatever the default parameter is set to (true)
                bat "mvn test -DsuiteXmlFile=smoke-testng.xml -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS}" 
            }
        }
    }

    post {
        always {
            echo 'Archiving execution test reports...'
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
