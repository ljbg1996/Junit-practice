pipeline {
    agent any

    tools {
        maven 'maven3.9.6'
    }
    triggers {
        githubPush() // 自动化触发GitHub推送事件
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
