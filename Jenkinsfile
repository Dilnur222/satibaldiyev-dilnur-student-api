pipeline {
    agent any

    environment {
        STUDENT_NAME = 'Dilnur'
        STUDENT_SURNAME = 'Satibaldiyev'
        STUDENT_GROUP = 'IT2-2304'
        STUDENT_ID = '38036'
        IMAGE_NAME = 'satibaldiyev-dilnur-student-api'
        IMAGE_TAG = 'v1.0-38036'
    }

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build') {
            steps {
                sh 'gradle --no-daemon clean assemble'
                sh 'echo "Student: $STUDENT_NAME $STUDENT_SURNAME"'
                sh 'echo "Group: $STUDENT_GROUP | Student ID: $STUDENT_ID"'
            }
        }
        stage('Test') {
            steps { sh 'gradle --no-daemon test' }
        }
        stage('Docker Build') {
            steps { sh 'docker build -t "$IMAGE_NAME:$IMAGE_TAG" .' }
        }
        stage('Verify') {
            steps {
                sh 'docker image inspect "$IMAGE_NAME:$IMAGE_TAG" >/dev/null'
                echo 'Docker image exists.'
            }
        }
    }

    post {
        success { echo 'Pipeline completed successfully.' }
        failure { echo 'Pipeline failed. Inspect console output.' }
        always { echo 'DevOps Midterm - Dilnur Satibaldiyev' }
    }
}
