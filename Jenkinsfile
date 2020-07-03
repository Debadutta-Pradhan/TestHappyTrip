pipeline {
    agent any
        stages {
            stage('package'){
                steps{
                        bat '''
                            cd 
                             mvn clean package
                             mvn clean install
                             mvn -B verify
                            '''
                    }
                }
            }
        }
