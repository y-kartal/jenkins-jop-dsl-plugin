job('My Job-DSL-example') {
    logRotator(3, 5)

    description('My first job')

    properties {
        githubProjectUrl('https://github.com/y-kartal/java-tomcat-sample-main.git')
    }

    scm {
        github('https://github.com/y-kartal/java-tomcat-sample-main.git', 'main')
    }

    triggers {
        scm('* * * * *')
    }

    wrappers {
        colorizeOutput()
        timestamps()
    }

    steps {
        maven {
            goals('clean package')
            rootPOM('pom.xml')
            mavenInstallation('maven-3.9.6')
        }
    }

    publishers {
        archiveArtifacts('build/test-output/**/*.jar')
    }
}
