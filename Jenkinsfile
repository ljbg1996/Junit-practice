pipeline {
    agent any

    tools {
        maven 'maven3.9.6'
        docker 'docker' // 使用Docker工具的名称
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
    }
}
