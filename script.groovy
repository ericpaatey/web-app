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
    script {
         def dockerCmd = 'docker run -p 3080:3080 -d ericpaatey/web-apps:1.0'
         sshagent() {
              ssh "ssh -o StrictHostKeyChecking=no ec2-user@18.184.54.160 ${dockerCmd}"
         }
    } 
     
}

return this
