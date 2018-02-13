# Effective Consents Connector

This service is designed to pull transactions from permissions-service and store the 'effective' consents for citizens in a Postgres database.

### Configuration

There are three main sections of configuration. These must be set either in the `application.properties` file or [externally](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html).

* Auth0
* Platform Services (transactions, configuration & citizens)
* Postgres

The Auth0 client being used **must** have access to the applicationId specified for the permissions service config.

This service will automatically create the database specified in the `datasource` url, and is set to create / delete the table where consents are stored when the service is started / stopped.

Example config:

```
{
  "consentric": {
    "auth0": {
      "clientId": "clientId",
      "clientSecret": "clientSecret",
      "domain": "clientDomain",
      "audience": "clientAudience"
    },
    "transactions": {
      "endpoint": "https://web4-api.consentric.io/v1/permissions/transactions",
      "applicationId": "123",
      "updateCron": "0 0/1 * * * *"
    },
    "configuration": {
      "endpoint": "https://web4-api.consentric.io/v1/permissions/configuration"
    },
    "citizens": {
      "endpoint": "https://web4-api.consentric.io/v1/citizens"
    }
  },
  "spring": {
    "datasource": {
      "url": "jdbc:postgresql://postgres:5432/effectivePermissions",
      "username": "postgresUser",
      "password": "postgresPass"
    }
  }
}
```

This can also be expressed as:

```
{
  "consentric.auth0.clientId": "clientId",
  "consentric.auth0.clientSecret": "clientSecret",
  "consentric.auth0.domain": "clientDomain",
  "consentric.auth0.audience": "clientAudience",
  "consentric.transactions.endpoint": "https://web4-api.consentric.io/v1/permissions/transactions",
  "consentric.transactions.applicationId": "123",
  "consentric.transactions.updateCron": "0 0/1 * * * *",
  "consentric.configuration.endpoint": "https://web4-api.consentric.io/v1/permissions/configuration",
  "consentric.citizens.endpoint": "https://web4-api.consentric.io/v1/citizens",
  "spring.datasource.url": "jdbc:postgresql://postgres:5432/effectivePermissions",
  "spring.datasource.username": "postgresUser",
  "spring.datasource.password": "postgresPass"
}
```

### Postgres Behaviour
As mentioned above, postgres is currently configured for `create-drop`, which will create and delete required tables on application startup / shutdown. If you want to change this behaviour, you can [add the following property](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-initialize-a-database-using-hibernate) to your configuration:

`spring.jpa.hibernate.ddl-auto=create`