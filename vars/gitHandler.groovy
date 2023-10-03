def call(REPO_URL,CREDENTIAL_GIT, BRANCH, TELEGRAM_BOT_TOKEN, TELEGRAM_CHAT_ID) {
    if (deploy == "production") {
    echo "Clone from master"
    try {
        // Fetch the code from the Git repository
        git credentialsId: ${CREDENTIAL_GIT}, url: ${REPO_URL}
        //git branch: ${BRANCH},credentialsId: 'password_for_gitlab', url: ${REPO_URL}
        sendTelegramMessage("Pull succeeded!")
        sendGmailMessage("Pull succeeded!")
    } catch (Exception e) {
        sendTelegramMessage("Pull failed!")
        throw e
    }
    } else if (deploy == "development") {
    echo "Clone from main"
    try {
        // Fetch the code from the Git repository
        git branch: ${BRANCH},credentialsId: ${CREDENTIAL_GIT}, url: ${REPO_URL}
        //git branch: ${BRANCH}, credentialsId: 'password_for_gitlab', url: ${REPO_URL}
        sendTelegramMessage("Pull succeeded!")
        sendGmailMessage("Pull succeeded!")
    } catch (Exception e) {
        sendTelegramMessage("Pull failed!")
        throw e
    }
    }
    // git branch: ${BRANCH}, url: ${REPO_URL}
    // try {
    //     // Fetch the code from the Git repository
    // git branch: ${BRANCH},credentialsId: 'password_for_gitlab', url: ${REPO_URL}
    // sendTelegramMessage("Pull succeeded!")
    // } catch (Exception e) {
    // sendTelegramMessage("Pull failed!")
    // throw e
    // }
}
def sendTelegramMessage(message, TELEGRAM_BOT_TOKEN, TELEGRAM_CHAT_ID) {
    sh "curl -s -X POST https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage -d chat_id=${TELEGRAM_CHAT_ID} -d text='${message}'"
}