# JOOQ
Java Oriented Object Query Example <br>
URL : https://www.jooq.org/


# version
- spring boot 1.5.9
- basic embed jooq version <br> ```<jooq.version>3.9.6</jooq.version>```
- jooq version overriding
<br>
```
<dependency>
 <groupId>org.jooq</groupId>
 <artifactId>jooq-meta</artifactId>
 <version>3.10.2</version>
</dependency>
<dependency>
 <groupId>org.jooq</groupId>
 <artifactId>jooq-codegen</artifactId>
 <version>3.10.2</version>
</dependency>
<dependency>
 <groupId>org.jooq</groupId>
 <artifactId>jooq</artifactId>
 <version>3.10.2</version>
</dependency>
```
- require DataBase -> mariaDB
- DB schema Name -> test

## 이 문서는 JOOQ를 가볍게 사용하면서 정리한 내용입니다.
- JOOQ ? Java Oriented Object Query 를 이야기 합니다.
- Java Code로 SQL을 작성할 수 있게 도와주는 인터페이스.
- JOOQ는 ORM이 아니니, 주의해야함.(하지만, JPA와 연동해서 사용 가능합니다.)
- JOOQ는 Code Generator를 지원합니다.(마치, QueryDSL Q도메인 만드는거처럼 DB 정보를 스캔하여, 필요한 class들을 생성해 줍니다.)
- JOOQ는 SQL을 Java Code로 작성하기 때문에, Type Safe 합니다.(컴파일 단계에서, Type 매칭 에러 확인 가능)

##사용 방법
- spring boot application.properties 에 spring.jooq.sql-dialect=mariadb 설정(JOOQ 데이터베이스 방언 설정으로 파악)
- repository class 를 작성하고, 해당 repository 에서, private final DSLContext dslContext; 를 정의해서 사용하면 됩니다.
- JOOQ Class 생성을 위해서, CodeGen을 지원합니다. pom.xml을 보고 참조하세요.(gradle 예제만 많아서 애먹은..)
```
        <dependency>
            <groupId>org.jooq</groupId>
            <artifactId>jooq-codegen-maven</artifactId>
            <version>3.10.2</version>
        </dependency>
```

```
 <profiles>
        <profile>
            <id>default</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <jdbc.user>root</jdbc.user>
                <jdbc.password>1234</jdbc.password>
                <jdbc.url>jdbc:mariadb://127.0.0.1:3306/test</jdbc.url>
                <jdbc.driver>org.mariadb.jdbc.Driver</jdbc.driver>
            </properties>
        </profile>
    </profiles>
```

```
<plugin>
                <groupId>org.jooq</groupId>
                <artifactId>jooq-codegen-maven</artifactId>
                <version>3.10.2</version>

                <!-- The plugin should hook into the generate goal -->
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                    </execution>
                </executions>

                <dependencies/>

                <configuration>
                    <jdbc>
                        <driver>${jdbc.driver}</driver>
                        <url>${jdbc.url}</url>
                        <user>${jdbc.user}</user>
                        <password>${jdbc.password}</password>
                    </jdbc>

                    <generator>
                        <database>
                            <name>org.jooq.util.mariadb.MariaDBDatabase</name>
                            <includes>.*</includes>
                            <excludes></excludes>
                            <inputSchema>test</inputSchema>
                        </database>
                        <target>
                            <packageName>com.phpbae.jooq.model</packageName>
                            <directory>src/main/java</directory>
                        </target>
                    </generator>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>1.5.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>exec</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <systemProperties>
                        <systemProperty>
                            <key>jdbc.driver</key>
                            <value>${jdbc.driver}</value>
                        </systemProperty>
                        <systemProperty>
                            <key>jdbc.user</key>
                            <value>${jdbc.user}</value>
                        </systemProperty>
                        <systemProperty>
                            <key>jdbc.password</key>
                            <value>${jdbc.password}</value>
                        </systemProperty>
                        <systemProperty>
                            <key>jdbc.url</key>
                            <value>${jdbc.url}</value>
                        </systemProperty>
                    </systemProperties>
                </configuration>
            </plugin>  
```
- 위 설정이 완료되었으면. maven execute : clean install 로 생성해 봅시다.
- JooqTest Class를 통해서, 코드들이 어떻게 실행이 되고 하는지 확인이 가능.(사용하면서 좋았던 점은, Type Safe와 가독성 좋은 메소드들로 공식문서를 조금만 참조해서 하면 금방 순탄하게 개발을 할수 있는 느낌이었다.)

```
dslContext.select(CUSTOMER.ID, CUSTOMER.NAME, CUSTOMER.EMAIL)
                .from(CUSTOMER)
                .where(CUSTOMER.ID.eq(id))
                .fetchOptionalInto(CustomerDTO.class)
```
- 위 코드가 바로 JOOQ 코드인데, 매우 가독성이 좋다. 그리고 CodeGen을 통해 CUSTOMER 라는 애가 생성이 되서 저렇게 사용이 가능하다. 코드를 보면, 
import static com.phpbae.jooq.model.tables.Customer.CUSTOMER; 이런 친구가 선언되어 있는게 눈에 들어올거다.

