param ($Ver = $("latest"))


function build
{
    ($Tag = ("garrowd/newsservice:$Ver"))
    ./gradlew clean build
    docker build -t $Tag .
    docker push $Tag
}
build