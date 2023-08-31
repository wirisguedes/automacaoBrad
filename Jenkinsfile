pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                echo 'step 2'
            }
        }
        stage('Running') {
             steps {
                echo 'Testing...'
                sh 'mvn clean install'
                sh 'mvn -Dtest=extracaoDadosDLeCargaICTestV2 test'
            }
        }
    }
}