# FirestoreSpringBootDocker
Firestore spring boot docker and kubernetes
Spring boot, Postgres, docker with kubernetes

-> clone master branch. -> build docker image: mvn spring-boot:build-image -DskipTests (since there are no test cases are written,just to speed up te build using the arg -DskipTests) -> Note: use the right java version in pom xml, I'm using 11 -> docker-compose will look something like this. (to run it locally use the below file and run it) -> docker-compose up in the directory where docker-compose exists -> this should run as expected. hit the post and get methods using postman

now:

setup cluster in your favourite Kubernetes provider(AWS, GKE, Azure)
Setup kubectl and run it locally.
kubectl apply -f
IP you get in services should, replaced localhost with the IP. All your services must be up and runnning

. note: new to writing tech stuff, pardon me if any mistakes. Always welcome for progressive feedback

