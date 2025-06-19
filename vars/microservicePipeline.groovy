def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Build') {
                steps {
                    echo "Building microservice..."
                }
            }

            stage('Test') {
                steps {
                    echo "Running tests..."
                }
            }

            stage('Deploy') {
                steps {
                    echo "Deploying microservice..."
                }
            }
        }

        post {
            success {
                echo "Pipeline completed successfully!"
            }
        }
    }
}

