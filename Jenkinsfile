pipeline {
    agent any
    tools {
       maven 'MAVEN_PATH'
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