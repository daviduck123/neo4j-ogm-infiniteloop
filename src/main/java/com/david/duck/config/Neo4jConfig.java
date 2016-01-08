package com.david.duck.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableNeo4jRepositories(basePackages = "com.david.duck")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {
	@Autowired
	Environment env;

	@Override
	public Neo4jServer neo4jServer() {
		// TODO Auto-generated method stub
		return new RemoteServer("http://localhost:7474","neo4j","root");
	}

	@Override
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return new SessionFactory("com.david.duck");
	}
}

