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
        // Credentials and SMTP configuration
        GMAIL_APP_PASSWORD = credentials('gmail-app-password')
        SMTP_SERVER = 'smtp.gmail.com'
        SMTP_PORT = '465'
        SELENIUM_HOST = 'selenium-chrome'
        SELENIUM_URL = "http://${SELENIUM_HOST}:4444/wd/hub"
    }

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Srinivasg457/WORK-ROOM_LIVE_WEB_AUTOMATION.git'
            }
        }

        stage('Setup Selenium Grid') {
            steps {
                script {
                    // Cleanup existing containers and network
                    sh '''
                        docker rm -f selenium-chrome || true
                        docker network rm test-network || true
                        docker network create test-network
                    '''

                    // Start Selenium with proper configuration
                    sh """
                        docker run -d \
                          --name ${SELENIUM_HOST} \
                          --network test-network \
                          -p 4444:4444 \
                          -e SE_NODE_GRID_URL="http://${SELENIUM_HOST}:4444" \
                          -e SE_NODE_MAX_SESSIONS=5 \
                          -e SE_NODE_OVERRIDE_MAX_SESSIONS=true \
                          -v /dev/shm:/dev/shm \
                          --shm-size="2g" \
                          selenium/standalone-chrome:4.11.0
                    """

                    // Enhanced readiness check
                    sh '''
                        for i in {1..15}; do
                            if curl -s http://localhost:4444/wd/hub/status | jq -e '.value.ready' >/dev/null; then
                                echo "Selenium Grid is ready"
                                break
                            fi
                            echo "Waiting for Selenium to start (attempt ${i}/15)..."
                            sleep 5
                        done
                    '''
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run tests with comprehensive configuration
                    try {
                        sh """
                            docker run --rm \
                              -v $PWD:/tests \
                              -w /tests \
                              --network test-network \
                              -e SELENIUM_REMOTE_URL="${SELENIUM_URL}" \
                              -e SELENIUM_BROWSER=chrome \
                              -e MAVEN_OPTS="-Xmx1024m -Dsurefire.rerunFailingTestsCount=2" \
                              maven:3.9.6-eclipse-temurin-17 \
                              mvn clean test \
                              -Dselenium.remote.url="${SELENIUM_URL}" \
                              -Dselenium.browser=chrome \
                              -Dheadless=true \
                              -Dmaven.test.failure.ignore=true \
                              -Dsurefire.skipAfterFailureCount=3 \
                              -Dretry.count=2 \
                              -Dbrowser.timeout=30
                        """
                    } catch (Exception e) {
                        echo "Test execution failed: ${e.toString()}"
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }

        stage('Diagnostics') {
            when { expression { currentBuild.result == 'UNSTABLE' || currentBuild.result == 'FAILURE' } }
            steps {
                script {
                    // Capture Selenium logs for debugging
                    sh 'docker logs selenium-chrome > selenium.log 2>&1 || true'
                    archiveArtifacts artifacts: 'selenium.log', allowEmptyArchive: true

                    // Network diagnostics
                    sh '''
                        echo "=== Network Diagnostics ==="
                        docker run --rm --network test-network curlimages/curl \
                          curl -v http://selenium-chrome:4444/wd/hub/status
                    '''
                }
            }
        }
    }

    post {
        always {
            script {
                // Test reports and cleanup
                junit '**/target/surefire-reports/*.xml'
                archiveArtifacts artifacts: '**/target/surefire-reports/*.*,**/screenshots/*.png', allowEmptyArchive: true
                sh 'docker rm -f selenium-chrome || true'
                sh 'docker network rm test-network || true'
            }
        }

        success {
            script {
                // Enhanced success notification
                emailext(
                    to: 'srinivasg457@gmail.com',
                    subject: "✅ SUCCESS: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                    body: """<html>
                        <body>
                        <h2>Build Success</h2>
                        <p>Job: ${env.JOB_NAME}</p>
                        <p>Build: ${env.BUILD_NUMBER}</p>
                        <p>Duration: ${currentBuild.durationString}</p>
                        <p><a href="${env.BUILD_URL}">View Build</a></p>
                        <p><a href="${env.BUILD_URL}testReport">Test Results</a></p>
                        </body>
                        </html>""",
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

        unsuccessful {
            script {
                // Enhanced failure notification with diagnostics
                def testReport = readFile('target/surefire-reports/emailable-report.html')
                emailext(
                    to: 'shreelimitscale@gmail.com',
                    subject: "❌ FAILURE: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                    body: """<html>
                        <body>
                        <h2>Build Failed</h2>
                        <p>Job: ${env.JOB_NAME}</p>
                        <p>Build: ${env.BUILD_NUMBER}</p>
                        <p>Duration: ${currentBuild.durationString}</p>
                        <p><a href="${env.BUILD_URL}">View Build</a></p>
                        <p><a href="${env.BUILD_URL}testReport">Test Results</a></p>
                        <h3>Failure Details:</h3>
                        ${testReport}
                        </body>
                        </html>""",
                    mimeType: 'text/html',
                    attachLog: true,
                    smtp: [
                        host: env.SMTP_SERVER,
                        port: env.SMTP_PORT,
                        auth: true,
                        user: 'your.email@gmail.com',
                        password: env.GMAIL_APP_PASSWORD,
                        ssl: true,
                        timeout: 30000
                    ]
                )
            }
        }
    }
}