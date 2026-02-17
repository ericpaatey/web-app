def testJar() {
     echo"Testing the Application"
}

def buildZip() {
    echo"Building the application"
    sh 'mvn package'
}

def buildImage() {
    echo"Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', username: 'USER')]){
        sh 'docker build -t nanatwn/demo-app:jma-2:0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push nanatwn/demo-app:jma-2:0'
    }
}

def deployImage() {
    echo"Deploying the application"
}
return this