// pipeline {
//     agent any
//
//     stages {
//         stage('Clone Repo') {
//             steps {
//                 git branch: 'main', url: 'https://github.com/Srinivasg457/WORK-ROOM_LIVE_WEB_AUTOMATION.git'
//             }
//         }
//
//         stage('Run in Docker') {
//             steps {
//                 script {
//                     // Pull latest image
//                     sh 'docker pull selenium/standalone-chrome:latest'
//
//                     // Check if port 4444 is used
//                     sh '''
//                         echo "Checking for existing container using port 4444..."
//                         PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
//                         if [ ! -z "$PORT_IN_USE" ]; then
//                             echo "Stopping and removing container $PORT_IN_USE using port 4444..."
//                             docker stop $PORT_IN_USE || true
//                             docker rm $PORT_IN_USE || true
//                             sleep 2
//                         fi
//                     '''
//
//                     // Clean up old selenium-chrome container if any
//                     sh '''
//                         if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
//                             echo "Cleaning up old selenium-chrome container..."
//                             docker stop selenium-chrome || true
//                             docker rm selenium-chrome || true
//                         fi
//                     '''
//
//                     // Start Selenium
//                     sh '''
//                         echo "Starting selenium-chrome container..."
//                         docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
//                     '''
//
//                     // Wait for Selenium
//                     sh '''
//                         echo "Waiting for Selenium to become ready..."
//                         for i in {1..10}; do
//                             if curl -s http://localhost:4444/status | grep -q "ready"; then
//                                 echo "Selenium is ready."
//                                 break
//                             else
//                                 echo "Waiting..."
//                                 sleep 5
//                             fi
//                         done
//                     '''
//
//                     // Run Maven test
//                     sh '''
//                         echo "Running tests inside Maven container..."
//                         docker run --rm \
//                             -v $PWD:/tests \
//                             -w /tests \
//                             --network=host \
//                             maven:3.9.6-eclipse-temurin-17 mvn clean test
//                     '''
//
//                     // Stop Selenium container
//                     sh 'docker stop selenium-chrome || true'
//                 }
//             }
//         }
//     }
//
//     post {
//         always {
//             script {
//                 sh '''
//                     echo "Final cleanup..."
//                     docker rm -f selenium-chrome || true
//                 '''
//             }
//             archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//         }
//     }
// }



/////   here we are going to send email

pipeline {
    agent any

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/Srinivasg457/WORK-ROOM_LIVE_WEB_AUTOMATION.git'
            }
        }

        stage('Run in Docker') {
            steps {
                script {
                    sh 'docker pull selenium/standalone-chrome:latest'

                    sh '''
                        echo "Checking for existing container using port 4444..."
                        PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
                        if [ ! -z "$PORT_IN_USE" ]; then
                            echo "Stopping and removing container $PORT_IN_USE..."
                            docker stop $PORT_IN_USE || true
                            docker rm $PORT_IN_USE || true
                            sleep 2
                        fi
                    '''

                    sh '''
                        if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
                            echo "Cleaning up old selenium-chrome container..."
                            docker stop selenium-chrome || true
                            docker rm selenium-chrome || true
                        fi
                    '''

                    sh '''
                        echo "Starting selenium-chrome container..."
                        docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
                    '''

                    sh '''
                        echo "Waiting for Selenium to become ready..."
                        for i in {1..10}; do
                            if curl -s http://localhost:4444/status | grep -q "ready"; then
                                echo "Selenium is ready."
                                break
                            else
                                echo "Waiting..."
                                sleep 5
                            fi
                        done
                    '''

                    sh '''
                        echo "Running tests inside Maven container..."
                        docker run --rm \
                            -v $PWD:/tests \
                            -w /tests \
                            --network=host \
                            maven:3.9.6-eclipse-temurin-17 mvn clean test
                    '''

                    sh 'docker stop selenium-chrome || true'
                }
            }
        }
    }

    post {
        always {
            script {
                sh '''
                    echo "Final cleanup..."
                    docker rm -f selenium-chrome || true
                '''
            }
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
        }

        success {
            emailext(
                to: 'srinivas.g@limitscale.io',
                subject: "✅ SUCCESS: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
                body: """<p>The Jenkins job has succeeded.</p>
                         <p>Project: ${env.JOB_NAME}</p>
                         <p>Build Number: ${env.BUILD_NUMBER}</p>
                         <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
                mimeType: 'text/html'
            )
        }

        failure {
            emailext(
                to: 'srinivas.g@limitscale.io',
                subject: "❌ FAILURE: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
                body: """<p>The Jenkins job has failed.</p>
                         <p>Project: ${env.JOB_NAME}</p>
                         <p>Build Number: ${env.BUILD_NUMBER}</p>
                         <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
                mimeType: 'text/html'
            )
        }
    }
}
