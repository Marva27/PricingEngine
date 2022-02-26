pipeline {
	agent any 
	stages {
		stage('mvn package') {
			steps {
				script {
					echo 'building jar...'
					def mvnHome = tool name: 'Maven', type: 'maven'
					def mvnCmd = "${mvnHome}/bin/mvn"
					sh "${mvnCmd} clean package"
				}
			}
		}
		stage('build docker image') {
			steps {
				script {
					sh 'docker build -t moviepopcorn/pricing_engine:0.0.1 .'
				}
			}
		}
		stage('push docker image') {
			steps {
				script {
					withCredentials([string(credentialsId: 'docker_password', variable: 'docker_password')]) {
						sh "docker login -u moviepopcorn -p ${docker_password}"
					}
					sh 'docker push moviepopcorn/pricing_engine:0.0.1'		
				}
			}
		}
		
		stage('copy deployment files') {
			steps {               
			   script {
					withCredentials([string(credentialsId: 'k8s_password', variable: 'k8s_password')]) {
						def remote = [:]
        				remote.name = 'master'
        				remote.host = '192.168.254.111'
        				remote.user = 'moviepopcorn'
        				remote.password = "${k8s_password}"
        				remote.allowAnyHosts = true
        				sshPut remote: remote, from: 'deployment', into: '.'
        			}
			   }               
			}   
		}

		stage('apply deployment files') {
			steps {
				script {
					withCredentials([string(credentialsId: 'k8s_password', variable: 'k8s_password')]) {
						def remote = [:]
        				remote.name = 'master'
        				remote.host = '192.168.254.111'
        				remote.user = 'moviepopcorn'
        				remote.password = "${k8s_password}"
        				remote.allowAnyHosts = true
        				//sshCommand remote: remote, command: "kubectl apply -f deployment/mongo.yaml"
        				sshCommand remote: remote, command: "kubectl apply -f deployment/application.yaml"	
					}
				}	
			}
		}
	}
}