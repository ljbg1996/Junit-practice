pipeline {
    agent any

    tools {
         maven "maven3.9.6"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvnw clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvnw test'
            }
        }
    }
}
