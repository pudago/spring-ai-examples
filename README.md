# Spring AI Examples


This repository is where I'll commit various examples of using Spring AI.

You can clone this project in its entirety and work with it like that. *Or*
better, use the [SpringCLI](https://docs.spring.io/spring-cli/reference/index.html)
to select individual projects and create them locally.

This repository includes a project-catalog.yml, so you can add it as a project
catalog to Spring CLI like this:

```
% spring project-catalog add spring-ai-examples https://github.com/habuma/spring-ai-examples
```

Then you will be able to see these projects when using `spring project list` and
be able to create projects locally using `spring boot new`. For example, to
create a new local copy of the "prompts-and-output-parsers" example, do this:

```
% spring boot new my-project output-parsers com.example.ai
```

This will create the project in a directory named "my-project" and will refactor
the package names to be `com.example.ai`.

You can also mix a project's functionality into an existing project by using
`spring boot add`. For example, let's say you already have a Spring Boot project
and want to add the functionality of the "prompts-and-output-parsers" project to
it. Here's how you would do that:

```
% spring boot add output-parsers
```

Be aware, however, that the Spring AI examples may build against newer versions
of Spring Boot than your project. If so, your project's original Boot version
will remain unchanged and you may get build or test errors. You'll need to
update your Boot version to the version of the example project to fix the build.

Also note that the project catalog includes one example that is maintained in
separate Git repositories:

- [SpeechAI](https://github.com/habuma/speechai)

Because they're in the project catalog, you can use the Spring CLI to create
those projects as well.

## Want more?

If you like this repository of example, then you're going to love [Spring AI in
Action](https://www.manning.com/books/spring-ai-in-action?a_aid=habuma&a_bid=f205d999&chan=habuma),
now available in Manning's Early Access Program (MEAP). It covers all aspects of
working with Spring AI with a fun example that runs throughout most of the book. 

![Spring AI in Action](https://www.habuma.com/img/SAIiA_small.png "Spring AI in Action")

## fork后的改动
- 由于网络的原因，将所有样例中的OpenAI改为ZhipuAi
- application.properties重命名为application.yml
- Spring Boot和JDK版本也有调整