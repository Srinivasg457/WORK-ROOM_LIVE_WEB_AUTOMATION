stage('Run in Docker') {
    steps {
        script {
            // Pull latest image
            sh 'docker pull selenium/standalone-chrome:latest'

            // Check if any container is using port 4444 and kill it
            sh '''
                echo "Checking for existing container using port 4444..."
                PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
                if [ ! -z "$PORT_IN_USE" ]; then
                    echo "Port 4444 is in use by container $PORT_IN_USE. Stopping and removing..."
                    docker stop $PORT_IN_USE || true
                    docker rm $PORT_IN_USE || true
                    sleep 2
                fi
            '''

            // Clean up old selenium-chrome container if it exists
            sh '''
                if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
                    echo "Cleaning up old selenium-chrome container..."
                    docker stop selenium-chrome || true
                    docker rm selenium-chrome || true
                    sleep 2
                fi
            '''

            // Start Selenium
            sh '''
                echo "Starting new selenium-chrome container..."
                docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
            '''

            // Wait for Selenium to be ready
            sh '''
                echo "Waiting for Selenium to become ready..."
                for i in {1..10}; do
                    if curl -s http://localhost:4444/status | grep -q "ready"; then
                        echo "Selenium is ready."
                        break
                    else
                        echo "Waiting..."
                        sleep 3
                    fi
                done
            '''

            // Run the test
            sh 'docker run --rm -v $PWD:/tests -w /tests maven:3.9.6-eclipse-temurin-17 ./run-tests.sh'

            // Stop container (in post actions too just in case)
            sh 'docker stop selenium-chrome || true'
        }
    }
    post {
        always {
            sh '''
                echo "Cleaning up selenium-chrome container (post-action)..."
                docker rm -f selenium-chrome || true
            '''
            archiveArtifacts artifacts: '**/target/*.xml', allowEmptyArchive: true
        }
    }
}
