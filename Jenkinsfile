pipeline {
    agent any
             options {
            // Keep the 10 most recent builds
            buildDiscarder(logRotator(numToKeepStr:'10')) 
          }
        stages {
            stage('package'){
                steps{
                        bat '''
                            cd Happytrip
                             mvn clean package
                             mvn clean install
                             mvn -B verify
                            '''
                    }
                }
            
                                 
                        stage('SCM') {
                          steps {
                             git 'https://github.com/Debadutta-Pradhan/TestHappyTrip.git'
                           }
                        }
                       stage("Build") {
                        tools{
                            jdk 'Jdk_1.8'
                            maven 'apache-maven-3.6.3'
                            }
                         steps {
                        bat '''
                               cd happytrip-code
                               mvn clean install
                               java -version
                               mvn -version
                               mvn clean package

                           '''
                       }
                       }
              
             
        }
}
