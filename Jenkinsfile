pipeline {
    agent any

    tools {
        maven 'maven3.9.6'
    }

    environment {
        DOCKER_IMAGE = 'myapp:latest'
        CONTAINER = 'myapp-container'
        PROJECT = 'unittest-practice'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Assuming the jar is generated in the 'target' directory and has a 'SNAPSHOT' in its name
                    def artifact = sh(script: "ls target/*.jar", returnStdout: true).trim()
                    docker.build("${env.DOCKER_IMAGE}", "-f Dockerfile . --build-arg JAR_FILE=${artifact}")
                }
            }
        }
        stage('Deploy to Docker') {
            steps {
                script {
                    // Stop and remove the old Docker container
                    sh "docker stop ${env.CONTAINER} || true"
                    sh "docker rm ${env.CONTAINER} || true"

                    // Run the new Docker container
                    sh "docker run -d --name ${env.CONTAINER} -p 8080:8080 ${env.DOCKER_IMAGE}"
                }
            }
        }
    }
    post {
        always {
            // Optional cleanup work, such as deleting unused Docker images
            sh "docker rmi $(docker images -f 'dangling=true' -q) || true"
        }
    }
}
