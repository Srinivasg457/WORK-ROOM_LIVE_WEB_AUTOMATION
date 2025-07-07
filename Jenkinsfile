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
// //
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
//                     sh 'docker pull selenium/standalone-chrome:latest'
//
//                     sh '''
//                         echo "Checking for existing container using port 4444..."
//                         PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
//                         if [ ! -z "$PORT_IN_USE" ]; then
//                             echo "Stopping and removing container $PORT_IN_USE..."
//                             docker stop $PORT_IN_USE || true
//                             docker rm $PORT_IN_USE || true
//                             sleep 2
//                         fi
//                     '''
//
//                     sh '''
//                         if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
//                             echo "Cleaning up old selenium-chrome container..."
//                             docker stop selenium-chrome || true
//                             docker rm selenium-chrome || true
//                         fi
//                     '''
//
//                     sh '''
//                         echo "Starting selenium-chrome container..."
//                         docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
//                     '''
//
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
//                     sh '''
//                         echo "Running tests inside Maven container..."
//                         docker run --rm \
//                             -v $PWD:/tests \
//                             -w /tests \
//                             --network=host \
//                             maven:3.9.6-eclipse-temurin-17 mvn clean test
//                     '''
//
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
//
//         success {
//             emailext(
//                 to: 'srinivasg457@gmail.com',
//                 subject: "✅ SUCCESS: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
//                 body: """<p>The Jenkins job has succeeded.</p>
//                          <p>Project: ${env.JOB_NAME}</p>
//                          <p>Build Number: ${env.BUILD_NUMBER}</p>
//                          <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
//                 mimeType: 'text/html'
//             )
//         }
//
//         failure {
//             emailext(
//                 to: 'shreelimitscale@gmail.com',
//                 subject: "❌ FAILURE: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
//                 body: """<p>The Jenkins job has failed.</p>
//                          <p>Project: ${env.JOB_NAME}</p>
//                          <p>Build Number: ${env.BUILD_NUMBER}</p>
//                          <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
//                 mimeType: 'text/html'
//             )
//         }
//     }
// }



pipeline {
    agent any

    environment {
        // Store sensitive credentials in Jenkins credentials store
        GMAIL_APP_PASSWORD = credentials('gmail-app-password')
        SMTP_SERVER = 'smtp.gmail.com'
        SMTP_PORT = '465'
    }

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Srinivasg457/WORK-ROOM_LIVE_WEB_AUTOMATION.git'
            }
        }

        stage('Setup Selenium') {
            steps {
                script {
                    // Cleanup any existing containers
                    sh '''
                        docker rm -f selenium-chrome || true
                        docker network create test-network || true
                    '''

                    // Start Selenium in a dedicated network
                    sh '''
                        docker run -d \
                          --name selenium-chrome \
                          --network test-network \
                          -p 4444:4444 \
                          selenium/standalone-chrome:latest
                    '''

                    // Wait for Selenium to be ready
                    sh '''
                        for i in {1..10}; do
                            if curl -s http://localhost:4444/status | grep -q "ready"; then
                                echo "Selenium ready"
                                break
                            fi
                            sleep 5
                        done
                    '''
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run tests with improved error handling
                    try {
                        sh '''
                            docker run --rm \
                              -v $PWD:/tests \
                              -w /tests \
                              --network test-network \
                              -e "MAVEN_OPTS=-Dsurefire.rerunFailingTestsCount=2" \
                              maven:3.9.6-eclipse-temurin-17 \
                              mvn clean test \
                              -DskipTests=false \
                              -Dmaven.test.failure.ignore=true \
                              -Dsurefire.skipAfterFailureCount=3
                        '''
                    } catch (Exception e) {
                        echo "Tests failed: ${e.toString()}"
                        // Continue pipeline even if tests fail
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                // Capture test results
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/surefire-reports/*.*', allowEmptyArchive: true

                // Cleanup containers
                sh 'docker rm -f selenium-chrome || true'
            }
        }

        success {
            script {
                // Success email with SMTP explicit configuration
                emailext(
                    to: 'srinivasg457@gmail.com',
                    subject: "SUCCESS: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                    body: readTrusted('email-success.html'),
                    mimeType: 'text/html',
                    replyTo: 'no-reply@yourdomain.com',
                    smtp: [
                        host: env.SMTP_SERVER,
                        port: env.SMTP_PORT,
                        auth: true,
                        user: 'your.email@gmail.com',
                        password: env.GMAIL_APP_PASSWORD,
                        ssl: true
                    ]
                )
            }
        }

        failure {
            script {
                // Failure email with multiple fallback methods
                try {
                    emailext(
                        to: 'shreelimitscale@gmail.com',
                        subject: "FAILURE: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                        body: readTrusted('email-failure.html'),
                        mimeType: 'text/html',
                        smtp: [
                            host: env.SMTP_SERVER,
                            port: env.SMTP_PORT,
                            auth: true,
                            user: 'your.email@gmail.com',
                            password: env.GMAIL_APP_PASSWORD,
                            ssl: true
                        ]
                    )
                } catch (Exception e) {
                    echo "Primary email failed, trying fallback method"
                    // Fallback using mailx
                    sh """
                        echo "Build Failed: ${env.BUILD_URL}" | \
                        mailx -s "FAILURE: ${env.JOB_NAME}" \
                        -S smtp="${env.SMTP_SERVER}:${env.SMTP_PORT}" \
                        -S smtp-use-starttls \
                        -S smtp-auth=login \
                        -S smtp-auth-user="your.email@gmail.com" \
                        -S smtp-auth-password="${env.GMAIL_APP_PASSWORD}" \
                        -S ssl-verify=ignore \
                        shreelimitscale@gmail.com
                    """
                }
            }
        }
    }
}