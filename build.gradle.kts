plugins {
	java
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
	id("com.gorylenko.gradle-git-properties") version "2.4.1"
}

group = "com.pending"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Default
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// Spring Web
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Lombok
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")

	// Json (Jackson)
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// validation
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// Swagger
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.7.0")

	// Test (Junit5)
	testImplementation("org.mockito:mockito-core:4.0.0")
	testImplementation("org.mockito:mockito-junit-jupiter:4.0.0")
	testImplementation("org.mockito:mockito-inline:4.7.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("org.junit.jupiter:junit-jupiter-engine")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.bootJar {
	archiveFileName.set("webRTC.jar.jar")
}

// Git 커밋 정보를 git.properties로 생성
gitProperties {
	keys = listOf("git.commit.id.abbrev") // 짧은 커밋 ID 사용
}

tasks.withType<Test> {
	useJUnitPlatform()
}
