def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Build Docker Image') {
                steps {
                    script {
                        echo "Building Docker image from Dockerfile..."
                        docker.build("simple-microservice")
                    }
                }
            }

            stage('Run Container') {
                steps {
                    script {
                        echo "Running the app inside Docker container..."
                        docker.image("simple-microservice").run()
                    }
                }
            }
        }

        post {
            success {
                echo "Build and run completed"
            }
        }
    }
}

