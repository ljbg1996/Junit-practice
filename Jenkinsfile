pipeline {
    agent any

    tools {
        maven 'maven3.9.6'
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
