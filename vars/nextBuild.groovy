def call(registryName, imageName, imageTag,TELEGRAM_BOT_TOKEN, TELEGRAM_CHAT_ID) {
    cleanDockerImages(registryName, imageName, imageTag)
    
    try {
        buildDockerImage(registryName, imageName, imageTag)
        sendTelegramMessage("Docker build Successfully!")
    } catch (Exception e) {
        echo "Build failed, retrying..."
        cleanDockerImages(registryName, imageName, imageTag)
        buildDockerImage(registryName, imageName, imageTag)
        sendTelegramMessage("Docker build failed!")
        throw e
    }
}

def cleanDockerImages(registryName, imageName, imageTag) {
    sh """
        docker rmi -f ${registryName}/${imageName}:${imageTag}
    """
}

def buildDockerImage(registryName, imageName, imageTag) {
    sh "docker build -t ${registryName}/${imageName}:${imageTag} ."
}

def sendTelegramMessage(message) {
    sh "curl -s -X POST https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage -d chat_id=${TELEGRAM_CHAT_ID} -d text='${message}'"
}
