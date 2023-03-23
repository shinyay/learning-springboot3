package io.spring.shinyay.learningspringboot3.ch5.video.entity

import io.spring.shinyay.learningspringboot3.ch5.video.entity.VideoEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class CoreDomainTest {

	@Test
	fun newVideoEntityShouldHaveNullId() {
		val entity = VideoEntity("alice", "title", "description")
		assertThat(entity.id).isNull()
		assertThat(entity.username).isEqualTo("alice")
		assertThat(entity.name).isEqualTo("title")
		assertThat(entity.description)
			.isEqualTo("description")
	}

	@Test
	fun toStringShouldAlsoBeTested() {
		val entity = VideoEntity("alice", "title", "description")
		assertThat(entity.toString())
			.isEqualTo("VideoEntity{id=null, username='alice', name='title', description='description'}")
	}

	@Test
	fun settersShouldMutateState() {
		val entity = VideoEntity(
			"alice", "title", "description"
		)
		entity.id = 99L
		entity.name = "new name"
		entity.description = "new desc"
		entity.username = "bob"
		assertThat(entity.id).isEqualTo(99L)
		assertThat(entity.username).isEqualTo("bob")
		assertThat(entity.name).isEqualTo("new name")
		assertThat(entity.description) //
			.isEqualTo("new desc")
	}
}
