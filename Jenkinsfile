pipeline {
    agent any

    triggers {
            parameterizedCron('''
               0 21 * * * %SUITE_NAME=smokeTest.xml;
               30 21 * * * %SUITE_NAME=regressionTest.xml;
            ''')
            }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    parameters {
     gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
     string(name: 'SUITE_NAME', defaultValue: 'smokeTest.xml')
     choice(name: 'BROWSER', choices: ['Chrome', 'Firefox',], description: 'Select a browser')
     booleanParam (defaultValue: false, description: 'HeadLess', name: 'HEADLESS')
         }

    stages {
        stage('Run Selenium Tests') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/Alexeyvolsky/SauceDemo_QA22_VolskiyAlexey_New'

                // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlFile=${params.SUITE_NAME} -Dbrowser=${params.BROWSER} -Dheadless=%{params.HEADLESS}% clean test"


                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Generate Allure report') {
            steps {
                 script {
                    allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }
    }
}
