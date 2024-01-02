pipeline {
    agent any

    tools {
        maven 'maven3.9.6'
    }

    environment {
        // 定义环境变量
        DOCKER_IMAGE = 'myapp:latest'
        CONTAINER = 'myapp-container'
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
                    // 构建 Docker 镜像
                    sh "docker build -t ${env.DOCKER_IMAGE} ."
                }
            }
        }
        stage('Deploy to Docker') {
            steps {
                script {
                    // 停止并删除旧的 Docker 容器
                    sh "docker stop ${env.CONTAINER} || true"
                    sh "docker rm ${env.CONTAINER} || true"

                    // 运行新的 Docker 容器
                    sh "docker run -d --name ${env.CONTAINER} -p 8080:8080 ${env.DOCKER_IMAGE}"
                }
            }
        }
    }
    post {
        always {
            // 可选：清理工作，如删除无用的 Docker 镜像
            sh "docker rmi \$(docker images -f 'dangling=true' -q) || true"
        }
    }
}
