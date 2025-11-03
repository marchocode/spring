pipeline {
    agent any

    environment {
        REGISTRY = "docker.io"
        REPO = "marchocode/test"
        IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Java App') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${REPO}:${IMAGE_TAG} ."
                }
            }
        }

    }

    post {
        success {
            echo "🎉 镜像推送成功：${REPO}:${IMAGE_TAG}"
        }
        failure {
            echo "❌ 构建失败，请检查日志"
        }
    }
}
