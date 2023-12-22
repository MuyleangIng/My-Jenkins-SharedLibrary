def call() {
    writeFile file: '.env.production', text: """

    NEXT_PUBLIC_BASE_URL=https://automatex.begoingdev.me/api/v1
    #Gitlab
    NEXT_PUBLIC_GITLAB_URL=https://gitlab-ce.sen-pai.live/api/v4
    # next-auth
    NEXTAUTH_SECRET=shTm0XQPhKqSXmAdHTSsBg==
    NEXTAUTH_URL=https://automatex.dev
    
    # Github
    GITHUB_CLIENT_ID=71d24c57f54fec5ad032
    GITHUB_CLIENT_SECRET=22f702b97ede1293858f6465d29268ff3f9128e1
    #captcha
    NEXT_PUBLIC_RECAPTCHA_SITE_KEY=6LeWcSopAAAAADDCU8WnKrI2IYVXlEKSBkKZYOvy
    NEXT_PUBLIC_RECAPTCHA_SECRET=6LeWcSopAAAAAKVvDOqXEPJdiZ-emsyspMlU7uGp
    # Gitlab
    GITLAB_CLIENT_ID=
    GITLAB_CLIENT_SECRET=
    
    # Google
    GOOGLE_CLIENT_ID=77228516030-eg7aqtirnbitsg242askud7vhoqsrdf3.apps.googleusercontent.com
    GOOGLE_CLIENT_SECRET=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
    
    NEXT_PUBLIC_DOMAIN_NAME=sen-pai.live
    NEXT_PUBLIC_CLOUD_URL=https://cloud.automatex.dev


    """
}
