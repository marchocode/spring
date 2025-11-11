pipeline {
    agent any

    environment {
        REGISTRY = "registry.cn-hangzhou.aliyuncs.com"
        REPO = "registry.cn-hangzhou.aliyuncs.com/marchocode/spring-demo"
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

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials', // Jenkins中配置的凭证ID
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh """
                    docker login -u $DOCKER_USER --password-stdin ${REGISTRY}
                    docker push ${REPO}:${IMAGE_TAG}
                    docker logout ${REGISTRY}
                    """
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
