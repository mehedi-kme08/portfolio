pipeline {

    // Runs directly on your Windows PC (the built-in Jenkins agent)
    agent any

    environment {
        // Override these at pipeline level if needed
        BASE_URL  = 'https://mhdhasan.netlify.app/'
        BROWSER   = 'chrome'
        HEADLESS  = 'true'
    }

    options {
        // Keep the last 10 builds, timeout the whole run after 30 min
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Cloning repository..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Compiling test classes..."
                dir('test-automation') {
                    bat 'gradlew.bat testClasses'
                }
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running Cucumber E2E tests against ${env.BASE_URL} ..."
                dir('test-automation') {
                    bat """
                        gradlew.bat cucumberTest ^
                            -Dbase.url=${env.BASE_URL} ^
                            -Dbrowser=${env.BROWSER} ^
                            -Dheadless=${env.HEADLESS}
                    """
                }
            }
        }
    }

    post {

        always {
            echo "Publishing Cucumber report..."
            cucumber(
                fileIncludePattern: '**/cucumber.json',
                jsonReportDirectory: 'test-automation/build/cucumber-reports',
                reportTitle: 'Portfolio E2E Test Report'
            )
        }

        success {
            echo "All tests passed!"
        }

        failure {
            echo "Tests failed — check the Cucumber report for screenshots."
        }

        cleanup {
            // Free workspace disk space after each run
            cleanWs()
        }
    }
}
