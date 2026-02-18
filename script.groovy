def testJar() {
     echo"Testing the Application..."
}

def buildZip() {
    echo"Building the application..."
    //sh 'mvn package'
}

def buildImage() {
    echo"Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t ericpaatey/web-apps:1.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push ericpaatey/web-apps:1.0'
        echo"Image build completed..."


    }
}

def deployImage() {
    echo"Deploying the application..."
}

return this
