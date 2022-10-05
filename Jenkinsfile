pipeline{
    agent any
        stages{
            stage("build"){
                steps{
                    'mvn -DskipTests clean package'
                }
            }
           stage("test"){
                steps{
                    'mvn test'
                }
            }
        }
}
