pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/Srinivasg457/WORK-ROOM_LIVE_WEB_AUTOMATION.git'
            }
        }

        stage('Run in Docker') {
            steps {
                script {
                    // Pull Selenium image
                    sh 'docker pull selenium/standalone-chrome:latest'

                    // Stop and remove existing container if it exists
                    sh '''
                        if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
                            echo "Removing existing selenium-chrome container..."
                            docker stop selenium-chrome || true
                            docker rm selenium-chrome || true
                        fi
                    '''

                    // Start new Selenium container
                    sh '''
                        echo "Starting new selenium-chrome container..."
                        docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
                    '''

                    // Wait for Selenium to be ready
                    sh '''
                        for i in {1..10}; do
                            if curl -s http://localhost:4444/status | grep -q "ready"; then
                                echo "Selenium is ready"
                                break
                            else
                                echo "Waiting for Selenium to be ready..."
                                sleep 5
                            fi
                        done
                    '''

                    // Run tests using Maven inside a container
                    sh 'docker run --rm -v $PWD:/tests -w /tests maven:3.9.6-eclipse-temurin-17 ./run-tests.sh'
                }
            }
        }
    }

    post {
        always {
            // Archive test reports
            archiveArtifacts artifacts: '**/target/*.xml', allowEmptyArchive: true

            // Clean up selenium container if still exists
            script {
                sh '''
                    if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
                        echo "Cleaning up selenium-chrome container..."
                        docker stop selenium-chrome || true
                        docker rm selenium-chrome || true
                    fi
                '''
            }
        }
    }
}
