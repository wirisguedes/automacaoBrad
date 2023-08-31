pipeline {
    agent any
    tools {
      maven 'MAVEN_HOME'
    }
    stages {
      
        stage('Running') {
             steps {
                echo 'Testing...'
                sh 'mvn clean test'
                
            }
        }
    }
}