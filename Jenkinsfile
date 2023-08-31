pipeline {
    agent any
    tools {
      maven 'mvn'
    }
    stages {
      
        stage('Running') {
             steps {
                echo 'Testing...'
                sh 'mvn clean install'
                
            }
        }
    }
}