pipeline {
    agent { docker { image 'maven:3.9.11-amazoncorretto-11-alpine' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}