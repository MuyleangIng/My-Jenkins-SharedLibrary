def call(REGISTRY_DOCKER, BUIDL_CONTAINER_NAME, Docker_Tag, MAIL_SEND_TO, TELEGRAM_BOT_TOKEN, TELEGRAM_CHAT_ID) {
    cleanDockerImages(REGISTRY_DOCKER, BUIDL_CONTAINER_NAME, Docker_Tag)
    
    try {
        buildDockerImage(REGISTRY_DOCKER, BUIDL_CONTAINER_NAME, Docker_Tag)
        sendTelegramMessage("Docker build Successfully!")
    } catch (Exception e) {
        echo "Build failed, retrying..."
        cleanDockerImages(REGISTRY_DOCKER, BUIDL_CONTAINER_NAME, Docker_Tag)
        buildDockerImage(REGISTRY_DOCKER, BUIDL_CONTAINER_NAME, Docker_Tag)
        sendTelegramMessage("Docker build failed!")
        throw e
    }
}

def cleanDockerImages(REGISTRY_DOCKER, BUIDL_CONTAINER_NAME, Docker_Tag) {
    sh """
        docker rmi -f ${BUIDL_CONTAINER_NAME}:${Docker_Tag}
        docker rmi -f ${REGISTRY_DOCKER}/${BUIDL_CONTAINER_NAME}:${Docker_Tag}
    """
}

def buildDockerImage(REGISTRY_DOCKER, BUIDL_CONTAINER_NAME, Docker_Tag) {
    sh "docker build -t ${BUIDL_CONTAINER_NAME}:${Docker_Tag} -t ${REGISTRY_DOCKER}/${BUIDL_CONTAINER_NAME}:${Docker_Tag} ."
}

def sendTelegramMessage(message) {
    sh "curl -s -X POST https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage -d chat_id=${TELEGRAM_CHAT_ID} -d text='${message}'"
}

def sendGmailMessage(message) {
    mail bcc: '', body: message, cc: '', from: '', replyTo: '', subject: 'Docker Build Status', to: MAIL_SEND_TO  
}