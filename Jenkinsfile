pipeline {
    agent any
    tools {
      maven 'MAVEN_HOME'
    }
    stages {
      
        stage('Running') {
             steps {
              
                bat 'mvn test'
                
            }
        }
    }
}