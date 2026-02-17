def gv

pipeline {
    agent any 
    tools {
        maven 'maven-3.9'
    }
    stages {
        
        stage("init") {
            steps {
                script {
                        gv = load "script.groovy"
                }    
            }
        }
        stage("test") {
            steps {
                script {
                       gv.testJar()
                }    
            }
        }
        stage("build zip") {
            steps {
                script {
                    gv.buildZip()
                }   
            }
        }

        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                    }
                }   
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployImage()
                }
            }
        }
    }
}