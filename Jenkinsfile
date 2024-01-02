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
    }
}
