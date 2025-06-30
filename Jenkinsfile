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
                    sh 'docker pull selenium/standalone-chrome:latest'
                    sh 'sh 'docker run --rm -v $PWD:/tests -w /tests maven:3.9.6-eclipse-temurin-17 bash ./run-tests.sh'
'
                }
            }
        }
    }
}
