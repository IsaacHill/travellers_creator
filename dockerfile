FROM java:8
COPY ./ .
RUN apt install libxext6
RUN javac @build
CMD ["java", "Test"] 