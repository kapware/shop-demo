package shop.test

import io.ktor.application.Application
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*
import org.junit.Test
import shop.main

class ShopAppTest {
    @Test
    fun `should support two kind of items`() = withTestApplication(Application::main) {
        // when:
        with (handleRequest(HttpMethod.Get, "/")) {
            // then:
            assertEquals(HttpStatusCode.OK, response.status())
            assertTrue(response.content?.contains("Item A") == true)
            assertTrue(response.content?.contains("Item B") == true)
        }
    }
}