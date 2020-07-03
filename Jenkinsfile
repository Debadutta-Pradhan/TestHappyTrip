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
            
                  // Build The Project              
         stage('Clone Source') {
                          steps {
                             git 'https://github.com/Debadutta-Pradhan/TestHappyTrip.git'
                           }
          }
            stage("Build") {
                         steps {
                           bat '''
                            cd Happytrip
                            mvn Happytrip/pom.xml clean install
                              

                           '''
                        }
                  post {
                       success{
                              archiveArtifact(artifacts: 'HappyTrip/Reports/*.html', allowEmptyArchive: true)
                       }
                }
         }
            
              
}
                
    post{
                failure{
                    mail to: 'debaduttapradhan95@gmail.com', from: 'debaduttapradhan95@gmail.com',
                        subject: "Project Build: ${env.JOB_NAME} - Failed",
                        body: "Job Failed - \"${env.JOB_NAME}\" build: ${env.BUILD_NUMBER}"
                }
            
                success {
                    emailext attachmentsPattern: '*Reports/*.html', body: '''${SCRIPT, template="groovy-html.template"}''',
                        subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - successful",
                        mimeType: 'text/html', to:"debaduttapradhan95@gmail.com"
                }

        }
    
}
    
    
