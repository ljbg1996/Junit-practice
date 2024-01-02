pipeline {
    agent any

    tools {
        maven 'maven3.9.6'
    }

    environment {
        // This is the name of your Docker image and tag
        IMAGE = 'myapp:latest'
        // This is the container name that you want to use
        CONTAINER_NAME = 'myapp-container'
        // The JAR file from your Maven build
        JAR_FILE = 'unittest-practice-0.0.1-SNAPSHOT.jar'
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
                    // Build the Docker image using the Dockerfile
                    // The JAR_FILE environment variable is used to indicate the artifact to be added to the Docker image
                    docker.build(env.IMAGE, "--build-arg JAR_FILE=target/${env.JAR_FILE} .")
                }
            }
        }
        stage('Deploy to Docker') {
            steps {
                script {
                    // Stop and remove any previous container with the same name
                    sh "docker stop ${env.CONTAINER_NAME} || true"
                    sh "docker rm ${env.CONTAINER_NAME} || true"

                    // Run a new container from the built image
                    sh "docker run -d --name ${env.CONTAINER_NAME} -p 8080:8080 ${env.IMAGE}"
                }
            }
        }
    }
    post {
        always {
            // Perform cleanup steps if necessary
            sh "docker rmi $(docker images -f 'dangling=true' -q) || true"
        }
    }
}
