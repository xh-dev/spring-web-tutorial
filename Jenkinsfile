pipeline {
    agent any
//     environment {
//       dockerhub=credentials('jenkins-docker-login')
//       ip=credentials('ip-xethh-me')
//     }
    stages {
        // stage('Build') {
        //     agent {
        //         docker { image 'xethhung/docker-hugo:latest' }
        //     }
        //     steps {
        //         sh 'hugo'
        //         sh 'ls -al'
        //     }
        // }
        stage('build') {
            agent any
            steps {
                sh 'printenv'
            }
        }
//         stage('build') {
//             agent any
//             steps {
//                 sh 'printenv'
//                 sh 'sed -i "s|{branch}|${BRANCH_NAME}|g" ./data/GitMeta.yaml'
//                 sh 'sed -i "s|{version}|$(echo "$GIT_COMMIT"| cut -c1-6)|g" ./data/GitMeta.yaml'
//                 sh 'cat ./data/GitMeta.yaml'
//                 sh 'docker build -t xethhung/my-blog:latest .'
//             }
//         }
//         stage('publish') {
//             agent any
//             steps {
//                 sh 'echo $dockerhub_USR'
//                 sh 'echo $dockerhub_PSW | docker login -u $dockerhub_USR --password-stdin'
//                 sh 'docker push $dockerhub_USR/my-blog:latest'
//             }
//         }
        // withCredentials([sshUserPrivateKey(credentialsId: "ssh-xethh-me-deploy", keyFileVariable: 'keyfile')]) {
//         stage('deploy') {
//             steps{
//                 withCredentials([string(credentialsId: 'ip-xethh-me', variable: 'ipAddress')]) {
//                     withCredentials([string(credentialsId: 'port-xethh-me', variable: 'port')]) {
//                         withCredentials([string(credentialsId: 'reload-path-xethh-me', variable: 'reloadPath')]) {
//                             withCredentials([sshUserPrivateKey(credentialsId: 'ssh-xethh-me-deploy', keyFileVariable:'kf', usernameVariable: 'un')]) {
//                                 sh 'ssh -p ${port} -i ${kf} -o StrictHostKeyChecking=no $un@$ipAddress ${reloadPath}'
//                             }
//                         }
//                     }
//                 }
//             }
//         }
    }
}