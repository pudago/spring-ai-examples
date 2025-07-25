package habuma.springaifunctions;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
public class SpringAiFunctionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiFunctionsApplication.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> routes(ChatClient.Builder chatClientBuilder) {
        return RouterFunctions.route()
                .GET("/waitTime", req -> {
                    ChatClient chatClient = chatClientBuilder.build();

                    ToolCallback toolCallback = FunctionToolCallback
                            .builder("getWaitTime", new WaitTimeService())
                            .description("Get the wait time for a Disneyland attraction in minutes")
                            .inputType(WaitTimeService.Request.class)
                            .build();

                    String ride = req.param("ride").orElse("Space Mountain");
                    String answer = chatClient.prompt()
                            .toolCallbacks(toolCallback)
                            .user("What's the wait time for " + ride + "?")
                            .call()
                            .content();

                    return ServerResponse
                            .ok()
                            .body(answer);
                })
                .build();
    }

}
