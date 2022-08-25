# guess-the-world

If you have more than one version of Azul JDK installed on your system, you
can set your `JAVA_HOME` environment variable to the correct JDK version before
running any Maven commands from the terminal using the following command (to use JDK 17):

```shell
export JAVA_HOME="$(/usr/libexec/java_home -v17)"