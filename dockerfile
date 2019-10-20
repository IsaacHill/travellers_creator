FROM java:8
COPY ./ .
RUN apt install libxext6
RUN javac Test.java
CMD ["java", "Test"] 