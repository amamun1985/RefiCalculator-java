Test_Env=local
Test_browser=chrome
.PHONY:test
test:
	ifeq($(Test_Env),remote)docker-compose up --detach && \
	mvn clean test -Denvironment=$(Test_Env) -Dbrowser=$(Test_browser) && \
	docker-compose down

