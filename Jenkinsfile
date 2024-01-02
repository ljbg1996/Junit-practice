pipeline {
    agent any

    tools {
        maven "Maven3"
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
        stage('Deploy') {
            steps {
                // 部署到您的服务器或容器环境，这里需要您自定义脚本
                // 比如：sh 'deploy-script.sh'
            }
        }
    }
}
