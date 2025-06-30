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

                    // Start Selenium container in background
                    sh 'docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest'

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

                    // Run your tests inside Docker container
                    sh 'docker run --rm -v $PWD:/tests -w /tests maven:3.9.6-eclipse-temurin-17 ./run-tests.sh'

                    // Stop Selenium container
                    sh 'docker stop selenium-chrome || true'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.xml', allowEmptyArchive: true
        }
    }
}
