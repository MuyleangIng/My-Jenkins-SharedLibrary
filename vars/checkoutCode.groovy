def call(String repoUrl, String branch) {
    // def workingDir = "${env.WORKSPACE}"
    git branch: ${repoUrl}, url: '${branch}'
    // sh "git clone ${repoUrl} ${workingDir}"
    // sh "cd ${workingDir} && git checkout ${branch}"
    // sh "cd ${workingDir} && git pull origin ${branch}" // Perform git pull
   
    // return workingDir
}
