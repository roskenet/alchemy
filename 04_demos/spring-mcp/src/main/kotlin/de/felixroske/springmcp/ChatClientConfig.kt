package de.felixroske.springmcp

import io.modelcontextprotocol.client.McpSyncClient
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfig {

    @Bean
    fun chatClient(chatClientBuilder: ChatClient.Builder, mcpSyncClients: List<McpSyncClient>): ChatClient {
        return chatClientBuilder
            .defaultSystem("You are a weather assistant ...")
            .defaultTools(SyncMcpToolCallbackProvider(mcpSyncClients))
            .build()
    }
}
