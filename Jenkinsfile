node {
     def projectDir = "selenium"
     def mvnHome
     def registry = "shlomitubul/gui-automation-course" 
     def registryCredential = 'dockerHubCird' 
     dockerImage = ''
    

    stage ("git checkout") {
        dir(projectDir) {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '7fed62af-6286-4430-83cf-f3f685e7d8c8', url: 'https://github.com/shlomitubul/AutomationCourse.git']]])  
        }
    }

    stage ("maven build") {
        mvnHome = tool 'M3'
         dir(projectDir) {
              withEnv(["MVN_HOME=$mvnHome"]) {
                sh "$MVN_HOME/bin/mvn -Dmaven.test.failure.ignore clean package"
            }
        }
    }

    stage ("docker build") {
        dir(projectDir) {
            sh "chmod +x -R ${env.WORKSPACE}"
            dockerImage = docker.build registry + ":$BUILD_NUMBER" 
        }
    }

    stage ("docker deploy to hub") {
        docker.withRegistry( '', registryCredential ) { 
            dockerImage.push() 
        }
    }

    stage('Cleaning up') { 
        sh "docker rmi $registry:$BUILD_NUMBER" 
    } 
}
