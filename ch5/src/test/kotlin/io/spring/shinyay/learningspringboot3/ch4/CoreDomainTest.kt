package io.spring.shinyay.learningspringboot3.ch4

import io.spring.shinyay.learningspringboot3.ch5.video.entity.VideoEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class CoreDomainTest {

	@Test
	fun newVideoEntityShouldHaveNullId() {
		val entity = VideoEntity("alice", "title", "description")
		assertThat(entity.id).isNull()
		assertThat(entity.username).isEqualTo("alice")
		assertThat(entity.name).isEqualTo("title")
		assertThat(entity.description) //
			.isEqualTo("description")
	}

}
