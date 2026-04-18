pipeline {

    agent any

    environment {
        BASE_URL = 'https://mhdhasan.netlify.app/'
        BROWSER  = 'chrome'
        HEADLESS = 'true'
    }

    options {
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
            echo "Archiving test reports..."

            // Publish JUnit XML so Jenkins shows pass/fail counts natively
            junit(
                testResults: 'test-automation/build/cucumber-reports/cucumber.xml',
                allowEmptyResults: true
            )

            // Archive the full HTML + JSON reports as downloadable artefacts
            archiveArtifacts(
                artifacts: 'test-automation/build/cucumber-reports/**',
                allowEmptyArchive: true,
                fingerprint: true
            )
        }

        success {
            echo "✅ All tests passed!"
        }

        failure {
            echo "❌ Tests failed — download cucumber-reports artefact for screenshots."
        }

        cleanup {
            cleanWs()
        }
    }
}
