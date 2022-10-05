pipeline{
    agent any
        stages{
            stage("build"){
                steps{
                    bat 'mvn -DskipTests clean package'
                }
            }
           stage("test"){
                steps{
                   bat 'mvn -DskipTests clean package'
                }
            }
        }
}
