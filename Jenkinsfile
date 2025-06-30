pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/your-username/your-repo.git'
            }
        }

        stage('Run in Docker') {
            steps {
                script {
                    sh 'docker pull selenium/standalone-chrome:latest'
                    sh 'docker run --rm -v $PWD:/tests -w /tests selenium/standalone-chrome:latest ./run-tests.sh'
                }
            }
        }
    }
}
