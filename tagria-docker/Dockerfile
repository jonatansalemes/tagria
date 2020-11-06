FROM centos:7
RUN yum -y update
RUN yum -y install java-1.8.0-openjdk-devel
ENV JAVA_HOME /usr/lib/jvm/java-1.8.0-openjdk
RUN mkdir -p /opt/app-server-easy-deploy
RUN curl https://oss.sonatype.org/service/local/repositories/snapshots/content/com/jslsolucoes/app-server-easy-deploy/all-1.0.35-SNAPSHOT/app-server-easy-deploy-all-1.0.35-20200410.011807-1.jar -o /opt/app-server-easy-deploy/app-server-easy-deploy-all-1.0.35-SNAPSHOT.jar
COPY tagria.yaml /opt/deploy/tagria.yaml
RUN date
RUN java -jar /opt/app-server-easy-deploy/app-server-easy-deploy-all-1.0.35-SNAPSHOT.jar -y /opt/deploy/tagria.yaml -c deploy -b master -p prod
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app-server-easy-deploy/app-server-easy-deploy-all-1.0.35-SNAPSHOT.jar", "-y", "/opt/deploy/tagria.yaml","-c","run"]