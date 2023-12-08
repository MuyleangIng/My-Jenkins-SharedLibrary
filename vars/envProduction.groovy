def call() {
    sh 'touch .env.production'
    writeFile file: '.env.production', text: """
    RAILS_ENV=production
    
    NEXT_PUBLIC_BASE_URL=https://automatex.begoingdev.me/api/v1
    NEXTAUTH_SECRET=shTm0XQPhKqSXmAdHTSsBg==
    NEXTAUTH_URL=https://automatex.dev

    GITLAB_CLIENT_ID=
    GITLAB_CLIENT_SECRET=

    GITHUB_CLIENT_ID=71d24c57f54fec5ad032
    GITHUB_CLIENT_SECRET=22f702b97ede1293858f6465d29268ff3f9128e1
    
    GOOGLE_CLIENT_ID=77228516030-eg7aqtirnbitsg242askud7vhoqsrdf3.apps.googleusercontent.com
    GOOGLE_CLIENT_SECRET=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
    """
}