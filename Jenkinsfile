pipeline {
    agent any
    tools {
      maven 'MAVEN_HOME'
    }
    stages {
      
        stage('Running') {
             steps {
              
                sh 'mvn clean test'
                
            }
        }
    }
}